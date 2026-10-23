import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionElegida = 0;

        do {
            System.out.println("-------------------------------------------------");
            System.out.println("BIENVENIDO A LA MANSIÓN ZOMBIE. ELIGE DIFICULTAD:");
            System.out.println("1. FÁCIL (5 HABITACIONES)");
            System.out.println("2. DIFÍCIL (10 HABITACIONES)");
            System.out.println("-------------------------------------------------");
            System.out.print("> OPCIÓN: ");

            if (sc.hasNextInt()) {
                opcionElegida = sc.nextInt();
            } else {
                sc.next();
            }

            if (opcionElegida != 1 && opcionElegida != 2) {
                System.out.println("Opción no válida.");
            }
        } while (opcionElegida != 1 && opcionElegida != 2);

        int maxHabitaciones = (opcionElegida == 1) ? 5 : 10;

        // Arrancamos el turno/partida con la dificultad seleccionada
        Turno turno = new Turno(maxHabitaciones);
        turno.iniciarJuego();
    }
}