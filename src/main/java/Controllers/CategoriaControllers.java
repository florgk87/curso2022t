package Controllers;

import java.util.List;
import java.util.Map;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.interfaces.daos.CategoriaDAO;
import es.rf.tienda.interfaces.daos.ICategoria;

public class CategoriaControllers implements ICategoria {

	private CategoriaDAO cDao;
	
	public CategoriaControllers() {
		cDao = new CategoriaDAO();
	}
	
	@Override
	public Categoria leer(Categoria obj) {
		try {
			return cDao.leer(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Categoria> leerTodos() {
		try {
			return cDao.leerTodos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Categoria> leerSQL() {
		return null;
	}

	@Override
	public boolean grabar(Categoria obj) {
		try {
			return cDao.guardar(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map<String, String> obtenSelect() {
		return null;
	}

	@Override
	public Categoria getRegistro(int num) {
		return null;
	}

	@Override
	public List<Categoria> leerRegistros(Categoria c) {
		try {
			return cDao.leerRegistros(c);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int insertar(Categoria c) {
		return 0;
	}

	@Override
	public int actualizar(Categoria c) {
		return 0;
	}

	@Override
	public int borrar(Categoria c) {
		return 0;
	}

}
