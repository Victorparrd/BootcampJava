package com.roshka.bootcamp;

import java.util.Stack;

public class BalanceadorParentesis {
    public static Boolean isBalanced(final String cadena) {

        Stack<String> pila = new Stack<String>();
        int i = 0;

        while (i < cadena.length()) {
            if (cadena.charAt(i) == '(') {
                pila.push("(");
            }
            else if (cadena.charAt(i) == '[') {
                pila.push("[");
            }
            else if (cadena.charAt(i) == '{') {
                pila.push("[");
            }
            else if (cadena.charAt(i)==')') {
                if (!pila.empty()){
                    pila.pop();
                }
                else {
                    pila.push(")");
                    break;
                }
            }
            else if (cadena.charAt(i)==']') {
                if (!pila.empty()){
                    pila.pop();
                }
                else {
                    pila.push("]");
                    break;
                }
            }
            else if (cadena.charAt(i)=='}') {
                if (!pila.empty()){
                    pila.pop();
                }
                else {
                    pila.push("}");
                    break;
                }
            }
            i++;
        }
        // devuelva true si los paréntesis están balanceados y false en caso contrario.
        if(pila.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
