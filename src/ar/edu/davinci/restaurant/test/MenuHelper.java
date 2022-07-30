package ar.edu.davinci.restaurant.test;

import ar.edu.davinci.restaurant.dominio.Menu;
import ar.edu.davinci.restaurant.servicio.ConsumibleServicio;
import ar.edu.davinci.restaurant.servicio.MenuServicio;

public class MenuHelper {

	//creacion del menu vacio
	
	public static Menu crearMenu (MenuServicio servicio)
	{
		return servicio.crearMenu();
	}
	
	
}
