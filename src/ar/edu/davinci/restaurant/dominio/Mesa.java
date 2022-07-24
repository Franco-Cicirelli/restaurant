package ar.edu.davinci.restaurant.dominio;

public class Mesa {

	private Integer numero;
	private Integer cantidadComensales;
	private Boolean ocupado;


	public Mesa(Integer numero, Integer cantidadComensales) {
		this.numero = numero;
		this.cantidadComensales = cantidadComensales;
		this.ocupado = false;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Integer getCantidadComensales() {
		return cantidadComensales;
	}


	public void setCantidadComensales(Integer cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}


	public Boolean getOcupado() {
		return ocupado;
	}

	public boolean isOcupado() {
		return (ocupado != null) ? ocupado : false;
	}


	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}


	@Override
	public String toString() {
		return "Mesa [numero=" + numero + ", cantidadComensales=" + cantidadComensales + ", ocupado=" + ocupado + "]";
	}




}
