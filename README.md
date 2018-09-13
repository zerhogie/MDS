Módulo para la determinación de similitud
=============

Last Modified: 2018/09/09

Introduction
============
Para aprovechar las herramientas tecnológicas en uso por los docentes en la FEI, se propone el módulo para la determinación de similitud de código fuente para experiencias educativas de programación o MDS, capaz de ser conectado a la versión web del sistema de evaluación de códigos fuente, utilizado para automatizar la calificación de prácticas, tareas y ejercicios de clases o concursos de programación. La propuesta consiste en la comparación del código, tokens y AST, extraídos de los archivos producidos por los estudiantes. El MDS se desarrolló bajo la metodología Merise, brindándole extensibilidad y facilidad para convertirse en un servicio.

Inicializar
============
Se recomienda iniciar el módulo desde la carpeta ModuloSimilitud con los siguientes comandos en distintas terminales (Para una observación más detallada de los procesos):
- python3 main.py
- python3 intermediario.py
- python3 Comparacion/contra.py
- python3 Extraccion/meta.py
- python3 clienteExperimentos.py

Para simplificar la acción se puede utilizar el script activarModulo.sh sin embargo se tendrá que detener de manera manual cada proceso dado el uso del operador "&" (puede detenerse con pkill Python si no existen otros procesos de python en uso).