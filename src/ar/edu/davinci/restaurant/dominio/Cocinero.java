package ar.edu.davinci.restaurant.dominio;

public class Cocinero extends Empleado {

	private Integer aniosExperiencia;
	private Integer numeroPedidos ;
	
	public Cocinero(String nombre, Integer legajo, String fechaIngreso, Integer aniosExperiencia) {
		super(nombre, legajo, fechaIngreso);
		this.aniosExperiencia = aniosExperiencia;
		this.numeroPedidos = 0;
	}

	public Integer getNumeroPedidos() {
		return numeroPedidos;
	}

	
	public Integer getAniosExperiencia() {
		return aniosExperiencia;
	}
	
	public void addNumeroDePedidos() {
		this.numeroPedidos++;
	}
	
	public void decreaseNumeroDePedidos() {
		this.numeroPedidos--;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return "Cocinero [aniosExperiencia=" + aniosExperiencia + "]";
	}

	
}
