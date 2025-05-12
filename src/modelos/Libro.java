package modelos;

public class Libro {
	private String titulo;
	private String autor;
	private String genero;
	private double precio;
	private int stock;
	public Libro(String titulo, String autor, String genero, double precio, int stock) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.precio = precio;
		this.stock = stock;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "{Titulo: " + titulo + 
				", Autor: " + autor + 
				", Genero: " + genero + 
				", Precio: " + precio + 
				", Stock: "+ stock + "}";
	}
	
	public String toCSV() {
		return titulo + "|" + autor + "|" + genero + "|" + precio + "|" + stock;
	}
	//Titulo 1|Autor 1|Literatura|250.5|10
	public static Libro fromCSV(String line) {
	    if (line == null || line.isEmpty()) {
	        return null;
	    }

	    String[] obj = line.split("\\|");
	    if (obj.length < 5) return null;

	    return new Libro(
	        obj[0],
	        obj[1],
	        obj[2],
	        Double.parseDouble(obj[3]),
	        Integer.parseInt(obj[4])
	    );
	}

}
