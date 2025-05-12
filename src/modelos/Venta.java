package modelos;

import java.time.LocalDate;
import java.util.List;

public class Venta {
	private Libro libro;
	private int cantidadVendida;
	private LocalDate fecha;
	public Venta(Libro libro, int cantidadVendida, LocalDate fecha) {
		this.libro = libro;
		this.cantidadVendida = cantidadVendida;
		this.fecha = fecha;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public int getCantidadVendida() {
		return cantidadVendida;
	}
	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "{Libro: " + libro.getTitulo() + 
				", Cantidad Vendida: " + cantidadVendida + 
				", Fecha: " + fecha + "}";
	}
	
	public String toCSV() {
		return libro.getTitulo() + "|" + cantidadVendida + "|" + fecha;
	}
	
	public static Venta fromCSV(String line, List<Libro> inventario) {
	    String[] elementos = line.split("\\|"); // Correcto para dividir por "|"
	    if (line.equalsIgnoreCase("")) 
	        return null;

	    String titulo = elementos[0];
	    int cantidad = Integer.parseInt(elementos[1]);
	    LocalDate fecha = LocalDate.parse(elementos[2]);

	    Libro libro = inventario.stream()
	                            .filter(lib -> lib.getTitulo().equals(titulo))
	                            .findFirst()
	                            .orElse(null);

	    if (libro == null)
	        return null;

	    return new Venta(libro, cantidad, fecha); // Devuelve un objeto Venta
	}
	
}
