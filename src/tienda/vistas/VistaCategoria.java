package tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import es.rf.tienda.dominio.Categoria;

public class VistaCategoria {

	Categoria objet;
	
	JFrame frame;
	JPanel panel;
	static JLabel id_label;
	static JLabel nombre_label;
	static JLabel descripcion_label;
	
	static JTextField id_text;
	static JTextField nombre_text;
	static JTextField descripcion_text;
	
	static JButton aceptar_button;
	static JButton cancelar_button;

//prueba modificacion git y otro cambio mas
	
	
	public VistaCategoria() {
		JFrame vista = new JFrame();
		vista.setTitle("Gestion de Categorias");
		vista.setSize(400,600);
		vista.setLocationRelativeTo(null);
		
//		JPanel panel = new JPanel();
	

		
	}
		
	public static void main(String[] args) {    
		vista(null);
		
	}

		//JPanel panel = new JPanel();
		
		
		
	public static void vista(String title) {
		JFrame frame = new JFrame(title);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setSize(500,120);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Container panel = frame.getContentPane();
		
		id_label = new JLabel("Id. ");
		nombre_label = new JLabel("nombre. ");
		descripcion_label = new JLabel("descripcion. ");
		
		id_text = new JTextField();
		nombre_text = new JTextField();
		descripcion_text = new JTextField();
		
		aceptar_button = new JButton("Aceptar");
		cancelar_button = new JButton("Cancelar");
		
/*	
		//Layout
		GroupLayout layout = new GroupLayout(frame.getAccessibleContext());
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(id_label)
						.addComponent(nombre_label)
						.addComponent(descripcion_label)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(id_text)
						.addComponent(nombre_text)
						.addComponent(descripcion_text))));
		
		//layout.setVerticalGroup(null);
*/
		
		//GridLayout layout = new GridLayout(4,2);
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		
		panel.add(id_label);
		panel.add(nombre_label);
		panel.add(descripcion_label);
		panel.add(id_text);
		panel.add(nombre_text);
		panel.add(descripcion_text);
		panel.add(cancelar_button);
		panel.add(aceptar_button);	
		panel.setSize(300,200);
	
		frame.getContentPane().setLayout(layout);
		frame.setVisible(true);
		
			
/*
 * 		layout.addLayoutComponent(title, aceptar_button);
		layout.addLayoutComponent(title, cancelar_button);
		layout.addLayoutComponent(title, id_text);
		layout.addLayoutComponent(title, nombre_text);
		layout.addLayoutComponent(title, descripcion_text);
		layout.addLayoutComponent(title, id_label);
		layout.addLayoutComponent(title, nombre_label);
		layout.addLayoutComponent(title, descripcion_label);
 */

		
		

		
			
		
	}


		public VistaCategoria(Categoria objet, JFrame frame, JPanel panel, JLabel id_label, JLabel nombre_label,
				JLabel descripcion_label, JTextField id_text, JTextField nombre_text, JTextField descripcion_text,
				JButton aceptar_button, JButton cancelar_button) {
			super();
			this.objet = objet;
			this.frame = frame;
			this.panel = panel;
			this.id_label = id_label;
			this.nombre_label = nombre_label;
			this.descripcion_label = descripcion_label;
			this.id_text = id_text;
			this.nombre_text = nombre_text;
			this.descripcion_text = descripcion_text;
			this.aceptar_button = aceptar_button;
			this.cancelar_button = cancelar_button;
		}
	
	
	
	
}
