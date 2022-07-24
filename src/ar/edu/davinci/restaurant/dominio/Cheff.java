package ar.edu.davinci.restaurant.dominio;

public class Cheff extends Cocinero {
	private String titulo;
	
	public Cheff(String nombre, Integer legajo, String fechaIngreso, Integer aniosExperiencia, String titulo) {
		super(nombre, legajo, fechaIngreso, aniosExperiencia);
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Cheff [titulo=" + titulo + "]";
	}
	
	
}
