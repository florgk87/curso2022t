package tienda.vistas;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class ListaCategoria {


	public ListaCategoria() {
			JFrame vista = new JFrame();
			vista.setTitle("Listado de Categorías");
			vista.setSize(1200,1200);
			vista.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {    
		view();
		
	}
	public static void view (){
	    JFrame vista = new JFrame();
		vista.setTitle("Listado de  Categorías");
		vista.setSize(800,800);
		vista.setResizable(false);
		vista.setLocationRelativeTo(null);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container panel = vista.getContentPane();
		SpringLayout layout = new SpringLayout();
		
		//establece el layout
		panel.setLayout(layout);
		
  		vista.setVisible(true);
        }
        

}
