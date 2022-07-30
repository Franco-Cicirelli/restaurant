package ar.edu.davinci.restaurant.test;

import java.util.ArrayList;
import java.util.List;

public class NombreHelper {

	static List <String> nombres = new ArrayList<>();
	
	public static void llenarNombres () {
		nombres.add("Franco");
		nombres.add("Emmanuel");
		nombres.add("Gabriel");
		nombres.add("Francisco");
		nombres.add("Elda");
		nombres.add("Marta");
		nombres.add("Adrian");
		nombres.add("Stefano");
		nombres.add("Eliana");
		nombres.add("Gustavo Beer");
	}
	
	public static String nombreRandom ()
	{
		NombreHelper.llenarNombres();
		int random = (int)(Math.random()*nombres.size()-1)+1;
		return nombres.get(random);
	}
}
