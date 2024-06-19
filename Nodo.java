public class Nodo {
    private Elemento dato;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Elemento dato) {
        this.dato = dato;
    }

    public Elemento getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
