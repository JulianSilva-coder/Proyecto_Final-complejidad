package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * La clase View sire para los scanners.
 * 
 * @version 1 29/11/2021
 * @author Julian Andres Silva Beltran
 * @author Juan Andres Castillo Fuenmayor
 * @author Diana Marcela Rios Gaviria
 * @author Juan Jose Navas Wittingham
 */
public class VistaConsola {

	/**
	 * Atributo de tipo {@link Scanner}
	 */
	private Scanner scan;

	/**
	 * Método público constructor de la clase
	 */
	public VistaConsola() {
		scan = new Scanner(System.in);
	}

	/**
	 * Método público de tipo {@link String}
	 * 
	 * @param a de tipo {@link String}
	 * @return un string
	 */
	public String scanS(String a) {
		System.out.println(a);
		String b = scan.next();
		return b;
	}

	/**
	 * Método público de tipo void para imprimir
	 * 
	 * @param a de tipo {@link String}
	 */
	public void print(String a) {
		System.out.println(a);
	}
}
