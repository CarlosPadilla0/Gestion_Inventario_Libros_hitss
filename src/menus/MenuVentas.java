package menus;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import modelos.Libro;
import modelos.Venta;
import servicio.ServicioVentas;


public class MenuVentas {
	private final static Scanner sc = new Scanner(System.in);
	private static ServicioVentas servicio;

	public MenuVentas(ServicioVentas serv) {
		MenuVentas.servicio=serv;
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
		System.out.print("Ingresa el Libro: ");
		String libroIngresado = sc.nextLine();

		Libro libroEncontrado = servicio.getInventarioLibros().stream()
				.filter(libro -> libro.getTitulo().equalsIgnoreCase(libroIngresado))  
				.findFirst()  
				.orElse(null); 

		if (libroEncontrado == null) {
			System.out.println("El libro no está en el inventario.");
			return;
		}

		System.out.print("Ingresa la cantidad de libros: ");
		int cant = sc.nextInt();

		LocalDate fechaAct = LocalDate.now();  

		Venta venta = new Venta(libroEncontrado, cant, fechaAct);

		if (servicio.agregar(venta)) {
			System.out.println("Venta agregada correctamente");
			servicio.guardar();  
		} else {
			System.out.println("Error al agregar la venta");
		}
	}


	private static void listar() {
		List<Venta> ventas = servicio.listar();
		if(ventas.isEmpty()) {
			System.out.println("No hay ventas registrados");
			return;
		}
		System.out.println(ventas);

	}

}
