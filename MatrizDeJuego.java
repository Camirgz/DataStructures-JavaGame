import java.io.*;
import java.util.Random;

public class MatrizDeJuego {

    //Atributos
    private Elemento[][] matriz;
    private final int FILAS = 10;
    private final int COLUMNAS = 10;

    //Constructor de la matriz
    public MatrizDeJuego() {
        matriz = new Elemento[FILAS][COLUMNAS];
        Random rand = new Random();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = new Elemento(rand.nextInt(100));
            }
        }
    }

    //Archivo
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

    //Getter de la matriz
    public Elemento[][] getMatriz() {
        return matriz;
    }
}
