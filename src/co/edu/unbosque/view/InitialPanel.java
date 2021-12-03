package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La clase InitialPanel es un panel que seutiliza en la vista del programa, se
 * extiende de {@link JPanel}.
 * 
 * @version 1 29/11/2021
 * @author Julian Andres Silva Beltran
 * @author Juan Andres Castillo Fuenmayor
 * @author Diana Marcela Rios Gaviria
 * @author Juan Jose Navas Wittingham
 */
public class InitialPanel extends JPanel {
	private static final long serialVersionUID = 5549877136347302500L;

	/**
	 * Atributo de tipo {@link JButton}
	 */
	private JButton init;
	/**
	 * Atributo de tipo {@link JButton}
	 */
	private JButton picture;
	/**
	 * Atributo de tipo {@link JLabel}
	 */
	private JLabel label1;
	/**
	 * Atributo de tipo {@link JLabel}
	 */
	private JLabel label2;

	/**
	 * Método público constructor de la clase
	 */
	public InitialPanel() {
		setSize(500, 600);
		setLayout(null);
		assign();
		setBackground(Color.DARK_GRAY);
		setVisible(true);
	}

	/**
	 * Método de configuración y creación del panel.
	 */
	private void assign() {
		ImageIcon image = new ImageIcon("logo.jpg");
		ImageIcon icon = new ImageIcon(image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		picture = new JButton(icon);
		picture.setActionCommand("FOTO");
		picture.setBounds(130, 150, 200, 200);
		add(picture);

		init = new JButton("Comenzar");
		init.setActionCommand("INICIAR");
		init.setBounds(165, 450, 150, 50);
		init.setFont(new Font("Arial", Font.BOLD, 15));
		add(init);

		label1 = new JLabel("Universidad El Bosque");
		label1.setFont(new Font("Arial", Font.ITALIC, 25));
		label1.setBounds(110, 370, 450, 80);
		label1.setForeground(Color.GREEN);
		add(label1);

		label2 = new JLabel("BackTracking y rama y poda");
		label2.setFont(new Font("Arial", Font.ITALIC, 25));
		label2.setBounds(70, 40, 450, 80);
		label2.setForeground(Color.white);
		add(label2);
	}
}
