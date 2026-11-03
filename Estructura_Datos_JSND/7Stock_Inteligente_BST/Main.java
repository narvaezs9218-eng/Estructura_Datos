import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        List<Producto> productos = crearProductos();

        // =====================================================
        // ESCENARIO 1: INSERCIÓN ALEATORIA
        // =====================================================
        List<Producto> aleatorios = new ArrayList<>(productos);

        // Semilla fija: permite repetir exactamente la práctica.
        Collections.shuffle(aleatorios, new Random(42));

        ArbolBSTCatalogo bstAleatorio = new ArbolBSTCatalogo();

        for (Producto p : aleatorios) {
            bstAleatorio.insertar(p);
        }

        // =====================================================
        // ESCENARIO 2: INSERCIÓN ORDENADA
        // =====================================================
        List<Producto> ordenados = new ArrayList<>(productos);

        ordenados.sort(
                (a, b) -> Integer.compare(
                        a.getCodigo(),
                        b.getCodigo()
                )
        );

        ArbolBSTCatalogo bstOrdenado = new ArbolBSTCatalogo();

        for (Producto p : ordenados) {
            bstOrdenado.insertar(p);
        }

        // =====================================================
        // MOSTRAR ORDEN DE INSERCIÓN
        // =====================================================
        System.out.println("=== STOCK INTELIGENTE ===");

        System.out.println("\nOrden ALEATORIO:");
        imprimirCodigos(aleatorios);

        System.out.println("\nOrden ASCENDENTE:");
        imprimirCodigos(ordenados);

        // =====================================================
        // MOSTRAR LOS DOS ÁRBOLES
        // =====================================================
        System.out.println("\n=== BST ALEATORIO ===");
        bstAleatorio.imprimirArbol();
        System.out.println("Altura: " + bstAleatorio.altura());

        System.out.println("\n=== BST ORDENADO ===");
        bstOrdenado.imprimirArbol();
        System.out.println("Altura: " + bstOrdenado.altura());

        // =====================================================
        // BÚSQUEDAS
        // =====================================================
        int existente = 650;
        int inexistente = 700;

        System.out.println("\n=== BUSQUEDAS EN BST ALEATORIO ===");
        mostrarBusqueda(bstAleatorio, existente);
        mostrarBusqueda(bstAleatorio, inexistente);

        System.out.println("\n=== BUSQUEDAS EN BST ORDENADO ===");
        mostrarBusqueda(bstOrdenado, existente);
        mostrarBusqueda(bstOrdenado, inexistente);

        // =====================================================
        // COMPARACIÓN FINAL
        // =====================================================
        System.out.println("\n=== COMPARACION FINAL ===");
        System.out.println(
                "Altura con datos aleatorios: "
                        + bstAleatorio.altura()
        );

        System.out.println(
                "Altura con datos ordenados: "
                        + bstOrdenado.altura()
        );

        System.out.println(
                "\nConclusion: el orden de insercion modifica "
                        + "la forma del BST. Cuando los datos llegan "
                        + "ordenados, el arbol puede degenerarse y "
                        + "aumentar considerablemente su altura."
        );

        // =====================================================
        // MOSTRAR CATÁLOGO ORDENADO POR CÓDIGO
        // =====================================================
        System.out.println("\n=== STOCK ORDENADO POR CODIGO ===");
        bstAleatorio.mostrarInorden();
    }

    private static void mostrarBusqueda(
            ArbolBSTCatalogo arbol,
            int codigo) {

        ResultadoBusqueda resultado =
                arbol.buscarConTraza(codigo);

        System.out.println("\nCodigo buscado: " + codigo);
        System.out.println(
                "Encontrado: " + resultado.encontrado()
        );
        System.out.println(
                "Comparaciones: " + resultado.getComparaciones()
        );
        System.out.println(
                "Camino: " + resultado.getCamino()
        );

        if (resultado.encontrado()) {
            System.out.println(
                    "Producto: " + resultado.getProducto()
            );
        }
    }

    private static void imprimirCodigos(
            List<Producto> productos) {

        for (Producto p : productos) {
            System.out.print(p.getCodigo() + " ");
        }
        System.out.println();
    }

    private static List<Producto> crearProductos() {

        List<Producto> lista = new ArrayList<>();

    lista.add(new Producto(0,   "NVZTORE",      "Hombre",   100.0));
    lista.add(new Producto(765, "Chamarras",    "Unisex",    90.0));
    lista.add(new Producto(123, "Chaqueta",     "Unisex",    50.0));
    lista.add(new Producto(876, "Buzos",        "Mujer",     60.0));
    lista.add(new Producto(234, "Sacos",        "Hombre",    30.0));
    lista.add(new Producto(345, "Pantalones", "Hombre",    45.0));
    lista.add(new Producto(901, "Pants",        "Mujer",     70.0));
    lista.add(new Producto(1012, "Vestidos",        "Mujer",     55.0));
    lista.add(new Producto(456, "Camisas", "Hombre",    20.0));
    lista.add(new Producto(678, "Correas",        "Mujer",     40.0));
    lista.add(new Producto(567, "Camisetas", "Unisex",    25.0));
 
    
    return lista;
    }
}
