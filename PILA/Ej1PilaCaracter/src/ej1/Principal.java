package ej1;

import java.util.Stack;

public class Principal {
    public static void main(String[] args) {
        Stack<Character> pilaEjemplo = new Stack<>();
        pilaEjemplo.push('R');
        pilaEjemplo.push('E');
        pilaEjemplo.push('C');
        pilaEjemplo.push('O');
        pilaEjemplo.push('N');
        pilaEjemplo.push('O');
        pilaEjemplo.push('C');
        pilaEjemplo.push('E');
        pilaEjemplo.push('R');

        PilaCaracteres pila = new PilaCaracteres(pilaEjemplo);
        
        System.out.println("Pila original: " + pila);
        
        String palindromo = pila.encontrarPalindromoMasGrande();
        System.out.println("\nA. Palíndromo más grande: " + palindromo);
        
        char caracterBuscado = 'R';
        int contador = pila.contarCaracter(caracterBuscado);
        System.out.println("\nB. El carácter '" + caracterBuscado + "' aparece " + contador + " veces");
        
        boolean intercalada = pila.estaIntercalada();
        System.out.println("\nC. ¿La pila está intercalada? " + intercalada);
        
        PilaCaracteres pilaInvertida = pila.invertirPila();
        System.out.println("\nD. Pila invertida: " + pilaInvertida);
        
    }
}