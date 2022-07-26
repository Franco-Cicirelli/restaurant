package ar.edu.davinci.restaurant.servicio;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.Cocinero;
import ar.edu.davinci.restaurant.dominio.Comanda;
import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.FormaPago;
import ar.edu.davinci.restaurant.dominio.Menu;
import ar.edu.davinci.restaurant.dominio.Mesa;
import ar.edu.davinci.restaurant.dominio.Mozo;

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
	
	public String crearComanda (Mesa mesa, Mozo mozo, Cocinero cocinero, Menu menu) {
		
		
		//Verifico que la mesa este ocupada
		if(mesa.isOcupado() != true)
		{
			return "La mesa " + mesa.getNumero() + " todavia no esta en servicio";
		}
		
		//Verifico que el mozo
		if(mozo.disponibilidadMozo() == false )
		{
			return "El mozo " + mozo.getNombre() + " se encuentra con trabajando";
		}
		
		//verifico que el menu no este vacio
		if(menu == null )
		{
			return "El menu " + menu.getTipoMenu() + " se encuentra vacio";
		}
		
		//Inicializo una lista de consimible vacia
		List<Consumible> consumidos = new ArrayList<Consumible>();
		
		Comanda comanda = new Comanda(menu,consumidos,mesa,mozo,cocinero,FormaPago.EFECTIVO);
		
		return "Comanda creada exitosamente \n" + comanda.toString();
	}
}
