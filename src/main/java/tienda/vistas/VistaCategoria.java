package tienda.vistas;

import java.awt.BorderLayout;
import java.awt.Container;

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
		frame = FormHelper.createCategoriaFrame("Gestion de Categorias", 400, 600);
	}
		
	public static void main(String[] args) {    
		vista(null);
		
	}

		//JPanel panel = new JPanel();
		
		
		
	public static void vista(String title) {
		JFrame frame = FormHelper.createCategoriaFrame(title, 500, 120);
		frame.getContentPane().setLayout(new BorderLayout());
		
		Container panel = frame.getContentPane();
		
		id_label = new JLabel("Id. ");
		nombre_label = new JLabel("nombre. ");
		descripcion_label = new JLabel("descripcion. ");
		
		id_text = new JTextField();
		nombre_text = new JTextField();
		descripcion_text = new JTextField();
		
		aceptar_button = new JButton("Aceptar");
		cancelar_button = new JButton("Cancelar");
		
		SpringLayout layout = new SpringLayout();
		FormHelper.addCategoriaFormComponents(panel, layout,
				id_label, nombre_label, descripcion_label,
				id_text, nombre_text, descripcion_text,
				aceptar_button, cancelar_button);
		panel.setSize(300,200);
	
		frame.setVisible(true);
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
