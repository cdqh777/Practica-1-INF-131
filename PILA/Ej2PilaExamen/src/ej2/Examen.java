package ej2;

public class Examen {
    private int numeroExamen;
    private int notaObtenida;
    private String nombreOso;
    private String idiomaEvaluado;

    public Examen(int numeroExamen, int notaObtenida, String nombreOso, String idiomaEvaluado) {
        this.numeroExamen = numeroExamen;
        this.notaObtenida = notaObtenida;
        this.nombreOso = nombreOso;
        this.idiomaEvaluado = idiomaEvaluado;
    }

    public int getNumeroExamen() {
        return numeroExamen;
    }

    public int getNotaObtenida() {
        return notaObtenida;
    }

    public String getNombreOso() {
        return nombreOso;
    }

    public String getIdiomaEvaluado() {
        return idiomaEvaluado;
    }

    @Override
    public String toString() {
        return "Examen #" + numeroExamen + " - Oso: " + nombreOso + 
               " - Idioma: " + idiomaEvaluado + " - Nota: " + notaObtenida;
    }
}