package ej3;

public class Principal {
    public static void main(String[] args) {
        PilaCaja pila = new PilaCaja();
        pila.apilar(new Caja(8, "rojo", "electrónicos"));
        pila.apilar(new Caja(2.7, "azul", "ropa"));
        pila.apilar(new Caja(6.9, "azul", "libros"));
        pila.apilar(new Caja(8, "verde", "muebles"));
        pila.apilar(new Caja(8.8, "azul", "juguetes"));
        pila.apilar(new Caja(10, "rojo", "deportes"));
        pila.apilar(new Caja(4, "azul", "herramientas"));
        
        pila.mostrarPila();
        System.out.println();
        
        System.out.println("\na) Cajas con área mayor y menor:");
        pila.mostrarAreaMayorYMenor();
        System.out.println();
        
        System.out.println("\nb) Pares de cajas con áreas iguales: " + pila.contarCajasAreasIguales());
        System.out.println();
        
        System.out.println("\nc) Color predominante: ");
        System.out.println(pila.determinarColorPredominante());
        
        System.out.println("\nd) ¿Existe secuencia de 3 cajas consecutivas del mismo color? ");
        System.out.println(pila.existeSecuenciaTresMismoColor());
        
    }
}
