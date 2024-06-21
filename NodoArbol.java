public class NodoArbol {

    //Atributos
    private Elemento dato;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    //Setters y getters
    public NodoArbol(Elemento dato) {
        this.dato = dato;
    }

    public Elemento getDato() {
        return dato;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
