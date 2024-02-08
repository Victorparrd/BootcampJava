package dia4;

import java.util.Scanner;

public class Nim extends Jugadores {
    private int[] pilas;
    private Jugadores jugador1;
    private Jugadores jugador2;
    private Jugadores jugadorActual;

    public Nim(String nombreJugador1, String nombreJugador2, int cantidaA, int cantidaB, int cantidaC) {
        pilas = new int[]{cantidaA, cantidaB, cantidaC};
        jugador1 = new Jugadores(nombreJugador1);
        jugador2 = new Jugadores(nombreJugador2);
        jugadorActual = jugador1;
    }

    public void estado() {
        System.out.print("A: " + pilas[0] + "\t");
        System.out.print("B: " + pilas[1] + "\t");
        System.out.print("C: " + pilas[2]);
    }

    public void turno() {
        Scanner scanner = new Scanner(System.in);
        String pila;
        boolean entradaValida = false;

        do {
            System.out.println("\n" + jugadorActual.getNombre() + ", elija una pila: ");
            pila = scanner.next().toUpperCase();

            if (pila.equals("A") || pila.equals("B") || pila.equals("C")) {
                entradaValida = true;
            } else {
                System.out.println("Por favor, introduce una pila válida (A, B, o C).");
            }
        } while (!entradaValida);

        System.out.println("Cuantos quitara de la pila " + pila);
        int cantidad = scanner.nextInt();
        int indicePila = pila.charAt(0) - 'A';

        if (pilas[indicePila] >= cantidad && cantidad > 0) {
            pilas[indicePila] -= cantidad;
            cambiarTurno();
        } else {
            System.out.println("Movimiento inválido. Por favor, elige otra pila o cantidad.");
        }
    }

    private void cambiarTurno() {
        if (jugadorActual == jugador1) {
            jugadorActual = jugador2;
        } else {
            jugadorActual = jugador1;
        }
    }

    public boolean juegoTerminado() {
        return pilas[0] == 0 && pilas[1] == 0 && pilas[2] == 0;
    }

    public Jugadores ganador() {
        return jugadorActual == jugador1 ? jugador2 : jugador1;
    }
}
