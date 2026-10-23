import java.util.Scanner;

public class Turno {
    private int maxHabitaciones;
    private Supervivente supervivente;
    private Habitacion habitacionActual;
    private Scanner scanner;

    public Turno(int maxHabitaciones) {
        this.maxHabitaciones = maxHabitaciones;
        this.supervivente = new Supervivente();
        this.habitacionActual = new Habitacion(1);
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            // Comprobación de estado del superviviente
            if (supervivente.getVida_Actual() <= 0) {
                System.out.println("\n--- GAME OVER ---");
                System.out.println("Has perdido todos tus puntos de vida. La mansión te ha devorado...");
                break;
            }

            // Mostrar estado actual
            System.out.println("\n** PV: " + supervivente.getVida_Actual() + " #MAX(" + supervivente.getVida_Maxima() +
                    "); ARMAS: " + supervivente.getCantidad_Armas() +
                    "; PROTECCIÓN: " + supervivente.getCantidad_Protecciones());
            System.out.println("** LA HABITACIÓN " + habitacionActual.getNumero_Habitacion() +
                    " CONTIENE: " + habitacionActual.getZombies_Activos() + " ZOMBIES.");

            // Mostrar opciones disponibles según las reglas
            System.out.println("* ELIGE UNA DE LAS SIGUIENTES ACCIONES:");
            int opcionCombate = -1;
            int opcionBuscar = -1;
            int opcionAvanzar = -1;
            int opcionCurar = -1;
            int contadorOpciones = 1;

            if (habitacionActual.getZombies_Activos() > 0) {
                opcionCombate = contadorOpciones++;
                System.out.println(opcionCombate + ". COMBATIR CONTRA UN ZOMBI.");
            } else {
                if (habitacionActual.getIntentosBusqueda() > 0) {
                    opcionBuscar = contadorOpciones++;
                    System.out.println(opcionBuscar + ". BUSCAR POR LA HABITACIÓN (" + habitacionActual.getIntentosBusqueda() + " INTENTOS).");
                }
                opcionAvanzar = contadorOpciones++;
                if (habitacionActual.getNumero_Habitacion() == maxHabitaciones) {
                    System.out.println(opcionAvanzar + ". SALIR DE LA MANSIÓN.");
                } else {
                    System.out.println(opcionAvanzar + ". AVANZAR A OTRA HABITACIÓN.");
                }

                if (supervivente.isTiene_Botiquin()) {
                    opcionCurar = contadorOpciones++;
                    System.out.println(opcionCurar + ". CURARSE.");
                }
            }

            System.out.print("> OPCIÓN: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Opción no válida.");
                scanner.next();
                continue;
            }
            int eleccion = scanner.nextInt();

            // Procesar la elección
            if (eleccion == opcionCombate && opcionCombate != -1) {
                ejecutarCombate();
            } else if (eleccion == opcionBuscar && opcionBuscar != -1) {
                ejecutarBusqueda();
            } else if (eleccion == opcionAvanzar && opcionAvanzar != -1) {
                if (habitacionActual.getNumero_Habitacion() == maxHabitaciones) {
                    System.out.println("\n ¡VICTORIA! Has conseguido salir de la mansión con vida.");
                    juegoEnCurso = false;
                } else {
                    int siguienteHabitacion = habitacionActual.getNumero_Habitacion() + 1;
                    habitacionActual = new Habitacion(siguienteHabitacion);
                    System.out.println("\nHas avanzado a la habitación " + siguienteHabitacion + ".");
                }
            } else if (eleccion == opcionCurar && opcionCurar != -1) {
                boolean curado = supervivente.curar();
                if (curado) {
                    System.out.println("Te has curado 4 puntos de vida.");
                } else {
                    System.out.println("No tienes ningún botiquín.");
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void ejecutarCombate() {
        Zombie zombie = new Zombie(habitacionActual.getNumero_Habitacion());
        System.out.println("El zombie tiene " + zombie.getPuntos_Ataque() + " puntos de ataque.");
        System.out.println("El zombie tiene " + zombie.getVida_Actual() + " puntos de vida.");

        int ronda = 1;
        while (zombie.estaVivo() && supervivente.getVida_Actual() > 0) {
            System.out.println(">> RONDA: " + ronda);

            // Ataca superviviente
            int danoSuperviviente = supervivente.atacar();
            System.out.println("> El superviviente ataca con valor " + danoSuperviviente);
            zombie.recibirDano(danoSuperviviente);

            if (!zombie.estaVivo()) {
                System.out.println("Has eliminado al zombie.");
                habitacionActual.reducirZombie();
                break;
            }

            // Ataca zombie si sigue vivo
            int danoZombie = zombie.atacar();
            System.out.println("> El zombie ataca con valor " + danoZombie);
            supervivente.recibirDano(danoZombie);

            if (supervivente.getVida_Actual() <= 0) {
                break;
            }
            ronda++;
        }
    }

    private void ejecutarBusqueda() {
        habitacionActual.reducirIntentosBusqueda();
        int dado100 = Dado.lanzar(100);

        if (dado100 >= 1 && dado100 <= 75) {
            System.out.println("!Has hecho ruido!, ¡cuidado!...");
            int ruido100 = Dado.lanzar(100);
            if (ruido100 >= 1 && ruido100 <= 40) {
                System.out.println("Por suerte nadie te escucha al otro lado esta vez.");
            } else if (ruido100 >= 41 && ruido100 <= 80) {
                System.out.println("¡Se oyen pasos! +1 zombie en la habitación.");
                habitacionActual.agregarZombie(1);
            } else {
                System.out.println("¡Vienen varios! +2 zombies en la habitación.");
                habitacionActual.agregarZombie(2);
            }
        } else if (dado100 >= 76 && dado100 <= 90) {
            if (supervivente.isTiene_Botiquin()) {
                System.out.println("Has encontrado un botiquín, pero ya llevas unoencima y no puedes cogerlo.");
            } else {
                supervivente.setTiene_Botiquin(true);
                System.out.println("¡Has encontrado un botiquín!");
            }
        } else if (dado100 >= 91 && dado100 <= 95) {
            supervivente.setCantidad_Protecciones(supervivente.getCantidad_Protecciones() + 1);
            System.out.println("¡Has encontrado una protección (+1)!");
        } else if (dado100 >= 96 && dado100 <= 100) {
            supervivente.setCantidad_Armas(supervivente.getCantidad_Armas() + 1);
            System.out.println("¡Has encontrado un arma (+1)!");
        }
    }
}