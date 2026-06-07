package tienda.vistas;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import es.rf.tienda.dominio.Categoria;

public class VistaCategoria {

	private Categoria objet;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel id_label;
	private JLabel nombre_label;
	private JLabel descripcion_label;
	
	private JTextField id_text;
	private JTextField nombre_text;
	private JTextField descripcion_text;
	
	private JButton aceptar_button;
	private JButton cancelar_button;
	
	
	public VistaCategoria() {
		frame = new JFrame();
		frame.setTitle("Gestion de Categorias");
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPanel = frame.getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPanel.setLayout(layout);
		
		id_label = new JLabel("Id. ");
		nombre_label = new JLabel("nombre. ");
		descripcion_label = new JLabel("descripcion. ");
		
		id_text = new JTextField(15);
		nombre_text = new JTextField(15);
		descripcion_text = new JTextField(15);
		
		aceptar_button = new JButton("Aceptar");
		cancelar_button = new JButton("Cancelar");
		
		contentPanel.add(id_label);
		contentPanel.add(id_text);
		contentPanel.add(nombre_label);
		contentPanel.add(nombre_text);
		contentPanel.add(descripcion_label);
		contentPanel.add(descripcion_text);
		contentPanel.add(aceptar_button);
		contentPanel.add(cancelar_button);
		
		layout.putConstraint(SpringLayout.WEST, id_label, 30, SpringLayout.WEST, contentPanel);
		layout.putConstraint(SpringLayout.WEST, nombre_label, 30, SpringLayout.WEST, contentPanel);
		layout.putConstraint(SpringLayout.WEST, descripcion_label, 30, SpringLayout.WEST, contentPanel);
		layout.putConstraint(SpringLayout.WEST, aceptar_button, 60, SpringLayout.WEST, contentPanel);
		layout.putConstraint(SpringLayout.WEST, id_text, 120, SpringLayout.WEST, contentPanel);
		layout.putConstraint(SpringLayout.WEST, nombre_text, 120, SpringLayout.WEST, contentPanel);
		layout.putConstraint(SpringLayout.WEST, descripcion_text, 120, SpringLayout.WEST, contentPanel);
		layout.putConstraint(SpringLayout.WEST, cancelar_button, 150, SpringLayout.WEST, contentPanel);
		
		layout.putConstraint(SpringLayout.NORTH, id_label, 30, SpringLayout.NORTH, contentPanel);
		layout.putConstraint(SpringLayout.NORTH, nombre_label, 60, SpringLayout.NORTH, contentPanel);
		layout.putConstraint(SpringLayout.NORTH, descripcion_label, 90, SpringLayout.NORTH, contentPanel);
		layout.putConstraint(SpringLayout.NORTH, aceptar_button, 130, SpringLayout.NORTH, contentPanel);
		
		layout.putConstraint(SpringLayout.SOUTH, id_text, 0, SpringLayout.SOUTH, id_label);
		layout.putConstraint(SpringLayout.SOUTH, nombre_text, 0, SpringLayout.SOUTH, nombre_label);
		layout.putConstraint(SpringLayout.SOUTH, descripcion_text, 0, SpringLayout.SOUTH, descripcion_label);
		layout.putConstraint(SpringLayout.SOUTH, cancelar_button, 0, SpringLayout.SOUTH, aceptar_button);
		
		frame.setVisible(true);
	}
		
	public static void main(String[] args) {    
		new VistaCategoria();
	}

}
