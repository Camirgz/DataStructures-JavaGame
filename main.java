import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MatrizDeJuego matriz = new MatrizDeJuego();
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        ArbolBinario arbol = new ArbolBinario();

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1- Crear/cargar – Guardar matriz");
            System.out.println("2- Crear Lista Enlazada Doble");
            System.out.println("3- Crear Árbol Binario");
            System.out.println("4- Operaciones con la Lista Enlazada Doble");
            System.out.println("5- Operaciones con el Árbol Binario");
            System.out.println("6- Salir");
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("1a. Crear nueva matriz");
                        System.out.println("1b. Guardar matriz en archivo CSV");
                        System.out.println("1c. Cargar matriz desde archivo CSV");
                        int subOpcion = scanner.nextInt();
                        if (subOpcion == 1) {
                            matriz = new MatrizDeJuego();
                            System.out.println("Matriz creada.");
                        } else if (subOpcion == 2) {
                            matriz.guardarEnCSV("matriz.csv");
                            System.out.println("Matriz guardada en matriz.csv");
                        } else if (subOpcion == 3) {
                            // Implementar la carga de archivo CSV
                        }
                        break;
                    case 2:
                        Elemento[][] elementos = matriz.getMatriz();
                        for (Elemento[] fila : elementos) {
                            for (Elemento e : fila) {
                                if (e.getValor() % 2 != 0) {
                                    lista.insertarAlInicio(e);
                                }
                            }
                        }
                        System.out.println("Lista Enlazada Doble creada.");
                        break;
                    case 3:
                        elementos = matriz.getMatriz();
                        for (Elemento[] fila : elementos) {
                            for (Elemento e : fila) {
                                if (e.getValor() % 2 == 0) {
                                    arbol.insertar(e);
                                }
                            }
                        }
                        System.out.println("Árbol Binario creado.");
                        break;
                    case 4:
                        System.out.println("4a. Obtener el elemento más grande");
                        System.out.println("4b. Obtener el elemento más pequeño");
                        System.out.println("4c. Obtener el promedio");
                        System.out.println("4d. Obtener cuántos números primos tiene la lista");
                        System.out.println("4e. Guardar cada elemento de la lista en un archivo BINARIO");
                        System.out.println("4f. Cargar los elementos de un archivo binario en una nueva lista");
                        int subOpcion4 = scanner.nextInt();
                        if (subOpcion4 == 1) {
                            System.out.println("Mayor elemento: " + lista.obtenerMayor());
                        } else if (subOpcion4 == 2) {
                            System.out.println("Menor elemento: " + lista.obtenerMenor());
                        } else if (subOpcion4 == 3) {
                            System.out.println("Promedio: " + lista.obtenerPromedio());
                        } else if (subOpcion4 == 4) {
                            System.out.println("Cantidad de números primos: " + lista.contarPrimos());
                        } else if (subOpcion4 == 5) {
                            lista.guardarEnBinario("lista.bin");
                            System.out.println("Lista guardada en lista.bin");
                        } else if (subOpcion4 == 6) {
                            lista.cargarDeBinario("lista.bin");
                            System.out.println("Lista cargada desde lista.bin");
                            lista.mostrar();
                        }
                        break;
                    case 5:
                        System.out.println("5a. Obtener cantidad de nodos a la izquierda de la raíz del árbol");
                        System.out.println("5b. Obtener cantidad de nodos a la derecha de la raíz del árbol");
                        System.out.println("5c. Guardar cada recorrido del árbol en archivos de texto");
                        System.out.println("5d. Cargar los datos del archivo recorrido PreOrder");
                        int subOpcion5 = scanner.nextInt();
                        if (subOpcion5 == 1) {
                            System.out.println("Nodos a la izquierda: " + arbol.contarNodosIzquierda());
                        } else if (subOpcion5 == 2) {
                            System.out.println("Nodos a la derecha: " + arbol.contarNodosDerecha());
                        } else if (subOpcion5 == 3) {
                            arbol.guardarEnArchivo("arbol_preorder.txt", "PreOrder");
                            arbol.guardarEnArchivo("arbol_order.txt", "Order");
                            arbol.guardarEnArchivo("arbol_postorder.txt", "PostOrder");
                            System.out.println("Recorridos guardados en archivos de texto.");
                        } else if (subOpcion5 == 4) {
                            arbol.cargarPreOrder("arbol_preorder.txt");
                            arbol.mostrarPreOrder();
                            arbol.mostrarOrder();
                            arbol.mostrarPostOrder();
                        }
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
