package tienda.vistas;

//import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import es.rf.tienda.dominio.Categoria;


public class VistaCategoria2 {
	Categoria object;
	
	VistaCategoria2() {
		JFrame vista = new JFrame();
		vista.setTitle("Gestion Categorías");
		vista.setSize(400,600);
		vista.setLocationRelativeTo(null);
		
//		JPanel p = new JPanel(new SpringLayout());
		
	}
	
	public static void main(String[] args) {    
		view();
		
	}
	public static void view (){
	    JFrame vista = new JFrame();
		vista.setTitle("Gestion Categorías");
		vista.setSize(350,250);
		vista.setResizable(false);
		vista.setLocationRelativeTo(null);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container panel = vista.getContentPane();
		SpringLayout layout = new SpringLayout();
		
		//establece el layout
		panel.setLayout(layout);
		
		JLabel jl1 = new JLabel("Categoria:	");
		JLabel jl2 = new JLabel("Nombre: ");
		JLabel jl3 = new JLabel("Descripción: ");
		
		JTextField jt1 = new JTextField(15);
		JTextField jt2 = new JTextField(15);
		JTextField jt3 = new JTextField(15);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		panel.add(jl1);
		panel.add(jl2);
		panel.add(jl3);
		panel.add(jt1);
		panel.add(jt2);
		panel.add(jt3);
		panel.add(aceptar);
		panel.add(cancelar);
		
		layout.putConstraint(SpringLayout.WEST, jl1, 30, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jl2, 30, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jl3, 30, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, aceptar, 60, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jt1, 120, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jt2, 120, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, jt3, 120, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, cancelar,150, SpringLayout.WEST, panel);
			
		layout.putConstraint(SpringLayout.NORTH, jl1, 30, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, jl2, 60, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, jl3, 90, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.NORTH, aceptar, 130, SpringLayout.NORTH, panel);
				
		layout.putConstraint(SpringLayout.SOUTH, jt1, 0, SpringLayout.SOUTH, jl1);
		layout.putConstraint(SpringLayout.SOUTH, jt2, 0, SpringLayout.SOUTH, jl2);
		layout.putConstraint(SpringLayout.SOUTH, jt3, 0, SpringLayout.SOUTH, jl3);
		layout.putConstraint(SpringLayout.SOUTH, cancelar, 0, SpringLayout.SOUTH, aceptar);
		
		          
    		vista.setVisible(true);
        }
        
	}


