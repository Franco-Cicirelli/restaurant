package ar.edu.davinci.restaurant.dominio;

public class Cheff extends Cocinero {
	private Boolean titulo;
	
	public Cheff(String nombre, Integer legajo, String fechaIngreso, Integer aniosExperiencia, Boolean titulo) {
		super(nombre, legajo, fechaIngreso, aniosExperiencia);
		this.titulo = true;
	}


	@Override
	public String toString() {
		return "Cheff [titulo=" + titulo + "]";
	}
	
	
}
