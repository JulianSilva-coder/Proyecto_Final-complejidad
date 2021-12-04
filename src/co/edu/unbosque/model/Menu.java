package co.edu.unbosque.model;

public class Menu {
	private String comida;
	private int calorias;
	public Menu(String comida, int calorias) {
		super();
		this.calorias=calorias;
		this.comida=comida;
	}
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	@Override
	public String toString() {
		return "comida=" + comida + ", Número de calorias=" + calorias;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (calorias != other.calorias)
			return false;
		if (comida == null) {
			if (other.comida != null)
				return false;
		} else if (!comida.equals(other.comida))
			return false;
		return true;
	}
	
}
