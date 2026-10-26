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

public class ArbolBST {
    private NodoArbol<Integer> raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbol<Integer> insertarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) return new NodoArbol<>(valor);
        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getDato()) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
        }
        return nodo;
    }

    // Método auxiliar requerido para el caso de dos hijos (sucesor inorden)
    private int minValor(NodoArbol<Integer> nodo) {
        int min = nodo.getDato();
        while (nodo.getIzquierdo() != null) {
            min = nodo.getIzquierdo().getDato();
            nodo = nodo.getIzquierdo();
        }
        return min;
    }

    // Método público de eliminación
    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    // Método recursivo de eliminación cubriendo los tres casos
    private NodoArbol<Integer> eliminarRec(NodoArbol<Integer> nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        // 1. Buscar el nodo a eliminar de forma recursiva
        if (valor < nodo.getDato()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getDato()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), valor));
        } else {
            // ¡Nodo encontrado! Evaluamos los 3 casos:

            // Caso 1: Nodo hoja o nodo con un solo hijo derecho
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } 
            // Caso 1 (continuación) o Nodo con un solo hijo izquierdo
            else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            // Caso 3: Nodo con dos hijos
            // Encontramos el sucesor inorden (el valor mínimo del subárbol derecho)
            nodo.setDato(minValor(nodo.getDerecho()));

            // Eliminamos el sucesor duplicado en el subárbol derecho
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), nodo.getDato()));
        }
        return nodo;
    }

    // Método en orden para verificar el estado del árbol
    public void inOrden() {
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(NodoArbol<Integer> nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inOrdenRec(nodo.getDerecho());
        }
    }

    public static void main(String[] args) {
        ArbolBST arbol = new ArbolBST();
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int v : valores) arbol.insertar(v);

        System.out.print("Arbol inicial (InOrden): ");
        arbol.inOrden();

        // Prueba Caso 1: Eliminar nodo hoja (ej. 20)
        arbol.eliminar(20);
        System.out.print("Despues de eliminar hoja 20: ");
        arbol.inOrden();

        // Prueba Caso 2: Eliminar nodo con un hijo (ej. 30 ahora que no tiene el 20, o insertando uno intermedio)
        // Agreguemos un caso claro de un hijo eliminando el 60
        arbol.eliminar(60);
        System.out.print("Despues de eliminar nodo con un hijo (60): ");
        arbol.inOrden();

        // Prueba Caso 3: Eliminar nodo con dos hijos (ej. la raíz 50)
        arbol.eliminar(50);
        System.out.print("Despues de eliminar la raiz (50) con dos hijos: ");
        arbol.inOrden();
    }
    

    
}