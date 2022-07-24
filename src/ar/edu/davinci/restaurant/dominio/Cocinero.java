package ar.edu.davinci.restaurant.dominio;

public class Cocinero extends Empleado {

	private Integer aniosExperiencia;
	
	public Cocinero(String nombre, Integer legajo, String fechaIngreso, Integer aniosExperiencia) {
		super(nombre, legajo, fechaIngreso);
		this.aniosExperiencia = aniosExperiencia;
	}

	public Integer getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return "Cocinero [aniosExperiencia=" + aniosExperiencia + "]";
	}

	
}
