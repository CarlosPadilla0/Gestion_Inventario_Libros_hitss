package servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import modelos.Libro;
import util.ArchivoUtil;

public class ServicioLibros {

    private List<Libro> elementos;
    private String archivo;

    public ServicioLibros(String archivo) {
        this.archivo = archivo;
        this.elementos = new ArrayList<>();
        leerArchivo();
    }

    public boolean agregar(Libro libro) {
        boolean agregado = elementos.add(libro);
        if (agregado) {
            guardar(); 
        }
        return agregado;
    }

    public List<Libro> listar() {
        return elementos;
    }

    private void leerArchivo() {
        try {
            List<String> lineas = ArchivoUtil.leerArchivo(archivo);
            elementos = lineas.stream()
                    .skip(1) 
                    .map(Libro::fromCSV)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardar() {
        try {
            List<String> lineas = new ArrayList<>();
            lineas.add("Titulo|Autor|Genero|Precio|Stock"); 
            lineas.addAll(elementos.stream()
                    .map(Libro::toCSV)
                    .collect(Collectors.toList()));
            ArchivoUtil.escribirArchivo(archivo, lineas);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
