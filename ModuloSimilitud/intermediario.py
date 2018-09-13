import json
import settings
import socket
import sys

from os import path
from threading import Timer
hilos = {}

def enviarAlModulo(datos):
    plug = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        plug.connect(settings.SERVER_MODULO_ADDRESS)
        print('Conectado al módulo en {} puerto {}'.format(*settings.SERVER_MODULO_ADDRESS))
    
        mensaje = json.dumps(datos).encode('utf-8')
        plug.sendall(mensaje)
    except ConnectionRefusedError:
        print("❗️No fue posible conectar al módulo {} en el puerto {}".format(*settings.SERVER_MODULO_ADDRESS))
        print("\t-Revise que el archivo settings tenga la configuración correcta")
        print("\t-Verifique sue esté encendido el servidor del archivo main del ModuloSimilitud")
    finally:
        plug.close()

def generarHilo(datos):
    nombreDelHilo = 't'+str(datos['idEjercicio'])+'Al'+str(datos['idAlumno'])
    try:
        hilo = hilos.pop(nombreDelHilo)
        if hilo.is_alive(): 
            hilo.cancel()
            print(nombreDelHilo + " cancelado")
    except Exception:
        pass
    hilos[nombreDelHilo] = Timer(settings.MINUTOS_ESPERA * 60, enviarAlModulo, args=[datos])
    hilos[nombreDelHilo].start()

# Función principal de comunicación con el Sistema de Evaluación de código
def comparar(ruta, idEjercicio, idAlumno, calificacion, maxCalificacion, idGrupo="", umbral=settings.UMBRAL):
    datos = {"ruta": ruta, "idEjercicio": idEjercicio, "idAlumno": idAlumno, "idGrupo": idGrupo, 'umbral': umbral}
    if path.exists(ruta):
        if calificacion == maxCalificacion:
            enviarAlModulo(datos)
        else:
            generarHilo(datos)
    else:
        print("No se encontró la ruta ", ruta)

# CREACIÓN Y SEGURO DEL SERVER TCP/IP INTERMEDIARIO
plug = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
plug.bind(settings.SERVER_ADDRESS)
# A la escucha
plug.listen(5)

while True:
    # Esperando conexión
    conexion, cliente = plug.accept()
    try:
        print('Petición al intermediario desde: ', cliente)
        datas = []
        # Receive los datos en pedazos de 1024bytes (suficiente para la petición completa)
        while True:
            data = conexion.recv(1024)
            if data:
                datas.append(data)
            else:
                break
        if datas:
            datos = json.loads(b"".join(datas))
            comparar(**datos)
        else:
            print("Vacía")
    finally:
        conexion.close()