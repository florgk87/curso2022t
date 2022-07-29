package es.rf.tienda.interfaces.daos;

import java.util.List;

import es.rf.tienda.dominio.Categoria;

public interface ICategoria{
	public Categoria getRegistro(int num);
	public List<Categoria> leerTodos();
	public List<Categoria> leerRegistros(Categoria clase);
	public int insertar(Categoria clase);
	public int actualizar(Categoria clasec);
	public int borrar(Categoria clase);
}
