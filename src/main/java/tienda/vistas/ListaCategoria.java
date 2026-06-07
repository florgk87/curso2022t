package tienda.vistas;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.CategoriaDAO;


public class ListaCategoria {

	private JFrame ventana;
	private JPanel contentPane;
	
	private CategoriaDAO catDao = new CategoriaDAO();
	
	private String[] column = {"ID", "Nombre", "Descripcion"};
			
	public ListaCategoria() {
	
		ventana = new JFrame("Tabla");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		contentPane = (JPanel) ventana.getContentPane();
		
		Object[][] data = cargarDatos();
		
		JTable jt = new JTable(data, column);
		jt.setBounds(200, 200, 200, 400);
		JScrollPane sp = new JScrollPane(jt);
		contentPane.add(sp);
		ventana.setSize(300, 500);
		ventana.setVisible(true);
	}
	
	private Object[][] cargarDatos() {
		try {
			List<Categoria> categorias = catDao.leerTodos();
			Object[][] data = new Object[categorias.size()][3];
			for (int i = 0; i < categorias.size(); i++) {
				Categoria c = categorias.get(i);
				data[i][0] = c.getId_categoria();
				data[i][1] = c.getCat_nombre();
				data[i][2] = c.getCat_descripcion();
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return new Object[0][3];
		}
	}
	
	public static void main(String[] args) {
		new ListaCategoria();
	}

}
