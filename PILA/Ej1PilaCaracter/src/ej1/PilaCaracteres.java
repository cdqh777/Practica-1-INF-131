package ej1;

import java.util.Stack;

public class PilaCaracteres {
	private Stack<Character> pila;
 
	public PilaCaracteres() {
		this.pila = new Stack<>();
	}
 
	public PilaCaracteres(Stack<Character> pila) {
		this.pila = new Stack<>();
		this.pila.addAll(pila);
	}
 
	public void apilar(char caracter) {
	    pila.push(caracter);
	}
	 
	public char desapilar() {
	    return pila.pop();
	}
 
	public boolean estaVacia() {
	    return pila.isEmpty();
	}
	 
	public int tamano() {
	    return pila.size();
	}
	 
	public Stack<Character> getPila() {
	    return pila;
	}
	 
	public void setPila(Stack<Character> pila) {
	    this.pila = pila;
	}
	 
	public String obtenerPalabra() {
	    Stack<Character> temporal = new Stack<>();
	    temporal.addAll(pila);
	     
	    String palabra = "";
	    while (!temporal.isEmpty()) {
	        palabra = temporal.pop() + palabra;
	    }
	    return palabra;
	}
	 
	public void restaurarPila(Stack<Character> original) {
	    this.pila.clear();
	    this.pila.addAll(original);
	}
 
	public String encontrarPalindromoMasGrande() {
		String palabra = obtenerPalabra();
	    String palindromoMasGrande = "";     
	    for (int i = 0; i < palabra.length(); i++) {
	        for (int j = i + 1; j <= palabra.length(); j++) {
	            String subcadena = palabra.substring(i, j);
	            if (esPalindromo(subcadena) && subcadena.length() > palindromoMasGrande.length()) {
	                palindromoMasGrande = subcadena;
	            }
	        }
	    }
	    return palindromoMasGrande.isEmpty() ? "No se encontró ningún palíndromo" : palindromoMasGrande;
	}
 
	private boolean esPalindromo(String cadena) {
	    if (cadena.length() <= 1) return false;     
	    int izquierda = 0;
	    int derecha = cadena.length() - 1;
	    while (izquierda < derecha) {
	        if (cadena.charAt(izquierda) != cadena.charAt(derecha)) {
	            return false;
	        }
	        izquierda++;
	        derecha--;
	    }
	    return true;
	}
 
	public int contarCaracter(char caracter) {
	    Stack<Character> temporal = new Stack<>();
	    temporal.addAll(pila);     
	    int contador = 0;
	    while (!temporal.isEmpty()) {
	        if (temporal.pop() == caracter) {
	            contador++;
	        }
	    }
	    return contador;
	}
 
	public boolean estaIntercalada() {
	    if (pila.size() <= 1) return true;     
	    Stack<Character> temporal = new Stack<>();
	    temporal.addAll(pila);
	    char anterior = temporal.pop();
	    boolean intercalada = true;
	    while (!temporal.isEmpty()) {
	        char actual = temporal.pop();
	        boolean anteriorEsVocal = esVocal(anterior);
	        boolean actualEsVocal = esVocal(actual);
	        if (anteriorEsVocal == actualEsVocal) {
	            intercalada = false;
	            break;
	        }
	        anterior = actual;
	    }
	     
	    return intercalada;
	}
 
	private boolean esVocal(char caracter) {
	    return "AEIOUaeiou".indexOf(caracter) != -1;
	}
	
	public PilaCaracteres invertirPila() {
	    Stack<Character> temporal = new Stack<>();
	    temporal.addAll(pila);     
	    Stack<Character> pilaInvertida = new Stack<>();
	    while (!temporal.isEmpty()) {
	        pilaInvertida.push(temporal.pop());
	    }
	    
	    return new PilaCaracteres(pilaInvertida);
	}
 
	public void mostrarPila() {
	    System.out.println("Contenido de la pila: " + pila);
	}
	
	@Override
	public String toString() {
	    return pila.toString();
	}
}