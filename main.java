import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Incializaciones
        Scanner scanner = new Scanner(System.in);
        MatrizDeJuego matriz = null;  // Inicializa matriz como nulo al inicio
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("\n=== Bienvenid@ ===");

        while (true) {
            System.out.println( "\n== Menu de opciones== \nIngrese el número correspondiente a su eleccion: \n");
            System.out.println("1.Crear/cargar - Guardar matriz");
            System.out.println("2.Crear Lista Enlazada Doble");
            System.out.println("3.Crear Arbol Binario");
            System.out.println("4.Operaciones con la Lista Enlazada Doble");
            System.out.println("5.Operaciones con el Arbol Binario");
            System.out.println("6.Salir");
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("1. Crear nueva matriz");
                        System.out.println("2. Guardar matriz en archivo CSV");
                        System.out.println("3. Cargar matriz desde archivo CSV");
                        int subOpcion = scanner.nextInt();
                        if (subOpcion == 1) {
                            matriz = new MatrizDeJuego();
                            System.out.println("Matriz creada.");
                        } else if (subOpcion == 2) {
                            if (matriz == null) {
                                System.out.println("Debe crear primero la matriz.");
                            } else {
                                matriz.guardarEnCSV("matriz.csv");
                                System.out.println("Matriz guardada en matriz.csv");
                            }
                        } else if (subOpcion == 3) {
                            // Implementar la carga de archivo CSV
                        }
                        break;
                    case 2:
                        if (matriz == null) {
                            System.out.println("Debe crear primero la matriz.");
                        } else {
                            Elemento[][] elementos = matriz.getMatriz();
                            for (Elemento[] fila : elementos) {
                                for (Elemento e : fila) {
                                    if (e.getValor() % 2 != 0) {
                                        lista.insertarAlInicio(e);
                                    }
                                }
                            }
                            System.out.println("Lista Enlazada Doble creada.");
                        }
                        break;
                    case 3:
                        if (matriz == null) {
                            System.out.println("Debe crear primero la matriz.");
                        } else {
                            Elemento[][] elementos = matriz.getMatriz();
                            for (Elemento[] fila : elementos) {
                                for (Elemento e : fila) {
                                    if (e.getValor() % 2 == 0) {
                                        arbol.insertar(e);
                                    }
                                }
                            }
                            System.out.println("Arbol Binario creado.");
                        }
                        break;
                    case 4:
                        if (lista == null) {
                            System.out.println("Debe crear primero la lista enlazada.");
                        } else {
                            // Operaciones con lista enlazada
                        }
                        break;
                    case 5:
                        if (arbol == null) {
                            System.out.println("Debe crear primero el Arbol binario.");
                        } else {
                            // Operaciones con Arbol binario
                        }
                        break;
                    case 6:
                        System.out.println("Gracias!");
                        System.exit(0); //Salir del programa
                    default:
                        System.out.println("Opción no vAlida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
    }
}
