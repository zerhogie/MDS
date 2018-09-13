import sys
import os
## Configuraciones propias de las comparaciones
COLAS_SIMULTANEAS = 4

# MODOS DE VISUALIZACIÓN
MODO_ALERTA = True
MODO_PORCENTAJES = False

## Añadir el path donde se encuentra el archivo settings.py
sys.path.append(os.path.dirname(os.path.abspath(__file__+"/..")))
