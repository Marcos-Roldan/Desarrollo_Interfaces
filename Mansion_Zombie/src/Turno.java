import java.util.Scanner;

public class Turno {
    private int maxHabitaciones;
    private Supervivente supervivente;
    private Habitacion habitacionActual;
    private Scanner scanner;

    public Turno(int maxHabitaciones) {
        this.maxHabitaciones = maxHabitaciones;
        this.supervivente = new Supervivente();
        this.habitacionActual = new Habitacion(1);
        this.scanner = new Scanner(System.in);
    }

    
}
