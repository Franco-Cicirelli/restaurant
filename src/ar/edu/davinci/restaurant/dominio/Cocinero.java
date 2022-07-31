package ar.edu.davinci.restaurant.dominio;

public class Cocinero extends Empleado {

	private Integer aniosExperiencia;
	private Integer numeroPedidos ;
	private Integer totalPedidos;
	
	public Cocinero(String nombre, Integer legajo, String fechaIngreso, Integer aniosExperiencia) {
		super(nombre, legajo, fechaIngreso);
		this.aniosExperiencia = aniosExperiencia;
		this.numeroPedidos = 0;
		this.totalPedidos = 0;
	}

	public Integer getNumeroPedidos() {
		return numeroPedidos;
	}

	
	public Integer getAniosExperiencia() {
		return aniosExperiencia;
	}
	
	public Integer getTotalPedidos() {
		return totalPedidos;
	}
	
	public void addNumeroDePedidos() {
		this.numeroPedidos++;
	}
	
	public void decreaseNumeroDePedidos() {
		this.numeroPedidos--;
	}
	
	public void addTotalPedidos() {
		this.totalPedidos ++;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	@Override
	public String toString() {
		return "\n***Cocinero***"
				+ "\n- Años de experiencia : " 
				+ aniosExperiencia 
				+ "\n- Nombre: "
				+ this.getNombre()
				+ "\n- Cantidad de pedidos: "
				+ totalPedidos;
	}

	
}
