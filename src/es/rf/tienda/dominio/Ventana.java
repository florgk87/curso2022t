package es.rf.tienda.dominio;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana  {

	public static void main(String[] args) {

		JFrame MiVentana = new JFrame("Mi Ventana");
		MiVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		MiVentana.setSize(300,300);
		
		Container panel = MiVentana.getContentPane();
		
		JButton buttonRojo = new  JButton("Rojo");
		JButton buttonAzul = new  JButton("Azul");
		JButton buttonVerde = new  JButton("Verde");
		JButton buttonAmarillo = new  JButton("Amarillo");
	
		MiVentana.getContentPane().add(buttonRojo);
		MiVentana.getContentPane().add(buttonAzul);
		MiVentana.getContentPane().add(buttonVerde);
		MiVentana.getContentPane().add(buttonAmarillo);
	
		BoxLayout boxLayout = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		
		buttonRojo.setBackground(Color.red);
		buttonAzul.setBackground(Color.blue);
		buttonVerde.setBackground(Color.green);
		buttonAmarillo.setBackground(Color.yellow);
		
		panel.add(buttonRojo);
		panel.add(buttonAzul);
		panel.add(buttonVerde);
		panel.add(buttonAmarillo);	
				
		buttonRojo.addActionListener(e -> panel.setBackground(Color.red));
		buttonAzul.addActionListener(e -> panel.setBackground(Color.blue));
		buttonVerde.addActionListener(e -> panel.setBackground(Color.green));
		buttonAmarillo.addActionListener(e -> panel.setBackground(Color.yellow));
		
		MiVentana.setVisible(true);
		
		
	}

}
