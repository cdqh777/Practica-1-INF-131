package ej2;

public class MultiPilaLibro {
    private PilaLibro[] pilas;
    private int cantidadPilas;
    private int capacidadPila;
    
    public MultiPilaLibro(int cantidadPilas, int capacidadPorPila) {
        this.cantidadPilas = cantidadPilas;
        this.setCapacidadPila(capacidadPorPila);
        this.pilas = new PilaLibro[cantidadPilas];
        
        for (int i = 0; i < cantidadPilas; i++) {
            pilas[i] = new PilaLibro(capacidadPorPila);
        }
    }
    
    public void agregarLibro(int numeroPila, Libro libro) {
        if (numeroPila >= 0 && numeroPila < cantidadPilas) {
            pilas[numeroPila].apilar(libro);
        }
    }
    
    public void eliminarLibrosStockCero() {
        for (int i = 0; i < cantidadPilas; i++) {
            pilas[i].eliminarLibrosStockCero();
        }
    }
    
    public void mostrarPilasConAutor(String autor) {
        for (int i = 0; i < cantidadPilas; i++) {
            if (pilas[i].contieneAutor(autor)) {
                System.out.println("Contenido de la Pila " + i + ":");
                pilas[i].mostrarPila();
                System.out.println();
            }
        }
    }
    
    public int buscarPilaLibro(String titulo, String autor) {
        for (int i = 0; i < cantidadPilas; i++) {
            if (pilas[i].contieneLibro(titulo, autor)) {
                return i;
            }
        }
        return -1;
    }
    
    public void mostrarTodasLasPilas() {
        for (int i = 0; i < cantidadPilas; i++) {
            System.out.println("Pila " + i + ":");
            pilas[i].mostrarPila();
            System.out.println();
        }
    }

	public int getCapacidadPila() {
		return capacidadPila;
	}

	public void setCapacidadPila(int capacidadPila) {
		this.capacidadPila = capacidadPila;
	}
}