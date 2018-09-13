from os import scandir, getcwd, path, makedirs, walk
from errno import EEXIST
import settings

## Regresa todos los paths de los archivos dentro de un directorio especificado
def ls(ruta = getcwd(), see = "all"):
    try:
        if see == "file": return [arch.path for arch in scandir(ruta) if arch.is_file() and not arch.name == ".DS_Store"]
        if see == "dir": return [arch.path for arch in scandir(ruta) if arch.is_dir()]
        return [arch.path for arch in scandir(ruta) if not arch.name == ".DS_Store"]
    except FileNotFoundError:
        return None

# Obtiene de manera recursiva todos los archivos metacodigo de un directorio
def obtenerArchivosMC(ruta):
    listaarchivos = []
    for (directorio,_,archivos) in walk(ruta):
        for nombre in archivos:
            listaarchivos.append(path.join(directorio,nombre))
    listaarchivos = [a for a in listaarchivos if a.endswith(".mc")]
    return listaarchivos

def createDir(directorio):
    try:
        makedirs(directorio)
    except OSError as e:
        if e.errno != EEXIST:
            raise

# Regresa la ruta del metacodigo con las característias coincidentes en los parametros
#! Los directorios deben estar en orden
def encontrarMC(idAlumno, *directorios):
    directorio = ""
    for d in directorios:
        directorio = path.join(directorio, str(d))
    rutas = obtenerArchivosMC(path.join(settings.RUTA_METACODIGO, directorio))
    for ruta in rutas:
        if ruta.endswith("meta" + str(idAlumno) + ".mc"):
            return ruta
    return False

# Regresa un arreglo con todas las rutas de los metacodigos que posean los datos del especificado en los parametros
def encontrarExceptoMC(idAlumno, *directorios):
    directorio = ""
    for d in directorios:
        directorio = path.join(directorio, str(d))
    metacodigos = obtenerArchivosMC(path.join(settings.RUTA_METACODIGO, directorio))
    try:
        metacodigos.remove(encontrarMC(idAlumno, *directorios))
    except ValueError as ve:
        print(ve)
    return metacodigos