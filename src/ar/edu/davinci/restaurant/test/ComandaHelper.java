package ar.edu.davinci.restaurant.test;

import ar.edu.davinci.restaurant.dominio.Comanda;
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
}
