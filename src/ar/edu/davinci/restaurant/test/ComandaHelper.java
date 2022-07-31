package ar.edu.davinci.restaurant.test;

import ar.edu.davinci.restaurant.dominio.Comanda;
import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.FormaPago;
import ar.edu.davinci.restaurant.servicio.ComandaServicio;

public class ComandaHelper {

	public static Double abonaConsumosTarjeta (ComandaServicio servicio, Comanda comanda) {
		return servicio.calcularTotalConDesc(comanda, FormaPago.TARJETA);
	}
	
	public static Double abonaConsumosDebito (ComandaServicio servicio, Comanda comanda) {
		return servicio.calcularTotalConDesc(comanda, FormaPago.DEBITO);
	}
	
	public static Double abonaConsumosEfectivo(ComandaServicio servicio, Comanda comanda) {
		return servicio.calcularTotalConDesc(comanda, FormaPago.EFECTIVO);
	}
	
	public static void liberacionCompletaMesa (ComandaServicio servicio,Comanda comanda) {
		
		System.out.println("\nLiberacion de comanda:\n");
		System.out.println("\nNumero de mesa: " + comanda.getMesa().getNumero());
		if(servicio.calcularTotalConDesc(comanda, comanda.getFormaPago()) == servicio.calcularTotalsinDesc(comanda))
		{
			System.out.println("Este medio de pago no tiene descuento: " + comanda.getFormaPago().name());
			System.out.println("Resultado total de la comanda sin descuento : " +servicio.calcularTotalsinDesc(comanda)); 
		}
		else
		{
			System.out.println("Resultado total de la comanda con descuento : " + servicio.calcularTotalConDesc(comanda, comanda.getFormaPago())); 
			System.out.println("Resultado total de la comanda sin descuento : " +servicio.calcularTotalsinDesc(comanda)); 
		}
		servicio.liberarServicio(comanda);
		}
		
}
