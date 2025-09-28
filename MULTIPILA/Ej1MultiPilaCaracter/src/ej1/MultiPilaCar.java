package ej1;

public class MultiPilaCar {
    private PilaCaracter[] pilas;
    private int cantidadPilas;
    
    public MultiPilaCar(int cantidadPilas) {
        this.cantidadPilas = cantidadPilas;
        this.pilas = new PilaCaracter[cantidadPilas];
    }
    
    public PilaCaracter[] getPilas() {
        return pilas;
    }
    
    public int getCantidadPilas() {
        return cantidadPilas;
    }
    
    public void cambioCaracter(String palabraVieja, String palabraNueva) {
        System.out.println("\nA: Reemplazar palabra");
        System.out.println("Letra a reemplazar: " + palabraVieja);
        System.out.println("Nueva letra: " + palabraNueva);
        
        for (int i = 0; i < cantidadPilas; i++) {
            pilas[i].reemplazarPalabra(palabraVieja, palabraNueva);
        }
    }
    
    public void palabraPalindromo() {
        System.out.println("\nB: Verificar palabras palíndromas");
        boolean existePalindroma = false;
        
        for (int i = 0; i < cantidadPilas; i++) {
            if (pilas[i].esPalindroma()) {
                System.out.println("La pila " + (i + 1) + " contiene una palabra palíndroma: " + pilas[i].obtenerPalabra());
                existePalindroma = true;
            }
        }
        
        if (!existePalindroma) {
            System.out.println("✗ No se encontraron palabras palíndromas en ninguna pila.");
        }
    }
    
    public void verCaraterS() {
        System.out.println("\nC: Verificar patrón de 'S'");
        int contador = 0;
        
        for (int i = 0; i < cantidadPilas; i++) {
            if (pilas[i].contieneSPatron()) {
                contador++;
                System.out.println("La pila " + (i + 1) + " cumple con el patrón de 'S' : " + pilas[i].obtenerPalabra());
            }
        }
        
        System.out.println("Total de pilas que cumplen con el patrón: " + contador);
    }
    
    public void ordenPilaAbc() {
        System.out.println("\nD: Ordenar pilas alfabéticamente");
        
        for (int i = 0; i < cantidadPilas; i++) {
            pilas[i].ordenarAlfabeticamente();
        }
    }
}