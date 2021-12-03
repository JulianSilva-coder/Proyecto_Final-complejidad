package co.edu.unbosque.model;

/**
 * La clase Rating se encarga de los arbitros, implementa un {@link Comparable}.
 * 
 * @version 1 29/11/2021
 * @author Julian Andres Silva Beltran
 * @author Juan Andres Castillo Fuenmayor
 * @author Diana Marcela Rios Gaviria
 * @author Juan Jose Navas Wittingham
 */
public class Rating implements Comparable {

	/**
	 * Atributo privado de tipo int
	 */
	private int referee;
	/**
	 * Atributo privado de tipo boolean
	 */
	private boolean inUse;
	/**
	 * Atributo privado de tipo int
	 */
	private int rating;

	/**
	 * Método público constructor de la clase
	 * 
	 * @param a de tipo int
	 * @param b de tipo int
	 * @param c de tipo int
	 */
	public Rating(int a, int b, int c) {
		referee = a;
		if (a == b) {
			rating = -1000000000;
		} else {
			rating = c;
		}
	}

	/**
	 * Método get público de tipo int para los arbitros.
	 * 
	 * @return un arbitro
	 */
	public int getReferee() {
		return referee;
	}

	/**
	 * Método set público de tipo void para los arbitros.
	 * 
	 * @param referee de tipo int
	 */
	public void setReferee(int referee) {
		this.referee = referee;
	}

	/**
	 * Método get público de tipo boolean para el atributo inUse.
	 * 
	 * @return si esta o no en uso.
	 */
	public boolean isInUse() {
		return inUse;
	}

	/**
	 * Método set público de tipo void para el atributo inUse.
	 * 
	 * @param inUse de tipo boolean
	 */
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	/**
	 * Método get público de tipo int para la clasificación.
	 * 
	 * @return una clasificación
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Método set público de tipo void para la clasificación.
	 * 
	 * @param rating de tipo int
	 */

	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Método público de tipo int para el atributo CompareTo.
	 * 
	 * @return una comparación
	 */
	@Override
	public int compareTo(Object o) {
		int compare = ((Rating) o).getRating();
		return compare - this.rating;
	}

}
