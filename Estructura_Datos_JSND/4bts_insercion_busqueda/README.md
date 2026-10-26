# 4bts_insercion_busqueda

# Guía 4: Árbol Binario de Búsqueda (BST) - Inserción y Búsqueda

Repositorio correspondiente a la asignatura **Estructura de Datos II** (Ingeniería de Software / Ingeniería de Sistemas)[cite: 1].

## 🎯 Objetivo de la Actividad
Implementar de forma recursiva los métodos de inserción y búsqueda en un Árbol Binario de Búsqueda (BST) en Java, analizando su comportamiento estructural, altura y eficiencia temporal bajo la notación Big O[cite: 1].

---

## 🛠️ Estructura del Proyecto (`04-bst-insercion-busqueda`)
El proyecto contiene la implementación orientada a objetos en Java:
* `NodoArbol.java`: Define la estructura del nodo con su respectivo valor y referencias a los subárboles izquierdo y derecho.
* `ArbolBST.java`: Contiene la lógica principal de la raíz, los métodos recursivos de `insertar` y `buscar`, así como las pruebas de rendimiento.

---

## 📊 Comparativa: Inserción Aleatoria vs. Inserción Ordenada

Siguiendo las indicaciones de la guía, se evaluaron dos escenarios de inserción con un conjunto de datos numéricos:

| Métrica / Característica | Inserción Aleatoria (Balanceado) | Inserción Ordenada (Degenerado) |
| :--- | :--- | :--- |
| **Valores de Ejemplo** | `50, 30, 70, 20, 40, 60, 80` | `20, 30, 40, 50, 60, 70, 80` |
| **Estructura Resultante** | Árbol ramificado equitativamente | Árbol lineal (tipo lista enlazada) |
| **Altura del Árbol ($h$)** | `2 niveles` | `6 niveles` |
| **Peor caso (Búsqueda)** | $\approx \log_2(n)$ comparaciones | $n$ comparaciones |
| **Complejidad Temporal** | $\mathcal{O}(\log n)$ | $\mathcal{O}(n)$ |

---

## 📈 Diagramas del Árbol

### 1. Inserción Aleatoria (Equilibrado)
*(Adjunta aquí tu imagen o diagrama del árbol balanceado generado con los valores 50, 30, 70, 20, 40, 60, 80)*
> **Comportamiento:** La propiedad de orden distribuye los nodos de forma simétrica, reduciendo a la mitad el espacio de búsqueda en cada nivel.

### 2. Inserción Ordenada (Sesgado / Degenerado)
*(Adjunta aquí tu imagen o diagrama del árbol lineal generado al insertar los datos en orden ascendente)*
> **Comportamiento:** Cada elemento nuevo es mayor al anterior, obligando al algoritmo a ubicarse únicamente en el subárbol derecho, elevando la altura al máximo.

---

## 🧠 Análisis de Eficiencia ($\mathcal{O}(\log n)$ vs $\mathcal{O}(n)$)

* **Árbol Balanceado ($\mathcal{O}(\log n)$):** Al insertar elementos en orden aleatorio[cite: 1], la estructura garantiza que las operaciones de búsqueda e inserción descarten la mitad de los elementos restantes en cada paso recursivo. Esto se traduce en un rendimiento altamente eficiente incluso para grandes volúmenes de datos[cite: 1].
* **Árbol Degenerado ($\mathcal{O}(n)$):** Cuando los datos de entrada ya se encuentran ordenados (o casi ordenados), el BST pierde su ventaja jerárquica y se transforma funcionalmente en una lista enlazada[cite: 1]. En este escenario, el algoritmo se ve obligado a recorrer nodo por nodo secuencialmente en el peor de los casos, anulando la optimización logarítmica[cite: 1].

---
