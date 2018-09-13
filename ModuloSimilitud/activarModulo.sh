#! /bin/bash
echo "Encendiendo Módulo"
python3 main.py & python3 intermediario.py & python3 Comparacion/contra.py & python3 Extraccion/meta.py & python3 clienteExperimentos.py 
# Será necesario detener todos los procesos de manera manual.
# De no tener otros programas abiertos se pueden detener con pkill (en este caso pkill Python)