package servicio;

import java.util.stream.Collectors;
import modelos.Venta;

public class ServicioReportes {
    private final ServicioVentas servicioVentas;

    public ServicioReportes(ServicioVentas servicioVentas) {
        this.servicioVentas = servicioVentas;
    }

    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE GENERAL DE VENTAS ===\n");
        reporte.append("Libro | Cantidad Vendida | Total Generado\n");

        servicioVentas.listar().stream()
            .collect(Collectors.groupingBy(
                venta -> venta.getLibro().getTitulo(),
                Collectors.summingInt(Venta::getCantidadVendida)
            ))
            .forEach((titulo, cantidadVendida) -> {
                double totalGenerado = servicioVentas.listar().stream()
                    .filter(venta -> venta.getLibro().getTitulo().equals(titulo))
                    .mapToDouble(venta -> venta.getCantidadVendida() * venta.getLibro().getPrecio())
                    .sum();
                reporte.append(String.format("%s | %d | %.2f\n", titulo, cantidadVendida, totalGenerado));
            });

        return reporte.toString();
    }
}
