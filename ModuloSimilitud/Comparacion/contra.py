import config
from settings import LENGUAJES_SOPORTADOS, SERVER_COMPARACION_ADDRESS, SERVER_REPORTE_ALERTA
from Informacion import extension    
from Informacion import MetaCodigo

import socket
import json, pickle
from multiprocessing import Process, Lock
from multiprocessing.pool import ThreadPool


# Importar lenguajes soportados
for lenguaje in LENGUAJES_SOPORTADOS.values():
    try:
        exec('from Informacion import contra' + lenguaje.capitalize())
    except (ModuleNotFoundError, ImportError):
        print('ERROR: Comparaciones de ' + lenguaje + ' no encontradas, se recomienda:')
        print('\t- Revisar la existencia módulo "contra" del lenguaje ' + lenguaje)
        print('\t- Verificar que coincida el nombre del módulo con el estandar')

def comparacionSegura(mc1, mc2, info):
    try:
        if info == 'Tokens' or info == 'Codigo' or info == 'AST':
            if mc1.getExt() == mc2.getExt():
                return eval('contra'+LENGUAJES_SOPORTADOS[mc1.getExt()].capitalize() + '.comparar' + info + '(mc1.get'+info+'(), mc2.get'+info+'())')
            else:
                raise TypeError("MetaCodigo: meta" + str(mc1.idAlumno) + ".mc esperaba ser " + LENGUAJES_SOPORTADOS[mc1.getExt()] + " pero encontró " + LENGUAJES_SOPORTADOS[mc2.getExt()] + " en MetaCodigo: meta" + str(mc2.idAlumno) + ".mc")
        else:
            print("Solo puede extraerse: Tokens, Codigo o AST")
    except Exception as ex:
        print("Error en comparación segura: ", type(ex), ex, ex.__traceback__)

### COMPARACIÓN DE METACODIGO  ###
#Función de comparación de dos MetaCodigos
def comparacionMetaCodigo(mc1, mc2, umbral):
    # Comparación de código
    simCodigo = comparacionSegura(mc1, mc2, "Codigo")
    similitud = simCodigo
    # Verifica si vale la pena pasar a la comparación de tokens
    try:
        if simCodigo < umbral and mc1.getTokens() and mc2.getTokens():
            simTokens = comparacionSegura(mc1, mc2, "Tokens")
            similitud = simTokens
            # Verifica si vale la pena pasar a la comparación de AST
            if simTokens < umbral and mc1.getAST() and mc2.getAST():
                simAST = comparacionSegura(mc1, mc2, "AST")
                similitud = simAST
    except Exception:
        pass
    return (round(similitud, 2), mc1.getReportData(), mc2.getReportData())
    

# Generar tabla de comparación
def verResultados(similitudes):
    """
    Método creado para visualizar de manera ordenada los 
    resultados en experimentación.

    Recibe las similitudes que son los resultados del método
    ComparacionMetaCodigo, es decir el grado de similitud de
    dos MetaCodigos y cada uno de sus identificadores.
    
    Regresa el ejercicio, los identificadores de los alumnos
    y el grado de similitud de los MetaCodigos.
    """
    for similitud, infoMC1, infoMC2 in similitudes:
        datos = (infoMC1['idEjercicio'], infoMC1['idAlumno'], infoMC2['idAlumno'], similitud)
        print("Ejercicio: {}, Alumno {} / Alumno {} => {}".format(*datos))

## METODOS PARA CADENA DE COMPARACIONES ##

# Enviar Alerta! (los datos de reporte son un diccionario con similitud, idAlumno, idEjercicio)
def enviarAlerta(datosReporte):
    try:
        plug = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        plug.connect(SERVER_REPORTE_ALERTA)
        print('Mandando alerta a {} en puerto {}'.format(*SERVER_REPORTE_ALERTA))
        reporte = json.dumps(datosReporte).encode('utf-8')
        plug.sendall(reporte)
    except TypeError:
        print("¡Alerta!, similitud elevada (no enviada): ", datosReporte)
    except ConnectionRefusedError:
        print("¡Alerta! similitud elevada (no enviada) NO SE ENCONTRÓ EL SERVIDOR EN: ", SERVER_REPORTE_ALERTA)
    finally:
        plug.close()
    
# Crea el metacodigo apartir de su ruta
def leerMCPorRuta(ruta):
    return MetaCodigo.porRuta(ruta)

# Revisar porcentaje (infoMC es lo que retorna getReportData del MC: idAlumno, idEjercicio en diccionario)
def revisarSimilitud(umbral, similitud, infoMC1, infoMC2):
    if similitud >= umbral:
        datosReporte = {'similitud': similitud, 'idAlumno1': infoMC1['idAlumno'], 'idAlumno2': infoMC2['idAlumno'], 'idEjercicio': infoMC1['idEjercicio']}
        enviarAlerta(datosReporte)
        return True
    return False


# Inicio de cadena de comparación
def iniciarCadenaComparativa(estructuraComparacion, umbral):
    """
    Genera una cadena comparativa a partir de la estructura
    de comparación normalmente con la forma: 
    [Comparable, [comparandos]].
    """
    mc1 = leerMCPorRuta(estructuraComparacion[0])

    # Multiprocesamiento para leer los MC
    pool = ThreadPool()
    #Comparación en multiprocesamiento
    comparables = pool.map(leerMCPorRuta, estructuraComparacion[1])
    pool.close()
    pool.join()

    #Generación de parametros iterables para multiprocesamiento de las comparaciones
    contras = [(mc1, mc2, umbral) for mc2 in comparables] # Lista de comparaciones
    pool = ThreadPool()
    #Comparación en multiprocesamiento
    similitudes = pool.starmap(comparacionMetaCodigo, contras)
    pool.close()
    pool.join()
    ## Bloque utilizado para experimientación 
    if config.MODO_PORCENTAJES:
        print()
        verResultados(similitudes)
        print()
    #"""
    if config.MODO_ALERTA:
        # Generación de parametros iterables para multiprocesamiento de las revisiones
        revision = [(umbral,) + similitud for similitud in similitudes]
        pool = ThreadPool()
        # Revisión de las similitudes
        pool.starmap(revisarSimilitud, revision)
        pool.close()
        pool.join()
    #"""

## CREACIÓN Y SEGURO DEL SERVER TCP/IP PARA LA COMPARACIÓN
plug = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
plug.bind(SERVER_COMPARACION_ADDRESS)

def manejarPeticion(conexion, cliente, lock=None):
    if lock is not None:
        lock.acquire()
    try:
        print("Petición a la comparación desde: ", cliente)
        # Recepción de los datos
        datas =  []
        while True:
            data = conexion.recv(1024)
            if data:
                datas.append(data)
            else:
                break
        if datas:
            estructuraComparacion, umbral = json.loads(b"".join(datas))
            #print("Iniciando compararciones de-> {} \ncontra {}".format(estructuraComparacion[0].split("/")[-1], [i.split("/")[-1] for i in estructuraComparacion[1]]))
            iniciarCadenaComparativa(estructuraComparacion, umbral)
    finally:
        if lock is not None:
            lock.release()
        conexion.close()

def rueda(max):
    """
    Crea un generador que incrementa desde 0
    hasta el número como parámetro retornando
    forma cíclica
    """
    n = 0
    while True:
        if n == max:
            n = 0
        yield n
        n += 1

if __name__ == '__main__':
    # A la escucha
    plug.listen(5)
    lock = []
    for i in range(config.COLAS_SIMULTANEAS): lock.append(Lock())
    r = rueda(len(lock))
    while True:
        # Esperando conexión
        conexion, cliente = plug.accept()
        p = Process(target=manejarPeticion, args=(conexion,cliente,lock[r.__next__()])).start()