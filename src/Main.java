/*Durante las clases de C++ en SoloLearn, me mencionaron sobre la Pascal Case y Camel Case para declarar funciones y variables.
En este caso intenté usar Camel Case, para llevar un orden en el código.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean continuar = true;
        while(continuar){
        printMenu(); //Primero se imprime el menu
        int opcion = readOption(); //Se declara una variable de tipo int, y se iguala a la funcion readOption
        switch (opcion) { //Utilizo un switch para las opciones
            case 1 ->
                    jugar();
            case 2 ->
                    continuar = salir();
            default -> //En caso de que no se seleccione una opcion valida, creo que no es necesaria debido al do-while en la funcion readOption... Pero lo dejo por si acaso
                    System.out.println("Opcion no valida");
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
        scanner.close(); //Se cierra el objeto de tipo Scanner
        return opcion; //Se retorna la opcion seleccionada por el usuario
    }

    public static void printMenu() { //Funcion que imprime el menu para que las funciones no sean tan largas
        System.out.println("\nMenu");
        System.out.println("1. Jugar");
        System.out.println("2. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    public static void crearMatrizCartas() {
    }

    public static void agregarCartas(){

    }

    public static void inicializarCartasJuego() {

    }

    public static void obtenerCartas(){

    }

    public static void jugar(){

    }

    public static boolean salir(){
        return false;
    }


}