public class Habitacion {
    private int numeroHabitacion;
    private int ZombiesActivos;
    private int intentosBusqueda;

    public Habitacion(int i) {
        this.numeroHabitacion = numeroHabitacion;
        this.ZombiesActivos = 1;
        this.intentosBusqueda = 3;
    }

    public int getNumero_Habitacion() {
        return numeroHabitacion;
    }

    public int getZombies_Activos() {
        return ZombiesActivos;
    }

    public int getIntentosBusqueda() {
        return intentosBusqueda;
    }

    public void setZombies_Activos(int zombies_Activos) {
        this.ZombiesActivos = zombies_Activos;
    }

    public void reducirIntentosBusqueda() {
        if(intentosBusqueda > 0) {
            intentosBusqueda--;
        }
    }

    public void reducirZombie() {
        if(ZombiesActivos > 0) {
            ZombiesActivos--;
        }
    }

    public void agregarZombie(int cantidad) {
        this.ZombiesActivos += cantidad;
    }
}
