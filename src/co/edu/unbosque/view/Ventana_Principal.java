package co.edu.unbosque.view;

import javax.swing.JFrame;

public class Ventana_Principal extends JFrame {
	public Ventana_Inicio inicio;

	public Ventana_Principal() {
		setTitle("BackTracking, rama y poda");
		setLayout(null);
		setSize(500, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		inicializar_componentes();
		setVisible(true);
	}

	private void inicializar_componentes() {
		inicio = new Ventana_Inicio();
		getContentPane().add(inicio);
	}

}
