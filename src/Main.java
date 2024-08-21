/*Durante las clases de C++ en SoloLearn, me mencionaron sobre la Pascal Case y Camel Case para declarar funciones y variables.
En este caso intenté usar Camel Case, para llevar un orden en el código.*/

//El menu tiene como base el menu que tengo como repositorio en Github

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String[][] cartas = crearMatrizCartas();
        //mostrarCartas(cartas);
        boolean continuar = true;
        while(continuar){
            printMenu(); //Primero se imprime el menu
            int opcion = readOption(); //Se declara una variable de tipo int, y se iguala a la funcion readOption
            switch (opcion) { //Utilizo un switch para las opciones
                case 1: {
                    jugar(cartas);
                    break;
                }
                case 2: {
                    continuar = salir();
                    break;
                }
                default: { //En caso de que no se seleccione una opcion valida, creo que no es necesaria debido al do-while en la funcion readOption... Pero lo dejo por si acaso
                    System.out.println("Opcion no valida");
                    break;
                }
            }
        }
    }

    public static int readOption() { //Funcion que se encargara de leer la opcion seleccionada por el usuario
        int opcion;
        Scanner scanner = new Scanner(System.in); //Se crea un objeto de tipo Scanner
        do{
            while (!scanner.hasNextInt()) { //Este while se repetira hasta que el dato ingresado sea un numero
                System.out.println("La opcion elegida debe ser un numero");
                System.out.print("Selecciona una opcion: ");
                scanner.next();
            }
            opcion = scanner.nextInt(); //Si el valor ingresado es un numero, este se igualara a la variable opcion
            if (opcion < 1 || opcion > 2) { //Se comprueba si el numero ingresado esta entre las opciones validas, por eso antes mencione lo de que en el switch no se si es necesario el default
                System.out.println("Opcion invalida");
                System.out.print("Selecciona una opcion: ");
            }
        } while (opcion < 1 || opcion > 2);
        return opcion; //Se retorna la opcion seleccionada por el usuario
    }

    public static void printMenu() { //Funcion que imprime el menu para que las funciones no sean tan largas
        System.out.println("\nMenu");
        System.out.println("1. Jugar");
        System.out.println("2. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    public static String[][] crearMatrizCartas() {
        String cartas[][] = new String[12][2]; //[Filas] [Columnas]
        cartas = inicializarCartasJuego(cartas);
        return cartas;
    }

    public static String[][] agregarCartas(String cartas[][]){
        cartas[0][0] = "Carta A";
        cartas[1][0] = "Carta 2";
        cartas[2][0] = "Carta 3";
        cartas[3][0] = "Carta 4";
        cartas[4][0] = "Carta 5";
        cartas[5][0] = "Carta 6";
        cartas[6][0] = "Carta 7";
        cartas[7][0] = "Carta 8";
        cartas[8][0] = "Carta 9";
        cartas[9][0] = "Carta J";
        cartas[10][0] = "Carta Q";
        cartas[11][0] = "Carta K";
        for (int i = 0; i < 12; i++) {
            if (i == 0){
                cartas[i][1] = "11";
            }
            if ( i > 0 && i < 9) {
                String valor = Integer.toString(i + 1);
                cartas[i][1] = valor;
            }
            if (i >= 9){
                cartas[i][1] = "10";
            }

        }
        return cartas;
    }

    public static String[][] inicializarCartasJuego(String cartas[][]) {
        cartas = agregarCartas(cartas);
        return cartas;
    }

    public static int obtenerCartas(String cartas[][]){
        Random random = new Random();
        int puntaje = 0;
        for (int i = 0; i < 2; i++) {
            int numeroRandom = random.nextInt(12);
            puntaje = puntaje + Integer.parseInt(cartas[numeroRandom][1]);
        }
        return puntaje;
    }

    public static void jugar(String cartas[][]){
        int puntajeUno = obtenerCartas(cartas);
        int puntajeDos = obtenerCartas(cartas);
        System.out.println("Puntaje del jugador 1: " + puntajeUno);
        System.out.println("Puntaje del jugador 2: " + puntajeDos);
        comprobacionVictoria(puntajeUno, puntajeDos);
        }

    public static void comprobacionVictoria(int puntajeUno, int puntajeDos){
        if (puntajeUno == 20){
            System.out.println("Ha ganado el jugador 1");
        }
        if (puntajeDos == 20) {
            System.out.println("Ha ganado el jugador 2");
        }
        if (puntajeUno > 20) {
            System.out.println("Ha ganado el jugador 2");
        }
        if (puntajeDos > 20) {
            System.out.println("Ha ganado el jugador 1");
        }
        if (puntajeUno < 20 && puntajeDos < 20) {
            if (puntajeUno == puntajeDos) {
                System.out.println("Ha sido un empate");
            } else if (puntajeUno > puntajeDos) {
                System.out.println("Ha ganado el jugador 1");
            } else {
                System.out.println("Ha ganado el jugador 2");
            }
        }
        }

    public static boolean salir(){
        System.out.println("Gracias por jugar c:");
        return false;
    }

    /* Esta funcion de aqui, la cree durante el desarrollo del codigo para poder ver si la matriz se creaba correctamente
    public static void mostrarCartas(String cartas[][]){
        for (int i = 0; i < 12; i++) {
            System.out.print(cartas[i][0]);
            System.out.println(cartas[i][1]);
            }
    }*/
}