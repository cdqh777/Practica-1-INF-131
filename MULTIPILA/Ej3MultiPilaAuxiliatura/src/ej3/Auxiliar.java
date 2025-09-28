package ej3;

public class Auxiliar {
    private int ci;
    private String nombre;
    private int cargaHoraria;
    private int cantidadMaterias;
    private double salario;

    public Auxiliar(int ci, String nombre, int cargaHoraria, int cantidadMaterias, double salario) {
        this.ci = ci;
        this.nombre = nombre;
        this.cargaHoraria = cargaHoraria;
        this.cantidadMaterias = cantidadMaterias;
        this.salario = salario;
    }

    public int getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}