# 2propiedades_arboles

# Guía 2: Propiedades, Recorridos y Operaciones sobre el Árbol General

## Descripción de la Actividad
En esta segunda fase, se expandió la estructura jerárquica de la Guía 1 (`NodoGeneral<T>`) incorporando métodos analíticos para calcular la topología del árbol (como la altura y el grado de los nodos) y algoritmos de exploración sistemática a través del recorrido en preorden. Para ello, se implementó y validó el organigrama empresarial diseñado en el modelado visual.

## Estructura del Proyecto
* **Main.java**: Contiene la instanciación de la jerarquía empresarial (desde la Dirección General hasta los cargos operativos de tecnología y ventas) junto con las pruebas de ejecución de propiedades y recorridos.
* **NodoGeneral.java**: Clase genérica base que gestiona los enlaces dinámicos mediante listas y los algoritmos recursivos de cálculo estructural y ordenamiento.

## Análisis de Propiedades y Resultados
* **Grado de la Raíz:** Representa el número de hijos directos del nodo principal (en este caso, 2 ramificaciones principales: *Dir. Tecnología* y *Dir. Ventas*).
* **Altura del Árbol:** Mide el nivel máximo de profundidad desde la raíz hasta las hojas terminales, obteniendo un valor de 3 niveles de ramificación.
* **Recorrido en Preorden:** Explora la jerarquía visitando primero el nodo raíz, seguido de sus subárboles descendientes de izquierda a derecha de manera recursiva, garantizando la trazabilidad completa del organigrama.

## Reflexión Técnica
La incorporación de propiedades métricas y algoritmos de recorrido en una estructura jerárquica permite que el software deje de ser un contenedor estático de datos y pase a ser un modelo consultable y navegable. A diferencia de las estructuras lineales, donde la exploración se limita a un recorrido secuencial (`O(N)`), los árboles permiten segmentar la lógica de negocio por ramas y subárboles. Sin embargo, en un árbol general no ordenado, las operaciones de búsqueda exhaustiva siguen requiriendo una evaluación recursiva completa de sus elementos, lo que motiva la evolución hacia estructuras más especializadas como los Árboles Binarios de Búsqueda (BST) o árboles auto-balanceados para optimizar el rendimiento en escenarios de alta concurrencia o grandes volúmenes de datos.

## El diagrama correspondiente se encuentra disponible en el archivo diagrama.drawio de este repositorio.
