public class Zombie {

    private int vidaActual;
    private int puntosAtaque;

    public Zombie(int numeroHabitacion) {
        int base = Dado.aleatorioCeroA(2) + 2 + (numeroHabitacion - 1);
        this.vidaActual = base;
        this.puntosAtaque = base;
    }

    public int getVida_Actual() {
        return vidaActual;
    }

    public int getPuntos_Ataque() {
        return puntosAtaque;
    }

    public boolean estaVivo() {
        return vidaActual > 0;
    }

    public int atacar() {
        return Dado.lanzar(puntosAtaque);
    }

    public void recibirDano(int cantidad) {
        this.vidaActual -= cantidad;
        if(this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }
}
