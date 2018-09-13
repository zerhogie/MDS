import json, pickle
import socket
import settings
import sys
sys.path.append(settings.RUTA_ABS)

from multiprocessing.pool import ThreadPool
from threading import Thread
from tools import encontrarExceptoMC, encontrarMC

# Función que consume el micro-servicio de extracción
def enviarAExtraccion(datos):
    # Crear socket como cliente
    plug = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        plug.connect(settings.SERVER_EXTRACCION_ADDRESS)
        print('Conectado a la extracción en {} puerto {}'.format(*settings.SERVER_EXTRACCION_ADDRESS))
        # Envía los datos necesarios para la extracción del MetaCodigo
        mensaje = json.dumps(datos).encode('utf-8')
        plug.sendall(mensaje)

        # Recibiendo respuesta
        data = plug.recv(1024)
        if data:
            # Agregar a la lista de comparables
            if json.loads(data):
                datosComparables = datos.copy()
                datosComparables.pop('ruta')
                return datosComparables
    except ConnectionRefusedError:
        print("No se encuentró el servidor de extracción en: {}, puerto: {}".format(*settings.SERVER_EXTRACCION_ADDRESS))
        print("\t-Revise que el archivo settings tenga la configuración correcta")
        print("\t-Verifique sue esté encendido el servidor del archivo 'meta' de 'Extraccion'")
    finally:
        plug.close()
    return False

# Función que consume el micro-servicio de comparación
def enviarAComparacion(estructuraComparacion, umbral):
    # Crear socket como cliente
    plug = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        plug.connect(settings.SERVER_COMPARACION_ADDRESS)
        print('Conectado a la comparación en {} puerto {}'.format(*settings.SERVER_COMPARACION_ADDRESS))
        # Envia la estructura de comparación (sus rutas)
        mensaje = json.dumps((estructuraComparacion, umbral)).encode('utf-8')
        plug.sendall(mensaje)
    except ConnectionRefusedError:
        print("No se encuentró el servidor de comparación en: {}, puerto: {}".format(*settings.SERVER_COMPARACION_ADDRESS))
        print("\t-Revise que el archivo settings tenga la configuración correcta")
        print("\t-Verifique sue esté encendido el servidor del archivo 'contra' de 'Comparacion'")
    finally:
        plug.close()

# Genera una estructura de comparaciones
def crearComparacionesDe(datos):
    if datos:
        mc = encontrarMC(datos['idAlumno'], datos['idEjercicio'], datos['idGrupo'])
        metacodigos = encontrarExceptoMC(datos['idAlumno'], datos['idEjercicio'], datos['idGrupo'])
        if metacodigos:
            return [mc, metacodigos]
    return False

# Función procesadora de peticiones
def recibirPeticion(conexion, cliente):
    try:
        print("Petición al Modulo desde: ", cliente)
        # Recepción de los datos
        datas=[]
        while True:
            data = conexion.recv(1024)
            if data:
                datas.append(data)
            else:
                break
        if datas:
            datos = json.loads(b"".join(datas))
            print(datos)
            datosExtraccion = {k:datos[k] for k in ('ruta', 'idAlumno','idEjercicio', 'idGrupo')}
            pool = ThreadPool(processes=1)
            result = pool.apply_async(enviarAExtraccion, (datosExtraccion,))
            pool.close()

            estructuraComparacion = crearComparacionesDe(result.get())
            if estructuraComparacion:
                enviarAComparacion(estructuraComparacion, datos['umbral'])
            else:
                print("Nada contra que comparar")
    finally:
        conexion.close()

# Creación del socket servidor
plug = socket.socket()
plug.bind(settings.SERVER_MODULO_ADDRESS)

plug.listen(5)

while True:
    conexion, cliente = plug.accept()
    Thread(target=recibirPeticion, args=(conexion,cliente,)).start()

