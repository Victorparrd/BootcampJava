package dia2;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        /*
        1. Declara dos variables numéricas (con el valor que desees), muestra por consola la
        suma, resta, multiplicación, división y módulo (resto de la división).
        */
        System.out.println("----------");
        int x = 10;
        int y = 2;
        System.out.println("X = " + x + "\nY = " + y);
        System.out.println("Suma: X + Y = " + (x+y) + "\nResta: X - Y = " + (x-y) +
                "\nMultiplicación: X * Y = " + (x*y) + "\nDivisón: X / Y = " + (x/y) +
                "\nResto: " + (x%y));

        /*
        2. Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
        Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.
        */
        System.out.println("----------");
        int a = 5;
        int b = 7;
        if (a==b){
            System.out.println("Los números son iguales: a = " + a + " b = " + b);
        } else if (a>b) {
            System.out.println("El mayor es a = " + a);
        } else {
            System.out.println("El mayor es b = " + b);
        }

        /*
        3. Declara un String que contenga tu nombre, después muestra un mensaje de bienvenida
        por consola. Por ejemplo: si introduzco “Fernando”, me aparezca “Bienvenido Fernando”.
        */
        System.out.println("----------");
        String nombre = "Victor";
        System.out.println("Bienvenido " + nombre);

        // 4. Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir.
        System.out.println("----------");
        Scanner nom = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre2 = nom.nextLine();
        System.out.println("Bienvenido " + nombre2);

        /*
        Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es,
        también debemos indicarlo.
        */
        System.out.println("----------");
        Scanner num = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        int numero = num.nextInt();
        if (numero%2==0){
            System.out.println("El número es divisible entre 2.");
        } else {
            System.out.println("El número no es divisible entre 2.");
        }

        /*
        6. Lee un número por teclado que pida el precio de un producto (puede tener decimales)
        y calcule el precio final con IVA. El IVA sera una constante que sera del 10%.
        */
        System.out.println("----------");
        Scanner prod = new Scanner(System.in);
        System.out.println("Ingrese el precio de un producto: ");
        double producto = prod.nextDouble();
        double precio = producto + producto*0.1;
        System.out.println("El precio del producto final con IVA es: " + (precio));

        // 7. Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3.
        System.out.println("----------");
        for(int i=1; i<101; i++){
            if (i%2==0 & i%3==0){
                System.out.println("El numero " + i + " es divisible entre 2 y 3.");
            }
        }

        /*
        8. Lee un número por teclado y comprueba que este numero es mayor o igual que cero,
        si no lo es lo volverá a pedir (do while), después muestra ese número por consola.
        */
        System.out.println("----------");
        int numero2;
        do {
            Scanner n = new Scanner(System.in);
            System.out.println("Ingrese un número: ");
            numero2 = n.nextInt();
        }while (numero2 < 0);
        System.out.println("Es mayor o igual a 0: " + numero2);

        /*
        9. Escribe una aplicación con un String que contenga una contraseña cualquiera.
        Después se te pedirá que introduzcas la contraseña, con 3 intentos.
        Cuando aciertes ya no pedirá mas la contraseña y mostrara un mensaje diciendo “Correcto!”.
        Piensa bien en la condición de salida (3 intentos y si acierta sale, aunque le queden intentos,
        si no acierta en los 3 intentos mostrar el mensaje “Fallaste jaja!!”).
         */
        System.out.println("----------");
        String contrasenha = "cont123";
        int intentos = 0;
        while(intentos < 3) {
            Scanner c = new Scanner(System.in);
            System.out.println("Ingrese su contraseña: ");
            String cont = c.nextLine();
            if (cont.equals(contrasenha)){
                System.out.println("Correcto!");
                break;
            } else {
                intentos++;
            }
        }
        if (intentos == 3){
            System.out.println("Fallaste jaja!!");
        }

        /*
        10. Crea una aplicación que nos pida un día de la semana y que nos diga si es un dia
        laboral o no (“De lunes a viernes consideramos dias laborales”).
        */
        System.out.println("----------");
        Scanner d = new Scanner(System.in);
        System.out.println("Ingrese un día de la semana: ");
        String dia = d.nextLine();

        if (dia.equals("Lunes") | dia.equals("Martes") | dia.equals("Miercoles") | dia.equals("Jueves") |
                dia.equals("Viernes")) {
            System.out.println("Es un dia laboral.");
        } else if (dia.equals("Sabado") | dia.equals("Domingo")) {
            System.out.println("No es un dia laboral.");
        } else {
            System.out.println("Error! Ingrese un dia.");
        }

    }
}
