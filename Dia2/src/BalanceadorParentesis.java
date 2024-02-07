package com.roshka.bootcamp.src;

import java.util.Stack;

public class BalanceadorParentesis {
    public static boolean isBalanced(final String cadena) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return false;
                }
                char top = pila.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }
}
