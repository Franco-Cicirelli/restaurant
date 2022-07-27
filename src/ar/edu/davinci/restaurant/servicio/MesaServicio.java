
package ar.edu.davinci.restaurant.servicio;

import ar.edu.davinci.restaurant.dominio.Mesa;

public class MesaServicio {

	private Integer numero;

	public MesaServicio() {
		numero = 0;
	}

	public Integer getNumero() {
		return numero;
	}

	public Mesa crear(Integer cantidadComensales) {
		numero++;
		return new Mesa(numero, cantidadComensales);
	}

	public void ocupar(Mesa mesa) {
		mesa.setOcupado(true);
	}

	public void liberar(Mesa mesa) {
		mesa.setOcupado(false);
	}

	public boolean estado(Mesa mesa) {
		return mesa.isOcupado();
	}

	public void mostrar(Mesa mesa) {
		StringBuilder str = new StringBuilder();
		str.append("Mesa");
		str.append("\n");
		str.append("número : ");
		str.append(mesa.getNumero());
		str.append("\n");
		str.append("cantidad comensales: ");
		str.append(mesa.getCantidadComensales());
		str.append("\n");
		str.append("ocupada: ");
		str.append(mesa.isOcupado());
		str.append("\n");
		System.out.println(str.toString());
	}
}
