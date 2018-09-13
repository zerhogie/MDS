import os
from tools import ls

# Obtencion del código completo en una string
def obtenerCodigo(ruta):
    code = ""
    try:
        file = open(ruta, 'r')
        for linea in file.readlines(): code += linea
    except Exception as ex:
        print(ex)
    finally:
        if file:
            file.close()
    return code

# Obtención de la extensión de una ruta
def extension(ruta):
    if len(ruta.split("."))>1: return (ruta.split("."))[-1]