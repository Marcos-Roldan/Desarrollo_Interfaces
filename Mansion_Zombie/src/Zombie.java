import java.util.ArrayList;

public class Zombie {
    ArrayList<Atributos_Mansion_Zombi> Num_Habitacion = new ArrayList<>();

    int Ataque_Zombie = (int) (Math.random() * 1) + 2 + Num_Habitacion.get(0).getNumHabitacion();
}
