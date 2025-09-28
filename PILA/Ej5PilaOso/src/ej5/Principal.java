package ej5;

public class Principal {
    public static void main(String[] args) {
        PilaOso pardo = new PilaOso("Pardo");
        PilaOso panda = new PilaOso("Panda");
        PilaOso polar = new PilaOso("Polar");
        
        pardo.apilar(new Alimento("Pescado", 5));
        pardo.apilar(new Alimento("Bayas", 3));
        pardo.apilar(new Alimento("Miel", 2));
        
        panda.apilar(new Alimento("Bambú", 8));
        panda.apilar(new Alimento("Bayas", 2));
        panda.apilar(new Alimento("Pescado", 4));
        
        polar.apilar(new Alimento("Pescado", 6));
        polar.apilar(new Alimento("Focas", 10));
        polar.apilar(new Alimento("Bayas", 1));
        
        System.out.println("MONITOREO LOS SABROSSOS");
        
        pardo.mostrarPila();
        panda.mostrarPila();
        polar.mostrarPila();
        
        System.out.println("\na) Alimento más común:");
        String alimentoComun = PilaOso.determinarAlimentoMasComun(pardo, panda, polar);
        System.out.println(alimentoComun);
        
        System.out.println("\nb) Promedio y osos arriba del promedio:");
        PilaOso.calcularPromedioYOsosArriba(pardo, panda, polar);
        
        System.out.println("\nc) ¿Tienen los mismos tipos de alimentos?");
        boolean mismosAlimentos = PilaOso.verificarMismosAlimentos(pardo, panda, polar);
        System.out.println(mismosAlimentos ? "Sí, todos tienen los mismos tipos" : "No, tienen diferentes tipos");
        
        System.out.println("\nd) Invertir pila de Pardo:");
        PilaOso.invertirPilaOso(pardo, "Pardo");
    }
}