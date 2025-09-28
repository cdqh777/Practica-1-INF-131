package ej2;

public class Libro {
    private String titulo;
    private String autor;
    private int idLibro;
    private int stock;
    
    public Libro(String titulo, String autor, int idLibro, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.idLibro = idLibro;
        this.stock = stock;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getIdLibro() {
        return idLibro;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ID: " + idLibro + ", Stock: " + stock;
    }
}