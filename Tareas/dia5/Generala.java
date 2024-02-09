package dia5;

public class Generala {
    public static void main(String[] args) {

        int[] jugada = new int[5];
        int random;
        System.out.print("Jugada: ");
        for (int i = 0; i < 5; i++) {
            random = (int) Math.floor(Math.random() * 6 + 1);
            jugada[i] = random;
            System.out.print(jugada[i]);
        }

        //int[] numeros = {3,4,5,6,1};

        if (esGenerala(jugada)) {
            System.out.println("\nGENERALA");
        } else if (esPoker(jugada)) {
            System.out.println("\nPOKER");
        } else if (esFull(jugada)) {
            System.out.println("\nFULL");
        } else if (esEscalera(jugada)) {
            System.out.println("\nESCALERA");
        } else {
            System.out.println("\nNADA");
        }

    }

    public static boolean esGenerala(int[] dados) {
        for (int i = 1; i < dados.length; i++) {
            if (dados[i] != dados[0]) {
                return false;
            }
        }
        return true;
    }

    public static boolean esPoker(int[] dados) {
        for (int i = 0; i < dados.length; i++) {
            int contador = 0;
            for (int j = i + 1; j < dados.length; j++) {
                if (dados[i] == dados[j]) {
                    contador++;
                }
            }
            if (contador == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean esFull(int[] dados) {
        int contadorTresUnicos = 0;
        int contadorDosIguales = 0;
        int valorUnico = 0;

        for (int i = 0; i < dados.length; i++) {
            int contador = 0;
            for (int j = i + 1; j < dados.length; j++) {
                if (dados[i] == dados[j]) {
                    contador++;
                }
            }
            if (contador == 2) {
                contadorTresUnicos++;
                valorUnico = dados[i];
            } else if (contador == 1) {
                contadorDosIguales++;
            }
        }

        return contadorTresUnicos == 1 && contadorDosIguales == 2 && dados[3] == dados[4] && dados[3] != valorUnico;
    }

    public static boolean esEscalera(int[] dados) {
        for (int i = 0; i < dados.length - 1; i++) {
            if (dados[i + 1] - dados[i] != 1) {
                if (i == 3 && dados[i + 1] == 1 && dados[i] == 6) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
