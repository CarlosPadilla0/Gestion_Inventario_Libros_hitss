package servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import modelos.Libro;
import modelos.Venta;
import util.ArchivoUtil;

public class ServicioVentas {

    private List<Venta> ventas;
    private String archivo;
    private List<Libro> inventarioLibros;

    public ServicioVentas(String archivo, List<Libro> inventario) {
        this.archivo = archivo;
        this.ventas = new ArrayList<>();
        this.inventarioLibros = inventario;
        leerArchivo();
    }

    public boolean agregar(Venta venta) {
        Libro libro = venta.getLibro();
        if (libro.getStock() < venta.getCantidadVendida()) {
            System.out.println("Error: No hay suficiente stock para realizar la venta.");
            return false;
        }
        libro.setStock(libro.getStock() - venta.getCantidadVendida());
        boolean agregado = ventas.add(venta);
        if (agregado) {
            guardar(); 
        }
        return agregado;
    }

    public List<Venta> listar() {
        return ventas;
    }

    private void leerArchivo() {
        try {
            List<String> lineas = ArchivoUtil.leerArchivo(archivo);
            ventas = lineas.stream()
                    .skip(1) // Saltar la cabecera
                    .map(linea -> Venta.fromCSV(linea, inventarioLibros))
                    .filter(venta -> venta != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardar() {
        try {
            List<String> lineas = new ArrayList<>();
            lineas.add("libro|cantidad|fecha"); // Cabecera
            lineas.addAll(ventas.stream()
                    .map(Venta::toCSV)
                    .collect(Collectors.toList()));
            ArchivoUtil.escribirArchivo(archivo, lineas);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

	public List<Libro> getInventarioLibros() {
		return inventarioLibros;
	}

	public void setInventarioLibros(List<Libro> inventarioLibros) {
		this.inventarioLibros = inventarioLibros;
	}
    
    
    
}


