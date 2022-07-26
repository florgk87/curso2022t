package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;

public interface ICategoria {
	public Categoria getRegistro(int num);
	public List<Categoria> leerTodos();
	public List<Categoria> leerRegistros(Categoria c);
	public int insertar(Categoria c);
	public int actualizar(Categoria c);
	public int borrar(Categoria c);
}
