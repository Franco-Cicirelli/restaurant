package ar.edu.davinci.restaurant.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.Bebida;
import ar.edu.davinci.restaurant.dominio.Cocinero;
import ar.edu.davinci.restaurant.dominio.Comanda;
import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.FormaPago;
import ar.edu.davinci.restaurant.dominio.Menu;
import ar.edu.davinci.restaurant.dominio.Mesa;
import ar.edu.davinci.restaurant.dominio.Mozo;
import ar.edu.davinci.restaurant.dominio.Plato;

public class ComandaServicio {

	public MenuServicio menuServicio = new MenuServicio( new ConsumibleServicio ());
	public MesaServicio mesaServicio = new MesaServicio();
	public EmpleadoServicio empleadoServicio = new EmpleadoServicio (new MozoServicio(),new CocineroServicio());
	
	
	public ComandaServicio (MenuServicio menuServicio,MesaServicio mesaServicio,EmpleadoServicio empleadoServicio)
	{
		this.menuServicio = menuServicio;
		this.mesaServicio = mesaServicio;
		this.empleadoServicio = empleadoServicio;
	}
	
	public Comanda crearComanda (Mesa mesa, Mozo mozo, Cocinero cocinero, Menu menu) {
		
		// Inicializo una lista de consimible vacia
		List<Consumible> consumidos = new ArrayList<Consumible>();
		
		Comanda comanda = new Comanda(menu,consumidos,mesa,mozo,cocinero,FormaPago.EFECTIVO);
		
		if(validarComanda(comanda))
		{
			return comanda;
		}
		return null;
	}
	
	
	//Validacion de comanda
	public static Boolean validarComanda (Comanda comanda) {
		
		// Verifico que la mesa este ocupada
		if (comanda.getMesa().isOcupado() != true) {
			System.out.println("La mesa " + comanda.getMesa().getNumero() + " todavia no esta en servicio");
			return false;
		}

		// Verifico la cantidad de pedidos del cocinero
		if (comanda.getCocinero().getNumeroPedidos() > 5) {
			System.out.println("El cocinero seleccionado tiene demasiados pedidos");
			return false;
		}

		// Verifico que el mozo
		if (comanda.getMozo().disponibilidadMozo() == false) {
			System.out.println("El mozo " + comanda.getMozo().getNombre() + " se encuentra con trabajando");
			return false;
		}

		// verifico que el menu no este vacio
		if (comanda.getMenu() == null) {
			System.out.println("El menu " + comanda.getMenu().getTipoMenu() + " se encuentra vacio");
			return false;
		}

		return true;
	}
	
	// Agregar consumible en comanda
	
	public String agregarConsumible(Comanda comanda, Consumible c) {
		
		if(menuServicio.cs.consumibles.contains(c))
		{
			comanda.getConsumidos().add(c);
			return "Se agrego exitosamente el consumible " + c.getNombre() + " a la comanda " + comanda.toString(); 
		}
		
		return "no existe ese plato en el menu " + comanda.getMenu().getTipoMenu();
	}
	

		
	
	/*
	 * En el caso que una mesa realice el pago en efectivo se le hará un descuento que se 
	calculará de la siguiente forma: A los platos pedidos se les descontará un 5% salvo a los 
	platos veganos que no llevan descuento y en el caso de los platos aptos para celíacos 
	tendrán un 7% de descuento . En el caso de las bebidas consumidas, el 
	descuento es de 10% para las que no contiene alcohol y de 3% en para las que si 
	contienen. */
	
	public double aplicarDescuento(Consumible consumible, FormaPago f) {

		if (f == f.EFECTIVO) {

			if (consumible instanceof Bebida) {

				if (((Bebida) consumible).isAlcohol()) {

					// con alcohol aplico 10% de descuento

					return consumible.getPrecio() - (consumible.getPrecio() * 10) / 100;

				}
				// sin alcohol aplico 3% de descuento

				return consumible.getPrecio() - (consumible.getPrecio() * 3) / 100;
			}

			if (((Plato) consumible).isAptoCeliaco()) {

				// plato celiaco 7% de descuento

				return consumible.getPrecio() - (consumible.getPrecio() * 7) / 100;

			}
			if (((Plato) consumible).isAptoVegano()) {

				// plato Vegano 0% de descuento

				return consumible.getPrecio();

			}

			// Plato normal 5%;

			return consumible.getPrecio() - (consumible.getPrecio() * 5) / 100;

		}

		// Si FormaPago es distinta de efectivo devuelvo 0;
		return consumible.getPrecio();

	}
	
	// Calcular total
	
	public Double calcularTotal (Comanda comanda , FormaPago f) {
		
		double total = 0;
		
		for (Consumible consumible : comanda.getConsumidos()) {
			total += aplicarDescuento(consumible, f);
		}
		
		return total;
	}
	
	// liberar mesa
	
	
}
