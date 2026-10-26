// DEFINICIÓN DEL NODO 
class NodoArbol<T> {
    private T dato;
    private NodoArbol<T> izquierdo;
    private NodoArbol<T> derecho;

    public NodoArbol(T dato) { this.dato = dato; }
    public T getDato() { return dato; }
    public NodoArbol<T> getIzquierdo() { return izquierdo; }
    public NodoArbol<T> getDerecho() { return derecho; }
    public void setIzquierdo(NodoArbol<T> n) { izquierdo = n; }
    public void setDerecho(NodoArbol<T> n) { derecho = n; }
}

// CLASE PRINCIPAL
public class Main {
    public static void main(String[] args) {
        NodoArbol<String> raiz = new NodoArbol<>("Final");
        NodoArbol<String> semiA = new NodoArbol<>("Semifinal A");
        NodoArbol<String> semiB = new NodoArbol<>("Semifinal B");
        NodoArbol<String> p1A = new NodoArbol<>("Partido 1 (A)");
        NodoArbol<String> p2A = new NodoArbol<>("Partido 2 (A)");
        NodoArbol<String> p1B = new NodoArbol<>("Partido 1 (B)");
        NodoArbol<String> p2B = new NodoArbol<>("Partido 2 (B)");

        raiz.setIzquierdo(semiA);
        raiz.setDerecho(semiB);
        semiA.setIzquierdo(p1A);
        semiA.setDerecho(p2A);
        semiB.setIzquierdo(p1B);
        semiB.setDerecho(p2B);

        System.out.println("--- Impresion del Arbol Binario ---");
        imprimirRaizYHijos(raiz);
    }

    public static void imprimirRaizYHijos(NodoArbol<String> nodo) {
        if (nodo == null) {
            System.out.println("El nodo es NULL.");
            return;
        }
        System.out.println("\n Nodo Actual: [" + nodo.getDato() + "]");
        if (nodo.getIzquierdo() != null) {
            System.out.println(" -> Hijo Izquierdo: " + nodo.getIzquierdo().getDato());
        } else {
            System.out.println(" -> Hijo Izquierdo: null");
        }
        if (nodo.getDerecho() != null) {
            System.out.println(" -> Hijo Derecho: " + nodo.getDerecho().getDato());
        } else {
            System.out.println(" -> Hijo Derecho: null");
        }
            System.out.println("\n===        <(*-*)>        ===");
    }
}
