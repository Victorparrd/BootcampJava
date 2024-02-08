package dia4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jugador 1, ingrese su nombre: ");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("Jugador 2, ingrese su nombre: ");
        String nombreJugador2 = scanner.nextLine();

        Nim juego = new Nim(nombreJugador1, nombreJugador2, 3, 4, 5);

        while (!juego.juegoTerminado()) {
            juego.estado();
            juego.turno();
        }

        System.out.println(juego.ganador().getNombre() + ", ya no quedan contadores, asi que... Ganaste!");
    }
}
