package ar.edu.davinci.restaurant.dominio;

public abstract class Consumible {
	private String nombre;
	private Double precio;
	
	public Consumible(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Consumible [nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
}
