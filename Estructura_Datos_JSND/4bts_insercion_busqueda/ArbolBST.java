// Definición del nodo para el Árbol Binario de Búsqueda
class NodoArbol<T> {
    private T dato;
    private NodoArbol<T> izquierdo;
    private NodoArbol<T> derecho;

    public NodoArbol(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    public T getDato() { return dato; }
    public void setDato(T dato) { this.dato = dato; }

    public NodoArbol<T> getIzquierdo() { return izquierdo; }
    public void setIzquierdo(NodoArbol<T> izquierdo) { this.izquierdo = izquierdo; }

    public NodoArbol<T> getDerecho() { return derecho; }
    public void setDerecho(NodoArbol<T> derecho) { this.derecho = derecho; }
}

// Clase principal del Árbol Binario de Búsqueda (BST)
public class ArbolBST {
    private NodoArbol<Integer> raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    // Método público de inserción
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    // Método privado recursivo para insertar un valor respetando la propiedad BST
    private NodoArbol<Integer> insertarRec(NodoArbol<Integer> nodo, int valor) {
        // Caso base: si el nodo es nulo, encontramos la posición adecuada y creamos el nodo
        if (nodo == null) {
            return new NodoArbol<>(valor);
        }

        // Si el valor es menor, se inserta en el subárbol izquierdo
        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
        } 
        // Si el valor es mayor o igual, se inserta en el subárbol derecho
        else if (valor > nodo.getDato()) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
        }
        // Si es igual, los duplicados se pueden omitir o manejar según criterio (aquí se ignoran)

        return nodo;
    }

    // Método público de búsqueda
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    // Método privado recursivo para buscar un valor
    private boolean buscarRec(NodoArbol<Integer> nodo, int valor) {
        // Caso base 1: el nodo es nulo (elemento no encontrado)
        if (nodo == null) {
            return false;
        }

        // Caso base 2: encontramos el valor
        if (valor == nodo.getDato()) {
            return true;
        }

        // Operador ternario: si es menor busca a la izquierda, de lo contrario a la derecha
        return valor < nodo.getDato() 
            ? buscarRec(nodo.getIzquierdo(), valor) 
            : buscarRec(nodo.getDerecho(), valor);
    }

    // Método auxiliar para calcular la altura del árbol 
    public int calcularAltura() {
        return obtenerAlturaRec(raiz);
    }

    private int obtenerAlturaRec(NodoArbol<Integer> nodo) {
        if (nodo == null) {
            return -1; // Un árbol vacío tiene altura -1 (o 0 según convención)
        }
        int alturaIzq = obtenerAlturaRec(nodo.getIzquierdo());
        int alturaDer = obtenerAlturaRec(nodo.getDerecho());
        return Math.max(alturaIzq, alturaDer) + 1;
    }

    // Método principal main
    public static void main(String[] args) {
        ArbolBST arbol = new ArbolBST();

        // Ejercicio de la guía: Inserción de valores 50, 30, 70, 20, 40, 60, 80
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("--- PRUEBAS DE BUSQUEDA ---");
        int buscarVal = 88;
        System.out.println("Existe el valor " + buscarVal + "? " + arbol.buscar(buscarVal)); // true
        
        int buscarNoExiste = 15;
        System.out.println("Existe el valor " + buscarNoExiste + "? " + arbol.buscar(buscarNoExiste)); // false
        

        System.out.println("Altura del arbol balanceado: " + arbol.calcularAltura());
        System.out.println("---       <(*-*)>       ---");
    }
}