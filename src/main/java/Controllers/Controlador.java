package Controllers;

import java.util.List;
import java.util.Map;

public interface Controlador<T> {

	public T leer(T obj);
	public List<T> leerTodos();
	public List<T> leerSQL();
	public boolean grabar(T obj);
	public boolean actualizar(T obj);
	public boolean borrar(T obj);
	
	public Map<String,String> obtenSelect();

}
