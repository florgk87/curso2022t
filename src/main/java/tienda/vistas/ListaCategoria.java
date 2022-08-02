package tienda.vistas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.CategoriaDAO;


public class ListaCategoria {

	JFrame ventana;
	JPanel contentPane;
	
	CategoriaDAO CatDao = new CategoriaDAO();
	Categoria cat = new Categoria();
	
	 
	Object[][] data   =  cat.leerTodos(cat);
	String column [] = {"ID", "Nombre", "Descripcion"};
			
	public ListaCategoria() {
	
		ventana = new JFrame("Tabla");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		contentPane=(JPanel) ventana.getContentPane();
		
		
		JTable jt = new JTable(data,column);
		
		
		jt.setBounds(200, 200, 200, 400);
		JScrollPane sp = new JScrollPane(jt);
		contentPane.add(sp);
		ventana.setSize(300,500);
		ventana.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ListaCategoria();
	}

}
