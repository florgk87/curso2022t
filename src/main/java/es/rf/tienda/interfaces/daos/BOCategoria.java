package es.rf.tienda.interfaces.daos;

import es.rf.tienda.dominio.Categoria;

public class BOCategoria extends CategoriaDAO {
	  
	public BOCategoria() {
		super();
	}

	public String obtenInsert(Categoria clase) {
		return obtenerLista(clase, ",");
	}
}
