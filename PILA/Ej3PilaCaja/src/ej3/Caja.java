package ej3;

public class Caja {
    private double area;
    private String color;
    private String contenido;
    
    public Caja(double area, String color, String contenido) {
        this.area = area;
        this.color = color;
        this.contenido = contenido;
    }
    
    public double getArea() {
        return area;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    @Override
    public String toString() {
        return "Caja{area=" + area + ", color='" + color + "', contenido='" + contenido + "'}";
    }
}