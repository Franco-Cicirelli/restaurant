package ar.edu.davinci.restaurant.dominio;

import java.util.List;

public class Salon {
	private List<Menu> menues;
	private List<Mesa> mesas;
	private List<Empleado> empleados;
	private List<Comanda> comandas;
	
	public Salon(List<Menu> menues, List<Mesa> mesas, List<Empleado> empleados, List<Comanda> comandas) {
		super();
		this.menues = menues;
		this.mesas = mesas;
		this.empleados = empleados;
		this.comandas = comandas;
	}

	public List<Menu> getMenues() {
		return menues;
	}

	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	@Override
	public String toString() {
		return "Salon [menues=" + menues + ", mesas=" + mesas + ", empleados=" + empleados + ", comandas=" + comandas
				+ "]";
	}
	
	
} 
