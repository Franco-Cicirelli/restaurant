package ar.edu.davinci.restaurant.test;

import ar.edu.davinci.restaurant.dominio.Mesa;
import ar.edu.davinci.restaurant.servicio.MesaServicio;

public class MesaHelper {

	public static Mesa crearMesax2(MesaServicio service) {
		return service.crear(2);
	}

	public static Mesa crearMesax4(MesaServicio service) {
		return service.crear(4);
	}

}
