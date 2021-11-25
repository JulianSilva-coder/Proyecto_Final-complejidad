package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana_Inicio extends JPanel{
	private JButton iniciar, foto;
	private JLabel etiqueta1, etiqueta2;
	
	public Ventana_Inicio() {
		setSize(500, 600);
		setLayout(null);
		asignar();
		setBackground(Color.DARK_GRAY);
		setVisible(true);
	}

	private void asignar() {
		ImageIcon imagen = new ImageIcon("logo.jpg");
		ImageIcon icon = new ImageIcon(imagen.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		foto = new JButton(icon);
		foto.setActionCommand("FOTO");
		foto.setBounds(130,150,200,200);
		add(foto);
		
		iniciar = new JButton("Comenzar");
		iniciar.setActionCommand("INICIAR");
		iniciar.setBounds(165,450,150,50);
		iniciar.setFont(new Font("Arial", Font.BOLD,15));
		add(iniciar);
		
		etiqueta1 = new JLabel("Universidad El Bosque");
		etiqueta1.setFont(new Font("Arial", Font.ITALIC,25));
		etiqueta1.setBounds(110,370,450,80);
		etiqueta1.setForeground(Color.GREEN);
		add(etiqueta1);
		
		etiqueta2 = new JLabel("BackTracking y rama y poda");
		etiqueta2.setFont(new Font("Arial", Font.ITALIC,25));
		etiqueta2.setBounds(70,40,450,80);
		etiqueta2.setForeground(Color.white);
		add(etiqueta2);	
	}
	
}
