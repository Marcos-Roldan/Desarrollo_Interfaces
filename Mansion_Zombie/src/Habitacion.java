public class Habitacion {
    private int numero_Habitacion;
    private int Zombies_Activos;
    private int intentos_Busqueda;

    public Habitacion() {
        this.numero_Habitacion = numero_Habitacion;
        this.Zombies_Activos = 1;
        this.intentos_Busqueda = 3;
    }

    public int getNumero_Habitacion() {
        return numero_Habitacion;
    }

    public int getZombies_Activos() {
        return Zombies_Activos;
    }

    public int getIntentos_Busqueda() {
        return intentos_Busqueda;
    }

    public void setNumero_Habitacion(int numero_Habitacion) {
        this.numero_Habitacion = numero_Habitacion;
    }

    public void setZombies_Activos(int zombies_Activos) {
        Zombies_Activos = zombies_Activos;
    }

    public void setIntentos_Busqueda(int intentos_Busqueda) {
        this.intentos_Busqueda = intentos_Busqueda;
    }
}
