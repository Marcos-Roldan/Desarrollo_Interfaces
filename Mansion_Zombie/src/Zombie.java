public class Zombie {
    public static void main(String[] args) {
        Zombie z = new Zombie();
        System.out.println(">El zombie ataca con valor " + z.numero_Ataque());
    }

    private int vida_Actual;
    private int puntos_Ataque;

    public Zombie() {
        this.vida_Actual = vida_Actual;
        this.puntos_Ataque = 4;
    }

    public int getVida_Actual() {
        return vida_Actual;
    }

    public int getPuntos_Ataque() {
        return puntos_Ataque;
    }

    public void setVida_Actual(int vida_Actual) {
        this.vida_Actual = vida_Actual;
    }

    public void setPuntos_Ataque(int puntos_Ataque) {
        this.puntos_Ataque = puntos_Ataque;
    }

    public int numero_Ataque() {
        int tira_Dado = (int)(Math.random() * this.puntos_Ataque) + 1;
        return tira_Dado;
    }
}
