# Manuel Gachs Ballegeer

###############################################################################
# Ejercicio propuesto
###############################################################################
ejercicio <- function(n) {
    # Creación de la matriz A y el vector b
    A<-matrix(NA,nrow=n,ncol=n)
    for (i in 1:n)
        A[i,]<-(1:n)^i
    b<-as.vector(A%*%rep(1,times=n))
    # Cálculo de la singularidad para el problema
    print(paste("Número de condición recíproco: ",rcond(A)))
    # Resolución del sistema
    x<-solve(A,b)
    print("Soluciones del problema:")
    print(x)
    # Máximo de las diferencias
    difs<-abs(x-1)
    max_difs<-max(difs)
    print(paste("El máximo de las diferencias es:",max_difs))
}

for (n in 3:12) {
    print(paste("Resolviendo el ejercicio para n igual a",n))
    ejercicio(n)
}

###############################################################################
# Comentario
###############################################################################
"""
Tenemos que calculando el número de condición recíproco, va acercándose a 0 muy
rápidamente. De hecho, para n=12, R no deja directamente usar la sentencia
solve, mostrando el error siguiente:

Error in solve.default(A, b) :
  sistema es computacionalmente singular: número de condición recíproco = 3.95621e-17
Calls: ejercicio -> solve -> solve.default

Puesto que la matriz A es bastante singular, al usar números muy grandes, como
pueden ser 9^9, es probable que haya errores de redondeo que hagan que las
soluciones del sistema no sean unos, sino cosas cercanas. Además, esto sumado a
los errores de redondeo de la operación |x-1| hacen que el máximo de las
diferencias deje de ser 0, aún cuando las soluciones son uno, a partir de n=4
"""