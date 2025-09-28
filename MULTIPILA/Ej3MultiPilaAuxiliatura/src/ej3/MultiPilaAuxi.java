package ej3;

public class MultiPilaAuxi {
    private static final int CARRERAS = 7;
    private PilaAuxi[] pilasCarreras;
    private PilaAuxi pilaInterdisciplinarios;

    public MultiPilaAuxi() {
        this.pilasCarreras = new PilaAuxi[CARRERAS];
        this.pilaInterdisciplinarios = new PilaAuxi();
        
        for (int i = 0; i < CARRERAS; i++) {
            pilasCarreras[i] = new PilaAuxi();
        }
    }

    public void agregarAuxiliar(int indiceCarrera, Auxiliar auxiliar) {
        if (indiceCarrera >= 0 && indiceCarrera < CARRERAS) {
            pilasCarreras[indiceCarrera].apilar(auxiliar);
        }
    }

    public void agregarInterdisciplinario(Auxiliar auxiliar) {
        pilaInterdisciplinarios.apilar(auxiliar);
    }

    public double[] calcularGastoTotalSalarios() {
        double[] gastos = new double[CARRERAS];
        
        for (int i = 0; i < CARRERAS; i++) {
            PilaAuxi pilaTemporal = new PilaAuxi();
            double gasto = 0;
            
            while (!pilasCarreras[i].estaVacia()) {
                Auxiliar auxiliar = pilasCarreras[i].desapilar();
                gasto += auxiliar.getSalario();
                pilaTemporal.apilar(auxiliar);
            }
            
            while (!pilaTemporal.estaVacia()) {
                pilasCarreras[i].apilar(pilaTemporal.desapilar());
            }
            
            gastos[i] = gasto;
        }
        
        return gastos;
    }

    public void mostrarCarreraMayorInversion() {
        double[] gastos = calcularGastoTotalSalarios();
        double maxGasto = 0;
        int indiceMax = 0;
        String[] nombresCarreras = {"Informática", "Física", "Matemática", "Química", "Estadística", "Biología", "Carrera 7"};
        
        for (int i = 0; i < gastos.length; i++) {
            if (gastos[i] > maxGasto) {
                maxGasto = gastos[i];
                indiceMax = i;
            }
        }
        
        System.out.println("Carrera con mayor inversión: " + nombresCarreras[indiceMax] + " - Gasto: " + maxGasto);
    }

    public int[] obtenerCantidadAuxiliaresPorCarrera() {
        int[] cantidades = new int[CARRERAS];
        
        for (int i = 0; i < CARRERAS; i++) {
            PilaAuxi pilaTemporal = new PilaAuxi();
            int contador = 0;
            
            while (!pilasCarreras[i].estaVacia()) {
                Auxiliar auxiliar = pilasCarreras[i].desapilar();
                contador++;
                pilaTemporal.apilar(auxiliar);
            }
            
            while (!pilaTemporal.estaVacia()) {
                pilasCarreras[i].apilar(pilaTemporal.desapilar());
            }
            
            cantidades[i] = contador;
        }
        
        return cantidades;
    }

    public void mostrarCarreraMayorAuxiliares() {
        int[] cantidades = obtenerCantidadAuxiliaresPorCarrera();
        int maxCantidad = 0;
        int indiceMax = 0;
        String[] nombresCarreras = {"Informática", "Física", "Matemática", "Química", "Estadística", "Biología", "Carrera 7"};
        
        for (int i = 0; i < cantidades.length; i++) {
            if (cantidades[i] > maxCantidad) {
                maxCantidad = cantidades[i];
                indiceMax = i;
            }
        }
        
        System.out.println("Carrera con más auxiliares: " + nombresCarreras[indiceMax] + " - Cantidad: " + maxCantidad);
    }

    public void incrementarSalarioInformatica() {
        int indiceInformatica = 0;
        PilaAuxi pilaTemporal = new PilaAuxi();
        
        while (!pilasCarreras[indiceInformatica].estaVacia()) {
            Auxiliar auxiliar = pilasCarreras[indiceInformatica].desapilar();
            double nuevoSalario = auxiliar.getSalario() * 1.30;
            auxiliar.setSalario(nuevoSalario);
            pilaTemporal.apilar(auxiliar);
        }
        
        while (!pilaTemporal.estaVacia()) {
            pilasCarreras[indiceInformatica].apilar(pilaTemporal.desapilar());
        }
        
        System.out.println("Salarios de Informática incrementados en 30%");
    }

    public void ordenarPilaAlfabeticamente(int indiceCarrera) {
        if (indiceCarrera < 0 || indiceCarrera >= CARRERAS) return;
        
        PilaAuxi pilaPrincipal = pilasCarreras[indiceCarrera];
        PilaAuxi pilaAuxiliar = new PilaAuxi();
        
        while (!pilaPrincipal.estaVacia()) {
            Auxiliar auxiliarActual = pilaPrincipal.desapilar();
            
            while (!pilaAuxiliar.estaVacia() && 
                   pilaAuxiliar.cima().getNombre().compareTo(auxiliarActual.getNombre()) < 0) {
                pilaPrincipal.apilar(pilaAuxiliar.desapilar());
            }
            
            pilaAuxiliar.apilar(auxiliarActual);
        }
        
        while (!pilaAuxiliar.estaVacia()) {
            pilaPrincipal.apilar(pilaAuxiliar.desapilar());
        }
    }

    public void ordenarTodasLasPilasAlfabeticamente() {
        for (int i = 0; i < CARRERAS; i++) {
            ordenarPilaAlfabeticamente(i);
        }
        System.out.println("Todas las pilas ordenadas alfabéticamente");
    }

    public void mostrarContenidoPila(int indiceCarrera) {
        if (indiceCarrera < 0 || indiceCarrera >= CARRERAS) return;
        
        String[] nombresCarreras = {"Informática", "Física", "Matemática", "Química", "Estadística", "Biología", "Carrera 7"};
        System.out.println("\nContenido de " + nombresCarreras[indiceCarrera] + ":");
        PilaAuxi pilaTemporal = new PilaAuxi();
        
        while (!pilasCarreras[indiceCarrera].estaVacia()) {
            Auxiliar auxiliar = pilasCarreras[indiceCarrera].desapilar();
            System.out.println("Nombre: " + auxiliar.getNombre() + ", Salario: " + auxiliar.getSalario());
            pilaTemporal.apilar(auxiliar);
        }
        
        while (!pilaTemporal.estaVacia()) {
            pilasCarreras[indiceCarrera].apilar(pilaTemporal.desapilar());
        }
    }
}