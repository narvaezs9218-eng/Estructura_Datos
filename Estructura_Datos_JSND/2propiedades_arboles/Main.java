import java.util.ArrayList;
import java.util.List;

class NodoGeneral<T> {
    private T dato;
    private List<NodoGeneral<T>> hijos;

    public NodoGeneral(T dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public void agregarHijo(NodoGeneral<T> hijo) {
        this.hijos.add(hijo);
    }

    public T getDato() {
        return dato;
    }

    public List<NodoGeneral<T>> getHijos() {
        return hijos;
    }

    // Método para calcular la altura del árbol (Guía 2)
    public int calcularAltura() {
        if (hijos.isEmpty()) {
            return 0;
        }
        int maxAlturaHijos = 0;
        for (NodoGeneral<T> hijo : hijos) {
            maxAlturaHijos = Math.max(maxAlturaHijos, hijo.calcularAltura());
        }
        return 1 + maxAlturaHijos;
    }

    // Método para calcular el grado del nodo (Guía 2)
    public int getGrado() {
        return hijos.size();
    }

    // Recorrido en Preorden (Guía 2)
    public void recorridoPreorden() {
        System.out.print(dato + " | ");
        for (NodoGeneral<T> hijo : hijos) {
            hijo.recorridoPreorden();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Nivel 0: Raíz
        NodoGeneral<String> raiz = new NodoGeneral<>("CO / DIR GENERAL");

        // Nivel 1: Ramas Principales
        NodoGeneral<String> dirTecnologia = new NodoGeneral<>("DIR TECNOLOGIA");
        NodoGeneral<String> dirVentas = new NodoGeneral<>("DIR VENTAS");

        raiz.agregarHijo(dirTecnologia);
        raiz.agregarHijo(dirVentas);

        // Nivel 2: Sub-ramas de Tecnología y Ventas
        NodoGeneral<String> gerDesarrollo = new NodoGeneral<>("GER DESARROLLO");
        NodoGeneral<String> gerQa = new NodoGeneral<>("GER QA");
        dirTecnologia.agregarHijo(gerDesarrollo);
        dirTecnologia.agregarHijo(gerQa);

        NodoGeneral<String> gerVentasNac = new NodoGeneral<>("GER VENTAS NAC.");
        NodoGeneral<String> gerVentasInter = new NodoGeneral<>("GER VENTAS INTER");
        dirVentas.agregarHijo(gerVentasNac);
        dirVentas.agregarHijo(gerVentasInter);

        // Nivel 3: Hojas / Nodos Operativos Terminales
        gerDesarrollo.agregarHijo(new NodoGeneral<>("DEV. FRONTED"));
        gerDesarrollo.agregarHijo(new NodoGeneral<>("DEV BACKEND"));

        gerQa.agregarHijo(new NodoGeneral<>("ING. PRUEBA"));

        gerVentasNac.agregarHijo(new NodoGeneral<>("E. CUENTAS LOCALES"));
        gerVentasNac.agregarHijo(new NodoGeneral<>("E. CUENTAS REGIONALES"));

        gerVentasInter.agregarHijo(new NodoGeneral<>("E. CUENTAS EXTRANJERAS"));

        // Pruebas de Propiedades y Recorridos (Guía 2)
        System.out.println("=== ANALISIS DEL ORGANIGRAMA EMPRESARIAL ===");
        System.out.println("Raiz del Arbol: " + raiz.getDato());
        System.out.println("Grado de la Raiz (Hijos directos): " + raiz.getGrado());
        System.out.println("Altura total del arbol: " + raiz.calcularAltura());
        System.out.println("\n=============================");

        System.out.println("\n=== RECORRIDO EN PREORDEN ===");
        raiz.recorridoPreorden();
        System.out.println();
        System.out.println("\n===        <(*-*)>        ===");
    }
}