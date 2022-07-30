package ar.edu.davinci.restaurant.test;

import ar.edu.davinci.restaurant.dominio.Bebida;
import ar.edu.davinci.restaurant.servicio.ConsumibleServicio;

public class BebidasHelper {

	// Agua
	public static Bebida agua(ConsumibleServicio service) {
		return service.crearBebida("Agua sin gas", 1.5, 500, false);
	}

	// Agua
	public static Bebida aguaCGas(ConsumibleServicio service) {
		return service.crearBebida("Agua con gas", 1.5, 500, false);
	}

	// vinoChico
	public static Bebida vinoChico(ConsumibleServicio service) {
		return service.crearBebida("vino de la casa", 20.0, 500, true);
	}

	// vinoChico
	public static Bebida vinoGrande(ConsumibleServicio service) {
		return service.crearBebida("vino de la casa grande", 30.0, 1000, true);
	}

	// Cerveza
	public static Bebida cerveza(ConsumibleServicio service) {
		return service.crearBebida("Cerveza", 5.0, 473, true);
	}

	// Gaseosa
	public static Bebida gaseosa(ConsumibleServicio service) {
		return service.crearBebida("Gaseosa", 3.0, 500, true);
	}
}
