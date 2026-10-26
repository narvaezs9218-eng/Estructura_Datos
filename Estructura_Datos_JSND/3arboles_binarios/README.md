# 3arboles_binarios
# Guía 3: Árbol Binario y Modelado en Java

Este repositorio contiene la solución práctica y teórica para la **Guía 3** de la asignatura **Estructura de Datos II** (Ingeniería de Software, Semestre IV). El objetivo principal es el diseño, modelado e implementación nativa de un árbol binario dinámico utilizando referencias en Java.

## 🚀 Estructura del Proyecto

```text
03-arbol-binario-java/
├── src/
│   └── arbol_binario/
│       ├── NodoArbol.java  # Clase genérica y encapsulada del nodo
│       └── Main.java       # Construcción del árbol de 7 nodos y pruebas
├── diagramas/              # Imágenes de las clasificaciones de árboles
└── README.md               # Explicación del modelo en memoria y teoría
```

---

## 📊 Clasificación de Árboles Implementados

Basado en las estructuras lógicas de la guía, se identificaron y modelaron cuatro tipos de árboles:

1. **Árbol Lleno (Ternario/N-ario Desbalanceado):** Representado mediante una estructura organizacional (CEO -> CTO -> Devs). Cada nodo tiene 0 o N hijos.
2. **Árbol Completo:** Representado por un menú de navegación e-commerce, donde los niveles se llenan de izquierda a derecha de forma secuencial.
3. **Árbol Perfecto (Binario de 7 Nodos):** Representado por un torneo de deportes (Playoffs). Todos los niveles internos están llenos y las hojas están a la misma altura. **Este fue el modelo seleccionado para la implementación en código.**
4. **Árbol Degenerado:** Representado por un historial de cambios (*Undo/Ctrl+Z*), donde cada nodo tiene un único hijo, comportándose como una lista enlazada.

---

## 🧠 Explicación del Modelo en Memoria

En Java, un árbol binario no se almacena de forma contigua en la memoria física (como un arreglo), sino que hace uso de la **memoria Heap** mediante **referencias (punteros)** dinámicas.

### 1. Comportamiento en la Memoria Heap
Cuando instanciamos la clase genérica `NodoArbol<T>` mediante el operador `new`, el entorno de ejecución de Java (JVM) reserva un espacio en el Heap para almacenar:
* La referencia al objeto `dato` de tipo genérico `T`.
* Dos variables de referencia (`izquierdo` y `derecho`) que guardan las direcciones de memoria de otros objetos del tipo `NodoArbol<T>`.

Al enlazar el árbol de 7 nodos con los métodos `.setIzquierdo()` y `.setDerecho()`, lo que realmente estamos haciendo es conectar estas direcciones de memoria en una red ramificada. El punto de entrada a toda esta estructura es la variable `raiz`, que reside temporalmente en la **memoria Stack** del hilo de ejecución.

### 2. Diferencia entre un Nodo Hoja y una Referencia `null`
* **Nodo Hoja:** Es una instancia real y válida en la memoria Heap. Ocupa espacio físico, tiene un valor asignado en su atributo `dato`, pero sus atributos `izquierdo` y `derecho` apuntan a `null` porque no tienen descendientes.
* **Referencia `null`:** Es la ausencia total de un objeto en memoria. Significa que el puntero no apunta a ninguna dirección del Heap, sirviendo como condición de parada física para los algoritmos de recorrido.

---

## 🛡️ Manejo Seguro de Punteros (`NullPointerException`)

Para evitar fallos en tiempo de ejecución al recorrer o imprimir el árbol, el método `imprimirRaizYHijos` implementa **validaciones defensivas previas**:

```java
if (nodo == null) {
    System.out.println("El nodo proporcionado es NULL.");
    return;
}
```

Antes de invocar `.getDato()` sobre cualquier hijo (`izquierdo` o `derecho`), el sistema evalúa si la referencia es distinta de `null`. Si un nodo es una hoja, el programa lo detecta y lo maneja de forma controlada sin romper el flujo de la aplicación.

---

## 📝 Solución a Ejercicios Teóricos

### A. Árbol de Expresiones Simples
Para la expresión matemática `(5 + 3) * 2`, la estructura del árbol binario de expresiones coloca los operadores en las raíces/nodos internos y los operandos en las hojas:

```text
       [*]   <- Operador principal (Raíz)
      /   \
   [+]     [2]
   / \
 [5] [3]
```

### B. Clasificación de nuestro Árbol de 7 Nodos
El árbol de 7 nodos creado en el archivo `Main.java` corresponde estrictamente a un **Árbol Binario Perfecto**. 
* **Justificación:** Cumple con la fórmula matemática de nodos máximos para su altura \(2^{h+1} - 1\). Con una altura \(h = 2\), el árbol contiene exactamente \(2^{2+1} - 1 = 7\) nodos. Todos sus niveles internos están saturados y todas sus hojas (`Partido 1` y `Partido 2`) se encuentran exactamente en el mismo nivel de profundidad.
