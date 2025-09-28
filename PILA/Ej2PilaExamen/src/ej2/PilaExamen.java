package ej2;

import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;

public class PilaExamen {
    private Stack<Examen> pilaExamenes;
    public PilaExamen() {
        this.pilaExamenes = new Stack<>();
    }

    public void agregarExamen(Examen examen) {
        pilaExamenes.push(examen);
    }

    public void mostrarNotasExtremas() {
        if (pilaExamenes.isEmpty()) {
            System.out.println("La pila está vacía");
            return;
        }

        Examen examenMaxNota = pilaExamenes.peek();
        Examen examenMinNota = pilaExamenes.peek();
        Stack<Examen> pilaTemporal = new Stack<>();

        while (!pilaExamenes.isEmpty()) {
            Examen examenActual = pilaExamenes.pop();
            pilaTemporal.push(examenActual);

            if (examenActual.getNotaObtenida() > examenMaxNota.getNotaObtenida()) {
                examenMaxNota = examenActual;
            }
            if (examenActual.getNotaObtenida() < examenMinNota.getNotaObtenida()) {
                examenMinNota = examenActual;
            }
        }

        while (!pilaTemporal.isEmpty()) {
            pilaExamenes.push(pilaTemporal.pop());
        }

        System.out.println("Examen con nota más alta:");
        System.out.println(examenMaxNota);
        System.out.println("Examen con nota más baja:");
        System.out.println(examenMinNota);
    }

    public void contarExamenesPorIdioma() {
        HashMap<String, Integer> contadorIdiomas = new HashMap<>();
        Stack<Examen> pilaTemporal = new Stack<>();

        while (!pilaExamenes.isEmpty()) {
            Examen examenActual = pilaExamenes.pop();
            pilaTemporal.push(examenActual);
            String idioma = examenActual.getIdiomaEvaluado();
            contadorIdiomas.put(idioma, contadorIdiomas.getOrDefault(idioma, 0) + 1);
        }

        while (!pilaTemporal.isEmpty()) {
            pilaExamenes.push(pilaTemporal.pop());
        }

        String idiomaMasParticipacion = "";
        int maximaParticipacion = 0;

        for (String idioma : contadorIdiomas.keySet()) {
            int cantidad = contadorIdiomas.get(idioma);
            System.out.println(idioma + ": " + cantidad + " exámenes");
            
            if (cantidad > maximaParticipacion) {
                maximaParticipacion = cantidad;
                idiomaMasParticipacion = idioma;
            }
        }

        System.out.println("Idioma con mayor participación: " + idiomaMasParticipacion + 
                          " (" + maximaParticipacion + " exámenes)");
    }

    public void verificarNotasRepetidas() {
        HashMap<String, HashSet<Integer>> notasPorOso = new HashMap<>();
        Stack<Examen> pilaTemporal = new Stack<>();
        boolean hayNotasRepetidas = false;

        while (!pilaExamenes.isEmpty()) {
            Examen examenActual = pilaExamenes.pop();
            pilaTemporal.push(examenActual);
            
            String nombreOso = examenActual.getNombreOso();
            int nota = examenActual.getNotaObtenida();
            
            if (!notasPorOso.containsKey(nombreOso)) {
                notasPorOso.put(nombreOso, new HashSet<>());
            }
            
            HashSet<Integer> notas = notasPorOso.get(nombreOso);
            if (notas.contains(nota)) {
                hayNotasRepetidas = true;
                System.out.println("El oso " + nombreOso + " obtuvo la nota " + nota + " en más de un examen");
            } else {
                notas.add(nota);
            }
        }

        while (!pilaTemporal.isEmpty()) {
            pilaExamenes.push(pilaTemporal.pop());
        }

        if (!hayNotasRepetidas) {
            System.out.println("Ningún oso obtuvo la misma nota en dos exámenes diferentes");
        }
    }

    public void eliminarReprobadosGraves() {
        Stack<Examen> pilaFiltrada = new Stack<>();
        Stack<Examen> pilaTemporal = new Stack<>();

        while (!pilaExamenes.isEmpty()) {
            Examen examenActual = pilaExamenes.pop();
            pilaTemporal.push(examenActual);
        }

        while (!pilaTemporal.isEmpty()) {
            Examen examenActual = pilaTemporal.pop();
            if (examenActual.getNotaObtenida() >= 40) {
                pilaFiltrada.push(examenActual);
            }
        }

        this.pilaExamenes = pilaFiltrada;
        mostrarPila();
    }

    public void mostrarPila() {
        if (pilaExamenes.isEmpty()) {
            System.out.println("La pila está vacía");
            return;
        }

        System.out.println("Contenido de la pila de exámenes:");
        Stack<Examen> pilaTemporal = new Stack<>();

        while (!pilaExamenes.isEmpty()) {
            Examen examenActual = pilaExamenes.pop();
            System.out.println(examenActual);
            pilaTemporal.push(examenActual);
        }

        while (!pilaTemporal.isEmpty()) {
            pilaExamenes.push(pilaTemporal.pop());
        }
    }

    public boolean estaVacia() {
        return pilaExamenes.isEmpty();
    }

    public int obtenerTamanio() {
        return pilaExamenes.size();
    }
}