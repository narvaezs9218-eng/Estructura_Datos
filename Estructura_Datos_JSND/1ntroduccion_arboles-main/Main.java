
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

    // Método auxiliar para imprimir el árbol en formato jerárquico por consola
    public void imprimirArbol(String prefijo) {
        System.out.println(prefijo + " * " + dato);
               for (NodoGeneral<T> hijo : hijos) {
            hijo.imprimirArbol(prefijo + "    ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Nivel 0 (Raíz) - Nodo 1
        NodoGeneral<String> raiz = new NodoGeneral<>(" Empresa ---> N0vel 0 Raiz ");

        // N1vel - 2Nodos 
        NodoGeneral<String> tec = new NodoGeneral<>(" Tecnologia ---> N1vel Padre");
        NodoGeneral<String> fin = new NodoGeneral<>(" Finanzas ---> N1vel Padre");
        NodoGeneral<String> reh = new NodoGeneral<>(" Recursos Humanos ---> N1vel Padre");

        raiz.agregarHijo(tec); // Agregar Padres N1 
        raiz.agregarHijo(fin);
        raiz.agregarHijo(reh);   

        // N2vel 4Nodos
        NodoGeneral<String> devOps = new NodoGeneral<>("DevOps ---> H1jo");
        NodoGeneral<String> backend = new NodoGeneral<>("Backend ---> H2jo");
        NodoGeneral<String> frontend = new NodoGeneral<>("Frontend ---> H3jo");
        NodoGeneral<String> contabilidad = new NodoGeneral<>("Contabilidad ---> H1jo");
        NodoGeneral<String> tesoreria = new NodoGeneral<>("Tesoreria ---> H2jo");
        NodoGeneral<String> seleccion = new NodoGeneral<>(" Seleccion ---> H1jo");
        NodoGeneral<String> bienestar = new NodoGeneral<>(" Bienestar ---> H2jo");


        tec.agregarHijo(devOps); // Agregar Hijos N2 
        tec.agregarHijo(backend);
        tec.agregarHijo(frontend);
        fin.agregarHijo(contabilidad);
        fin.agregarHijo(tesoreria);
        reh.agregarHijo(seleccion);
        reh.agregarHijo(bienestar);

        // N3vel - 2Nodos 
        NodoGeneral<String> reactSpec = new NodoGeneral<>("Especialista React");
        NodoGeneral<String> auditoria = new NodoGeneral<>("Auditoria Interna");

        frontend.agregarHijo(reactSpec); // Agregar hijo 
        contabilidad.agregarHijo(auditoria);

        // Visualización
        System.out.println(" === Estructura Jerarquica del Arbol General === ");
        raiz.imprimirArbol("");
        System.out.println("\n===        <(*-*)>        ===");
    }
}
