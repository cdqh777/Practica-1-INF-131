package ej3;

public class Principal {
    public static void main(String[] args) {
    	MultiPilaAuxi multipila = new MultiPilaAuxi();
        
        multipila.agregarAuxiliar(0, new Auxiliar(123, "Ana García", 40, 3, 2500));
        multipila.agregarAuxiliar(0, new Auxiliar(124, "Carlos López", 35, 2, 2200));
        multipila.agregarAuxiliar(1, new Auxiliar(125, "María Rodríguez", 45, 4, 2800));
        multipila.agregarAuxiliar(2, new Auxiliar(126, "Pedro Martínez", 30, 1, 1800));
        multipila.agregarAuxiliar(0, new Auxiliar(127, "Beatriz Silva", 38, 3, 2400));
        
        multipila.mostrarCarreraMayorInversion();
        
        multipila.mostrarCarreraMayorAuxiliares();
        
        multipila.mostrarContenidoPila(0);
        multipila.incrementarSalarioInformatica();
        multipila.mostrarContenidoPila(0);
        
        multipila.ordenarTodasLasPilasAlfabeticamente();
        multipila.mostrarContenidoPila(0);
    }
}