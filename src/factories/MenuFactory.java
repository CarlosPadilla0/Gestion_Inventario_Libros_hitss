package factories;

import java.util.Scanner;
import menus.MenuLibros;
import menus.MenuVentas;
import menus.MenuReportes;
import servicio.ServicioLibros;
import servicio.ServicioReportes;
import servicio.ServicioVentas;

public class MenuFactory {
	private static final String ARCHIVO_VENTAS = "ventas.csv";
	private static final String ARCHIVO_LIBROS = "libros.csv";
	private final static ServicioLibros servicioLibros = new ServicioLibros(ARCHIVO_LIBROS);
	private final static ServicioVentas servicioVentas = new ServicioVentas(ARCHIVO_VENTAS, servicioLibros.listar());
	private final static ServicioReportes servicioReportes = new ServicioReportes(servicioVentas);
	private final Scanner sc = new Scanner(System.in);

	public void iniciar() {
		int opcion;
		do {
			System.out.println("=== MENU PRINCIPAL ===");
			System.out.println("1. Gestionar Libros");
			System.out.println("2. Gestionar Ventas");
			System.out.println("3. Mostrar Reportes");
			System.out.println("4. Salir");
			System.out.print("Selecciona una opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1 -> new MenuLibros(servicioLibros).mostrar();
			case 2 -> new MenuVentas(servicioVentas).mostrar();
			case 3 -> new MenuReportes(servicioReportes).mostrar();
			case 4 -> System.out.println("Saliendo...");
			default -> System.out.println("Opción no válida. Intenta de nuevo.");
			}
		} while (opcion != 4);
	}   
}

