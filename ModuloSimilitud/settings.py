import os
import sys

#Configuración de Módulo
UMBRAL = .8 # Float entre 0 y 1. Grado minimo de alertas
MINUTOS_ESPERA = .2 # Minutos de espera para encolar

#Configuración de las rutas del módulo
RUTA_ABS = os.path.dirname(os.path.abspath(__file__+"/"))

RUTA_METACODIGO = os.path.join(RUTA_ABS, "Out/")
RUTA_CODIGO_FUENTE = os.path.join(RUTA_ABS, "../Tests/Archivos")

## CONFIGURACIÓN DE EXTRACCIÓN Y COMPARACIÓN
LENGUAJES_SOPORTADOS = { 
    # Extensión: Lenguaje (Lenguaje de la configuración, debe tener el mismo nombre que el módulo agregado en 'Informacion')
    "java": "java"
}

# CONFIGURACIÓN DE CONEXIÓN
SERVER_ADDRESS = ('localhost', 9000)
SERVER_MODULO_ADDRESS = ('localhost', 9001)
SERVER_EXTRACCION_ADDRESS = ('localhost', 9002)
SERVER_COMPARACION_ADDRESS = ('localhost', 9003)
SERVER_REPORTE_ALERTA = ()

#Obtención de archivos
# OBSOLETE: CODIGOS_FUENTE = [os.path.join(RUTA_CODIGO_FUENTE, codigo) for codigo in ls(RUTA_CODIGO_FUENTE)]
# CODIGOS_FUENTE = ls(RUTA_CODIGO_FUENTE, see = 'file')