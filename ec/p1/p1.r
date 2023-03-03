# Manuel Gachs Ballegeer

###############################################################################
# Ejercicio 1 
###############################################################################
x <- seq(1,10,by=0.2)
# Apartado a
n <- length(x)
# Apartado b
names(x) <- paste("x_",1:n,sep="")
# Apartado c
mx <- mean(x)
# Apartado d
sobre_mx <- length(x[x>mx])
# Apartado e
pos_min_sobre_mx <- which(x==x[x>mx][1])
# Apartado f
y <- seq(from=1,by=2,length.out=n)
# Apartado g
print("Valores de x:")
print(x[y[1:5]])

###############################################################################
# Ejercicio 2
###############################################################################
i <- seq(from=-2,to=2,by=0.1)
f <- (i<(-1))*1+(i>=-1 & i<0)*log(i^2)+(i>=0 & i<1)*log((i^2+1))+(i>=1)*2
print("Evaluación de la función")
print(f)

###############################################################################
# Ejercicio 3
###############################################################################
set.seed(1)
x<-runif(50)
# Apartado a
elems_intervalo <-length(x[x>0.25 & x<0.75])
# Apartado b
elems_intervalo_2 <-length(x[x<0.1 | x>0.9])
x[x<0.1 | x>0.9] <- NA
mx_nan <- mean(x,na.rm=TRUE)
# Apartado c
x[is.na(x)] <- 0
mx_0 <- mean(x)
print(paste("Media con NaN: ",mx_nan))
print(paste("Media con 0: ",mx_0))

###############################################################################
# Ejercicio 4
###############################################################################
a<-1+((1:20)-1)*1.2
# Apartado a
sum_comprobacion = 20*(a[1]+a[20])/2
print(paste("Las sumas son iguales: ",sum(a)==sum_comprobacion))
# Apartado b
sd_comprobacion = 1.2*sqrt((20*21)/12)
print(paste("Las cuasi-desviaciones típicas son iguales: ",sd(a)==sd_comprobacion))
# Apartado c
prod_comprobacion = 1.2^20*gamma((a[1]/1.2)+20)/gamma(a[1]/1.2)
print(paste("Los productos son iguales: ",prod(a)==prod_comprobacion)) # Es el mismo valor pero da FALSE...

###############################################################################
# Ejercicio 5
###############################################################################
x<-c(2,2,8,7,6,1,5)
diferencias<-x[2:length(x)]-x[1:length(x)-1]
print("Las diferencias acumuladas son:")
print(diferencias)

###############################################################################
# Ejercicio 6
###############################################################################
ABE<-LETTERS
# Apartado a
ABE.5<-sample(ABE,5,replace=FALSE)
# Apartado b
PAL<-c(paste(sample(ABE.5),collapse=""),paste(sample(ABE.5),collapse=""))
print("Vector de palabras:")
print(PAL)