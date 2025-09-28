package ej2;

public class Principal {
    public static void main(String[] args) {
        MultiPilaLibro biblioteca = new MultiPilaLibro(3, 5);
        
        biblioteca.agregarLibro(0, new Libro("Cien años de soledad", "Gabriel García Márquez", 1, 5));
        biblioteca.agregarLibro(0, new Libro("1984", "George Orwell", 3, 3));
        biblioteca.agregarLibro(1, new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", 2, 1));
        biblioteca.agregarLibro(1, new Libro("Rebelión en la granja", "George Orwell", 4, 0));
        biblioteca.agregarLibro(2, new Libro("Don Quijote", "Miguel de Cervantes", 5, 2));
        biblioteca.agregarLibro(2, new Libro("La Galatea", "Miguel de Cervantes", 6, 0));
        
        System.out.println("Estado inicial de la biblioteca:");
        biblioteca.mostrarTodasLasPilas();
        
        System.out.println("\na)Eliminando libros con stock 0");
        biblioteca.eliminarLibrosStockCero();
        
        System.out.println("Estado después de eliminar libros sin stock:");
        biblioteca.mostrarTodasLasPilas();
        
        System.out.println("\nb)Mostrando pilas con libros de Gabriel García Márquez:");
        biblioteca.mostrarPilasConAutor("Gabriel García Márquez");
        
        System.out.println("\nc)Buscar el libro 'Don Quijote' de Miguel de Cervantes:");
        String tituloBuscado = "Don Quijote";
        String autorBuscado = "Miguel de Cervantes";
        int numeroPila = biblioteca.buscarPilaLibro(tituloBuscado, autorBuscado);
        
        if (numeroPila != -1) {
            System.out.println("El libro '" + tituloBuscado + "' de " + autorBuscado + " está en la pila " + numeroPila);
        } else {
            System.out.println("El libro '" + tituloBuscado + "' de " + autorBuscado + " no se encontró");
        }
    }
}
