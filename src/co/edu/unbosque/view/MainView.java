package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * La clase MainView se encarga de manejar las vistas del programa, se extiende
 * de {@link JFrame}.
 * 
 * @version 1 29/11/2021
 * @author Julian Andres Silva Beltran
 * @author Juan Andres Castillo Fuenmayor
 * @author Diana Marcela Rios Gaviria
 * @author Juan Jose Navas Wittingham
 */
public class MainView extends JFrame {
	private static final long serialVersionUID = 5760994557770026726L;

	/**
	 * Atribuo de tipo {@link MainView}
	 */
	public InitialPanel init;

	/**
	 * Método público constructor de la clase
	 */
	public MainView() {
		setTitle("BackTracking, rama y poda");
		setLayout(null);
		setSize(500, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		initializeComponents();
		setVisible(true);
	}

	/**
	 * Método privado de tipo void para incializar los componentes.
	 */
	private void initializeComponents() {
		init = new InitialPanel();
		getContentPane().add(init);
	}

}
