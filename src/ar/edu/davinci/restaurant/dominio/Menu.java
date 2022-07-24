package ar.edu.davinci.restaurant.dominio;

import java.util.List;

public class Menu {
	private List<Consumible> consumibles;
	private Integer tipoMenu;
	
	public Menu(List<Consumible> consumibles, Integer tipoMenu) {
		super();
		this.consumibles = consumibles;
		this.tipoMenu = tipoMenu;
	}

	public List<Consumible> getConsumibles() {
		return consumibles;
	}

	public void setConsumibles(List<Consumible> consumibles) {
		this.consumibles = consumibles;
	}
	
	public void addConsumibles(Consumible consumible) {
		this.consumibles.add(consumible);
	}

	public Integer getTipoMenu() {
		return tipoMenu;
	}

	public void setTipoMenu(Integer tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	@Override
	public String toString() {
		return "Menu [consumibles=" + consumibles + ", tipoMenu=" + tipoMenu + "]";
	}
	
	
	
}
