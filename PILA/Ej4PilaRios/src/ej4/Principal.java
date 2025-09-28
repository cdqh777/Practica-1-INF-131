package ej4;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        PilaRio gestion = new PilaRio();

        gestion.agregarRio(new Rio("Pilcomayo", "Villamontes", 4.5, 3.2));
        gestion.agregarRio(new Rio("Grande", "Uyuni", 2.8, 2.5));
        gestion.agregarRio(new Rio("Parapeti", "Uyuni", 3.1, 2.9));
        gestion.agregarRio(new Rio("Bermejo", "Bermejo", 5.2, 4.0));
        gestion.agregarRio(new Rio("Pilcomayo", "Yacuiba", 3.8, 3.2));
        gestion.mostrarPila();

        System.out.println("\na) Ríos desbordados en orden alfabético:");
        List<String> desbordados = gestion.listarRiosDesbordadosOrdenados();
        for (String rio : desbordados) {
            System.out.println("- " + rio);
        }

        System.out.println("\nb) ¿Existe río que atraviesa exactamente 2 municipios?");
        System.out.println("R: " + (gestion.existeRioConDosMunicipios() ? "Sí" : "No"));

        System.out.println("\nc) ¿Municipio Uyuni tiene más de un río registrado?");
        System.out.println("R: " + (gestion.municipioUyuniTieneMasDeUnRio() ? "Sí" : "No"));

        System.out.println("\nd) Río con menor diferencia entre altura actual y normal:");
        Rio rioMenorDiferencia = gestion.identificarRioMenorDiferencia();
        if (rioMenorDiferencia != null) {
            System.out.printf("%s - Diferencia: %.3fm%n", 
                rioMenorDiferencia.getNombre(), 
                rioMenorDiferencia.calcularDiferenciaAltura());
        }
    }
}