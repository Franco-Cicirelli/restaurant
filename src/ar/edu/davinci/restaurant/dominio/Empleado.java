package ar.edu.davinci.restaurant.dominio;

public abstract class Empleado {
	private String nombre;
	private Integer legajo;
	private String fechaIngreso;
	private Boolean trabajando;
	
	public Empleado(String nombre, Integer legajo, String fechaIngreso) {
		this.nombre = nombre;
		this.legajo = legajo;
		this.fechaIngreso = fechaIngreso;
		this.trabajando = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", legajo=" + legajo + ", fechaIngreso=" + fechaIngreso + "]";
	}
	
	public static String comenzarTrabajo (boolean trabajar) {

		if(trabajar)
		{
			return "He comenzado a trabajar";
		}
		
		return "He terminado mi horario laboral";
	}

	public Boolean isTrabajando() {
		return trabajando;
	}

	public void setTrabajando(Boolean trabajando) {
		this.trabajando = trabajando;
	}
	
	
}
