import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        //Inicializar 
        Scanner scanner = new Scanner(System.in);
        //Se pone en null para verificar luego que se hayan creado 
        MatrizDeJuego matriz = null;
        ListaDobleEnlazada lista = null;
        ArbolBinario arbol = null;

        System.out.println("\n === Bienvenid@ ===");

        //Menu
        while (true) {
            System.out.println("\nMenu de opciones, \nIngrese el número correspondiente a tu elección: \n");
            System.out.println("1. Crear/cargar - Guardar matriz");
            System.out.println("2. Crear Lista Enlazada Doble");
            System.out.println("3. Crear Arbol Binario");
            System.out.println("4. Operaciones con la Lista Enlazada Doble");
            System.out.println("5. Operaciones con el Arbol Binario");
            System.out.println("6. Salir");
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
                            System.out.println("Ingrese el nombre del archivo CSV:");
                            scanner.nextLine(); // Limpiar el scanner
                            String archivoCSV = scanner.nextLine().trim();
                            matriz = new MatrizDeJuego(archivoCSV);
                            System.out.println("Matriz cargada desde " + archivoCSV);
                        }
                        break;
                    case 2:
                        if (matriz == null) {
                            System.out.println("Debe crear primero la matriz.");
                        } else {
                            lista = new ListaDobleEnlazada();
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
                            arbol = new ArbolBinario();
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
                            System.out.println("Operaciones con la Lista Enlazada Doble:");
                            System.out.println("1. Obtener el elemento mAs grande");
                            System.out.println("2. Obtener el elemento mAs pequeño");
                            System.out.println("3. Obtener el promedio");
                            System.out.println("4. Obtener cuAntos números primos tiene la lista");
                            System.out.println("5. Guardar cada elemento de la lista en un archivo BINARIO");
                            System.out.println("6. Cargar los elementos de un archivo binario en una nueva lista");
                            int subOpcion4 = scanner.nextInt();
                            switch (subOpcion4) {
                                case 1:
                                    System.out.println("Mayor elemento: " + lista.obtenerMayor());
                                    break;
                                case 2:
                                    System.out.println("Menor elemento: " + lista.obtenerMenor());
                                    break;
                                case 3:
                                    System.out.println("Promedio: " + lista.obtenerPromedio());
                                    break;
                                case 4:
                                    System.out.println("Cantidad de números primos: " + lista.contarPrimos());
                                    break;
                                case 5:
                                    lista.guardarEnBinario("lista.bin");
                                    System.out.println("Lista guardada en lista.bin");
                                    break;
                                case 6:
                                    lista.cargarDeBinario("lista.bin");
                                    System.out.println("Lista cargada desde lista.bin");
                                    lista.mostrar();
                                    break;
                                default:
                                    System.out.println("Opción no vAlida.");
                            }
                        }
                        break;
                    case 5:
                        if (arbol == null) {
                            System.out.println("Debe crear primero el Arbol binario.");
                        } else {
                            System.out.println("Operaciones con el Arbol Binario:");
                            System.out.println("1. Obtener cantidad de nodos a la izquierda de la raíz del Arbol");
                            System.out.println("2. Obtener cantidad de nodos a la derecha de la raíz del Arbol");
                            System.out.println("3. Guardar cada recorrido del Arbol en archivos de texto");
                            System.out.println("4. Cargar los datos del archivo recorrido PreOrden");
                            int subOpcion5 = scanner.nextInt();
                            switch (subOpcion5) {
                                case 1:
                                    System.out.println("Nodos a la izquierda: " + arbol.contarNodosIzquierda());
                                    break;
                                case 2:
                                    System.out.println("Nodos a la derecha: " + arbol.contarNodosDerecha());
                                    break;
                                case 3:
                                    arbol.guardarEnArchivo("arbol_preOrden.txt", "PreOrden");
                                    arbol.guardarEnArchivo("arbol_Orden.txt", "Orden");
                                    arbol.guardarEnArchivo("arbol_postOrden.txt", "PostOrden");
                                    System.out.println("Recorridos guardados en archivos de texto.");
                                    break;
                                case 4:
                                    arbol.cargarPreOrden("arbol_preorden.txt");
                                    arbol.mostrarPreOrden();
                                    arbol.mostrarOrden();
                                    arbol.mostrarPostOrden();
                                    break;
                                default:
                                    System.out.println("Opción no vAlida.");
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Gracias!");
                        System.exit(0); // Salir del programa
                    default:
                        System.out.println("Opción no vAlida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
    }
}
