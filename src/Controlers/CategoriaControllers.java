

package Controlers;

import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.InterfacesDAO;

public class CategoriaControllers implements Controlador<Categoria> {

	private ICategoriaDao cDao;
	
	public T leer(T obj);
	public List<T> leerTodos();
	public List<T> leerSQL();
	public boolean grabar(T obj);
	public boolean actualizar(T obj);
	public boolean borrar(T obj);
	
	//vista invocar al controlador con LeeTodos
	//Pantalla de captura con la orden Grabar
	
	public Map<String,String> obtenSelect();
	
	public ControllerCategoria() {
		cDao = new ICategoriaDao();
		
	}
	
	@Override
	public Categoria leer(Categoria obj) {
		// TODO Auto-generated method stub
	
		cDao.leerTodos();
		
	}

	@Override
	public List<Categoria> leerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> leerSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean grabar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(Categoria obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Map<String, String> obtenSelect() {
		// TODO Auto-generated method stub
		return null;
	}

}

