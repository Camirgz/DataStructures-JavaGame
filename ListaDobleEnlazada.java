import java.io.*;

public class ListaDobleEnlazada implements Serializable {

    //Atributo
    private Nodo cabeza;

    public void insertarAlInicio(Elemento dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza != null) {
            cabeza.setAnterior(nuevoNodo);
            nuevoNodo.setSiguiente(cabeza);
        }
        cabeza = nuevoNodo;
    }

    //Imprimir lista
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato().getValor() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    //Estats
    public int obtenerMayor() {
        if (cabeza == null) return Integer.MIN_VALUE;
        Nodo actual = cabeza;
        int mayor = actual.getDato().getValor();
        while (actual != null) {
            if (actual.getDato().getValor() > mayor) {
                mayor = actual.getDato().getValor();
            }
            actual = actual.getSiguiente();
        }
        return mayor;
    }

    public int obtenerMenor() {
        if (cabeza == null) return Integer.MAX_VALUE;
        Nodo actual = cabeza;
        int menor = actual.getDato().getValor();
        while (actual != null) {
            if (actual.getDato().getValor() < menor) {
                menor = actual.getDato().getValor();
            }
            actual = actual.getSiguiente();
        }
        return menor;
    }

    public double obtenerPromedio() {
        if (cabeza == null) return 0;
        Nodo actual = cabeza;
        int suma = 0;
        int count = 0;
        while (actual != null) {
            suma += actual.getDato().getValor();
            count++;
            actual = actual.getSiguiente();
        }
        return (double) suma / count;
    }

    public int contarPrimos() {
        int count = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (esPrimo(actual.getDato().getValor())) {
                count++;
            }
            actual = actual.getSiguiente();
        }
        return count;
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    //Manejo de archivos binarios
    public void guardarEnBinario(String archivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            Nodo actual = cabeza;
            while (actual != null) {
                out.writeObject(actual.getDato());
                actual = actual.getSiguiente();
            }
        }
    }

    public void cargarDeBinario(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            cabeza = null;
            Elemento elemento;
            while ((elemento = (Elemento) in.readObject()) != null) {
                insertarAlInicio(elemento);
            }
        } catch (EOFException ignored) {}
    }
}
