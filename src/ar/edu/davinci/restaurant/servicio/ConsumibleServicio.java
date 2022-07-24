package ar.edu.davinci.restaurant.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.Bebida;
import ar.edu.davinci.restaurant.dominio.Plato;
import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.Mesa;

public class ConsumibleServicio {
	
	
	public List<Consumible> consumibles = new ArrayList<Consumible>() ;
	
	// crear un nuevo plato
	
	public String crearPlato(String nombre, Double precio, String descripcion, Boolean aptoVegano,
			Boolean aptoCeliaco) {

		Plato nuevoPlato = new Plato(nombre, precio, descripcion, aptoVegano, aptoCeliaco);

		for (Consumible plato : consumibles) {

			if (plato.getNombre().equals(nuevoPlato.getNombre())) {
				return "El plato ya existe";

			}
		}
		consumibles.add(nuevoPlato);
		return "El plato" + nuevoPlato.toString() + " creada exitosamente";

	}
	
	//crear una nueva bebida
	
	public String crearBebida (String nombre, Double precio, Integer tamanioCc, Boolean alcohol) {
		
		Bebida nuevaBebida = new Bebida (nombre, precio,tamanioCc,alcohol);
		
		for (Consumible bebida : consumibles) {
			
			
			
			if(bebida.getNombre().equals(nuevaBebida.getNombre())){
				return "La bebida ya existe";
				
			}
		}
		consumibles.add(nuevaBebida);
		return "La bebida" + nuevaBebida.toString()+ " creada exitosamente";
	}
	
	//borrar un consumible
	
	public String borrarConsumible (String nombre)
	{
		for (Consumible consumible : consumibles) {
			if(consumible.getNombre().equalsIgnoreCase(nombre))
			{
				consumibles.remove(consumible);
				return "Se elimino el item";
			}
		}
		
		return "El nombre del item no existe";
	}
	
	// modificar consumible
	
	public String modificarPrecio (String nombre,Double nuevoPrecio)
	{
		for (Consumible consumible : consumibles) {
			if(consumible.getNombre().equalsIgnoreCase(nombre))
			{
				consumible.setPrecio(nuevoPrecio);
				return "Se modifico el precio del item " + consumible.getNombre()
				+ "\nNuevo precio : " + consumible.getPrecio();
			}
		}
		
		return "El nombre del item no existe";
	}
	
	
	
}
