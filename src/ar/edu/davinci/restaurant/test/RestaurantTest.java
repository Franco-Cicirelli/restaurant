package ar.edu.davinci.restaurant.test;


import ar.edu.davinci.restaurant.dominio.*;
import ar.edu.davinci.restaurant.servicio.*;

public class RestaurantTest {

	public static void main(String[] args) {

		// Inicialización de servicios
		MesaServicio mesaServicio = new MesaServicio();
		
		//consumible servicio
		ConsumibleServicio consumibleServicio = new ConsumibleServicio();
		
		//menu servicio
		MenuServicio menuServicio = new MenuServicio(consumibleServicio);
		
		Menu primerMenu = menuServicio.crearMenu();
		
		
		
		
		
		//Plato
		System.out.println(consumibleServicio.crearPlato("Doble cuarto", 5.5, "hamburguesa doble con queso",false,false));
		//System.out.println(consumibleServicio.borrarConsumible("doble cuarto"));
		System.out.println(consumibleServicio.crearPlato("Ravioles", 5.5, "hamburguesa doble con queso",false,false));
		System.out.println(consumibleServicio.modificarPrecio("Doble cuarto", 7.5));
		
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
		
		System.out.println(menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(0)));
		System.out.println(menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(0)));
		System.out.println(menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(1)));
		System.out.println(menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(2)));
		System.out.println(menuServicio.agregarConsumible(primerMenu,consumibleServicio.consumibles.get(3)));
		
		
		//*compruebo que los consumibles agregados se encuentren la lista de consumibles 
		
		
		Plato plato2 = new Plato ("Doble cuarto", 5.5, "hamburguesa doble con queso",false,false);
		Plato plato1 = new Plato ("Ravioles espinaca",70.0,"Cuadretti rellenos de ricotta, parmesano y espinca",false,false);
		System.out.println(menuServicio.agregarConsumible(primerMenu, plato1 ));
		System.out.println(menuServicio.agregarConsumible(primerMenu, plato2 ));
		
		//*Compruebo el metodo de borrado de menu servicio
		/*System.out.println(menuServicio.borrarConsumible(primerMenu, plato1));
		System.out.println(menuServicio.borrarConsumible(primerMenu, consumibleServicio.consumibles.get(0)));*/

		System.out.println("\nMenu platos - mostrar\n");
		//*obtengo platos y bebidas
		 menuServicio.obtenerPlatos(primerMenu);
		 menuServicio.obtenerBebidas(primerMenu);
		
		// Creación de los escenarios
		Mesa mesax2n1 = MesaHelper.crearMesax2(mesaServicio);
		Mesa mesax4n3 = MesaHelper.crearMesax4(mesaServicio);
		Mesa mesax2n2 = MesaHelper.crearMesax2(mesaServicio);


		// Ejecución de los escenarios
		System.out.println("1. Mostrar estado mesas");
		mesaServicio.mostrar(mesax2n1);
		mesaServicio.mostrar(mesax2n2);
		mesaServicio.mostrar(mesax4n3);
		
		
		System.out.println("2. Ocupar mesa 1");
		mesaServicio.ocupar(mesax2n1);

		//System.out.println("3. Mostrar estado mesas");
		//mesaServicio.mostrar(mesax2n1);
		//mesaServicio.mostrar(mesax2n2);
		mostrar(mesaServicio, mesax2n1, mesax2n2, "3. Mostrar estado mesas");


		System.out.println("4. Mesa 1 ocupada: " + mesaServicio.estado(mesax2n1));

		System.out.println("5. Liberar mesa 1");
		mesaServicio.liberar(mesax2n1);

		System.out.println("6. Mesa 1 ocupada: " + mesaServicio.estado(mesax2n1));

		mostrar(mesaServicio, mesax2n1, mesax2n2, "7. Mostrar estado mesas");
	}

	private static void mostrar(MesaServicio mesaServicio, Mesa mesax2n1, Mesa mesax2n2, String mensaje) {
		System.out.println(mensaje);
		mesaServicio.mostrar(mesax2n1);
		mesaServicio.mostrar(mesax2n2);
	}

}
