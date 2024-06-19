

import java.io.*;

public class ArbolBinario {
    private NodoArbol raiz;

    public void insertar(Elemento dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbol insertarRec(NodoArbol raiz, Elemento dato) {
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

    public void guardarEnArchivo(String archivo, String recorrido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            if ("PreOrder".equals(recorrido)) {
                guardarPreOrder(raiz, writer);
            } else if ("Order".equals(recorrido)) {
                guardarOrder(raiz, writer);
            } else if ("PostOrder".equals(recorrido)) {
                guardarPostOrder(raiz, writer);
            }
        }
    }

    private void guardarPreOrder(NodoArbol nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            writer.write(nodo.getDato().getValor() + "\n");
            guardarPreOrder(nodo.getIzquierdo(), writer);
            guardarPreOrder(nodo.getDerecho(), writer);
        }
    }

    private void guardarOrder(NodoArbol nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            guardarOrder(nodo.getIzquierdo(), writer);
            writer.write(nodo.getDato().getValor() + "\n");
            guardarOrder(nodo.getDerecho(), writer);
        }
    }

    private void guardarPostOrder(NodoArbol nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            guardarPostOrder(nodo.getIzquierdo(), writer);
            guardarPostOrder(nodo.getDerecho(), writer);
            writer.write(nodo.getDato().getValor() + "\n");
        }
    }

    public void cargarPreOrder(String archivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            raiz = null;
            String linea;
            while ((linea = reader.readLine()) != null) {
                insertar(new Elemento(Integer.parseInt(linea)));
            }
        }
    }

    public void mostrarPreOrder() {
        mostrarPreOrderRec(raiz);
        System.out.println();
    }

    private void mostrarPreOrderRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato().getValor() + " ");
            mostrarPreOrderRec(nodo.getIzquierdo());
            mostrarPreOrderRec(nodo.getDerecho());
        }
    }

    public void mostrarOrder() {
        mostrarOrderRec(raiz);
        System.out.println();
    }

    private void mostrarOrderRec(NodoArbol nodo) {
        if (nodo != null) {
            mostrarOrderRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato().getValor() + " ");
            mostrarOrderRec(nodo.getDerecho());
        }
    }

    public void mostrarPostOrder() {
        mostrarPostOrderRec(raiz);
        System.out.println();
    }

    private void mostrarPostOrderRec(NodoArbol nodo) {
        if (nodo != null) {
            mostrarPostOrderRec(nodo.getIzquierdo());
            mostrarPostOrderRec(nodo.getDerecho());
            System.out.print(nodo.getDato().getValor() + " ");
        }
    }
}
