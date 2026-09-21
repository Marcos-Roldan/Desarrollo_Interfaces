public class Mansion_Zombie {

    private int numZombies;
    private int numHabitacion;
    private int puntosVida;
    private int Armas;
    private int Proteccioes;

    public Mansion_Zombie(int numZombies, int numHabitacion, int puntosVida, int Armas, int Protecciones) {
        this.numZombies = numZombies;
        this.numHabitacion = numHabitacion;
        this.puntosVida = puntosVida;
        this.Armas = Armas;
        this.Proteccioes = Protecciones;
    }

    public int getNumZombies() {
        return numZombies;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public int getPuntosVida() {
        if(puntosVida > 20) {
            return 20;
        } else {
            return puntosVida;
        }
    }

    public int getArmas() {
        return Armas;
    }

    public int getProteccioes() {
        return Proteccioes;
    }

    public void setNumZombies(int numZombies) {
        this.numZombies = numZombies;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setArmas(int armas) {
        Armas = armas;
    }

    public void setProteccioes(int proteccioes) {
        Proteccioes = proteccioes;
    }

    public String toString() {
        return "Num_Zombies: " + numZombies + ", Num_Habitacion: " + numHabitacion + ", Puntos_Vida: " + puntosVida + ", Armas: " + Armas + ", Protecciones: " + Proteccioes;
    }
}
