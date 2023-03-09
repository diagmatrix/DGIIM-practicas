# -*- coding: utf-8 -*-
# Importamos paquetes necesarios.
import numpy as np
from sklearn import datasets
import matplotlib.pyplot as plt

"""## Ejercicio 1: lectura y visualización de datos (Iris Flower)

*   Leer la base de datos de Iris que hay en scikit-learn. Véase https://scikit-learn.org/stable/datasets/toy_dataset.html. El  conjunto de datos de flor Iris (https://en.wikipedia.org/wiki/Iris_flower_data_set), introducido por Ronald Fisher en 1936, es clásico en aprendizaje automático. 
*   Obtener las características (datos de entrada $X$) y la clase ($y$).
*   Quedarse con las características segunda y cuarta. Recuérdese que en Python los índices comienzan en $0$. 
*   Visualizar con un Scatter Plot los datos, coloreando cada clase con un color diferente e indicando con una leyenda la clase a la que corresponde cada color. Más concretamente, el resultado debe ser exactamente el que se muestra en la celda de resultados que se incluye más abajo. Esta es la única salida que proporciona este ejercicio. No se debe mostrar ninguna otra información en la celda de resultados.
"""

# Leemos el dataset
data = datasets.load_iris()
X = data.data
y = data.target
nombres = data.target_names
caracteristicas = data.feature_names

# Caracteristicas a mantener
X = X[:,1::2]
caracteristicas = caracteristicas[1::2] # Nombres de las características que mantenemos

# Obtenemos los extremos de las clases
clase_0_ultimo_indice = np.where(y==0)[0][-1]+1
clase_1_ultimo_indice = np.where(y==1)[0][-1]+1

clases = [X[:clase_0_ultimo_indice,:],
          X[clase_0_ultimo_indice:clase_1_ultimo_indice,:],
          X[clase_1_ultimo_indice:,:]
          ]

# Visualizamos los datos con un Scatter plot
colores = ['red','green','blue']
fig, ax = plt.subplots()

# Graficar cada una de las clases
for i in range(3):
  x = clases[i][:,0]
  y = clases[i][:,1]
  ax.scatter(x,y,c=colores[i],label=nombres[i],marker='*')

# Leyenda y ejes
ax.set_xlabel(caracteristicas[0])
ax.set_ylabel(caracteristicas[1])
ax.legend()
plt.show()

"""
## Ejercicio 2: lectura y visualización de datos (Breast Cancer)

*   Leer la también clásica base de datos de Breast Cancer (introducida en los años 90) que hay en scikit-learn. Véase https://scikit-learn.org/stable/datasets/toy_dataset.html y https://scikit-learn.org/stable/modules/generated/sklearn.datasets.load_breast_cancer.html#sklearn.datasets.load_breast_cancer. 
*   Obtener las características (datos de entrada $X$) y la clase ($y$).
*   Quedarse con las características denominadas 'mean area' y 'mean texture'. Para identificarlas el alumno debe explorar el conjunto de datos y ver qué índices corresponden a dichas características.  
*   Visualizar con un Scatter Plot los datos, coloreando cada clase con un color diferente e indicando con una leyenda la clase a la que corresponde cada color. El resultado debe ser el que se muestra en la celda de resultados que se incluye más abajo.
"""

# Leemos el dataset
data = datasets.load_breast_cancer()
X = data.data
y_ = data.target
nombres = data.target_names
caracteristicas = data.feature_names

# Caracteristicas a mantener
mean_area = np.where(caracteristicas=="mean area")[0][0]
mean_texture = np.where(caracteristicas=="mean texture")[0][0]
X_mantener = np.vstack((X[:,mean_area],X[:,mean_texture])).T

# Separamos los datos según su clase
clase_0 = np.where(y_==0)
clase_1 = np.where(y_==1)
clases = [np.take(X_mantener,clase_0,axis=0)[0],np.take(X_mantener,clase_1,axis=0)[0]]

# Visualizamos los datos con un Scatter plot
colores = ['red','green']
fig, ax = plt.subplots(figsize=(12,5))

# Graficar cada una de las clases
for i in range(2):
  x = clases[i][:,0]
  y = clases[i][:,1]
  ax.scatter(x,y,c=colores[i],label=nombres[i])

# Leyenda y ejes
ax.set_xlabel("mean area")
ax.set_ylabel("mean texture")
ax.legend()
plt.show()

# Cálculo de ejemplos por clase
cantidad_clase= (clase_0[0].size, clase_1[0].size)

#Visualización de datos
fig, ax = plt.subplots(figsize=(8,5))
ax.set_title("Numero de ejemplos por clase")
for i in range(2):
  ax.bar(nombres[i],cantidad_clase[i],color='tab:blue')
  ax.bar(nombres[i],cantidad_clase[i],color='tab:blue')
plt.show()

# Impresión de nº de ejemplos
for i in range(2):
  print("La clase \""+nombres[i]+"\" tiene "+str(cantidad_clase[i])+" ejemplos")

# Obtención de los datos de la característica
X_mean_radius = X[:,np.where(caracteristicas=="mean radius")[0][0]]
mean_radius = [np.take(X_mean_radius,clase_0,axis=0)[0],np.take(X_mean_radius,clase_1,axis=0)[0]]
clases = (np.take(y_,clase_0)[0],np.take(y_,clase_1)[0])
#Visualización de datos
colores = ['red','green']
fig, ax = plt.subplots(figsize=(3.2,5.5))
for i in range(2):
  x = clases[i]
  y = mean_radius[i]
  ax.scatter(x,y,c=colores[i],label=nombres[i])
plt.xticks(ticks=[0,1],labels=nombres)
ax.set_xlabel("diagnosis")
ax.set_ylabel("mean radius")
ax.set_title("mean radius vs diagnosis")
ax.legend()
plt.show()
# Impresión de datos
def print_min_max(classname,min,max):
  return "La clase \""+classname+"\" para la variable \"mean radius\" presenta unos valores entre "+str(min)+" y "+str(max)

malign = np.array(mean_radius[0])
benign = np.array(mean_radius[1])
print(print_min_max(nombres[0],malign.min(),malign.max()))
print(print_min_max(nombres[1],benign.min(),benign.max()))

"""
## Ejercicio 3: separación balanceada de conjuntos de entrenamiento y test

*   Partir de los datos de Iris (empleados en el Ejercicio 1), y separar en training (80\% de los datos) y test (20\%) aleatoriamente, conservando la proporción de elementos en cada clase tanto en training como en test. Con esto se pretende evitar que haya clases infra-representadas en entrenamiento o test. Con "aleatoriamente" nos referimos a que no sería válido escoger como conjunto de entrenamiento el 80\% inicial de ejemplos de cada clase y como conjunto de test el 20\% final. Es decir, al principio, los ejemplos pertenecientes a cada clase deben desordenarse con respecto al orden original. En la implementación de este ejercicio no se pueden emplear funciones como $train\_test\_split$ de scikit-learn o similares.
*   Se debe imprimir el número resultante de ejemplos de cada clase, tanto en entrenamiento como en test, así como las clases de cada uno de los ejemplos de entrenamiento y test. En la celda de resultados que se incluye a continuación se muestra el tipo de salida que se espera obtener.
"""

# Semilla
np.random.seed(0)

# Releemos los datos
data = datasets.load_iris()
X = data.data
y = data.target
nombres = data.target_names

# Índices de los datos de entrenamiento separados equitativamente
indices_training = []
for i in range(3):
  indices_training.append(np.random.choice(np.where(y==i)[0],size=int(50*0.8),replace=False))
indices_training = np.array(indices_training).flatten()
np.random.shuffle(indices_training) # Desordenamos los índices
#Índices de test
indices_test = [i for i in range(X.shape[0]) if i not in indices_training]

# Asignamos los datos separados
X_training = np.take(X,indices_training,axis=0)
y_training = np.take(y,indices_training,axis=0)
X_test = np.take(X,indices_test,axis=0)
y_test = np.take(y,indices_test,axis=0)

# Función para imprimir los ejemplos de cada clase
def print_data_class(classname,training_number,test_number):
  title = "--- Clase "+classname+" ---\n"
  training = "Ejemplos train: "+str(training_number)+"\n"
  test = "Ejemplos test: "+str(test_number)
  return title+training+test

# Impresión de datos
for i in range(len(nombres)):
  print(print_data_class(nombres[i],len(np.where(y_training==i)[0]),len(np.where(y_test==i)[0])))
print("Clase de los ejemplos de entrenamiento: \n",y_training)
print("Clase de los ejemplos de test: \n",y_test)

"""
## Ejercicio 4: visualización de funciones 2D

*   Obtener 150 valores equiespaciados entre 0 y 4$\pi$
*   Obtener el valor de las siguientes funciones  para los 150 valores anteriormente calculados.

$f_1(x)= 10^{-5}\cdot\sinh(x) + 0.5\cdot\arctan(x)$

$f_2(x)= \cos(x) - 2\cdot\sin(x)$

$f_3(x)= \tanh(5\cdot\sin(x) + 3\cdot\cos(x))$

*   Visualizar las tres curvas simultáneamente en el mismo plot (con líneas discontinuas en rojo, azul y verde) e incluir la leyenda correspondiente. Más concretamente, el resultado debe ser el que se muestra en la siguiente celda de resultados. Esta es la única salida que proporciona este ejercicio. No se debe mostrar ninguna otra información.
"""

# Obtener 150 valores equiespaciados entre 0 y 4$\pi$
dom = np.linspace(0,4*np.pi,num=150)

# Obtener el valor de las funciones indicadas para los 10 valores anteriormente calculados.
f1 = np.vectorize(lambda x: (10**-5)*np.sinh(x) + 0.5*np.arctan(x))
f2 = np.vectorize(lambda x: np.cos(x) - 2*np.sin(x))
f3 = np.vectorize(lambda x: np.tanh(5*np.sin(x) + 3*np.cos(x)))

img_f = [f1(dom),f2(dom),f3(dom)]
#Visualizar las tres curvas simultáneamente en el mismo plot (con líneas discontinuas en rojo, azul y verde). 
fig, ax = plt.subplots(figsize=(13.5,6))
colores = ['red','blue','green']
nombres = [r'$f_1(x)= 10^{-5}\cdot\sinh(x) + 0.5\cdot\arctan(x)$',
           r'$f_2(x)= \cos(x) - 2\cdot\sin(x)$',
           r'$f_3(x)= \tanh(5\cdot\sin(x) + 3\cdot\cos(x))$']

for i in range(3):
  x = dom
  y = img_f[i]
  ax.plot(x,y,c=colores[i],linestyle='dashed',label=nombres[i])

ax.legend(prop={'size': 11})
plt.show()

"""
## Ejercicio 5: visualización de funciones 3D

*   Mostrar dos funciones 3D dentro de la misma figura. Las funciones a mostrar son las siguientes:

$f_1(x,y) =  10 - 2\cdot|x+y| + 2\cdot|y-x|$

$f_2(x,y) =  10 \cdot sin(\sqrt{x^2+y^2})$

*   Como se indicaba, ambas funciones deben mostrarse dentro de la misma figura/ventana como *surface plots*. Más concretamente, el resultado debe ser exactamente el que se muestra en la siguiente celda de resultados (tanto a nivel de título de las gráficas, como de rango de valores en los ejes y colores empleados). Esta es la única salida que proporciona este ejercicio. No se debe mostrar ninguna otra información. El siguiente enlace puede servir de ayuda y referencia a la hora de realizar este ejercicio: https://matplotlib.org/stable/gallery/mplot3d/subplot3d.html. De cara a mostrar ecuaciones matemáticas en figuras de Matplotlib usando LaTeX la siguiente referencia puede ser de utilidad: https://matplotlib.org/stable/gallery/text_labels_and_annotations/tex_demo.html.

La función *meshgrid* puede ser de gran utilidad en este ejercicio. Véanse https://interactivechaos.com/es/manual/tutorial-de-numpy/la-funcion-meshgrid
y https://numpy.org/doc/stable/reference/generated/numpy.meshgrid.html
"""

def f1(x, y):
    return 10 - 2*np.absolute(x+y) + 2*np.absolute(y-x)

def f2(x,y):
    return 10*np.sin(np.sqrt(x*x+y*y))

fig = plt.figure(figsize=(30, 13))
# f1
ax = fig.add_subplot(1,2,1, projection='3d')
x,y = np.meshgrid(np.arange(-6,6,0.1),np.arange(-6,6,0.1))
z = f1(x,y)
ax.set_title(r"$f_1(x,y) =  10 - 2\cdot|x+y| + 2\cdot|y-x|$",fontsize=20)
ax.plot_surface(x,y,z,cmap="coolwarm")
#f2
ax = fig.add_subplot(1,2,2, projection='3d')
x,y = np.meshgrid(np.arange(-2,2,0.01),np.arange(-2,2,0.01))
z = f2(x,y)
ax.set_title(r"$f_2(x,y) =  10 \cdot sin(\sqrt{x^2+y^2})$",fontsize=20)
ax.plot_surface(x,y,z,rcount=100,ccount=100,cmap="viridis")

plt.show()
