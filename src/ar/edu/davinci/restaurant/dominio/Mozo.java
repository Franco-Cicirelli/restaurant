package ar.edu.davinci.restaurant.dominio;

import java.util.List;

public class Mozo extends Empleado {
	private List<Mesa> mesas;
	
	public Mozo(String nombre, Integer legajo, String fechaIngreso, List<Mesa> mesas) {
		super(nombre, legajo, fechaIngreso);
		this.mesas = mesas;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	@Override
	public String toString() {
		return "Mozo [mesas=" + mesas + "]";
	}
	
	public Boolean disponibilidadMozo()
	{
		boolean disponibilidad = true;
		//capacidad maxima de trabajo 3 mesas
		if(this.mesas.size() >= 3)
		{
			return disponibilidad = false;
		}
		
		return disponibilidad;
	}
	
	
	
}
