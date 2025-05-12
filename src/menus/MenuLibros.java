package menus;

import java.util.List;
import java.util.Scanner;
import modelos.Libro;
import servicio.ServicioLibros;


public class MenuLibros {
    private final static Scanner sc = new Scanner(System.in);
    private static  ServicioLibros servicio;
    
    public MenuLibros(ServicioLibros Serv) {
    	MenuLibros.servicio=Serv;
    }
    
    public void mostrar() {
        int opcion;
        do {
            System.out.println("=== MENU LIBROS ===");
            System.out.println("1. Agregar");
            System.out.println("2. Listar");
            System.out.println("3. Regresar");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 3);
    }
    private static void agregar() {    	
		System.out.print("Ingresa el titulo");
		String titulo = sc.nextLine();
		System.out.print("Ingresa el autor");
		String autor = sc.nextLine();
		System.out.print("Ingresa el genero");
		String genero = sc.nextLine();
		System.out.print("Ingresa el precio");
		Double precio = sc.nextDouble();
		System.out.print("Ingresa el Stock");
		int stock = sc.nextInt();
		
		if(servicio.agregar(new Libro(titulo, autor, genero, precio, stock))){
			System.out.println("Libro agregado correctamente");
			servicio.guardar();
			return;
		}
		System.out.println("Error al agregar el libro");
	}
    
    private static void listar() {
		List<Libro> libros =servicio.listar();
		if(libros.isEmpty()) {
			System.out.println("No hay libros registrados");
			return;
		}
		System.out.println(libros);
		
	}

}
