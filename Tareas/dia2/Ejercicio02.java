package dia2;

public class Ejercicio02 {
    public static void main(String[] args) {
        /*
        1. Cargar un array de manera aleatoria con 10 números enteros del -5 al 5.
        Imprimirlo en pantalla y computar cuál es el mayor elemento del vector.
        */
        System.out.println("----------");
        int num;
        int[] numeros = new int[10];
        int mayor = numeros[0];
        for (int i = 0; i < numeros.length; i++) {
            num = (int) (Math.random() * (5+5+1) - 5); // (int)(Math.random() * (HASTA - DESDE + 1) + DESDE);
            numeros[i] = num;
            System.out.println(numeros[i]);
            if (numeros[i]>mayor) {
                mayor = numeros[i];
            }
        }
        System.out.println("El mayor es: " + mayor);

        /*
        2. Cargar un array de manera aleatoria con 100 números enteros del -30 al 30.
        Imprimirlo en pantalla y computar cuál es el elemento que más veces se repite,
        y cuáles son los números que no están presentes (si es que hay alguno).
        */
        System.out.println("----------");
        int num2;
        int[] numeros2 = new int[100];

        for (int i = 0; i < numeros2.length; i++) {
            num2 = (int) (Math.random() * (30+30+1) - 30); // (int)(Math.random() * (HASTA - DESDE + 1) + DESDE);
            numeros2[i] = num2;
            System.out.println(numeros2[i]);
        }

        int cont = 0;
        int aux = 0;
        int max = 0;
        for (int i = 0; i < numeros2.length; i++){
            for (int j = 1; j < numeros2.length; j++) {
                if (numeros2[i]==numeros2[j]) {
                    cont = cont + 1;
                }
            }
            if (cont>aux){
                aux = cont;
                max = numeros2[i];
            }
            cont = 0;
        }
        System.out.println("El elemento que mas veces se repite: " + max);

        boolean[] presente = new boolean[61];

        for (int n : numeros2) {
            if (n >= -30 && n <= 30) {
                presente[n + 30] = true;
            }
        }

        System.out.println("Números ausentes: ");
        for (int i = 0; i < presente.length; i++) {
            if (!presente[i]) {
                int ausente = i - 30;
                System.out.println(ausente);
            }
        }

        /*
        3. Hacer una función que, dada una palabra (String) o frase, diga si la misma es palíndrome o no.
        Una palabra/frase palíndrome es aquella que se lee igual tanto de atrás para adelante,
        como de adelante para atrás. Ejemplos de palíndromes: "MADAM", "RACECAR", "AMORE, ROMA",
        "BORROW OR ROB", "WAS IT A CAR OR A CAT I SAW?".
        */
        System.out.println("----------");
        String palabra = "madam";
        palabra = palabra.toLowerCase().replace(" ", "").replace(",", "")
                .replace(".", "");
        String invertida = new StringBuilder(palabra).reverse().toString();
        if (palabra.equals(invertida)) {
            System.out.println("La palabra es palíndrome");
        } else {
            System.out.println("La palabra NO es palíndrome");
        }

        /*
        4. Dada una cadena de caracteres (String) de longitud desconocida que tiene solamente dígitos,
        crear un array de N elementos (donde N es el tamaño de la cadena)
        que tenga cada uno de los valores numéricos de los dígitos.
        */
        System.out.println("----------");
        String cadena = "13792468";
        int[] array = new int[cadena.length()];

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            int valorNumerico = Character.getNumericValue(caracter);
            array[i] = valorNumerico;
            System.out.print(array[i]);
        }
    }
}
