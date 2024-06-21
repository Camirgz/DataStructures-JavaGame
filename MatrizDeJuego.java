import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MatrizDeJuego {

    //Atributos
    private Elemento[][] matriz;
    private final int FILAS = 10;
    private final int COLUMNAS = 10;

    public MatrizDeJuego() {
        matriz = new Elemento[FILAS][COLUMNAS];
        Random rand = new Random();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = new Elemento(rand.nextInt(100));
            }
        }
    }

    public void guardarEnCSV(String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < FILAS; i++) {
                for (int j = 0; j < COLUMNAS; j++) {
                    writer.write(matriz[i][j].getValor() + (j < COLUMNAS - 1 ? "," : ""));
                }
                writer.newLine();
            }
        }
    }

    public Elemento[][] getMatriz() {
        return matriz;
    }
}
