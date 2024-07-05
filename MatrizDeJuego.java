import java.io.*;
import java.util.Random;

public class MatrizDeJuego {

    private Elemento[][] matriz;
    private final int FILAS = 10;
    private final int COLUMNAS = 10;

    public MatrizDeJuego() {
        matriz = new Elemento[FILAS][COLUMNAS];
        inicializarMatrizAleatoria();
    }

    // Constructor para cargar desde un archivo CSV
    public MatrizDeJuego(String archivoCSV) {
        matriz = new Elemento[FILAS][COLUMNAS];
        try {
            cargarDesdeCSV(archivoCSV);
        } catch (Exception e) {
            System.out.println("Error al cargar la matriz desde el archivo CSV: " + e.getMessage());
            inicializarMatrizAleatoria(); // En caso de error, inicializa aleatoriamente
        }
    }

    private void inicializarMatrizAleatoria() {
        Random rand = new Random();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = new Elemento(rand.nextInt(100));
            }
        }
    }

    // Guardar la matriz en CSV
    public void guardarEnCSV(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < FILAS; i++) {
                for (int j = 0; j < COLUMNAS; j++) {
                    writer.write(matriz[i][j].getValor() + (j < COLUMNAS - 1 ? "," : ""));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la matriz en el archivo CSV: " + e.getMessage());
        }
    }

    // Cargar la matriz desde CSV
    public void cargarDesdeCSV(String archivoCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            int fila = 0;
            while ((line = br.readLine()) != null && fila < FILAS) {
                String[] valores = line.split(",");
                for (int columna = 0; columna < COLUMNAS && columna < valores.length; columna++) {
                    try {
                        matriz[fila][columna] = new Elemento(Integer.parseInt(valores[columna].trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir valor en la línea " + fila + ", columna " + columna);
                        matriz[fila][columna] = new Elemento(0); // Asignar un valor por defecto
                    }
                }
                fila++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
    

    public Elemento[][] getMatriz() {
        return matriz;
    }
}
