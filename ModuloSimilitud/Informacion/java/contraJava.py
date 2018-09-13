from difflib import SequenceMatcher
from .javalangMaster.javalang import tree

# Compara el código fuente
def compararCodigo(cod1, cod2):
    """
    Compara el código gracias a la clase SequenceMatcher
    de la biblioteca difflib, requiere de dos parametros
    que sean el mismo tipo de iterables y regresan un
    porcentaje de similitud.
    """
    # Comparación de cadenas según método TF-IDF y utilizando difflib. Método de Ratcliff/Obershelp
    coincidencias = SequenceMatcher(None, cod1, cod2)
    #print("compara código: {}".format(coincidencias.ratio()))
    return coincidencias.ratio() # Comparación minuciosa
    

# Compara los tokens
def compararTokens(tokens1, tokens2):
    """
    Para comparar tokens en java se utiliza la lista dada 
    en la extracción.
    Identifica los tipos de los tokens reservadolo en como 
    si de secuencias se tratará, para emplear el método 
    diff.SequenceMatcher, identificando así un porcentaje de similitud
    """
    pocosTokens = 600
    secuenciaTokens1 = [type(token).__name__ for token in tokens1]
    secuenciaTokens2 = [type(token).__name__ for token in tokens2]
    serEstricto = True if len(secuenciaTokens1+secuenciaTokens2) < pocosTokens else False
    coincidencias = SequenceMatcher(None, secuenciaTokens1, secuenciaTokens2, serEstricto)
    #print("compara tokens: ", coincidencias.ratio())
    return coincidencias.ratio()

# Compara árbol sintáctico
def compararPorLongitud(arr1, arr2):
    """
    Al emplear un método de comparación por número de nodos dentro de cada 
    arbol, este método se encarga de facilitar un porcentaje de similitud
    acorde con el número de elementos de cada lista.
    """
    #print(len(arr1),"\n" + str(len(arr2)))
    if len(arr1+arr2) > 0:
        try:
            if len(arr1) == len(arr2):
                return 1
            menor = arr1
            mayor = arr2
            if len(arr1) > len(arr2):
                menor = arr2
                mayor = arr1
            return len(menor) / len(mayor)
        except ZeroDivisionError:
            return 0
    return None
    
def compararAST(ast1, ast2):
    """
    Recibe dos CompilationUnit para realizar su tarea, y cuenta todos
    los nodos de cada tipo, para saber que tanto es el parecido entre
    los dos AST del CompilationUnit.
    Retorna un porcentaje de similitud entre ASTs.
    """
    clasesDeclaradas1 = [nodo for path, nodo in ast1.filter(tree.ClassDeclaration)]
    clasesDeclaradas2 = [nodo for path, nodo in ast2.filter(tree.ClassDeclaration)]
    #
    clasesCreadas1 = [nodo for path, nodo in ast1.filter(tree.ClassCreator)]
    clasesCreadas2 = [nodo for path, nodo in ast2.filter(tree.ClassCreator)]
    #
    metodosDeclarados1 = [nodo for path, nodo in ast1.filter(tree.MethodDeclaration)]
    metodosDeclarados2 = [nodo for path, nodo in ast2.filter(tree.MethodDeclaration)]
    #
    metodosInvocados1 = [nodo for path, nodo in ast1.filter(tree.MethodInvocation)]
    metodosInvocados2 = [nodo for path, nodo in ast2.filter(tree.MethodInvocation)]
    #
    referencias1 = [nodo for path, nodo in ast1.filter(tree.ReferenceType)]
    referencias2 = [nodo for path, nodo in ast2.filter(tree.ReferenceType)]
    #
    invocaciones1 = [nodo for path, nodo in ast1.filter(tree.Invocation)]
    invocaciones2 = [nodo for path, nodo in ast2.filter(tree.Invocation)]
    #
    basicos1 = [nodo for path, nodo in ast1.filter(tree.BasicType)]
    basicos2 = [nodo for path, nodo in ast2.filter(tree.BasicType)]
    #
    asignaciones1 = [nodo for path, nodo in ast1.filter(tree.Assignment)]
    asignaciones2 = [nodo for path, nodo in ast2.filter(tree.Assignment)]
    #
    statements1 = [nodo for path, nodo in ast1.filter(tree.BlockStatement)]
    statements2 = [nodo for path, nodo in ast2.filter(tree.BlockStatement)]
    #
    ciclos1 = [nodo for path, nodo in ast1.filter(tree.DoStatement)] + [nodo for path, nodo in ast1.filter(tree.WhileStatement)] + [nodo for path, nodo in ast1.filter(tree.ForStatement)]
    ciclos2 = [nodo for path, nodo in ast2.filter(tree.DoStatement)] + [nodo for path, nodo in ast2.filter(tree.WhileStatement)] + [nodo for path, nodo in ast2.filter(tree.ForStatement)]    
    #
    condicionales1 = [nodo for path, nodo in ast1.filter(tree.IfStatement)] + [nodo for path, nodo in ast1.filter(tree.SwitchStatementCase)]
    condicionales2 = [nodo for path, nodo in ast2.filter(tree.IfStatement)] + [nodo for path, nodo in ast2.filter(tree.SwitchStatementCase)]
    #
    variables1 = [nodo for path, nodo in ast1.filter(tree.VariableDeclaration)]
    variables2 = [nodo for path, nodo in ast2.filter(tree.VariableDeclaration)]
    #
    arreglos1 = [nodo for path, nodo in ast1.filter(tree.ArrayCreator)]
    arreglos2 = [nodo for path, nodo in ast2.filter(tree.ArrayCreator)]
    #
    cc = compararPorLongitud(clasesCreadas1, clasesCreadas2)
    #print("ClasesCreadas ",cc)
    cd = compararPorLongitud(clasesDeclaradas1, clasesDeclaradas2)
    #print("ClasesDeclaradas ",cd)
    a = compararPorLongitud(asignaciones1, asignaciones2)
    #print("asignacion ", a)
    b = compararPorLongitud(basicos1,basicos2)
    #print("basicos ", b)
    md = compararPorLongitud(metodosDeclarados1, metodosDeclarados2)
    #print("metodos d ", md)
    mi = compararPorLongitud(metodosInvocados1, metodosInvocados2)
    #print("metodos i", mi)
    i = compararPorLongitud(invocaciones1,invocaciones2)
    #print("invocaciones ", i)
    r = compararPorLongitud(referencias1,referencias2)
    #print("referencias ", r)
    s = compararPorLongitud(statements1, statements2)
    #print("statements ", s)
    con = compararPorLongitud(condicionales1, condicionales2)
    #print("condicionales ", con)
    ci = compararPorLongitud(ciclos1,ciclos2)
    #print("ciclos ", ci)
    v = compararPorLongitud(variables1,variables2)
    #print("variables ",v)
    arr = compararPorLongitud(arreglos1, arreglos2)
    prep = [cc,cd,a,b,md,mi,r,i,s,con,ci,v,arr]
    nodos = tuple(i for i in prep if i is not None)
    #print("compara ast: ", sum(nodos)/len(nodos), "de los nodos: ", nodos )
    return sum(nodos) / len(nodos) #Promedio de resultados

def tieneHijo(nodo):
    if isinstance(nodo, list):
        return True
    try:
        nodo.children
        return True
    except Exception:
        return False

nodos = []
def recorrerArbol(arbol):
    if tieneHijo(arbol):
        if isinstance(arbol, list):
            for hijo in arbol:
                recorrerArbol(hijo)
        else:
            recorrerArbol(arbol.children)
            nodos.append(arbol)
    