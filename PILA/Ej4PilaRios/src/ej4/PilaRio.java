package ej4;

import java.util.*;

public class PilaRio {
    private Stack<Rio> pilaRios;

    public PilaRio() {
        this.pilaRios = new Stack<>();
    }

    public void agregarRio(Rio rio) {
        pilaRios.push(rio);
    }

    public List<String> listarRiosDesbordadosOrdenados() {
        List<String> riosDesbordados = new ArrayList<>();
        
        for (Rio rio : pilaRios) {
            if (rio.estaDesbordado()) {
                riosDesbordados.add(rio.getNombre());
            }
        }
        
        Collections.sort(riosDesbordados);
        return riosDesbordados;
    }

    public boolean existeRioConDosMunicipios() {
        Map<String, Integer> conteoMunicipiosPorRio = new HashMap<>();
        
        for (Rio rio : pilaRios) {
            String nombreRio = rio.getNombre();
            conteoMunicipiosPorRio.put(nombreRio, conteoMunicipiosPorRio.getOrDefault(nombreRio, 0) + 1);
        }
        
        for (int conteo : conteoMunicipiosPorRio.values()) {
            if (conteo == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean municipioUyuniTieneMasDeUnRio() {
        int contadorUyuni = 0;
        
        for (Rio rio : pilaRios) {
            if ("Uyuni".equalsIgnoreCase(rio.getMunicipio())) {
                contadorUyuni++;
            }
        }
        
        return contadorUyuni > 1;
    }

    public Rio identificarRioMenorDiferencia() {
        if (pilaRios.isEmpty()) {
            return null;
        }
        
        Rio rioMenorDiferencia = pilaRios.get(0);
        double menorDiferencia = rioMenorDiferencia.calcularDiferenciaAltura();
        
        for (Rio rio : pilaRios) {
            double diferenciaActual = rio.calcularDiferenciaAltura();
            if (diferenciaActual < menorDiferencia) {
                menorDiferencia = diferenciaActual;
                rioMenorDiferencia = rio;
            }
        }
        
        return rioMenorDiferencia;
    }

    public void mostrarPila() {
        System.out.println("Ríos en la pila:");
        for (Rio rio : pilaRios) {
            System.out.println(rio);
        }
    }
}
