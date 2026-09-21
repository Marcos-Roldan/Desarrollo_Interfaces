import java.util.ArrayList;

public class Zombie {
    ArrayList<Mansion_Zombie> Num_Habitacion = new ArrayList<>();

    int Ataque_Zombie = (int) (Math.random() * 1) + 2 + Num_Habitacion.get(0).getNumHabitacion();
}
