import config
from settings import LENGUAJES_SOPORTADOS, SERVER_EXTRACCION_ADDRESS
from Informacion import extension    
from Informacion import MetaCodigo

import socket
import json

# Importar lenguajes soportados
for lenguaje in LENGUAJES_SOPORTADOS.values():
    try:
        exec('from Informacion import meta' + lenguaje.capitalize())
    except (ModuleNotFoundError, ImportError):
        print('ERROR: Modulo ' + lenguaje + ' no encontrado, se recomienda:')
        print('\t- Revisar que el lenguaje tenga un módulo asignado dentro de "Informacion"')
        print('\t- Verificar que coincida el nombre del módulo con la configuración')

# Función para extraer Tokens, Código o Arbol sintáctico según el lenguaje.
def extSegura(ruta, info):
    try:
        if info == 'Tokens' or info == 'Codigo' or info == 'AST':
            return eval("meta"+LENGUAJES_SOPORTADOS[extension(ruta)].capitalize() + ".extraer" + info + "('"+ ruta +"')")
        else:
            print("Solo puede extraerse: Tokens, Codigo o AST")
    except KeyError as ke:
        print("Extracción de %s no soportado en %s" % (info, ke))
    #except Exception as ex:
    #    print("Error en extracción de "+ info, type(ex))

## Función para la extracción completa de la MetaInformacion
def extraccionMetaCodigo(ruta,idEjercicio, idAlumno, idGrupo=""):
    if extension(ruta) in LENGUAJES_SOPORTADOS:
        # Crear MetaCodigo
        mc = MetaCodigo(idEjercicio=idEjercicio, idAlumno=idAlumno, idGrupo=idGrupo)
        # Declarar la extensión del lenguaje
        mc.setExt(extension(ruta))
        #Añadir el código a la estructura 
        mc.setCodigo(extSegura(ruta, 'Codigo'))
        #Añadir la lista de tokens a estructura
        mc.setTokens(extSegura(ruta, 'Tokens'))
        #Añadir el arbol sintáctico a estructura 
        mc.setAST(extSegura(ruta, 'AST'))

        # Guarda los cambios realizados en el archivo
        mc.guardar()
        return True
    else:
        print("La extensión %s no coincide con ningún lenguaje soportado" % extension(ruta))
        return False

# CREACIÓN Y SEGURO DEL SERVER TCP/IP PARA LA EXTRACCIÓN
plug = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
plug.bind(SERVER_EXTRACCION_ADDRESS)
# A la escucha
plug.listen(5)

while True:
    # Esperando conexión
    conexion, cliente = plug.accept()
    print('Petición a la extracción desde: ', cliente)
    try:
        while True:
            data = conexion.recv(1024)            
            if not data:
                break
            recibido = json.loads(data)
            print("Recibido: ", recibido)
            respuesta = extraccionMetaCodigo(**recibido)
            conexion.sendall(json.dumps(respuesta).encode('utf-8'))
    finally:
        conexion.close()