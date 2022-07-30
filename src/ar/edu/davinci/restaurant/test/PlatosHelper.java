package ar.edu.davinci.restaurant.test;

import ar.edu.davinci.restaurant.dominio.Mesa;
import ar.edu.davinci.restaurant.dominio.Plato;
import ar.edu.davinci.restaurant.servicio.ConsumibleServicio;
import ar.edu.davinci.restaurant.servicio.MesaServicio;

public class PlatosHelper {
	/**
	 * 2. Platos
		1. Hamburgesa, vegana: no, celíaco: no
		2. Hamburgesa Vegie, vegana: si, celíaco: no
		3. Hamburgesa Celiaco, vegana: no, celíaco: si
		4. Fideos con salsa, vegana: no, celíaco: no
		5. Fideos con salsa Vegie, vegana: si, celíaco: no
		6. Fideos con salsa Celiaco, vegana: no, celíaco: si
		7. Ensalada, vegana: si, celíaco: si
		*/
	
	// Hamburguesa
	public static Plato crearHamburguesa(ConsumibleServicio service) {
		return service.crearPlato("Hamburguesa", 10.0, "Hamburguesa de carne con queso ", false, false);
	}

	// Hamburguesa Veggie
	public static Plato crearHamburguesaVeggie(ConsumibleServicio service) {
		return service.crearPlato("Hamburgesa Vegie", 12.0, "Hamburguesa de verdura", true, false);
	}
	
	// Hamburguesa Celiaco
	
	public static Plato crearHamburguesaCeliaco(ConsumibleServicio service) {
		return service.crearPlato("Hamburgesa Celiaco", 15.0, "Hamburguesa apta celiaco", false, true);
	}
	
	// Fideos con salsa
	
	public static Plato fideosSalsa(ConsumibleServicio service) {
		return service.crearPlato("Fideos con salsa", 8.0, "Fideos con salsa fileto", false, false);
	}
	
	// Fideos con salsa vegana
	
	public static Plato fideosSalsaVegana(ConsumibleServicio service) {
		return service.crearPlato("Fideos con salsa vegana", 9.0, "Fideos con salsa vegana", true, false);
	}
	
	// Fideos con salsa vegana
	
	public static Plato fideosSalsaCeliaco(ConsumibleServicio service) {
		return service.crearPlato("Fideos con salsa celiaco", 11.0, "Fideos celiaco con salsa vegana", false, true);
	}

	// Ensalada vegana
	
	public static Plato ensaladaVegana(ConsumibleServicio service) {
		return service.crearPlato("Enasalda Vegana", 11.0, "Ensalda: pepino, lechuga, tomate y lechuga", true, true);
	}
	
	
	
	
}
