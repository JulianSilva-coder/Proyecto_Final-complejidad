package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import co.edu.unbosque.model.Menu;
import co.edu.unbosque.model.Nutricionista;
import co.edu.unbosque.model.Rating;
import co.edu.unbosque.model.Saltos_Conejo;
import co.edu.unbosque.view.VistaConsola;

/**
 * La clase Controller se encarga de la ejecuci√≥n del programa.
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
	private VistaConsola vistaConsola;
	/**
	 * Atributo privado de tipo int
	 */
	private int number;

	/**
	 * M√©todo p√∫blico constructor de la clase
	 */
	public Controller() {
		vistaConsola = new VistaConsola();
		int caso = Integer.parseInt(vistaConsola.scanS("Cual es el ejersicio que quieres ejecutar"));
		
		if(caso == 1) {
			Menu[] menu;
			try {
			int tam = Integer.parseInt(vistaConsola.scanS("Cual es la cantidad comidas"));
			while(tam<2) {
				tam = Integer.parseInt(vistaConsola.scanS("El tamaÒo del del arreglo es muy pequeÒo"));
			}
			menu = new Menu[tam];
			for (int i = 0; i < tam; i++) {
				String comida = vistaConsola.scanS("NÛmbre de la Comida");
				for (int j = 0; j < menu.length; j++) {
					if (menu[j] != null) {
						while (menu[j].getComida().equals(comida.toLowerCase())) {
							vistaConsola.print("Ya existe ese nombre de la comida");
							comida = vistaConsola.scanS("Ingrese nuevamente el nombre de la comida");
							}
						}
					}
				int cal = Integer.parseInt(vistaConsola.scanS("Cual es la cantidad de calorias de "+comida));
				menu[i]= new Menu(comida.toLowerCase(), cal);
				}
			int cal = Integer.parseInt(vistaConsola.scanS("Cual es el n˙mero de calorias minimo"));
			Nutricionista m_base = new Nutricionista(cal, menu.length);
			Nutricionista m_opt = new Nutricionista(cal, menu.length);
			vistaConsola.print("el menu Ûptimo es: "+m_base.realizarBackTracking(m_base, m_opt, false, menu));
			}
			catch(Exception e) {
				vistaConsola.print("Algo pasÛ m·l");
			}
		}	
		else if(caso == 2) {
		int teams = Integer.parseInt(vistaConsola.scanS("N√∫mero de equipos"));
		int referee = Integer.parseInt(vistaConsola.scanS("N√∫mero de arbitros"));
		number = teams;

		while (referee <= teams / 2) {
			referee = Integer.parseInt(vistaConsola.scanS("El valor no es mayor a la mitad de los equipos"));
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
						Integer.parseInt(vistaConsola.scanS("Cual es el rating del equipo " + a + " del arbitro " + b))));
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
		else if(caso == 3) {
			int x, y, da, ce, a, b;
			boolean solucion;
			try {
				vistaConsola.print("Posicion inicial del caballo.");
				x = Integer.parseInt(vistaConsola.scanS("x="));
				y = Integer.parseInt(vistaConsola.scanS("y="));
				da = Integer.parseInt(vistaConsola.scanS("Movimientos orizontales"));
				ce = Integer.parseInt(vistaConsola.scanS("Movimientos verticales"));
				Saltos_Conejo miConejo = new Saltos_Conejo(x, y, da, ce);
				a = Integer.parseInt(vistaConsola.scanS("x del destino"));
				b = Integer.parseInt(vistaConsola.scanS("y del destino"));
				solucion = miConejo.resolverProblema(a,b);
				if (solucion) {
					miConejo.escribirTablero();
				}
			} catch (Exception m) {
				System.out.println("No se pudo probar el algoritmo, " + m);
			}
		}
		else {
			vistaConsola.print("No se escogiÛ un n˙mero adecuado");
		}
	}

	/**
	 * M√©todo p√∫blico de tipo boolean, para elegir una preferencia, es mas un
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
	 * M√©todo p√∫blico de tipo void, para las preferencias.
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
