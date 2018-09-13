from multiprocessing.pool import ThreadPool
from os import path
import time

import socket
import sys
import json

def enviarDatos(jsonArray):
    # Create a TCP/IP socket
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # Connect the socket to the port where the server is listening
    server_address = ('localhost', 9000)
    print('Conectado a {} puerto {}'.format(*server_address))
    sock.connect(server_address)

    try:
        # Enviar información
        mensaje = json.dumps(jsonArray).encode('utf-8')
        print(mensaje)
        sock.sendall(mensaje)

    finally:
        sock.close()

DIRECTORIO_PROYECTOS = "Experimentos/ProyectosJavaCorregidos"
NUM_PROYECTOS = 20
for i in range(1,NUM_PROYECTOS+1):
    ruta = path.join(DIRECTORIO_PROYECTOS, str(i)+".java")
    print("Enviando ", i)
    time.sleep(2)
    enviarDatos({
        "ruta": ruta,
        "idEjercicio":
        "Experimentos",
        "idAlumno": i,
        "calificacion": 5,
        "maxCalificacion": 5
        })
    