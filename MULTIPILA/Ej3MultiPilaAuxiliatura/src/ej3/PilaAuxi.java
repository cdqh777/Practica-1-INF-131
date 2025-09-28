package ej3;

public class PilaAuxi {
    private static final int MAXIMO = 100;
    private Auxiliar[] elementos;
    private int tope;

    public PilaAuxi() {
        this.elementos = new Auxiliar[MAXIMO];
        this.tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == MAXIMO - 1;
    }

    public void apilar(Auxiliar auxiliar) {
        if (!estaLlena()) {
            tope++;
            elementos[tope] = auxiliar;
        }
    }

    public Auxiliar desapilar() {
        if (!estaVacia()) {
            Auxiliar auxiliar = elementos[tope];
            tope--;
            return auxiliar;
        }
        return null;
    }

    public Auxiliar cima() {
        if (!estaVacia()) {
            return elementos[tope];
        }
        return null;
    }

    public int obtenerTamanio() {
        return tope + 1;
    }

    public Auxiliar[] obtenerElementos() {
        return elementos;
    }

    public int obtenerTope() {
        return tope;
    }
}