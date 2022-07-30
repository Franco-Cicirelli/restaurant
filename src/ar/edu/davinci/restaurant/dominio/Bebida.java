package ar.edu.davinci.restaurant.dominio;

public class Bebida extends Consumible {
	private Integer tamanioCc;
	private Boolean alcohol;
	
	
	public Bebida(String nombre, Double precio, Integer tamanioCc, Boolean alcohol) {
		super(nombre, precio);
		this.tamanioCc = tamanioCc;
		this.alcohol = alcohol;
	}


	public Integer getTamanioCc() {
		return tamanioCc;
	}


	public void setTamanioCc(Integer tamanioCc) {
		this.tamanioCc = tamanioCc;
	}


	public Boolean isAlcohol() {
		return alcohol;
	}


	public void setAlcohol(Boolean alcohol) {
		this.alcohol = alcohol;
	}


	@Override
	public String toString() {
		return "\n---Bebida---\n"
				+"- Nombre: "
				+this.getNombre()
				+"\n- TamanioCc: " 
				+  tamanioCc 
				+"\n- Alcohol: " 
				+ alcohol 
				+ "\n-------------";
	}
	
	
}
