package ej2;

public class PilaLibro {
    private Libro[] libros;
    private int tope;
    private int capacidad;
    
    public PilaLibro(int capacidad) {
        this.capacidad = capacidad;
        this.libros = new Libro[capacidad];
        this.tope = -1;
    }
    
    public boolean estaVacia() {
        return tope == -1;
    }
    
    public boolean estaLlena() {
        return tope == capacidad - 1;
    }
    
    public void apilar(Libro libro) {
        if (!estaLlena()) {
            tope++;
            libros[tope] = libro;
        }
    }
    
    public Libro desapilar() {
        if (!estaVacia()) {
            Libro libro = libros[tope];
            tope--;
            return libro;
        }
        return null;
    }
    
    public Libro cima() {
        if (!estaVacia()) {
            return libros[tope];
        }
        return null;
    }
    
    public void mostrarPila() {
        for (int i = tope; i >= 0; i--) {
            System.out.println(libros[i]);
        }
    }
    
    public boolean contieneAutor(String autor) {
        for (int i = 0; i <= tope; i++) {
            if (libros[i].getAutor().equals(autor)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean contieneLibro(String titulo, String autor) {
        for (int i = 0; i <= tope; i++) {
            if (libros[i].getTitulo().equals(titulo) && libros[i].getAutor().equals(autor)) {
                return true;
            }
        }
        return false;
    }
    
    public void eliminarLibrosStockCero() {
        PilaLibro pilaAuxiliar = new PilaLibro(capacidad);
        
        while (!estaVacia()) {
            Libro libro = desapilar();
            if (libro.getStock() != 0) {
                pilaAuxiliar.apilar(libro);
            }
        }
        
        while (!pilaAuxiliar.estaVacia()) {
            apilar(pilaAuxiliar.desapilar());
        }
    }
}
