package Controlers;

import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.CategoriaDAO;
import es.rf.tienda.interfaces.daos.ICategoria;
import es.rf.tienda.interfaces.daos.InterfacesDAO;

public class CategoriaControllers implements ICategoria {


	//La vista invoca al controlador con LeeTodos
	//Pantalla de captura con la orden Grabar
	
	private CategoriaDAO cDao;
	
	public Map<String,String> obtenSelect1() {
		return null;
	}
	
	public CategoriaControllers() {
		cDao = new CategoriaDAO();
		
	}
	
	@Override
	public Categoria leer(Categoria obj) {
		// TODO Auto-generated method stub
	
		return cDao.leer(obj);
		
	}

	@Override
	public List<Categoria> leerTodos() {
		// TODO Auto-generated method stub
		cDao.leerTodos(Categoria);
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
	public Map<String, String> obtenSelect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria getRegistro(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> leerRegistros(Categoria c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(Categoria c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(Categoria c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrar(Categoria c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
