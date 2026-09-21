public class Dado {
    public static  void main(String[] args) {
        int numeroAleatorio = numeroAleatorio();

        System.out.println(numeroAleatorio);
    }

    public static int numeroAleatorio() {
        int numero_Aleatorio = (int)(Math.random() * 2);

        return numero_Aleatorio;
    }
}
