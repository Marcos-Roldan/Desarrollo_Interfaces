import java.util.*;
public class Supervivente {

    private int vidaActual;
    private int vidaMaxima;
    private int puntosAtaque;
    private boolean tieneBotiquin;
    private int cantidadArmas;
    private int cantidadProtecciones;

    public Supervivente() {
        this.vidaActual = 20;
        this.vidaMaxima = 20;
        this.puntosAtaque = 4;
        this.tieneBotiquin = false;
        this.cantidadArmas = 0;
        this.cantidadProtecciones = 0;
    }

    public int getVida_Actual() {
        return vidaActual;
    }

    public int getVida_Maxima() {
        return vidaMaxima;
    }

    public int getPuntos_Ataque() {
        return puntosAtaque;
    }

    public boolean isTiene_Botiquin() {
        return tieneBotiquin;
    }

    public int getCantidad_Armas() {
        return cantidadArmas;
    }

    public int getCantidad_Protecciones() {
        return cantidadProtecciones;
    }

    public void setVida_Actual(int vida_Actual) {
        this.vidaActual = vida_Actual;
    }

    public void setVida_Maxima(int vida_Maxima) {
        this.vidaMaxima = vida_Maxima;
    }

    public void setPuntos_Ataque(int puntos_Ataque) {
        this.puntosAtaque = puntos_Ataque;
    }

    public void setTiene_Botiquin(boolean tiene_Botiquin) {
        this.tieneBotiquin = tiene_Botiquin;
    }

    public void setCantidad_Armas(int cantidad_Armas) {
        this.cantidadArmas = cantidad_Armas;
    }

    public void setCantidad_Protecciones(int cantidad_Protecciones) {
        this.cantidadProtecciones = cantidad_Protecciones;
    }

    public int atacar() {
        int tiradaDado = Dado.lanzar(puntosAtaque);
        return tiradaDado + cantidadArmas; // Las armas suman + 1 por arma al resultado
    }

    public void recibirDano(int danoBase) {
        int danoReal = danoBase - cantidadProtecciones; // Cada protección reduce 1 de daño
        if (danoReal < 0) { //Si daño es menor q cero pues nada
            danoReal = 0;
        }
        this.vidaActual -= danoReal; //Vida menos el daño
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public boolean curar() {
        if (tieneBotiquin) {
            vidaActual += 4;
            if (vidaActual > vidaMaxima) {
                vidaActual = vidaMaxima;
            }
            tieneBotiquin = false;
            return true;
        }
        return false;
    }
}