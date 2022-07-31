package ar.edu.davinci.restaurant.dominio;

import java.util.ArrayList;
import java.util.List;

public class Mozo extends Empleado {
	private List<Mesa> mesas ;
	
	public Mozo(String nombre, Integer legajo, String fechaIngreso) {
		super(nombre, legajo, fechaIngreso);
		this.mesas = new ArrayList<>();
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public void addMesas (Mesa mesa){
		this.mesas.add(mesa);
	}

	@Override
	public String toString() {
		return "\nMozo [mesas = " 
				+ mesas 
				+ " - Nombre = "
				+ this.getNombre();
	}
	
	public Boolean disponibilidadMozo()
	{
		
		boolean disponibilidad = true;
		//capacidad maxima de trabajo 4 mesas
		if(this.mesas.size() > 4)
		{
			return disponibilidad = false;
		}
		
		return disponibilidad;
	}
	
	
	
}
