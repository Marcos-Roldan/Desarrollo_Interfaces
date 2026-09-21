import java.util.*;
public class Supervivente {
    public static void main(String[] args) {
        Supervivente s = new Supervivente();
        System.out.println(">El superviviente ataca con valor " + s.numero_Aleatorio());
    }
    private int vida_Actual;
    private int vida_Maxima;
    private int puntos_Ataque;
    private boolean tiene_Botiquin;
    private int cantidad_Armas;
    private int cantidad_Protecciones;

    public Supervivente() {
        this.vida_Actual = 20;
        this.vida_Maxima = 20;
        this.puntos_Ataque = 4;
        this.tiene_Botiquin = false;
        this.cantidad_Armas = 0;
        this.cantidad_Protecciones = 0;
    }

    public int getVida_Actual() {
        return vida_Actual;
    }

    public int getVida_Maxima() {
        return vida_Maxima;
    }

    public int getPuntos_Ataque() {
        return puntos_Ataque;
    }

    public boolean isTiene_Botiquin() {
        return tiene_Botiquin;
    }

    public int getCantidad_Armas() {
        return cantidad_Armas;
    }

    public int getCantidad_Protecciones() {
        return cantidad_Protecciones;
    }

    public void setVida_Actual(int vida_Actual) {
        this.vida_Actual = vida_Actual;
    }

    public void setVida_Maxima(int vida_Maxima) {
        this.vida_Maxima = vida_Maxima;
    }

    public void setPuntos_Ataque(int puntos_Ataque) {
        this.puntos_Ataque = puntos_Ataque;
    }

    public void setTiene_Botiquin(boolean tiene_Botiquin) {
        this.tiene_Botiquin = tiene_Botiquin;
    }

    public void setCantidad_Armas(int cantidad_Armas) {
        this.cantidad_Armas = cantidad_Armas;
    }

    public void setCantidad_Protecciones(int cantidad_Protecciones) {
        this.cantidad_Protecciones = cantidad_Protecciones;
    }

    public int numero_Aleatorio() {
        int tira_Dado = (int)(Math.random() * this.puntos_Ataque) + 1;
        return tira_Dado;
    }

    public void Botiquin() {
        Scanner sc = new Scanner(System.in);
        int opcion_botiquin = 0;

        if(tiene_Botiquin) {
            System.out.println("¿QUIERES USAR EL BOTIQUIN?");
            System.out.println("1. QUIERO USARLO ");
            System.out.println("2. NO QUIERO USARLO ");
            System.out.println("OPCION: ");

            if(sc.hasNextInt()) {
                opcion_botiquin = sc.nextInt();
            } else {
                sc.next();
            }

            if(opcion_botiquin == 1) {
                vida_Actual = vida_Actual + 4;
                if(vida_Actual > 20) {
                    vida_Actual = 20;
                }
                tiene_Botiquin = false;
                System.out.println("TE HAS CURADO CON EL BOTIQUIN. LA VIDA ACTUAL ES: " + vida_Actual);
            } else {
                System.out.println("HAS DECIDIDO NO USAR EL BOTIQUIN");
            }
        } else {
            System.out.println("NO TIENES BOTIQUINES PARA USAR ");
        }
    }

    public void Armas() {
        Scanner sc = new Scanner(System.in);
        int opcion_armas = 0;
        int cant_armas;

        if(cantidad_Armas > 0) {
            System.out.println("¿QUIERES USAR LAS ARMAS?");
            System.out.println("1. QUIERO USARLO ");
            System.out.println("2. NO QUIERO USARLO ");
            System.out.println("OPCION: ");

            if(sc.hasNextInt()) {
                opcion_armas = sc.nextInt();
            } else {
                sc.next();
            }

            if(opcion_armas == 1) {
                System.out.println("¿CUANTAS ARMAS QUIERES USAR?");
                cant_armas = sc.nextInt();

                if(cant_armas > cantidad_Armas) {
                    System.out.println("ERROR:TIENES MENOS ARMAS");
                } else {
                    cantidad_Armas = cantidad_Armas - cant_armas;
                    System.out.println("TE HAS REFORZADO CON LAS ARMAS. LOS PUNTOS DE ATAQUE SON: " + puntos_Ataque);
                }
            } else {
                System.out.println("HAS DECIDIDO NO USAR LAS ARMAS");
            }
        } else {
            System.out.println("NO TIENES ARMAS PARA USAR");
        }
    }

    public void Protecciones() {
        Scanner sc = new Scanner(System.in);
        int opcion_protecciones = 0;
        int cant_protecciones;

        if(cantidad_Protecciones > 0) {
            System.out.println("¿QUIERES USAR LAS PROTECCIONES?");
            System.out.println("1. QUIERO USARLO");
            System.out.println("2. NO QUIERO USARLO");
            System.out.println("OPCION: ");

            if(sc.hasNextInt()) {
                opcion_protecciones = sc.nextInt();
            } else {
                sc.next();
            }

            if(opcion_protecciones == 1) {
                System.out.println("¿CUANTAS PROTECCIONES QUIERES USAR?");
                cant_protecciones = sc.nextInt();

                if(cant_protecciones > cantidad_Protecciones) {
                    System.out.println("ERROR: TIENES MENOS PROTECCIONES");
                } else {
                    vida_Actual = vida_Actual + 1;
                    if(vida_Actual > 20) {
                        vida_Actual = 20;
                    }
                    cantidad_Protecciones = cantidad_Protecciones - cant_protecciones;
                    System.out.println("TE HAS CURADO CON LAS PROTECCIONES. LA VIDA ACTUAL ES: " + vida_Actual);
                }
            } else {
                System.out.println("HAS DECIDIDO NO USAR LAS PROTECCIONES");
            }
        } else {
            System.out.println("NO TIENES PROTECCIONES PARA USAR");
        }
    }
}
