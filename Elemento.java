import java.io.Serializable;

public class Elemento implements Serializable {
    private int valor;
    private boolean usado;

    public Elemento(int valor) {
        this.valor = valor;
        this.usado = false;
    }

    public int getValor() {
        return valor;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
