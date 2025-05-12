package menus;

import java.util.Scanner;
import servicio.ServicioReportes;

public class MenuReportes {
    private final static Scanner sc = new Scanner(System.in);
    private final ServicioReportes servicioReportes;

    public MenuReportes(ServicioReportes servicioReportes) {
        this.servicioReportes = servicioReportes;
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("=== MENU REPORTES ===");
            System.out.println("1. Generar Reporte General de Ventas");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> generarReporteGeneral();
                case 2 -> System.out.println("Saliendo del menú de reportes...");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 2);
    }

    private void generarReporteGeneral() {
        System.out.println(servicioReportes.generarReporte());
    }
}
