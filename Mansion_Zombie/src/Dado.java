public class Dado {

    public static int lanzar(int maximo) { //Numero aleatorio entre 1 y maximo incluido
        if (maximo <= 0) return 1;
        return (int) (Math.random() * maximo) + 1;
    }

    public static int aleatorioCeroA(int limiteExclusivo) { //Numero aleatorio entre 0 y 1
        return (int) (Math.random() * limiteExclusivo);
    }
}