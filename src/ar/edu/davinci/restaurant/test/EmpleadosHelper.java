package ar.edu.davinci.restaurant.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.Cocinero;
import ar.edu.davinci.restaurant.dominio.Mozo;
import ar.edu.davinci.restaurant.servicio.EmpleadoServicio;

public class EmpleadosHelper {
	
	static int legajo = 0;
	
	public static Mozo crearMozo (EmpleadoServicio servicio)
	{
		String nombre = NombreHelper.nombreRandom();
		legajo ++;
		
		return servicio.crearMozo(nombre, legajo, new Date().toString());
	}
	
	public static Cocinero crearCocinero (EmpleadoServicio servicio)
	{
		int exp = (int)((Math.random()*5)+1);
		legajo ++;
		
		return servicio.crearCocinero(NombreHelper.nombreRandom(), legajo, new Date().toString(), exp);
	}

}
