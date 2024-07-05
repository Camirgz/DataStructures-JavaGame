import java.io.*;

public class ArbolBinario {

    //Atributo nodo
    private NodoArbol raiz;

    public void insertar(Elemento dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbol insertarRec(NodoArbol raiz, Elemento dato) {

        //Verificar que el arbol no esté vacío
        if (raiz == null) {
            raiz = new NodoArbol(dato);
            return raiz;
        }
        if (dato.getValor() < raiz.getDato().getValor()) {
            raiz.setIzquierdo(insertarRec(raiz.getIzquierdo(), dato));
        } else if (dato.getValor() > raiz.getDato().getValor()) {
            raiz.setDerecho(insertarRec(raiz.getDerecho(), dato));
        }
        return raiz;
    }

    //Contar nodos
    public int contarNodosIzquierda() {
        return contarNodos(raiz.getIzquierdo());
    }

    public int contarNodosDerecha() {
        return contarNodos(raiz.getDerecho());
    }

    private int contarNodos(NodoArbol nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }
    public void guardarEnArchivo(String archivo, String recorrido) {
        while (true) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                if ("PreOrden".equals(recorrido)) {
                    guardarPreOrden(raiz, writer);
                } else if ("Orden".equals(recorrido)) {
                    guardarOrden(raiz, writer);
                } else if ("PostOrden".equals(recorrido)) {
                    guardarPostOrden(raiz, writer);
                }
                break; // Si todo va bien, salimos del bucle
            } catch (IOException e) {
                System.out.println("Error al guardar en archivo: " + e.getMessage());
            }
        }
    }

    private void guardarPreOrden(NodoArbol nodo, BufferedWriter writer) {
        try {
            if (nodo != null) {
                writer.write(nodo.getDato().getValor() + "\n");
                guardarPreOrden(nodo.getIzquierdo(), writer);
                guardarPreOrden(nodo.getDerecho(), writer);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo: " + e.getMessage());
        }
    }

    private void guardarOrden(NodoArbol nodo, BufferedWriter writer) {
        try {
            if (nodo != null) {
                guardarOrden(nodo.getIzquierdo(), writer);
                writer.write(nodo.getDato().getValor() + "\n");
                guardarOrden(nodo.getDerecho(), writer);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo: " + e.getMessage());
        }
    }

    private void guardarPostOrden(NodoArbol nodo, BufferedWriter writer) {
        try {
            if (nodo != null) {
                guardarPostOrden(nodo.getIzquierdo(), writer);
                guardarPostOrden(nodo.getDerecho(), writer);
                writer.write(nodo.getDato().getValor() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo: " + e.getMessage());
        }
    }

    // Cargar pre-orden
    public void cargarPreOrden(String archivo) {
        while (true) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                raiz = null;
                String linea;
                while ((linea = reader.readLine()) != null) {
                    insertar(new Elemento(Integer.parseInt(linea)));
                }
                break; // Si todo va bien, salimos del bucle
            } catch (IOException e) {
                System.out.println("Error al cargar desde archivo: " + e.getMessage());
            }
        }
    }


    //Mostrar Órdenes
    public void mostrarPreOrden() {
        mostrarPreOrdenRec(raiz);
        System.out.println();
    }

    private void mostrarPreOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato().getValor() + " ");
            mostrarPreOrdenRec(nodo.getIzquierdo());
            mostrarPreOrdenRec(nodo.getDerecho());
        }
    }

    public void mostrarOrden() {
        mostrarOrdenRec(raiz);
        System.out.println();
    }

    private void mostrarOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            mostrarOrdenRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato().getValor() + " ");
            mostrarOrdenRec(nodo.getDerecho());
        }
    }

    public void mostrarPostOrden() {
        mostrarPostOrdenRec(raiz);
        System.out.println();
    }

    private void mostrarPostOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            mostrarPostOrdenRec(nodo.getIzquierdo());
            mostrarPostOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato().getValor() + " ");
        }
    }
}
