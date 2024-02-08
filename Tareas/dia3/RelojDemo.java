package dia3;

import java.util.Scanner;

public class RelojDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tiempo en segundos desde la medianoche:");
        int tiempoSegundos = scanner.nextInt();
        Reloj reloj = new Reloj(tiempoSegundos);

        System.out.println("Hora actual:");
        for (int i = 0; i < 10; i++) {
            reloj.tick();
            System.out.println(reloj);
        }

        Reloj reloj2 = new Reloj(2, 30, 15);
        System.out.println("Segundo reloj creado: " + reloj2);
        Reloj diferencia = reloj.restaReloj(reloj2);
        System.out.println("Diferencia de tiempo: " + diferencia);
    }
}
