package ar.edu.davinci.restaurant.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.Menu;

public class MenuServicio {
	
	public List<Consumible> consumibleMenu = new ArrayList<Consumible>();
	public ConsumibleServicio cs = new ConsumibleServicio();
	public Integer numero = 0;
	
	public MenuServicio(ConsumibleServicio cs) {
		this.cs = cs;
	}
	
	public Menu crearMenu () {
		numero ++;
		return new Menu (consumibleMenu,numero);
	}
	
	public String agregarConsumible (Menu menu , Consumible consumible ) {
		
		if( cs.consumibles.contains(consumible)) {
			menu.addConsumibles(consumible);
			return "agregado consumible";
		}
		
		
		return "hola";
	}
	
	public String mostrarMenu (Menu menu) {
		return menu.toString();
	}
	
}
