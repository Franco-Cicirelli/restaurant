package ar.edu.davinci.restaurant.servicio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.Menu;
import ar.edu.davinci.restaurant.dominio.Plato;

public class MenuServicio {

	public List<Consumible> consumibleMenu = new ArrayList<Consumible>();
	public ConsumibleServicio cs = new ConsumibleServicio();
	public Integer numero = 0;

	public MenuServicio(ConsumibleServicio cs) {
		this.cs = cs;
	}

	public Menu crearMenu() {
		numero++;
		return new Menu(consumibleMenu, numero);
	}

	public String agregarConsumible(Menu menu, Consumible consumible) {

		// verifico si el menu contiene el consumible del parametro

		if (!(menu.getConsumibles().contains(consumible))) {

			// verifico si consumibles permitidos contiene el consumible del parametro
			if (!(cs.consumibles.contains(consumible))) {

				return "No se ha adherido al menu. Este producto " + consumible.getNombre()
						+ " no se encuentra en la lista de consumibles permitidos " + menu.getTipoMenu();

			}

			menu.addConsumibles(consumible);

			return "El consumible " + consumible.getNombre() + " ha sido exitosamente unido al menu ";

		}

		return "Este consumible " + consumible.getNombre() + " ya se encuentra en el menu";
	}

	// borrar
	public String borrarConsumible(Menu menu, Consumible consumible) {

		// verifico si el menu contiene el consumible del parametro

		if (menu.getConsumibles().contains(consumible)) {

			menu.getConsumibles().remove(consumible);

			return "El consumible " + consumible.getNombre() + " ha sido exitosamente borrado del menu ";

		}

		return "Ha ocurrido un error: Este consumible " + consumible.getNombre() + " no se encuentra en el menu";
	}

	// obtener platos menu

	public void obtenerPlatos(Menu menu) {

		int contador = 0;

		System.out.println("Platos:\n");
		
		for (Consumible consumible : consumibleMenu) {
			if (consumible.getClass().getSimpleName().equals("Plato")) {
				contador++;
				System.out.println(consumible.getNombre());
			}
		}

		if (contador == 0) {

			System.out.println("No se encuentran platos en el menu" + menu.getTipoMenu());

		}
	}

	// obtener platos menu

	public void obtenerBebidas (Menu menu) {

		int contador = 0;
		
		System.out.println("Bebidas:\n");
		
		for (Consumible consumible : consumibleMenu) {
			if (consumible.getClass().getSimpleName().equals("Bebida")) {
				contador++;
				System.out.println(consumible.getNombre());
			}
		}

		if (contador == 0) {

			System.out.println("No se encuentran bebidas en el menu" + menu.getTipoMenu());

		}
	}

	public String mostrarMenu(Menu menu) {
		return menu.toString();
	}
	
	public Boolean consumiblePorNombre (Consumible c) {
		if (c == null) {
			return false;
		}
		for (Consumible consumible : consumibleMenu) {
			if(consumible.getNombre().equals(c.getNombre()))
			{
				return true;
			}
		}
		return false;
	}

}
