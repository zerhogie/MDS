import fcntl
import os
import pickle
import settings
from datetime import datetime
from tools import createDir, encontrarMC

class MetaCodigo:
    idGrupo = ""
    idEjercicio = "0"
    idAlumno = "0"
    MetaInfo = {}

    ## Constructor del MetaCodigo
    def __init__(self, idAlumno, idEjercicio, idGrupo=""):
        self.idGrupo = str(idGrupo)
        self.idEjercicio = str(idEjercicio)
        self.idAlumno = str(idAlumno)
        self.MetaInfo["build"] = (idAlumno, idEjercicio, idGrupo)
        self.leer()

    # Constructor por ruta
    @classmethod
    def porRuta(cls, ruta):
        """
        Puede construir el MetaCodigo a partir de la ruta
        del archivo mc que contiene su información.
        """
        try:
            with open(ruta, "rb") as pFile:
                fcntl.flock(pFile, fcntl.LOCK_EX)
                dMC = pickle.load(pFile)
                fcntl.flock(pFile, fcntl.LOCK_UN)
                if isinstance(dMC, dict):
                    if dMC:
                        return cls(*dMC['build'])
                else:
                    raise pickle.UnpicklingError
        except EOFError as ex:
            print("Problemas al leer el archivo por ruta, no se ha terminado de escribir", type(ex), ex)
        except pickle.UnpicklingError:
            print("Este archivo no es un MetaCodigo válido")
        except FileNotFoundError:
            print("No existe el archivo enviado")

    ## Metodo de obtención de resumen de contenido de la clase
    def __str__(self):
        return str(self.MetaInfo)

    def __hash__(self):
        return hash(str(self))

    def guardar(self): # Serialzación y guardado de archivo en binario
        #fecha = datetime.strftime(datetime.now(), "%Y/%m/%d/")
        if self.MetaInfo:
            # Se genera el archivo, notece que al cambiar el nombre del archivo el método encontrarMC se ve afectado
            createDir(os.path.join(settings.RUTA_METACODIGO, self.idEjercicio, self.idGrupo))
            with open(os.path.join(settings.RUTA_METACODIGO, self.idEjercicio, self.idGrupo, "meta" + str(self.idAlumno) + '.mc'), "wb") as pFile:
                fcntl.flock(pFile, fcntl.LOCK_EX)
                pickle.dump(self.MetaInfo, pFile)
                fcntl.flock(pFile, fcntl.LOCK_UN)
        else:
            return "Nada que guardar"
    
    def leer(self): # Decerialización y lectura del archivo binario
        ruta = encontrarMC(self.idAlumno, self.idEjercicio, self.idGrupo)
        if ruta:
            with open(ruta, "rb") as pFile:
                fcntl.flock(pFile, fcntl.LOCK_EX)
                self.MetaInfo = pickle.load(pFile)
                fcntl.flock(pFile, fcntl.LOCK_UN)
        else:
            return "No existe MetaCodigo con id=" + str(self.idAlumno)


    ## Seters
    def setExt(self, extension):
        self.MetaInfo["ext"] = extension
    def setCodigo(self, codigo):
        self.MetaInfo["codigo"] = codigo
    def setTokens(self, tokens):
        self.MetaInfo["tokens"] = tokens
    def setAST(self, ast):
        self.MetaInfo["ast"] = ast
    
    ## Geters
    def getReportData(self):
        return {"idAlumno": self.idAlumno, "idEjercicio": self.idEjercicio}
    def getExt(self):
        try:
            return self.MetaInfo["ext"]
        except:
            return False
    def getCodigo(self):
        try:
            return self.MetaInfo["codigo"]
        except:
            return False
    def getTokens(self):
        try:
            return self.MetaInfo["tokens"]
        except:
            return False
    def getAST(self):
        try:
            return self.MetaInfo["ast"]
        except:
            return False