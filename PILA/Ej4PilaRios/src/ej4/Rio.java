package ej4;

public class Rio {
    private String nombre;
    private String municipio;
    private double alturaActual;
    private double alturaNormal;

    public Rio(String nombre, String municipio, double alturaActual, double alturaNormal) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.alturaActual = alturaActual;
        this.alturaNormal = alturaNormal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public double getAlturaActual() {
        return alturaActual;
    }

    public double getAlturaNormal() {
        return alturaNormal;
    }

    public boolean estaDesbordado() {
        return alturaActual > alturaNormal;
    }

    public double calcularDiferenciaAltura() {
        return Math.abs(alturaActual - alturaNormal);
    }

    @Override
    public String toString() {
        return nombre + " - " + municipio + " | Actual: " + alturaActual + "m | Normal: " + alturaNormal + "m";
    }
}