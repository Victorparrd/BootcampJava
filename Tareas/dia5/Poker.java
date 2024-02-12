package dia5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Poker {

    public static void main(String[] args) {
        Carta[] jugada = {
                new Carta('2', 'S'),
                new Carta('3', 'S'),
                new Carta('4', 'S'),
                new Carta('5', 'S'),
                new Carta('6', 'S')
        };

        if (esEscaleraColor(jugada)) {
            System.out.println("Escalera Color");
        } else if (esPoker(jugada)) {
            System.out.println("Poker");
        } else if (esFull(jugada)) {
            System.out.println("Full");
        } else if (esColor(jugada)) {
            System.out.println("Color");
        } else if (esEscalera(jugada)) {
            System.out.println("Escalera");
        } else {
            System.out.println("Ninguna jugada especial");
        }
    }


    public static boolean esEscaleraColor(Carta[] mano) {
        return esEscalera(mano) && esColor(mano);
    }

    public static boolean esPoker(Carta[] mano) {
        return cuentaValores(mano).containsValue(4);
    }

    public static boolean esFull(Carta[] mano) {
        Map<Character, Integer> valores = cuentaValores(mano);
        return valores.containsValue(3) && valores.containsValue(2);
    }

    public static boolean esColor(Carta[] mano) {
        char palo = mano[0].palo;
        for (Carta carta : mano) {
            if (carta.palo != palo) {
                return false;
            }
        }
        return true;
    }

    public static boolean esEscalera(Carta[] mano) {
        char[] valoresOrdenados = new char[mano.length];
        for (int i = 0; i < mano.length; i++) {
            valoresOrdenados[i] = mano[i].valor;
        }
        Arrays.sort(valoresOrdenados);
        for (int i = 0; i < valoresOrdenados.length - 1; i++) {
            if (valoresOrdenados[i + 1] - valoresOrdenados[i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static Map<Character, Integer> cuentaValores(Carta[] mano) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (Carta carta : mano) {
            char valor = carta.valor;
            countMap.put(valor, countMap.getOrDefault(valor, 0) + 1);
        }
        return countMap;
    }

}
