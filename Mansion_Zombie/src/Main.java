//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int opcionElegida = Menu_Inicio();
        if(opcionElegida == 1) {
            int Resultado_Dificultad_Facil = Menu_DIficultad_Facil();
            System.out.println("Has elegido el numero " + Resultado_Dificultad_Facil);
        } else {
            int Resultado_Dificultad_Dificil = Menu_Dificultad_Dificl();
            System.out.println("Has elegido el numero " + Resultado_Dificultad_Dificil);
        }
    }

    public static int Menu_Inicio() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("BIENVENIDO A LA MANSION ZOMBIE, ELIGE DIFICULTAD: ");
            System.out.println("1. FACIL: (5 HABITACIONES)");
            System.out.println("2.DIFICIL: (10 HABITACIONES)");
            System.out.println("-------------------------------------------------");
            System.out.println("OPCION: ");

            if(sc.hasNextInt()) { //Si escribe un numero lo lee
                opcion = sc.nextInt();
            } else {
                sc.next(); //Desechamos o Borramos todos los simbolos
            }

            if(opcion != 1 && opcion != 2) {
                System.out.println("Opcion no valida");
            }
        } while(opcion != 1 && opcion != 2);
        return  opcion;
    }

    public static int Menu_DIficultad_Facil() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("** PV:20 #MAX(20); ARMAS:0; PROTECCION:0");
            System.out.println("** LA HABITACION 1 CONTIENE: 1 ZOMBIE");
            System.out.println("** ELIGE UNA DE LAS SIGUIENTES ACCIONES:");
            System.out.println("1.COMBATIR CONTRA UN ZOMBIE");
            System.out.println("-------------------------------------------------");
            System.out.println("OPCION: ");

            if (sc.hasNextInt()) { //Si escribes un numero lo lee
                opcion = sc.nextInt();
            } else {
                sc.next(); //Desechamos o Borramos todos los simbolos
            }

            if (opcion != 1) {
                System.out.println("Opcion no valida");
            }
        } while(opcion != 1);
        return opcion;
    }

    public static int Menu_Dificultad_Dificl() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("** PV:20 #MAX(20); ARMAS:0; PROTECCION:O");
            System.out.println("** LA HABITACION 1 CONTIENE: 1 ZOMBIE");
            System.out.println("** ELIGE UNA DE LAS SIGUIENTES ACCIONES:");
            System.out.println("1. COMBATIR CONTRA UN ZOMBIE");
            System.out.println("-------------------------------------------------");
            System.out.println("OPCION: ");

             if (sc.hasNextInt()) {
                 opcion = sc.nextInt();
             } else {
                 sc.next();
             }

             if (opcion != 1) {
                 System.out.println("Opcion no valida");
             }
        } while(opcion != 1);
        return opcion;
    }
}