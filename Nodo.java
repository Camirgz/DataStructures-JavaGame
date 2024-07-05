public class Nodo {
    
    //Atributos
    private Elemento dato;
    private Nodo siguiente;
    private Nodo anterior;

    //Constructor
    public Nodo(Elemento dato) {
        this.dato = dato;
    }

    //Getters Setters
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
