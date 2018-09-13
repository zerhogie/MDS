import socket
import sys
import json

def enviarDatosPrueba(jsonArray):
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
        print('Cerro el socket')
        sock.close()

arch1 = {"ruta": "ArchivosPrueba/java/PruebasTesis.java", "idEjercicio": 1, "idAlumno": 1, "calificacion": 5, "maxCalificacion": 5, "idGrupo": 8}
arch2 = {"ruta": "ArchivosPrueba/java/PruebasTesis1.java", "idEjercicio": 1, "idAlumno": 2, "calificacion": 5, "maxCalificacion": 5, "idGrupo": 8, "umbral":0.9}
arch3 = {"ruta": "ArchivosPrueba/java/PruebasTesis2.java", "idEjercicio": 1, "idAlumno": 3, "calificacion": 3, "maxCalificacion": 5, "umbral":0.8}
arch4 = {"ruta": "ArchivosPrueba/java/Original.java", "idEjercicio": 1, "idAlumno": 4, "calificacion": 2, "maxCalificacion": 5, "idGrupo": 8, "umbral":0.8}
arch5 = {"ruta": "ArchivosPrueba/java/Original(Modificado).java", "idEjercicio": 1, "idAlumno": 5, "calificacion": 4, "maxCalificacion": 5, "idGrupo": 8, "umbral":0.6}
arch6 = {"ruta": "ArchivosPrueba/java/PruebasTesis3.java", "idEjercicio": 1, "idAlumno": 6, "calificacion": 5, "maxCalificacion": 5, "idGrupo": 8, "umbral":0.7}

ejercicios = [arch1,arch2,arch3,arch6,arch4,arch5,arch6]
for ejercicio in ejercicios:
    enviarDatosPrueba(ejercicio)