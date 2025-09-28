package ej1;

import java.util.Arrays;

public class PilaCaracter {
    private char[] elementos;
    private int cima;
    private int capacidad;
    
    public PilaCaracter(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new char[capacidad];
        this.cima = -1;
    }
    
    public boolean estaVacia() {
        return cima == -1;
    }
    
    public boolean estaLlena() {
        return cima == capacidad - 1;
    }
    
    public void apilar(char dato) {
        if (!estaLlena()) {
            cima++;
            elementos[cima] = dato;
        }
    }
    
    public char desapilar() {
        if (!estaVacia()) {
            char dato = elementos[cima];
            cima--;
            return dato;
        }
        return '\0';
    }
    
    public char verCima() {
        if (!estaVacia()) {
            return elementos[cima];
        }
        return '\0';
    }
    
    public int getTamaño() {
        return cima + 1;
    }
    
    public String obtenerPalabra() {
        if (estaVacia()) {
            return "";
        }
        char[] palabraArray = new char[getTamaño()];
        for (int i = 0; i <= cima; i++) {
            palabraArray[i] = elementos[i];
        }
        return new String(palabraArray);
    }
    
    public void reemplazarPalabra(String palabraVieja, String palabraNueva) {
        if (palabraVieja.isEmpty()) {
            return;
        }
        
        String palabraActual = obtenerPalabra();
        String nuevaPalabra = palabraActual.replace(palabraVieja, palabraNueva);
        
        vaciarPila();
        
        for (int i = nuevaPalabra.length() - 1; i >= 0; i--) {
            apilar(nuevaPalabra.charAt(i));
        }
    }
    
    public boolean esPalindroma() {
        String palabra = obtenerPalabra();
        if (palabra.isEmpty()) {
            return false;
        }
        
        int izquierda = 0;
        int derecha = palabra.length() - 1;
        
        while (izquierda < derecha) {
            if (palabra.charAt(izquierda) != palabra.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }
    
    public boolean contieneSPatron() {
        String palabra = obtenerPalabra();
        if (palabra.isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == 'S') {
                boolean anteriorValido = (i == 0 || palabra.charAt(i - 1) != 'O');
                boolean posteriorValido = (i == palabra.length() - 1 || palabra.charAt(i + 1) != 'O');
                
                if (anteriorValido && posteriorValido) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void ordenarAlfabeticamente() {
        if (estaVacia() || getTamaño() == 1) {
            return;
        }
        
        char[] caracteres = new char[getTamaño()];
        for (int i = 0; i < getTamaño(); i++) {
            caracteres[i] = elementos[i];
        }
        
        Arrays.sort(caracteres);
        
        vaciarPila();
        
        for (int i = caracteres.length - 1; i >= 0; i--) {
            apilar(caracteres[i]);
        }
    }
    
    private void vaciarPila() {
        while (!estaVacia()) {
            desapilar();
        }
    }
}