package ar.edu.davinci.restaurant.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import ar.edu.davinci.restaurant.dominio.Cocinero;
import ar.edu.davinci.restaurant.dominio.Comanda;
import ar.edu.davinci.restaurant.dominio.Consumible;
import ar.edu.davinci.restaurant.dominio.Empleado;
import ar.edu.davinci.restaurant.dominio.Menu;
import ar.edu.davinci.restaurant.dominio.Mesa;
import ar.edu.davinci.restaurant.dominio.Mozo;
import ar.edu.davinci.restaurant.dominio.Salon;
import ar.edu.davinci.restaurant.test.MesaHelper;

public class SalonServicio {

	private ConsumibleServicio consumibleServicio = new ConsumibleServicio();
	private EmpleadoServicio empleadosServicio = new EmpleadoServicio();
	private CocineroServicio cocineroServicio = new CocineroServicio();

	private MesaServicio mesaServicio = new MesaServicio();
	private MenuServicio menuServicio = new MenuServicio(consumibleServicio);
	private ComandaServicio comandaServicio = new ComandaServicio(menuServicio, mesaServicio, empleadosServicio);

	private List<Menu> menues = new ArrayList<>();
	private List<Mesa> mesas = new ArrayList<>();
	private List<Empleado> empleados = new ArrayList<>();
	private List<Comanda> comandas = new ArrayList<Comanda>();

	public SalonServicio(ComandaServicio comandaServicio) {
		this.comandaServicio = comandaServicio;
	}

	public Salon crearSalon() {

		return new Salon(menues, mesas, empleados, comandas);
	}

	public ComandaServicio getComandaServicio() {
		return comandaServicio;
	}

	public void setComandaServicio(ComandaServicio comandaServicio) {
		this.comandaServicio = comandaServicio;
	}

	public CocineroServicio getCocineroServicio() {
		return cocineroServicio;
	}

	public void setCocineroServicio(CocineroServicio cocineroServicio) {
		this.cocineroServicio = cocineroServicio;
	}

	// Agregar mesa

	public String agregarMesa(Mesa mesa) {
		int total = 0;

		for (Mesa mesas2 : mesas) {
			if (mesas2.getCantidadComensales() == 2 && mesas2.isOcupado() == true) {
				total++;
				if (total == 2) {
					return "Error noy hay mas mesas disponibles";

				}
			}
		}

		total = 0;

		if (!(mesas.contains(mesa))) {
			mesas.add(mesa);
			return "Mesa adherida correctamente";
		}

		return "La mesa ya se encuentra en el salon";

	}

	// Borrar mesa

	public void borrarMesa(Mesa mesa) {
		mesas.remove(mesa);
	}

	public void agregarMenu(Menu menu) {
		if (!(menues.contains(menu))) {
			menues.add(menu);
		} else {
			System.out.println("El menu ya se encuentra en el salon");
		}
	}

	public void agregarComanda(Comanda comanda) {
		if (!(comandas.contains(comanda))) {
			comandas.add(comanda);
		} else {
			System.out.println("La comanda ya se encuentra en el salon");

		}
	}

	public void agregarMozo(Mozo mozo) {
		if (!(empleados.contains(mozo))) {
			empleados.add(mozo);
		} else {
			System.out.println("El empleado ya se encuentra en el salon");
		}
	}

	public void agregarCocinero(Cocinero cocinero) {
		if (!(empleados.contains(cocinero))) {
			empleados.add(cocinero);
		} else {
			System.out.println("El empleado ya se encuentra en el salon");
		}
	}

	// asigno mesa

	public void asignarMesa(Mozo mozo, Mesa mesa) {

		List<Mozo> mozos = new ArrayList<>();

		for (Empleado empMozo : empleados) {
			if (empMozo.getClass().getSimpleName().equals("Mozo")) {
				mozos.add((Mozo) empMozo);
			}
		}

		try {
			boolean mozoTieneMesa = false;

			for (Mozo mozoSalon : mozos) {
				if (!(mozoSalon.equals(mozo)) && mozoSalon.getMesas().contains(mesa)) {
					mozoTieneMesa = true;
					System.out.println("El mozo" + mozoSalon.getNombre() + " ya tiene esta mesa" + mesa.getNumero());
				}
			}
			if (mozoTieneMesa == false) {
				mozo.addMesas(mesa);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		mozos.clear();
	}

	public Comanda pedidoConMasConsumibles() {
		Comanda masConsumibles = comandas.get(0);

		for (Comanda comanda : comandas) {
			if (comanda.getConsumidos().size() > 0) {
				if (comanda.getConsumidos().size() > masConsumibles.getConsumidos().size()) {
					masConsumibles = comanda;
				}
			}

		}

		return masConsumibles;
	}

	public String pedidosPorCocinero() {

		List<Cocinero> cocineros = new ArrayList<>();
		HashMap<Cocinero, Integer> mapCocineros = new HashMap<Cocinero, Integer>();

		for (Empleado empCocinero : empleados) {
			if (empCocinero.getClass().getSimpleName().equals("Cocinero")) {
				cocineros.add((Cocinero) empCocinero);
			}
		}

		for (Cocinero cocinero : cocineros) {
			mapCocineros.put(cocinero, cocinero.getNumeroPedidos());
		}

		Cocinero maxCocinero = Collections.max(mapCocineros.entrySet(),
				(cocinero, pedidosCocinero) -> cocinero.getValue() - pedidosCocinero.getValue()).getKey();

		return maxCocinero.toString();
	}

	

}
