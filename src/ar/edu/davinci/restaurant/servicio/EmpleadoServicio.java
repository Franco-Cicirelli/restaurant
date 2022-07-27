package ar.edu.davinci.restaurant.servicio;

import java.util.List;

import ar.edu.davinci.restaurant.dominio.Cheff;
import ar.edu.davinci.restaurant.dominio.Cocinero;
import ar.edu.davinci.restaurant.dominio.Mozo;
import ar.edu.davinci.restaurant.dominio.Mesa;

public class EmpleadoServicio {
	
	public MozoServicio mozoServicio = new MozoServicio();
	public CocineroServicio cocineroServicio = new CocineroServicio();

	
	public EmpleadoServicio() {

	}

	public EmpleadoServicio(MozoServicio mozoServicio,CocineroServicio cocineroServicio) {
		
		this.cocineroServicio = cocineroServicio;
		this.mozoServicio = mozoServicio;
	}

	public Mozo crearMozo(String nombre, Integer legajo, String fechaIngreso, List<Mesa> mesas) {
		return new Mozo(nombre, legajo, fechaIngreso, mesas);
	}

	public Cocinero crearCocinero(String nombre, Integer legajo, String fechaIngreso, Integer aniosExperiencia) {

		return new Cocinero(nombre, legajo, fechaIngreso, aniosExperiencia);

	}

	public Cocinero crearCheff(String nombre, Integer legajo, String fechaIngreso, Integer aniosExperiencia,
			Boolean titulo) {
		if (titulo == false) {
			return new Cocinero(nombre, legajo, fechaIngreso, aniosExperiencia);
		}

		return new Cheff(nombre, legajo, fechaIngreso, aniosExperiencia,titulo);
	}
}
