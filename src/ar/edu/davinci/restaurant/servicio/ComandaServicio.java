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

	private MenuServicio menuServicio = new MenuServicio( new ConsumibleServicio ());
	private MesaServicio mesaServicio = new MesaServicio();
	private EmpleadoServicio empleadoServicio = new EmpleadoServicio (new MozoServicio(),new CocineroServicio());
	



	public ComandaServicio (MenuServicio menuServicio,MesaServicio mesaServicio,EmpleadoServicio empleadoServicio)
	{
		this.menuServicio = menuServicio;
		this.mesaServicio = mesaServicio;
		this.empleadoServicio = empleadoServicio;
	}
	
	
	public MesaServicio getMesaServicio() {
		return mesaServicio;
	}


	public void setMesaServicio(MesaServicio mesaServicio) {
		this.mesaServicio = mesaServicio;
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
	
	static Boolean validacionMesa(Mozo mozo, Mesa mesa) {
		
		if(mozo.getMesas().isEmpty()) {
			System.out.println("El mozo no tiene mesas asignadas");
		}
		if (!(mozo.getMesas().contains(mesa))) {
			System.out.println("El mozo " + mozo.getNombre() + " no tiene asignada esta mesa " + mesa.getNumero());
			return false;
		}
		System.out.println("Validacion correcta");
		return true;

	}

	//Validacion de comanda
	static Boolean validarComanda (Comanda comanda) {
		
		// Verifico que la mesa este ocupada
		// Verifico que el mozo
		
		if(!(validacionMesa(comanda.getMozo(),comanda.getMesa()))){
			return false;
		}
		
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
			System.out.println("****Error****\nEl mozo " + comanda.getMozo().getNombre() 
					+ " tiene mas mesas de las que puede atender . Mesas atendiendo: " 
					+ comanda.getMozo().getMesas().size()
					+ "\nAsignar la mesa " + comanda.getMesa().getNumero() + " a otro mozo "
					);
			return false;
		}

		// verifico que el menu no este vacio
		if (comanda.getMenu() == null) {
			System.out.println("El menu " + comanda.getMenu().getTipoMenu() + " se encuentra vacio");
			return false;
		}
		
		comanda.getMozo().setTrabajando(true);
		return true;
	}
	
	
	// Agregar consumible en comanda
	
	public String agregarConsumibleComanda(Comanda comanda, Consumible c) {
		
		if(menuServicio.cs.consumibles.contains(c))
		{
			comanda.getConsumidos().add(c);
			return "Se agrego exitosamente el consumible " + c.getNombre() + " a la comanda " + comanda.toString(); 
		}
		
		return "no existe ese plato en el menu " + comanda.getMenu().getTipoMenu();
	}
	
	// Aplicar descuento
	
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
	
	public Double calcularTotalConDesc (Comanda comanda, FormaPago f) {
		
		double total = 0;
		comanda.setFormaPago(f);
		
		for (Consumible consumible : comanda.getConsumidos()) {
			total += aplicarDescuento(consumible, f);
		}
		
		return total;
	}
	
	// Calcular total sin descuento
	
	public Double calcularTotalsinDesc (Comanda comanda) {
		
		double total = 0;
		
		for (Consumible consumible : comanda.getConsumidos()) {
			total += consumible.getPrecio();
		}
		
		return total;
	}
	
	// Liberar mesa
	
	public void liberarServicio (Comanda comanda) {
		
		double total = calcularTotalsinDesc(comanda);
		
		if(total > 0)
		{
			mesaServicio.liberar(comanda.getMesa());
			
			// tomo el mozo y remuevo de su lista de mesas la mesa liberada
			
			comanda.getMozo().getMesas().remove(comanda.getMesa());
			
			System.out.println("La mesa se encuentra disponible para su uso") ;
		}
		else
		{
			System.out.println("No es valido el pedido de liberacion");
		}
		
	}
	
	public void mostrarComanda(Comanda comanda) {
		StringBuilder str = new StringBuilder();
		str.append("********Comanda*********\n");
		str.append("\n");
		str.append("Menu : ");
		str.append(comanda.getMenu().getTipoMenu());
		str.append("\n");
		str.append("Consumidos: ");
		str.append(comanda.getConsumidos());
		str.append("\n");
		str.append("Mozo: ");
		str.append(comanda.getMozo().getNombre());
		str.append("\n");
		str.append("Cocinero: ");
		str.append(comanda.getCocinero().getNombre());
		str.append("\n");
		str.append("Forma De Pago: ");
		str.append(comanda.getFormaPago());
		str.append("\n");
		str.append("\n*************************");
		System.out.println(str.toString());
	}
	
	
}
