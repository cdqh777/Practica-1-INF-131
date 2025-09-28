package ej1;

public class Principal {
    public static void main(String[] args) {
        MultiPilaCar multiPilaCar = new MultiPilaCar(5);
        
        multiPilaCar.getPilas()[0] = new PilaCaracter(4);
        multiPilaCar.getPilas()[1] = new PilaCaracter(3);
        multiPilaCar.getPilas()[2] = new PilaCaracter(4);
        multiPilaCar.getPilas()[3] = new PilaCaracter(3);
        multiPilaCar.getPilas()[4] = new PilaCaracter(5); 
        inicializarPilas(multiPilaCar);
        
        System.out.println("ESTADO INICIAL DE LAS PILAS:");
        mostrarPilas(multiPilaCar);
        
        String palabraVieja = "A";
        String palabraNueva = "E";
        multiPilaCar.cambioCaracter(palabraVieja, palabraNueva);
        mostrarPilas(multiPilaCar);
        
        multiPilaCar.palabraPalindromo();
        
        multiPilaCar.verCaraterS();
        
        multiPilaCar.ordenPilaAbc();
        mostrarPilas(multiPilaCar);
    }
    
    public static void inicializarPilas(MultiPilaCar multiPilaCar) {
        multiPilaCar.getPilas()[0].apilar('R');
        multiPilaCar.getPilas()[0].apilar('A');
        multiPilaCar.getPilas()[0].apilar('T');
        multiPilaCar.getPilas()[0].apilar('O');
        
        multiPilaCar.getPilas()[1].apilar('L');
        multiPilaCar.getPilas()[1].apilar('O');
        multiPilaCar.getPilas()[1].apilar('S');
        
        multiPilaCar.getPilas()[2].apilar('A');
        multiPilaCar.getPilas()[2].apilar('M');
        multiPilaCar.getPilas()[2].apilar('O');
        multiPilaCar.getPilas()[2].apilar('R');
        
        multiPilaCar.getPilas()[3].apilar('A');
        multiPilaCar.getPilas()[3].apilar('N');
        multiPilaCar.getPilas()[3].apilar('A');
        
        multiPilaCar.getPilas()[4].apilar('R');
        multiPilaCar.getPilas()[4].apilar('A');
        multiPilaCar.getPilas()[4].apilar('S');
        multiPilaCar.getPilas()[4].apilar('O');
        multiPilaCar.getPilas()[4].apilar('N');
    }
    
    public static void mostrarPilas(MultiPilaCar multiPilaCar) {
        for (int i = 0; i < multiPilaCar.getCantidadPilas(); i++) {
            System.out.println("Pila " + (i + 1) + ": " + multiPilaCar.getPilas()[i].obtenerPalabra());
        }
    }
    
}