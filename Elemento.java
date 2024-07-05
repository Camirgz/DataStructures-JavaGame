import java.io.Serializable;

public class Elemento implements Serializable {

    //Atributos
    private int valor;
    private boolean usado;

    //Constructor
    public Elemento(int valor) {
        this.valor = valor;
        this.usado = false;
    }

    //Getters Setters 
    public int getValor() {
        return valor;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    //Override de método toString para conveniencia
    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
