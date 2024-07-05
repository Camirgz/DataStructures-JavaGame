import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Inicializaciones
        Scanner scanner = new Scanner(System.in);
        MatrizDeJuego matriz = new MatrizDeJuego();
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        ArbolBinario arbol = new ArbolBinario();

        //Menu
        while (true) {
            System.out.println("Menú de opciones, ingrese el número correspondiente a tu elección:");
            System.out.println("1.Crear/cargar – Guardar matriz");
            System.out.println("2.Crear Lista Enlazada Doble");
            System.out.println("3.Crear Árbol Binario");
            System.out.println("4.Operaciones con la Lista Enlazada Doble");
            System.out.println("5.Operaciones con el Árbol Binario");
            System.out.println("6.Salir");
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                    //Crear/Guardar matriz
                        System.out.println("1. Crear nueva matriz");
                        System.out.println("2. Guardar matriz en archivo CSV");
                        System.out.println("3. Cargar matriz desde archivo CSV");
                        int subOpcion = scanner.nextInt();
                        if (subOpcion == 1 ) {
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
                    //Lista enalazada
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
                    //Arbol binario
                        elementos = matriz.getMatriz();
                        for (Elemento[] fila : elementos) {
                            //Ciclo for-each
                            for (Elemento e : fila) {
                                if (e.getValor() % 2 == 0) {
                                    arbol.insertar(e);
                                }
                            }
                        }
                        System.out.println("Árbol Binario creado.");
                        break;
                    case 4:
                    //Manipular lista enlazada
                        System.out.println("1. Obtener el elemento más grande");
                        System.out.println("2. Obtener el elemento más pequeño");
                        System.out.println("3. Obtener el promedio");
                        System.out.println("4. Obtener cuántos números primos tiene la lista");
                        System.out.println("5. Guardar cada elemento de la lista en un archivo BINARIO");
                        System.out.println("6. Cargar los elementos de un archivo binario en una nueva lista");
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
                    //Manipular arbol
                        System.out.println("1. Obtener cantidad de nodos a la izquierda de la raíz del árbol");
                        System.out.println("2. Obtener cantidad de nodos a la derecha de la raíz del árbol");
                        System.out.println("3. Guardar cada recorrido del árbol en archivos de texto");
                        System.out.println("4. Cargar los datos del archivo recorrido PreOrden");
                        int subOpcion5 = scanner.nextInt();
                        if (subOpcion5 == 1) {
                            System.out.println("Nodos a la izquierda: " + arbol.contarNodosIzquierda());
                        } else if (subOpcion5 == 2) {
                            System.out.println("Nodos a la derecha: " + arbol.contarNodosDerecha());
                        } else if (subOpcion5 == 3) {
                            arbol.guardarEnArchivo("arbol_preOrden.txt", "PreOrden");
                            arbol.guardarEnArchivo("arbol_Orden.txt", "Orden");
                            arbol.guardarEnArchivo("arbol_postOrden.txt", "PostOrden");
                            System.out.println("Recorridos guardados en archivos de texto.");
                        } else if (subOpcion5 == 4) {
                            arbol.cargarPreOrden("arbol_preorden.txt");
                            arbol.mostrarPreOrden();
                            arbol.mostrarOrden();
                            arbol.mostrarPostOrden();
                        }
                        break;
                    case 6:
                        System.out.println("Gracias!");
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Valor inválido, " + e.toString());
            }
        }
    }
}
