package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import co.edu.unbosque.model.Rating;
import co.edu.unbosque.view.MainView;
import co.edu.unbosque.view.View;

/**
 * La clase Controller se encarga de la ejecución del programa.
 * 
 * @version 1 29/11/2021
 * @author Julian Andres Silva Beltran
 * @author Juan Andres Castillo Fuenmayor
 * @author Diana Marcela Rios Gaviria
 * @author Juan Jose Navas Wittingham
 */
public class Controller {

	/**
	 * Instancia a la clase {@link MainView}
	 */
	private MainView window;
	/**
	 * Instancia a la clase {@link View}
	 */
	private View view;
	/**
	 * Atributo privado de tipo int
	 */
	private int number;

	/**
	 * Método público constructor de la clase
	 */
	public Controller() {
		window = new MainView();
		view = new View();
		int teams = Integer.parseInt(view.scanS("Número de equipos"));
		int referee = Integer.parseInt(view.scanS("Número de arbitros"));
		number = teams;

		while (referee <= teams / 2) {
			referee = Integer.parseInt(view.scanS("El valor no es mayor a la mitad de los equipos"));
		}
		int prefer[][] = new int[teams * 2][teams];
		for (int a = 0; a < teams * 2; a++) {
			for (int b = 0; b < teams; b++) {
				if (a >= teams) {
					prefer[a][b] = b;
				} else {
					if (b < referee) {
						prefer[a][b] = teams - referee;
					} else {
						prefer[a][b] = 1;
					}
				}
			}
		}

		for (int a = 0; a < teams; a++) {
			ArrayList<Rating> rating = new ArrayList<Rating>();
			int[] selection = new int[referee];
			for (int b = 0; b < referee; b++) {
				rating.add(new Rating(b, a,
						Integer.parseInt(view.scanS("Cual es el rating del equipo " + a + " del arbitro " + b))));
			}
			Collections.sort(rating);
			for (int c = 0; c < referee; c++) {
				prefer[a][c] = prefer[a][c] + rating.get(c).getReferee();
			}
		}
		for (int a = 0; a < teams * 2; a++) {
			int c = -1;
			for (int b = referee; b < teams && a < teams; b++) {
				prefer[a][b] = prefer[a][b] + c;
				c++;
			}
		}
		for (int a = 0; a < teams * 2; a++) {
			for (int b = 0; b < teams; b++) {
				if (a < teams) {
					prefer[a][b] = prefer[a][b] + number;
				}
			}
		}
		for (int a = 0; a < teams * 2; a++) {
			for (int b = 0; b < teams; b++) {
				System.out.print(prefer[a][b] + ", ");
			}
			System.out.println("");
		}
		preferences(prefer, teams - referee);
	}

	/**
	 * Método público de tipo boolean, para elegir una preferencia, es mas un
	 * validador.
	 * 
	 * @param prefer de tipo int[][]
	 * @param w      de tipo int
	 * @param m      de tipo int
	 * @param m1     de tipo int
	 * @return un valor boleano
	 */
	public boolean preference(int prefer[][], int w, int m, int m1) {
		for (int i = 0; i < number; i++) {
			if (prefer[w][i] == m1)
				return true;
			if (prefer[w][i] == m)
				return false;
		}
		return false;
	}

	/**
	 * Método público de tipo void, para las preferencias.
	 * 
	 * @param prefer de tipo int[][]
	 * @param size   de tipo int
	 */
	public void preferences(int prefer[][], int size) {
		int wPartner[] = new int[number];
		boolean mFree[] = new boolean[number];
		Arrays.fill(wPartner, -1);
		int freeCount = number;

		while (freeCount > 0) {
			int m;
			for (m = 0; m < number; m++)
				if (mFree[m] == false)
					break;
			for (int i = 0; i < number && mFree[m] == false; i++) {
				int w = prefer[m][i];
				if (wPartner[w - number] == -1) {
					wPartner[w - number] = m;
					mFree[m] = true;
					freeCount--;
				} else {
					int m1 = wPartner[w - number];
					if (preference(prefer, w, m, m1) == false) {
						wPartner[w - number] = m;
						mFree[m] = true;
						mFree[m1] = false;
					}
				}
			}
		}
		System.out.println("Equipo Arbitro");
		for (int i = size; i < number; i++) {
			System.out.print(" ");
			System.out.println(i - size + "     " + wPartner[i]);
		}
	}
}
