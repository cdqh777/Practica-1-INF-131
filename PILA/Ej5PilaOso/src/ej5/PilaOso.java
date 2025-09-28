package ej5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PilaOso {
    private ArrayList<Alimento> pila;
    private String nombreOso;
    
    public PilaOso(String nombreOso) {
        this.pila = new ArrayList<>();
        this.nombreOso = nombreOso;
    }
    
    public boolean estaVacia() {
        return pila.isEmpty();
    }
    
    public void apilar(Alimento alimento) {
        pila.add(alimento);
    }
    
    public Alimento desapilar() {
        if (estaVacia()) {
            return null;
        }
        return pila.remove(pila.size() - 1);
    }
    
    public Alimento verCima() {
        if (estaVacia()) {
            return null;
        }
        return pila.get(pila.size() - 1);
    }
    
    public String getNombreOso() {
        return nombreOso;
    }
    
    public double calcularTotalKilos() {
        double total = 0;
        for (Alimento alimento : pila) {
            total += alimento.getCantidad();
        }
        return total;
    }
    
    public int contarAlimentos() {
        return pila.size();
    }
    
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("La pila de " + nombreOso + " está vacía");
            return;
        }
        
        System.out.println("Pila de " + nombreOso + ":");
        for (int i = pila.size() - 1; i >= 0; i--) {
            System.out.println("  - " + pila.get(i));
        }
    }
    
    public PilaOso copiarPila() {
        PilaOso copia = new PilaOso(nombreOso);
        for (Alimento alimento : pila) {
            copia.apilar(new Alimento(alimento.getNombre(), alimento.getCantidad()));
        }
        return copia;
    }
    
    public void invertirPila() {
        ArrayList<Alimento> pilaInvertida = new ArrayList<>();
        for (int i = pila.size() - 1; i >= 0; i--) {
            pilaInvertida.add(pila.get(i));
        }
        pila = pilaInvertida;
    }
    
    public Set<String> obtenerTiposAlimentos() {
        Set<String> tipos = new HashSet<>();
        for (Alimento alimento : pila) {
            tipos.add(alimento.getNombre());
        }
        return tipos;
    }
    
    public Map<String, Integer> obtenerFrecuenciaAlimentos() {
        Map<String, Integer> frecuencia = new HashMap<>();
        for (Alimento alimento : pila) {
            String nombre = alimento.getNombre();
            frecuencia.put(nombre, frecuencia.getOrDefault(nombre, 0) + 1);
        }
        return frecuencia;
    }
    
    public static String determinarAlimentoMasComun(PilaOso pardo, PilaOso panda, PilaOso polar) {
        Map<String, Integer> frecuenciaTotal = new HashMap<>();
        
        agregarFrecuenciaPila(frecuenciaTotal, pardo);
        agregarFrecuenciaPila(frecuenciaTotal, panda);
        agregarFrecuenciaPila(frecuenciaTotal, polar);
        
        String alimentoMasComun = "";
        int maxFrecuencia = 0;
        
        for (Map.Entry<String, Integer> entry : frecuenciaTotal.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                alimentoMasComun = entry.getKey();
            }
        }
        
        return alimentoMasComun + " (aparece " + maxFrecuencia + " veces)";
    }
    
    private static void agregarFrecuenciaPila(Map<String, Integer> frecuencia, PilaOso pila) {
        Map<String, Integer> frecuenciaPila = pila.obtenerFrecuenciaAlimentos();
        for (Map.Entry<String, Integer> entry : frecuenciaPila.entrySet()) {
            frecuencia.put(entry.getKey(), frecuencia.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }
    
    public static void calcularPromedioYOsosArriba(PilaOso pardo, PilaOso panda, PilaOso polar) {
        double totalPardo = pardo.calcularTotalKilos();
        double totalPanda = panda.calcularTotalKilos();
        double totalPolar = polar.calcularTotalKilos();
        
        double promedio = (totalPardo + totalPanda + totalPolar) / 3;
        
        System.out.println("Promedio de kilos por pila: " + String.format("%.2f", promedio));
        System.out.println("Osos por encima del promedio:");
        
        if (totalPardo > promedio) {
            System.out.println("- Pardo: " + String.format("%.2f", totalPardo) + " kg");
        }
        if (totalPanda > promedio) {
            System.out.println("- Panda: " + String.format("%.2f", totalPanda) + " kg");
        }
        if (totalPolar > promedio) {
            System.out.println("- Polar: " + String.format("%.2f", totalPolar) + " kg");
        }
    }
    
    public static boolean verificarMismosAlimentos(PilaOso pardo, PilaOso panda, PilaOso polar) {
        Set<String> alimentosPardo = pardo.obtenerTiposAlimentos();
        Set<String> alimentosPanda = panda.obtenerTiposAlimentos();
        Set<String> alimentosPolar = polar.obtenerTiposAlimentos();
        
        return alimentosPardo.equals(alimentosPanda) && alimentosPanda.equals(alimentosPolar);
    }
    
    public static void invertirPilaOso(PilaOso pila, String nombreOso) {
        System.out.println("Pila de " + nombreOso + " antes de invertir:");
        pila.mostrarPila();
        
        pila.invertirPila();
        
        System.out.println("Pila de " + nombreOso + " después de invertir:");
        pila.mostrarPila();
    }
}