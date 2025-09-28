package ej3;

public class PilaCaja {
    private NodoPila cima;
    private int tamaño;
    
    public PilaCaja() {
        this.cima = null;
        this.tamaño = 0;
    }
    
    public void apilar(Caja caja) {
        NodoPila nuevoNodo = new NodoPila(caja);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tamaño++;
    }
    
    public Caja desapilar() {
        if (estaVacia()) {
            return null;
        }
        Caja caja = cima.getCaja();
        cima = cima.getSiguiente();
        tamaño--;
        return caja;
    }
    
    public boolean estaVacia() {
        return cima == null;
    }
    
    public int getTamaño() {
        return tamaño;
    }
    
    public void mostrarAreaMayorYMenor() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return;
        }
        
        Caja mayor = cima.getCaja();
        Caja menor = cima.getCaja();
        NodoPila actual = cima.getSiguiente();
        
        while (actual != null) {
            Caja cajaActual = actual.getCaja();
            if (cajaActual.getArea() > mayor.getArea()) {
                mayor = cajaActual;
            }
            if (cajaActual.getArea() < menor.getArea()) {
                menor = cajaActual;
            }
            actual = actual.getSiguiente();
        }
        
        System.out.println("Caja con área más grande: " + mayor);
        System.out.println("Caja con área más pequeña: " + menor);
    }
    
    public int contarCajasAreasIguales() {
        if (estaVacia()) {
            return 0;
        }
        
        int pares = 0;
        NodoPila actual = cima;
        
        while (actual != null) {
            NodoPila comparador = actual.getSiguiente();
            double areaActual = actual.getCaja().getArea();
            
            while (comparador != null) {
                if (Math.abs(areaActual - comparador.getCaja().getArea()) < 0.001) {
                    pares++;
                }
                comparador = comparador.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
        
        return pares;
    }
    
    public String determinarColorPredominante() {
        if (estaVacia()) {
            return "No hay cajas";
        }
        
        java.util.HashMap<String, Integer> contadorColores = new java.util.HashMap<>();
        NodoPila actual = cima;
        
        while (actual != null) {
            String color = actual.getCaja().getColor();
            contadorColores.put(color, contadorColores.getOrDefault(color, 0) + 1);
            actual = actual.getSiguiente();
        }
        
        String colorPredominante = "";
        int maxFrecuencia = 0;
        
        for (java.util.Map.Entry<String, Integer> entry : contadorColores.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                colorPredominante = entry.getKey();
            }
        }
        
        return colorPredominante;
    }
    
    public String existeSecuenciaTresMismoColor() {
        if (estaVacia()) {
            return "NO";
        }
        
        NodoPila actual = cima;
        int contadorConsecutivos = 1;
        String colorAnterior = actual.getCaja().getColor();
        actual = actual.getSiguiente();
        
        while (actual != null) {
            String colorActual = actual.getCaja().getColor();
            if (colorActual.equals(colorAnterior)) {
                contadorConsecutivos++;
                if (contadorConsecutivos >= 3) {
                    return "SÍ";
                }
            } else {
                contadorConsecutivos = 1;
                colorAnterior = colorActual;
            }
            
            actual = actual.getSiguiente();
        }
        
        return "NO";
    }
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Pila vacía");
            return;
        }
        
        NodoPila actual = cima;
        System.out.println("Contenido de la pila:");
        while (actual != null) {
            System.out.println(actual.getCaja());
            actual = actual.getSiguiente();
        }
    }
}