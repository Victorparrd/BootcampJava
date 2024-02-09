package dia1;
/*
=============
Vacas y Toros
 100 Puntos
=============
El programa elige un número al azar, de cuatro dígitos, cuyos dígitos no se repitan.
El número debe:
 * Debe tener 4 dígitos (sin ceros adelante)
 * Los dígitos no se pueden repetir. 1234 es un número válido. 1224, no.
El programa pregunta a el usuario por un número y le desafía a adivinar el número que la computadora ha pensado.
El programa controla la cadena (string) ingresada por el usuario, y si es un número de 4 dígitos, analiza el número:
Toros: Dígitos acertados en el mismo lugar.
Vacas: Dígitos acertados, pero en un lugar diferente.
Número de la computadora:    1   2  [3] [4]
Número de ingreso de user:  [4] [3]  8   0
** 2 vacas, 0 toros.
Número de la computadora:   [1]  2  [3] [4]
Número de ingreso de user:  [1] [3]  8  [4]
** 1 vaca, 2 toros.
El programa luego debe imprimir: 2 vacas, 0 toros y permitir el ingreso de un nuevo intento:
"Por favor, intente de nuevo: "
El programa termina cuando el usuario gana el juego, obteniendo 4 toros.
"Felicidaes! El número secreto era: <number>"
*/
import java.util.Scanner;
import java.util.Stack;

public class VacasToros {
    public static void main(String[] args) {

        int random;
        int[] num = new int[4]; // declaro un array para almacenar los numeros
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < num.length; i++) {

            random = (int) Math.floor(Math.random() * 9) + 1; // genera un numero random del 1 al 9
            num[i] = random; // guarda el numero

            while (stack.contains(random)) { // comprueba que el numero no sea repetido
                random = (int) Math.floor(Math.random() * 9) + 1; // genera un numero random nuevo
                num[i] = random; // guarda el numero
            }
            stack.push(random); // guarda el stack
        }

        System.out.println("Número: " + num[0] + num[1] + num[2] + num[3]);

        int toros;
        int vacas;

        do {

            int user;
            Scanner leer = new Scanner(System.in);
            // pide al usuario ingresar un numero y guarda en la variable user
            System.out.println("Ingrese un numero de 4 digitos: ");
            user = leer.nextInt();

            String numeroString2 = String.valueOf(user);
            char[] num2 = numeroString2.toCharArray();

            toros = 0;
            vacas = 0;
            for (int i = 0; i < 4; i++) {
                char charFromInt = (char) (num[i] + '0'); // paso de int a char para comparar
                if (charFromInt == num2[i]) {
                    toros = toros + 1;
                }
                for (int j = 0; j < 4; j++) {
                    if (charFromInt == num2[j] & i != j) {
                        vacas = vacas + 1;
                    }
                }
            }

            System.out.println("Número de la computadora: " + num[0] + " " + num[1] + " " + num[2] + " " + num[3]);
            System.out.println("Número de ingreso de user: " + num2[0] + " " + num2[1] + " " + num2[2] + " " + num2[3]);

            System.out.println("Vacas: " + vacas);
            System.out.println("Toros: " + toros);

            if (toros == 4) {
                System.out.println("Felicidaes! El número secreto era: " + num[0] + num[1] + num[2] + num[3]);

            } else {
                System.out.println("Por favor, intente de nuevo: ");
            }

        } while (toros < 4);
    }
}
