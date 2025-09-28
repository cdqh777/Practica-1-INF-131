package ej2;

public class Principal {
    public static void main(String[] args) {
        PilaExamen pilaExamenes = new PilaExamen();
        pilaExamenes.agregarExamen(new Examen(1, 25, "Baloo", "Inglés"));
        pilaExamenes.agregarExamen(new Examen(2, 92, "Winnie", "Francés"));
        pilaExamenes.agregarExamen(new Examen(3, 78, "Yogi", "Inglés"));
        pilaExamenes.agregarExamen(new Examen(4, 88, "Baloo", "Francés"));
        pilaExamenes.agregarExamen(new Examen(5, 99, "Winnie", "Inglés"));
        pilaExamenes.agregarExamen(new Examen(6, 39, "Yogi", "Alemán"));
        pilaExamenes.agregarExamen(new Examen(7, 95, "Baloo", "Alemán"));

        System.out.println("A) NOTAS MÁS ALTA Y MÁS BAJA");
        pilaExamenes.mostrarNotasExtremas();

        System.out.println("\nB) CONTEO POR IDIOMA");
        pilaExamenes.contarExamenesPorIdioma();

        System.out.println("\nC) VERIFICACIÓN DE NOTAS REPETIDAS");
        pilaExamenes.verificarNotasRepetidas();

        System.out.println("\nD) ELIMINAR REPROBADOS GRAVES (nota < 40)");
        pilaExamenes.eliminarReprobadosGraves();
    }
}