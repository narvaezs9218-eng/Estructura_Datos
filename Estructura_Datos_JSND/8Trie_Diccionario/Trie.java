import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ==========================================
// 1. CLASE NODO DEL TRIE
// ==========================================
class NodoTrie {
    // Mapa de hijos: cada carácter apunta a su respectivo nodo hijo
    Map<Character, NodoTrie> hijos;
    boolean esFinDePalabra;
    String palabraCompleta; // Opcional: almacena la palabra para un acceso directo más rápido

    public NodoTrie() {
        hijos = new HashMap<>();
        esFinDePalabra = false;
        palabraCompleta = null;
    }
}

// ==========================================
// 2. CLASE PRINCIPAL DEL TRIE (AUTOCOMPLETABLE)
// ==========================================
public class Trie {
    private final NodoTrie raiz;
    private int contadorPalabras;

    public Trie() {
        raiz = new NodoTrie();
        contadorPalabras = 0;
    }

    // Insertar una palabra en el Trie (ignora mayúsculas convirtiéndolas a minúsculas)
    public void insertar(String palabra) {
        if (palabra == null || palabra.isEmpty()) return;
        String palabraLimpia = palabra.toLowerCase().trim();
        
        NodoTrie actual = raiz;
        for (char c : palabraLimpia.toCharArray()) {
            actual.hijos.putIfAbsent(c, new NodoTrie());
            actual = actual.hijos.get(c);
        }
        
        // Si no era una palabra registrada previamente, incrementamos el tamaño
        if (!actual.esFinDePalabra) {
            actual.esFinDePalabra = true;
            actual.palabraCompleta = palabraLimpia;
            contadorPalabras++;
        }
    }

    // Buscar una palabra exacta en el Trie
    public boolean buscar(String palabra) {
        if (palabra == null) return false;
        String palabraLimpia = palabra.toLowerCase().trim();
        
        NodoTrie nodo = buscarNodo(palabraLimpia);
        return nodo != null && nodo.esFinDePalabra;
    }

    // Verificar si existe alguna palabra que empiece con un prefijo dado
    public boolean empiezaCon(String prefijo) {
        return buscarNodo(prefijo) != null;
    }

    // Método auxiliar para descender por el Trie según los caracteres de una cadena
    private NodoTrie buscarNodo(String cadena) {
        if (cadena == null) return null;
        String limpia = cadena.toLowerCase().trim();
        NodoTrie actual = raiz;
        
        for (char c : limpia.toCharArray()) {
            NodoTrie hijo = actual.hijos.get(c);
            if (hijo == null) {
                return null;
            }
            actual = hijo;
        }
        return actual;
    }

    // Devolver sugerencias de autocompletado limitadas por defecto a 5 resultados
    public List<String> sugerir(String prefijo) {
        return sugerir(prefijo, 5);
    }

    // Devolver sugerencias de autocompletado con un límite personalizado de resultados
    public List<String> sugerir(String prefijo, int limite) {
        List<String> resultados = new ArrayList<>();
        if (prefijo == null) return resultados;
        
        NodoTrie nodoPrefijo = buscarNodo(prefijo);
        if (nodoPrefijo == null) {
            return resultados; // Retorna lista vacía si el prefijo no existe
        }
        
        // Recorrido en profundidad (DFS) para recolectar todas las palabras bajo el nodo del prefijo
        recolectarPalabras(nodoPrefijo, resultados, limite);
        return resultados;
    }

    // Método auxiliar recursivo DFS para recolectar palabras
    private void recolectarPalabras(NodoTrie nodo, List<String> resultados, int limite) {
        if (resultados.size() >= limite) return;
        
        if (nodo.esFinDePalabra) {
            resultados.add(nodo.palabraCompleta);
        }
        
        // Orden alfabético implícito si se recorre el mapa ordenado (o iteración estándar de HashMap)
        for (Character c : nodo.hijos.keySet()) {
            if (resultados.size() >= limite) break;
            recolectarPalabras(nodo.hijos.get(c), resultados, limite);
        }
    }

    // Retorna la cantidad total de palabras almacenadas
    public int tamanio() {
        return contadorPalabras;
    }

    // ==========================================
    // 3. MÉTODO PRINCIPAL (PRUEBAS CON SVZTORE)
    // ==========================================
    public static void main(String[] args) {
        Trie trieSVZTORE = new Trie();

        // Cargamos los productos de la tienda SVZTORE
        String[] productosSVZTORE = {
            "buzos", "buscos","busos", "buscar", "camisas", "camisetas", "camillas", "camellos", "camisetillas", "cama", "chaqueta", "chamarras", "chatarra","correas", "correras", "corremos", "correrlas","sacos","secos", "sacas", "pantalon","pantaleta", 
             "pants", "pan",  "pantis", "panson",  "vestidos", "vestilos",  "vestir", "vestira", "vestidas", "vestidores", "vestidos", "svztore", "snarvaez"
        };

        for (String p : productosSVZTORE) {
            trieSVZTORE.insertar(p);
        }

        System.out.println("=== MOTOR DE BUSQUEDA Y AUTOCOMPLETADO SVZTORE (TRIE) ===");
        System.out.println("Productos cargados en el Trie: " + trieSVZTORE.tamanio());

        // Pruebas de autocompletado con prefijos de la tienda
        System.out.println("\n--- Sugerencias de busqueda ---");
        String[] prefijosPrueba = {"ca", "pa", "bu", "ve", "al", "svz", "sna", "xyz"};
        for (String pref : prefijosPrueba) {
            List<String> sugerencias = trieSVZTORE.sugerir(pref);
            System.out.printf("Prefijo \"%s\" -> %s%n", pref, sugerencias.isEmpty() ? "(sin sugerencias)" : sugerencias);
        }

        // Verificaciones del sistema
        System.out.println("\n--- Verificaciones de inventario ---");
        System.out.println(" Existe 'chaqueta'? " + trieSVZTORE.buscar("chaqueta"));
        System.out.println(" Existe 'snarvaez'? " + trieSVZTORE.buscar("snarvaez"));
        System.out.println(" Existe categoria o prefijo 'cam'? " + trieSVZTORE.empiezaCon("cam"));
        System.out.println(" Existe categoria o prefijo 'pam'? " + trieSVZTORE.empiezaCon("pam"));
        System.out.println(" Sugerencias para 'cam' (max 4): " + trieSVZTORE.sugerir("cam", 4));
        System.out.println("\n---                 <<(*-*)>>                  ---");
    }
}