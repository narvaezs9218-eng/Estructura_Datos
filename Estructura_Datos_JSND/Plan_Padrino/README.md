# Plan_Padrino
Integrantes : Sebastian Narvaez, Andres Rojas, Cristian Clavijo, Maicol Franco, Andres Lozano

# 📚 Estructura de Datos: Pilas y Colas (Stack & Queue)

Repositorio educativo diseñado para el aprendizaje y la enseñanza de estructuras de datos lineales básicas (Pilas y Colas) en cursos de primer semestre[cite: 9, 10, 14]. Este material combina una introducción lúdica sin computador, un guion metodológico para clases magistrales y una implementación práctica en Java[cite: 9, 10, 14].

## Contenido de las Actividades

El repositorio está estructurado en tres componentes principales:

1. **`La_cafeteria_del_caos.pdf`** *(Actividad Preliminar)*: 
   * Dinámica en parejas de 35 minutos basada en papel, lápiz y tarjetas recortables[cite: 14].
   * Permite simular de forma visual y manual una pila (bandeja de platos con comportamiento LIFO) y una cola (fila de clientes con comportamiento FIFO) antes de escribir código[cite: 14, 15].
   * Incluye tres rondas de práctica y análisis de errores comunes (como extraer elementos de estructuras vacías)[cite: 14, 15].

2. **`Guion_Docente_Pilas_y_Colas.pdf`** *(Guía Metodológica)*: 
   * Planificación detallada para una clase magistral de 2 horas[cite: 10].
   * Desglose cronológico por bloques: desde el gancho inicial y ejemplos cotidianos (como `Ctrl+Z` o turnos bancarios) hasta la resolución de problemas prácticos con paréntesis balanceados[cite: 10, 11, 12, 13].

3. **`ClasePilasColas.java`** *(Implementación en Código)*: 
   * Código fuente en Java que implementa las clases `Pila` y `Cola` utilizando `ArrayList`[cite: 9].
   * Contiene demostraciones ejecutables para:
     * Simulación de "deshacer" (`Ctrl+Z`) en editores usando pilas[cite: 9].
     * Control de turnos en un consultorio médico usando colas[cite: 9].
     * Algoritmo para invertir palabras automáticamente[cite: 9].
     * Validador de paréntesis balanceados con múltiples tipos de símbolos `()`, `[]`, `{}`[cite: 9].

---

## ⏱️ Plan de Clase Sugerido (2 Horas)

| Minutos | Bloque | Actividad Principal |
| :--- | :--- | :--- |
| **0-10** | **Gancho** | Preguntas disparatoras y ejemplos de la vida real[cite: 10]. |
| **10-40** | **Pila (LIFO)** | Teoría de la cima, operaciones (`push`, `pop`, `peek`) y revisión de código[cite: 10, 11]. |
| **40-50** | **Invertir Palabra** | Ejercicio práctico individual en Java[cite: 10, 12]. |
| **50-60** | **Descanso** | Pausa activa[cite: 10]. |
| **60-85** | **Cola (FIFO)** | Teoría de flujo, operaciones (`enqueue`, `dequeue`) y comparación directa con la pila[cite: 10, 13]. |
| **85-110** | **Actividad Práctica** | Dinámica de tarjetas con paréntesis balanceados y codificación en parejas[cite: 10, 13]. |
| **110-120** | **Cierre** | Resumen conceptual y entrega del boleto de salida[cite: 10, 14]. |

---

## ⚙️ Resumen de Conceptos Clave

* **Pila (Stack - *Last In, First Out*):** El último elemento en entrar es el primero en salir. Las operaciones clave son `push` (insertar arriba), `pop` (extraer de arriba) y `peek` (observar la cima)[cite: 9].
* **Cola (Queue - *First In, First Out*):** El primer elemento en entrar es el primero en salir. Las operaciones clave son `enqueue` (entrar al final), `dequeue` (atender al frente) y `peek` (observar al próximo)[cite: 9].

---

## 🚀 Instrucciones de Ejecución (Java)

Para compilar y ejecutar las demostraciones y pruebas del archivo principal:

```bash
# Compilar el archivo fuente
javac ClasePilasColas.java

# Ejecutar la clase principal
java ClasePilasColas
---
*Desarrollado con fines educativos para la enseñanza de Estructuras de Datos.*
