package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArchivoUtil {

    public static List<String> leerArchivo(String ruta) throws IOException {
        if (!Files.exists(Paths.get(ruta))) {
            throw new IOException("El archivo no existe: " + ruta);
        }
        return Files.readAllLines(Paths.get(ruta));
    }

    public static void escribirArchivo(String ruta, List<String> lineas) throws IOException {
        Files.write(Paths.get(ruta), lineas);
    }
}