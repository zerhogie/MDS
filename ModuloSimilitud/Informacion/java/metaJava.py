import os
import sys
import re
from string import whitespace
from .javalangMaster import javalang
from ..select import obtenerCodigo

## FUNCIONES DEL PRIMER PRODUCTO DE LA EXTRACCIÓN: *CADENA DE TEXTO*

# Retirar todos los comentarios (¡Siempre antes de retirar saltos de linea!)
def retirarComentarios(contenido):
    comentarioLargo = re.compile(r"/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/")
    comentarioCorto = re.compile(r"//([\w|\ ]|[-!$%^&*()_+|~=`{}\[\]:\";\'<>?,.\/])*")
    sinComentarios = comentarioCorto.sub("",contenido)
    return comentarioLargo.sub("", sinComentarios) 

# Retirar todos los espacios y comentarios
def reducir(contenido):
    return contenido.translate(dict.fromkeys(map(ord, whitespace)))

# Codigo fuente con resultado a la estructura
def extraerCodigo(ruta):
    try:
        ## Lectura del archivo y conversión a una cadena sin espacios ni comentarios
        codigo = obtenerCodigo(ruta)
        codigoPuro = retirarComentarios(codigo)
        return reducir(codigoPuro)
    except Exception as ex:
        print("Error al extraer código del archivo: ", ruta)
        print(type(ex))
        print(ex.args)

# Extracción de tokens tratado
def extraerTokens(ruta):
    listaTokens = []
    try:
        # TOKENIZAR con el código
        listaTokens = list(javalang.tokenizer.tokenize(obtenerCodigo(ruta)))
    except javalang.tokenizer.LexerError:
        print("El archivo de la ruta: {} tiene errores LEXICOS".format(ruta))
        return False
    except Exception as ex:
        print("Error al extraer token del arcivo: ", ruta)
        print(type(ex), ex.args)
        return False
    return listaTokens

# Extraer el arbol sintáctico en un objeto de compilación
def extraerAST(ruta): 
    ast = object()
    try:
        # Extraer arbol (estructura compleja: CompilationUnit) 
        ast = javalang.parse.parse(obtenerCodigo(ruta))
    except javalang.parser.JavaSyntaxError:
        print("El archivo de la ruta: {} NO COMPILA".format(ruta))
        return False
    except Exception as ex:
        print("Error al extraer AST del archivo: ", ruta)
        print(type(ex), ex.args)
    return ast