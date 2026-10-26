import java.util.LinkedList;
import java.util.Queue;

// 1. Definición de la clase que representa cada nodo producto dentro del árbol BST
class NodoProducto {
    int idCodigo;           // ID numérico del producto (clave para ordenar el BST)
    String nombreProducto;  // Nombre del artículo de la tienda
    double precio;          // Precio del producto
    NodoProducto izquierdo; // Puntero al subárbol izquierdo (IDs menores)
    NodoProducto derecho;   // Puntero al subárbol derecho (IDs mayores)

    // Constructor para inicializar el nodo producto
    public NodoProducto(int idCodigo, String nombreProducto, double precio) {
        this.idCodigo = idCodigo;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.izquierdo = null;
        this.derecho = null;
    }
}

// 2. Clase principal que administra el Árbol Binario de Búsqueda de la Tienda
public class TiendaRopaBST {
    private NodoProducto raiz; // Nodo raíz principal del árbol (SVZTORE)

    // Constructor que inicializa el árbol vacío
    public TiendaRopaBST() {
        this.raiz = null;
    }

    // Método público para insertar un nuevo producto al árbol
    public void insertar(int idCodigo, String nombre, double precio) {
        raiz = insertarRec(raiz, idCodigo, nombre, precio);
    }

    // Método privado recursivo para ubicar el nodo respetando la propiedad BST
    private NodoProducto insertarRec(NodoProducto nodo, int idCodigo, String nombre, double precio) {
        // Caso base: si la posición está vacía, se crea y retorna el nuevo nodo producto
        if (nodo == null) {
            return new NodoProducto(idCodigo, nombre, precio);
        }
        // Si el ID es menor, avanza recursivamente hacia el subárbol izquierdo
        if (idCodigo < nodo.idCodigo) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, idCodigo, nombre, precio);
        } 
        // Si el ID es mayor, avanza recursivamente hacia el subárbol derecho
        else if (idCodigo > nodo.idCodigo) {
            nodo.derecho = insertarRec(nodo.derecho, idCodigo, nombre, precio);
        }
        return nodo; // Retorna la referencia del nodo actualizado
    }

    //  PREORDEN (Raíz -> Izquierda -> Derecha)
    public void preOrden() {
        System.out.print("Preorden:   "); // roo,left, right
        preOrdenRec(raiz);
        System.out.println();
    }
    private void preOrdenRec(NodoProducto nodo) {
        if (nodo != null) {
            System.out.print("[ID:" + nodo.idCodigo + " - " + nodo.nombreProducto + "] "); // Visita la raíz
            preOrdenRec(nodo.izquierdo);                                               // Recorre izquierda
            preOrdenRec(nodo.derecho);                                                 // Recorre derecha
        }
    }

    //  INORDEN (Izquierda -> Raíz -> Derecha/ing 004,002,005,001,003,006) -> Entrega los IDs ordenados de menor a mayor
    public void inOrden() {
        System.out.print("Inorden:    "); // let, root, ring
        inOrdenRec(raiz);
        System.out.println();
    }
    private void inOrdenRec(NodoProducto nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo);                                               // Recorre izquierda
            System.out.print("[ID:" + nodo.idCodigo + " - " + nodo.nombreProducto + "] "); // Visita la raíz
            inOrdenRec(nodo.derecho);                                                 // Recorre derecha
        }
    }

    //  POSTORDEN (Izquierda -> Derecha -> Raíz)
    public void postOrden() {
        System.out.print("Postorden:  ");
        postOrdenRec(raiz);
        System.out.println();
    }
    private void postOrdenRec(NodoProducto nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierdo);                                             // Recorre izquierda
            postOrdenRec(nodo.derecho);                                               // Recorre derecha
            System.out.print("[ID:" + nodo.idCodigo + " - " + nodo.nombreProducto + "] "); // Visita la raíz al final
        }
    }

    //  POR NIVELES / ANCHURA (Usa una Cola para barrer nivel por nivel)
    public void porNiveles() {
        System.out.print("Por Niveles: ");
        if (raiz == null) return;

        Queue<NodoProducto> cola = new LinkedList<>();
        cola.add(raiz); // Añade la raíz a la cola

        while (!cola.isEmpty()) {
            NodoProducto actual = cola.poll(); // Extrae el primer elemento de la cola
            System.out.print("[ID:" + actual.idCodigo + " - " + actual.nombreProducto + "] ");

            // Si tiene hijo izquierdo, lo encola
            if (actual.izquierdo != null) cola.add(actual.izquierdo);
            // Si tiene hijo derecho, lo encola
            if (actual.derecho != null) cola.add(actual.derecho);
        }
        System.out.println();
    }

    // Método principal (Main) con la ejecución de tus 10 productos exactos
    public static void main(String[] args) {
        TiendaRopaBST tienda = new TiendaRopaBST();

        // Inserción de los 10 productos extraídos de tu diagrama final SVZTORE
        tienda.insertar(0, "NVZTORE", 100.0);    //ID 000
        tienda.insertar(7, "Chamarras", 90.0);    // ID: 007
        tienda.insertar(1, "Chaqueta", 50.0);      // ID: 001
        tienda.insertar(8, "Buzos", 60.0);         // ID: 008
        tienda.insertar(2, "Sacos", 30.0);         // ID: 002
        tienda.insertar(3, "Pantalones", 45.0);      // ID: 003
        tienda.insertar(9, "Pants", 70.0);         // ID: 009
        tienda.insertar(10, "Vestidos", 55.0);      // ID: 010
        tienda.insertar(4, "Camisas", 20.0);       // ID: 004
        tienda.insertar(6, "Correas", 40.0);       // ID: 006
        tienda.insertar(5, "Camisetas", 25.0);     // ID: 005

        System.out.println("\n--- DEMOSTRACION DE RECORRIDOS: CATALOGO ---\n");
        tienda.preOrden();
        tienda.inOrden();
        tienda.postOrden();
        tienda.porNiveles();
        System.out.println("\n---                             SVZTORE  ---");
    }
}