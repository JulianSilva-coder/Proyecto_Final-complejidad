package co.edu.unbosque.model;

public class Saltos_Conejo {
	/*
	 * Inicializamos la clase de rama y poda por una matriz junto con una variable N
	 * que sea de 8 pero para la variable n es la sumatoria de N esto nos permite
	 * para el tamaño maximo de la matriz
	 */
	static final int N = 8;
	static final int n = (N + 1);
	private int[][] tablero = new int[n][n];
	private boolean exito;
	private int vertical;
	private int horizantel;
	int[][] SALTO;

	/*
	 * {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}}
	 */
	private int x0, y0;

	// constructor
	/*
	 * Aca inicializamos la clase dando la condicion que si es menor de 1 o si es
	 * mayo de 8 tanto para vertical o horizontal genera una excepcion diciendo que
	 * es fuera del rango
	 */
	public Saltos_Conejo(int x, int y, int da, int de) throws Exception {
		SALTO = new int[8][2];
		int[] des = { da, de, de, da, de, da, -da, de, -da, -de, -de, -da, de, -da, -da, -de };
		int suma = 0;
		for (int a = 0; a < SALTO.length; a++) {
			for (int b = 0; b < SALTO[a].length; b++) {
				SALTO[a][b] = des[suma];
				suma++;
			}
		}

		if ((x < 1) || (x > N) || (y < 1) || (y > N)) {
			throw new Exception("Coordenadas fuera de rango");
		}
		/*
		 * En estos dos ciclos utilizamos para marcar los recorridos del conejo, si ya
		 * paso marque como un 1, y si no debe ser un cero.
		 */

		x0 = x;
		y0 = y;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				tablero[i][j] = 0;
			}
		}
		tablero[x0][y0] = 1;
		exito = false;
	}

	public boolean resolverProblema(int a, int b) {
		saltoConejo(x0, y0, 2,a,b);
		return exito;
	}

	private void saltoConejo(int x, int y, int i, int a, int b) {
		int nx, ny;
		int k;
		k = 0; // inicializa el conjunto de posibles movimientos
		do {
			k++;
			nx = x + SALTO[k - 1][0];
			ny = y + SALTO[k - 1][1];
			// determina si nuevas coordenadas son aceptables
			if ((nx >= 1) && (nx <= N) && (ny >= 1) && (ny <= N) && (tablero[nx][ny] == 0)) {
				tablero[nx][ny] = i; // anota movimiento
				if (i < N * N) {
					saltoConejo(nx, ny, i + 1,a ,b);
					// se analiza si se ha completado la solución
					if (!exito) { // no se alcanzó la solución
						tablero[nx][ny] = 0; // se borra anotación
					}
				}
				if(tablero[a][b]!=0){
					exito = true; // tablero cubierto
				}
			}
		} while ((k < 8) && !exito);
	}
	// muestra por pantalla los pasos del caballo

	public void escribirTablero() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
}
