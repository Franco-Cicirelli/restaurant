package ar.edu.davinci.restaurant.test;


import java.util.ArrayList;
import java.util.List;

import ar.edu.davinci.restaurant.dominio.*;
import ar.edu.davinci.restaurant.servicio.*;

public class RestaurantTest {

	public static void main(String[] args) {
		
		// Inicializo servicios
		SalonServicio salonService = new SalonServicio();
		
		ConsumibleServicio consumibleService = new ConsumibleServicio ();
		
		MenuServicio menuServicio = new MenuServicio(consumibleService);
		
		EmpleadoServicio empleadoServicio = new EmpleadoServicio();
		
		MesaServicio mesaService = new MesaServicio();
		
		ComandaServicio comandaService = new ComandaServicio(menuServicio,mesaService,empleadoServicio);
		
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
		
		// Agrego las mesas al salon
		
		salonService.agregarMesa(mesax2n1);
		salonService.agregarMesa(mesax2n2);
		
		// Ocupo las mesas agregadas al salon
		
	  	mesaService.ocupar(mesax2n1);
	   	mesaService.ocupar(mesax2n2);
	   	
	   	// Validacion de error de mesas de 2 personas
	   	
		/*System.out.println(salonService.agregarMesa(mesax2n7));*/
		
		// Agrego mas mesas al salon , recordar que estan vacias
		
		salonService.agregarMesa(mesax4n3);
		salonService.agregarMesa(mesax4n4);
		salonService.agregarMesa(mesax6n5);
		salonService.agregarMesa(mesax6n6);
		
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
		menuServicio.agregarConsumibleAlMenu(menu,hamburguesa);
		menuServicio.agregarConsumibleAlMenu(menu,hamburguesaV);
		menuServicio.agregarConsumibleAlMenu(menu,hamburguesaCC);
		menuServicio.agregarConsumibleAlMenu(menu,fideosSalsa);
		menuServicio.agregarConsumibleAlMenu(menu,fideosSalsaVegana);
		menuServicio.agregarConsumibleAlMenu(menu,fideosSalsaCeliaco);
		menuServicio.agregarConsumibleAlMenu(menu,ensaladaVegana);
		
		
		// Adhiero Bebidas Al Menu
		menuServicio.agregarConsumibleAlMenu(menu,agua);
		menuServicio.agregarConsumibleAlMenu(menu,aguaCGas);
		menuServicio.agregarConsumibleAlMenu(menu,cerveza);
		menuServicio.agregarConsumibleAlMenu(menu,gaseosa);
		menuServicio.agregarConsumibleAlMenu(menu,vinoChico);
		menuServicio.agregarConsumibleAlMenu(menu,vinoGrande);
		
		
		// agrego el Menu al salon
		
		salonService.agregarMenu(menu);
		
	   	
	   	//creo a los empleados
		
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
	   	salonService.asignarMesa(mozo2, mesax2n2);
	 
	   	// Creo comanda escenario 1
	   	
	   	Comanda comanda1 = comandaService.crearComanda(mesax2n1, mozo1, cocinero1, menu);
	   	
	   	// Agrego consumibles
	   	
	   	comandaService.agregarConsumibleComanda(comanda1, fideosSalsa);
	   	
	   	
	   	// Agrego la comanda al salon
	   	
	   	salonService.agregarComanda(comanda1);
	   	
	   	System.out.println("Comanda mostrar \n");
	    comandaService.mostrarComanda(comanda1);
	    System.out.println("\n******************");
	   	System.out.println(salon.toString());
	   	
	   	System.out.println(mozo1.getMesas().toString());
	   	
	   	

	   	
	   	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		/*// Inicialización de servicios
		MesaServicio mesaServicio = new MesaServicio();
		
		//consumible servicio
		ConsumibleServicio consumibleServicio = new ConsumibleServicio();
		
		//menu servicio
		MenuServicio menuServicio = new MenuServicio(consumibleServicio);
		
		Menu primerMenu = menuServicio.crearMenu();
		
		//empleado servico
		EmpleadoServicio empleadoServicio = new EmpleadoServicio();
		
		//comanda servicio
		ComandaServicio comandaServicio = new ComandaServicio(menuServicio, mesaServicio, empleadoServicio);

		
		
		//Plato
		System.out.println(consumibleServicio.crearPlato("Asado", 5.5, "Asado de tira",false,false));
		//System.out.println(consumibleServicio.borrarConsumible("doble cuarto"));
		System.out.println(consumibleServicio.crearPlato("Ravioles", 5.5, "Ravioles de espinaca",false,false));
		System.out.println(consumibleServicio.modificarPrecio("Asado", 7.5));
		
		System.out.println("\n");
		//Bebida 
		System.out.println(consumibleServicio.crearBebida("pepsi cola", 50.0,500,false));
		System.out.println(consumibleServicio.crearBebida("pepsi cola", 50.0,500,false));
		System.out.println(consumibleServicio.crearBebida("cimes cola", 50.0,500,false));
		System.out.println(consumibleServicio.crearBebida("cimes cola", 50.0,500,false));
		System.out.println(consumibleServicio.crearBebida("manaos cola", 50.0,500,false));
		
		//Menu Servicio
		System.out.println("\nMenu servicio\n");
		
		//*agrego consumibles al menu
		
		menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(0));
		menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(0));
		menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(1));
		menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(2));
		menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(3));
		
		
		//*compruebo que los consumibles agregados se encuentren la lista de consumibles 
		
		Plato plato1 = new Plato ("Ravioles espinaca",70.0,"Cuadretti rellenos de ricotta, parmesano y espinca",false,false);
		Plato plato2 = new Plato ("Doble cuarto", 5.5, "hamburguesa doble con queso",false,false);
		Plato plato3 = new Plato ("Choripan",70.0,"Chori costanera turro",false,false);
		menuServicio.agregarConsumible(primerMenu, plato1 );
		menuServicio.agregarConsumible(primerMenu, plato2 );
		menuServicio.agregarConsumible(primerMenu, plato3 );
		
		//*Compruebo el metodo de borrado de menu servicio
		/*System.out.println(menuServicio.borrarConsumible(primerMenu, plato1));
		System.out.println(menuServicio.borrarConsumible(primerMenu, consumibleServicio.consumibles.get(0)));*/

		/*System.out.println("\nMenu platos - mostrar\n");
		obtengo platos y bebidas
		 menuServicio.obtenerPlatos(primerMenu);
		 menuServicio.obtenerBebidas(primerMenu);*/
		 
		
		
		// Creación de los escenarios
		/*Mesa mesax2n1 = MesaHelper.crearMesax2(mesaServicio);
		Mesa mesax2n4 = MesaHelper.crearMesax2(mesaServicio);
		Mesa mesax4n3 = MesaHelper.crearMesax4(mesaServicio);
		Mesa mesax2n2 = MesaHelper.crearMesax2(mesaServicio);
		
		 //Creacion de los consumibles Platos
		 
		 Consumible hamburguesa = PlatosHelper.crearHamburguesa(consumibleServicio);
		 Consumible hamburguesaV = PlatosHelper.crearHamburguesaVeggie(consumibleServicio);
		 Consumible hamburguesaC = PlatosHelper.crearHamburguesaCeliaco(consumibleServicio);
		 Consumible fideos = PlatosHelper.fideosSalsa(consumibleServicio);
		 Consumible fideosV = PlatosHelper.fideosSalsaVegana(consumibleServicio);
		 Consumible fideosC = PlatosHelper.fideosSalsaCeliaco(consumibleServicio);
		 Consumible ensalada = PlatosHelper.ensaladaVegana(consumibleServicio);*/
		 
		 // Creacion de los consumibles Bebidas
		 
		 /*Consumible agus = BebidasHelper.agua(consumibleServicio);
		 Consumible agusCGas = BebidasHelper.aguaCGas(consumibleServicio);
		 Consumible vinoChico = BebidasHelper.vinoChico(consumibleServicio);
		 Consumible vinoGrande = BebidasHelper.vinoGrande(consumibleServicio);
		 Consumible cerveza = BebidasHelper.cerveza(consumibleServicio);
		 Consumible gaseosas = BebidasHelper.gaseosa(consumibleServicio);


		// Ejecución de los escenarios
		System.out.println("1. Mostrar estado mesas");
		mesaServicio.mostrar(mesax2n1);
		mesaServicio.mostrar(mesax4n3);
		mesaServicio.mostrar(mesax2n4);
		
		
		System.out.println("2. Ocupar mesa 1");
		mesaServicio.ocupar(mesax2n1);

		//System.out.println("3. Mostrar estado mesas");
		//mesaServicio.mostrar(mesax2n1);
		//mesaServicio.mostrar(mesax2n2);
		mostrar(mesaServicio, mesax2n1, mesax2n2, "3. Mostrar estado mesas");


		System.out.println("4. Mesa 1 ocupada: " + mesaServicio.estado(mesax2n1));

		System.out.println("5. Liberar mesa 1");
		mesaServicio.liberar(mesax2n1);
		mesaServicio.ocupar(mesax2n1);

		System.out.println("6. Mesa 1 ocupada: " + mesaServicio.estado(mesax2n1));

		mostrar(mesaServicio, mesax2n1, mesax2n2, "7. Mostrar estado mesas");
		
		
		Mozo mozo1 = empleadoServicio.crearMozo("juan", 1, "10102020");
		Cocinero esclavo1 = empleadoServicio.crearCocinero("esclavo", 1, "1010203", 12);
		Comanda comandita = comandaServicio.crearComanda(mesax2n1, mozo1, esclavo1, primerMenu);
		System.out.println("\nComanda Menu:\n");
		System.out.println(comandita.getMenu().toString());
		

		System.out.println("\nComandita agregar consumible");
		
		System.out.println(comandaServicio.agregarConsumible(comandita, consumibleServicio.consumibles.get(0)));
		System.out.println(comandaServicio.agregarConsumible(comandita, consumibleServicio.consumibles.get(1)));
		System.out.println("\nComandita agregar consumible error");
		
		System.out.println(comandaServicio.agregarConsumible(comandita, plato3));
		System.out.println(comandaServicio.agregarConsumible(comandita, plato1));
		System.out.println(comandaServicio.agregarConsumible(comandita, consumibleServicio.consumibles.get(3)));*/
		
		//Por que los platos no se agregan :
		// Los platos como plato1 , plato2, plato3 
		// Son consumibles pero jamas se agregaron al primerMenu 
		//Por lo tanto la funcion agregarConsumible nunca los va a insertar en su lista de consumibles
		//
		//Este error lo puedo ver si chequeo el codigo de esta clase 
		// y leo el output de consola 
		
		/*System.out.println("\nComandita get consumidos\n");
		System.out.println(comandita.getConsumidos());*/
		
		
		//total
		/*
		Double totalComanda = comandaServicio.calcularTotal(comandita, FormaPago.EFECTIVO);
		System.out.println("El total de la comanda es de " + totalComanda);
		
		CocineroServicio CocineroServicio = new CocineroServicio();
		
		CocineroServicio.recibeServicio(comandita);
		CocineroServicio.recibeServicio(comandita);
		CocineroServicio.despachaServicio(comandita);*/
				
		// Creacion de Salon Servicio 
		
		/*SalonServicio salonServicio = new SalonServicio();
		
		Salon salon = salonServicio.crearSalon();
		System.out.println("Salon servicio\n");
		salonServicio.agregarMenu(primerMenu);
		salonServicio.agregarMesa(mesax2n1);
		System.out.println(salon.toString()); 
		salonServicio.agregarEmpleado(mozo1);
		
		System.out.println("\n Mozo \n");
		System.out.println(mozo1.toString()); 
		
		salonServicio.agregarComanda(comandita);
		System.out.println("\nAsigno mesa\n");
		salonServicio.asignarMesa(mozo1, mesax2n1);
		System.out.println(salon.toString()); */
		
	}

	private static void mostrar(MesaServicio mesaServicio, Mesa mesax2n1, Mesa mesax2n2, String mensaje) {
		System.out.println(mensaje);
		mesaServicio.mostrar(mesax2n1);
		mesaServicio.mostrar(mesax2n2);
	}
	

}



