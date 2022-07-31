package ar.edu.davinci.restaurant.test;

import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.*;
import ar.edu.davinci.restaurant.servicio.*;

public class RestaurantTest {

	public static void main(String[] args) {

		// Inicializo servicios

		ConsumibleServicio consumibleService = new ConsumibleServicio();

		MenuServicio menuServicio = new MenuServicio(consumibleService);

		EmpleadoServicio empleadoServicio = new EmpleadoServicio();

		MesaServicio mesaService = new MesaServicio();

		ComandaServicio comandaService = new ComandaServicio(menuServicio, mesaService, empleadoServicio);

		SalonServicio salonService = new SalonServicio(comandaService);

		// Creo salon

		Salon salon = salonService.crearSalon();

		// creo las mesas

		Mesa mesax2n1 = MesaHelper.crearMesax2(mesaService);
		Mesa mesax2n2 = MesaHelper.crearMesax2(mesaService);
		Mesa mesax4n3 = MesaHelper.crearMesax4(mesaService);
		Mesa mesax4n4 = MesaHelper.crearMesax4(mesaService);
		Mesa mesax6n5 = MesaHelper.crearMesax6(mesaService);
		Mesa mesax6n6 = MesaHelper.crearMesax6(mesaService);
		Mesa mesax2n7 = MesaHelper.crearMesax2(mesaService);

		// Ocupo las mesas agregadas al salon

		mesaService.ocupar(mesax2n1);
		mesaService.ocupar(mesax2n2);
		mesaService.ocupar(mesax4n3);
		mesaService.ocupar(mesax4n4);
		mesaService.ocupar(mesax6n5);
		mesaService.ocupar(mesax6n6);
		mesaService.ocupar(mesax2n7);

		// Agrego las mesas al salon

		System.out.println(salonService.agregarMesa(mesax2n1));
		salonService.agregarMesa(mesax2n2);
		salonService.agregarMesa(mesax4n3);
		salonService.agregarMesa(mesax4n4);
		salonService.agregarMesa(mesax6n5);
		salonService.agregarMesa(mesax6n6);

		// Validacion de error de mesas de 2 personas

		/* System.out.println(salonService.agregarMesa(mesax2n7)); */

		// Agrego mas mesas al salon , recordar que estan vacias

		// Creacion de los platos

		Plato hamburguesa = PlatosHelper.crearHamburguesa(consumibleService);
		Plato hamburguesaV = PlatosHelper.crearHamburguesaCeliaco(consumibleService);
		Plato hamburguesaCC = PlatosHelper.crearHamburguesaVeggie(consumibleService);
		Plato fideosSalsa = PlatosHelper.fideosSalsa(consumibleService);
		Plato fideosSalsaVegana = PlatosHelper.fideosSalsaVegana(consumibleService);
		Plato fideosSalsaCeliaco = PlatosHelper.fideosSalsaCeliaco(consumibleService);
		Plato ensaladaVegana = PlatosHelper.ensaladaVegana(consumibleService);

		// Creacion de las bebidas

		Bebida agua = BebidasHelper.agua(consumibleService);
		Bebida aguaCGas = BebidasHelper.aguaCGas(consumibleService);
		Bebida cerveza = BebidasHelper.cerveza(consumibleService);
		Bebida gaseosa = BebidasHelper.gaseosa(consumibleService);
		Bebida vinoChico = BebidasHelper.vinoChico(consumibleService);
		Bebida vinoGrande = BebidasHelper.vinoGrande(consumibleService);

		// Creo el Menu Completo con sus consumibles
		Menu menu = MenuHelper.crearMenu(menuServicio);

		// Adhiero Platos Al Menu
		menuServicio.agregarConsumibleAlMenu(menu, hamburguesa);
		menuServicio.agregarConsumibleAlMenu(menu, hamburguesaV);
		menuServicio.agregarConsumibleAlMenu(menu, hamburguesaCC);
		menuServicio.agregarConsumibleAlMenu(menu, fideosSalsa);
		menuServicio.agregarConsumibleAlMenu(menu, fideosSalsaVegana);
		menuServicio.agregarConsumibleAlMenu(menu, fideosSalsaCeliaco);
		menuServicio.agregarConsumibleAlMenu(menu, ensaladaVegana);

		// Adhiero Bebidas Al Menu
		menuServicio.agregarConsumibleAlMenu(menu, agua);
		menuServicio.agregarConsumibleAlMenu(menu, aguaCGas);
		menuServicio.agregarConsumibleAlMenu(menu, cerveza);
		menuServicio.agregarConsumibleAlMenu(menu, gaseosa);
		menuServicio.agregarConsumibleAlMenu(menu, vinoChico);
		menuServicio.agregarConsumibleAlMenu(menu, vinoGrande);

		// agrego el Menu al salon

		salonService.agregarMenu(menu);

		// creo a los empleados

		Mozo mozo1 = EmpleadosHelper.crearMozo(empleadoServicio);
		Mozo mozo2 = EmpleadosHelper.crearMozo(empleadoServicio);
		Cocinero cocinero1 = EmpleadosHelper.crearCocinero(empleadoServicio);
		Cocinero cocinero2 = EmpleadosHelper.crearCocinero(empleadoServicio);

		// Agrego los empleados al salon

		salonService.agregarMozo(mozo1);
		salonService.agregarMozo(mozo2);
		salonService.agregarCocinero(cocinero1);
		salonService.agregarCocinero(cocinero2);

		// Asignar mesas

		salonService.asignarMesa(mozo1, mesax2n1);
		salonService.asignarMesa(mozo1, mesax2n2);
		salonService.asignarMesa(mozo1, mesax4n3);
		salonService.asignarMesa(mozo2, mesax4n4);
		salonService.asignarMesa(mozo2, mesax6n5);
		salonService.asignarMesa(mozo2, mesax6n6);

		// Creo comanda escenario 1

		Comanda comanda1 = comandaService.crearComanda(mesax2n1, mozo1, cocinero1, menu);
		Comanda comanda2 = comandaService.crearComanda(mesax2n2, mozo1, cocinero1, menu);
		Comanda comanda3 = comandaService.crearComanda(mesax4n3, mozo1, cocinero1, menu);
		Comanda comanda4 = comandaService.crearComanda(mesax4n4, mozo2, cocinero2, menu);
		Comanda comanda5 = comandaService.crearComanda(mesax6n5, mozo2, cocinero2, menu);
		Comanda comanda6 = comandaService.crearComanda(mesax6n6, mozo2, cocinero1, menu);

		// Agrego consumibles

		// Escenario (1)

		comandaService.agregarConsumibleComanda(comanda1, fideosSalsa);
		comandaService.agregarConsumibleComanda(comanda1, hamburguesa);
		comandaService.agregarConsumibleComanda(comanda1, gaseosa);
		comandaService.agregarConsumibleComanda(comanda1, agua);

		// Escenario (2)

		comandaService.agregarConsumibleComanda(comanda2, fideosSalsaVegana);
		comandaService.agregarConsumibleComanda(comanda2, hamburguesaV);
		comandaService.agregarConsumibleComanda(comanda2, gaseosa);
		comandaService.agregarConsumibleComanda(comanda2, agua);

		// Escenario (3)

		comandaService.agregarConsumibleComanda(comanda3, fideosSalsaVegana);
		comandaService.agregarConsumibleComanda(comanda3, hamburguesaV);
		comandaService.agregarConsumibleComanda(comanda3, hamburguesa);
		comandaService.agregarConsumibleComanda(comanda3, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda3, gaseosa);
		comandaService.agregarConsumibleComanda(comanda3, agua);
		comandaService.agregarConsumibleComanda(comanda3, cerveza);
		comandaService.agregarConsumibleComanda(comanda3, cerveza);

		// Escenario (4)

		comandaService.agregarConsumibleComanda(comanda4, fideosSalsaVegana);
		comandaService.agregarConsumibleComanda(comanda4, hamburguesaV);
		comandaService.agregarConsumibleComanda(comanda4, ensaladaVegana);
		comandaService.agregarConsumibleComanda(comanda4, hamburguesaV);
		comandaService.agregarConsumibleComanda(comanda4, cerveza);
		comandaService.agregarConsumibleComanda(comanda4, cerveza);
		comandaService.agregarConsumibleComanda(comanda4, cerveza);
		comandaService.agregarConsumibleComanda(comanda4, cerveza);
		comandaService.agregarConsumibleComanda(comanda4, cerveza);
		comandaService.agregarConsumibleComanda(comanda4, vinoChico);
		comandaService.agregarConsumibleComanda(comanda4, vinoChico);
		comandaService.agregarConsumibleComanda(comanda4, vinoChico);
		comandaService.agregarConsumibleComanda(comanda4, vinoChico);
		comandaService.agregarConsumibleComanda(comanda4, vinoChico);

		// Escenario (5)

		comandaService.agregarConsumibleComanda(comanda5, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda5, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda5, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda5, fideosSalsaCeliaco);
		comandaService.agregarConsumibleComanda(comanda5, fideosSalsaCeliaco);
		comandaService.agregarConsumibleComanda(comanda5, fideosSalsaCeliaco);
		comandaService.agregarConsumibleComanda(comanda5, cerveza);
		comandaService.agregarConsumibleComanda(comanda5, cerveza);
		comandaService.agregarConsumibleComanda(comanda5, vinoChico);
		comandaService.agregarConsumibleComanda(comanda5, vinoChico);
		comandaService.agregarConsumibleComanda(comanda5, gaseosa);
		comandaService.agregarConsumibleComanda(comanda5, agua);

		// Escenario (6)

		comandaService.agregarConsumibleComanda(comanda6, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda6, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda6, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda6, hamburguesaCC);
		comandaService.agregarConsumibleComanda(comanda6, fideosSalsaCeliaco);
		comandaService.agregarConsumibleComanda(comanda6, fideosSalsaCeliaco);
		comandaService.agregarConsumibleComanda(comanda6, cerveza);
		comandaService.agregarConsumibleComanda(comanda6, cerveza);
		comandaService.agregarConsumibleComanda(comanda6, vinoGrande);
		comandaService.agregarConsumibleComanda(comanda6, vinoGrande);
		comandaService.agregarConsumibleComanda(comanda6, aguaCGas);
		comandaService.agregarConsumibleComanda(comanda6, agua);

		// Metodo de pago

		ComandaHelper.abonaConsumosEfectivo(comandaService, comanda1);
		ComandaHelper.abonaConsumosEfectivo(comandaService, comanda2);
		ComandaHelper.abonaConsumosTarjeta(comandaService, comanda3);
		ComandaHelper.abonaConsumosEfectivo(comandaService, comanda4);
		ComandaHelper.abonaConsumosEfectivo(comandaService, comanda5);
		ComandaHelper.abonaConsumosTarjeta(comandaService, comanda6);

		// Agrego la comanda al salon
		salonService.agregarComanda(comanda1);
		salonService.agregarComanda(comanda2);
		salonService.agregarComanda(comanda3);
		salonService.agregarComanda(comanda4);
		salonService.agregarComanda(comanda5);
		salonService.agregarComanda(comanda6);

		// Cocineros reciben y despachan los pedidos

		salonService.getCocineroServicio().recibeServicio(comanda1);
		salonService.getCocineroServicio().recibeServicio(comanda2);
		salonService.getCocineroServicio().recibeServicio(comanda3);
		salonService.getCocineroServicio().recibeServicio(comanda4);
		salonService.getCocineroServicio().recibeServicio(comanda5);
		salonService.getCocineroServicio().recibeServicio(comanda6);

		salonService.getCocineroServicio().despachaServicio(comanda1);
		salonService.getCocineroServicio().despachaServicio(comanda2);
		salonService.getCocineroServicio().despachaServicio(comanda3);
		salonService.getCocineroServicio().despachaServicio(comanda4);
		salonService.getCocineroServicio().despachaServicio(comanda5);
		salonService.getCocineroServicio().despachaServicio(comanda6);

		// 7. Agrego otra mesa de dos al salon - lanza un mensaje de error

		System.out.println(salonService.agregarMesa(mesax2n7));

		// 8. Libero una mesa de dos
		ComandaHelper.liberacionCompletaMesa(comandaService, comanda1);

		// 9. Agrgeo otra mesa de dos al salon

		System.out.println("***Agrego Mesa al salon ***");
		System.out.println(salonService.agregarMesa(mesax2n7));
		salonService.asignarMesa(mozo1, mesax2n7);

		Comanda comanda7 = comandaService.crearComanda(mesax2n7, mozo1, cocinero1, menu);

		comandaService.agregarConsumibleComanda(comanda7, hamburguesa);
		comandaService.agregarConsumibleComanda(comanda7, hamburguesa);
		comandaService.agregarConsumibleComanda(comanda7, gaseosa);
		comandaService.agregarConsumibleComanda(comanda7, agua);
		salonService.getCocineroServicio().recibeServicio(comanda7);
		salonService.getCocineroServicio().despachaServicio(comanda7);

		
		comandaService.mostrarComanda(comanda7);

		/* Libero las mesas */
		
		ComandaHelper.liberacionCompletaMesa(comandaService, comanda2);
		ComandaHelper.liberacionCompletaMesa(comandaService, comanda3);
		ComandaHelper.liberacionCompletaMesa(comandaService, comanda4);
		ComandaHelper.liberacionCompletaMesa(comandaService, comanda5);
		ComandaHelper.liberacionCompletaMesa(comandaService, comanda6);
		ComandaHelper.liberacionCompletaMesa(comandaService, comanda7);

		/* (7)-1 pedidos por cocinero */

		System.out.println("Cocinero con mas pedidos\n");
		System.out.println(salonService.pedidosPorCocinero());

		/* (7)-2 pedido con mas consumibles */

		System.out.println("Comanda con mas consumibles\n");
		System.out.println(salonService.pedidoConMasConsumibles());

	}

	private static void mostrar(MesaServicio mesaServicio, Mesa mesax2n1, Mesa mesax2n2, String mensaje) {
		System.out.println(mensaje);
		mesaServicio.mostrar(mesax2n1);
		mesaServicio.mostrar(mesax2n2);
	}

}
