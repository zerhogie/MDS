from .select import extension
from settings import LENGUAJES_SOPORTADOS

## Extracción y comparación de meta información
for proceso in ["meta", "contra"]:
    for lenguaje in LENGUAJES_SOPORTADOS.values():
        try:
            exec('from .' + lenguaje + " import " + proceso + lenguaje.capitalize())
        except ModuleNotFoundError:
            print('ERROR: Modulo ' + lenguaje + ' no encontrado, se recomienda:')
            print('\t- Revisar que el lenguaje tenga un módulo asignado dentro de "Informacion"')
            print('\t- Verificar que coincida el nombre del módulo con la configuración')
            print('\t- Verificar que tenga su debido archivo ' + proceso + ' [Lenguaje].py implementado')

# Selects
from .select import obtenerCodigo

##Clase de metacódigo
from .metacodigo import MetaCodigo