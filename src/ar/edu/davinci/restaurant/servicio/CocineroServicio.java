package ar.edu.davinci.restaurant.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.Bebida;
import ar.edu.davinci.restaurant.dominio.Cheff;
import ar.edu.davinci.restaurant.dominio.Cocinero;
import ar.edu.davinci.restaurant.dominio.Comanda;
import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.Plato;

public class CocineroServicio {

	private List<Comanda> pedidos = new ArrayList<>();

	public CocineroServicio() {

	}

	public List<Comanda> getComandas() {
		return pedidos;
	}

	public Boolean recibeServicio(Comanda comanda) {

		if (pedidos.contains(comanda)) {
			System.out.println("Este pedido ya fue anotado");
			return false;
		}

		comanda.getCocinero().addNumeroDePedidos();
		pedidos.add(comanda);
		System.out.println("La comanda fue recibida exitomsamente " + comanda.getCocinero().getNombre()
				+ " comenzara a preparar el pedido");
		return true;
	}

	public Boolean despachaServicio(Comanda comanda) {

		if (!(pedidos.contains(comanda))) {
			System.out.println("Este pedido nunca fue anotado");
			return false;
		}

		comanda.getCocinero().decreaseNumeroDePedidos();
		pedidos.remove(comanda);
		System.out.println("La comanda fue despachada exitomsamente en la mesa" 
				+ comanda.getMesa().getNumero()
				+ comanda.getCocinero().getNombre());
		return true;
	}

	/*
	 * public Cocinero crearCocinero (String nombre, Integer legajo, String
	 * fechaIngreso, Integer aniosExperiencia) {
	 * 
	 * return new Cocinero (nombre,legajo,fechaIngreso,aniosExperiencia);
	 * 
	 * }
	 * 
	 * public Cocinero crearCheff (String nombre, Integer legajo, String
	 * fechaIngreso, Integer aniosExperiencia , Boolean titulo) { if(titulo ==
	 * false) { return new Cocinero(nombre,legajo,fechaIngreso,aniosExperiencia); }
	 * 
	 * return new Cheff(nombre,legajo,fechaIngreso,aniosExperiencia, titulo); }
	 */
}
