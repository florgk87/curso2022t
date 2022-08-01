package es.rf.tienda.interfaces.daos;

import static es.rf.tienda.interfaces.daos.CategoriaDAO.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.OracleJDBC;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Modelo;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Rutinas;

@SuppressWarnings("hiding")
public abstract class CategoriaDAO<Categoria, T> extends Modelo {
	
	
	private static final String SELECT = "SELECT * FROM Categoria ";
	private static final String UPDATE = "UPDATE Categoria SET ";
	private static final String INSERT = "INSERT INTO Categoria VALUES ";
	private static final String DELETE = "DELETE FROM Categoria ";
	
	OracleJDBC odbc = new OracleJDBC();

	

	public List<Categoria> leerTodos() throws Exception {
		String sql = SELECT;
		return (List<Categoria>) montarLista(sql);
		
	}
	
	public List<Categoria> leerRegistros() throws Exception {
		String where = obtenerWhere(null);
		String sql = SELECT + where;
		return (List<Categoria>) montarLista(sql);
		
	}
	

	public boolean guardar(Categoria clase) throws Exception {
		String salida = "";
		
		int clave = odbc.consigueClave("Categoria", "id_Categoria");
		salida = Rutinas.addCampo(salida, "", ((es.rf.tienda.dominio.Categoria) clase).getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "", ((es.rf.tienda.dominio.Categoria) clase).getCat_nombre(), ",");
		salida = Rutinas.addCampo(salida, "", ((es.rf.tienda.dominio.Categoria) clase).getCat_descripcion(), ",");
		String sql = INSERT + "(" + salida + ")";
		System.out.println(sql);
		int ret = odbc.ejecutar(sql);
		if (ret==0)
			throw new DAOException();
		return true;
	}
	

	public List<T> leer(Categoria clase) throws Exception {
		String where = obtenerWhere(null);
		String sql = SELECT + where;
		ResultSet rs = OracleJDBC.ejecutarQuery(sql);
		try {
			rs.next();
			if (rs.isLast()) {
				return montarLista(sql);
			} else
				throw new DAOException();
			
		} catch (SQLException e) {
			throw new DAOException();
		}
		
		
		
	}

/*
	public boolean actualizar(Categoria clase) throws Exception {
		String where = " WHERE ID_CATEGORIA = " + ((es.rf.tienda.dominio.Categoria) clase).getId_categoria();
		int tmp = ((es.rf.tienda.dominio.Categoria) clase).getId_categoria();
		((es.rf.tienda.dominio.Categoria) clase).setId_categoria(0);
		String update = obtenerUpdate(clase, update);
		String sql = UPDATE + update + where;
		return odbc.ejecutar(sql) >1;
	}	
	
*/	
	
	private String obtenerWhere(T clase) {
		String salida = obtenerLista(clase, "AND");
		if (salida.length() >0 )
			salida = "WHERE " + salida;
		return salida;
	}
	
	//private String obtenerUpdate(Categoria clase, String separador) {
	//	return obtenerLista(clase, ",");
	//}
	

	
	private String obtenerLista(T clase, String separador) {
		String salida = "";
		salida = Rutinas.addCampo(salida, "Id_categoria", ((es.rf.tienda.dominio.Categoria) clase).getId_categoria(), separador);
		salida = Rutinas.addCampo(salida, "Cat_nombre", ((es.rf.tienda.dominio.Categoria) clase).getCat_nombre(), separador);
		salida = Rutinas.addCampo(salida, "Cat_descripcion", ((es.rf.tienda.dominio.Categoria) clase).getCat_descripcion(), separador);
		
		return salida;
	}
	
	public boolean borrarRegistro(T clase) throws Exception{
		String where = obtenerWhere(clase);
		String sql = DELETE + ((es.rf.tienda.dominio.Categoria) clase).getTabla() + where;
		return odbc.ejecutar(sql) >0;
	}

	

	private List<T> montarLista(String sql) throws Exception {
		
		ResultSet rs = OracleJDBC.ejecutarQuery(sql);
		List<T> lista = new ArrayList<T>();
		try {
			while (rs.next()) {
				lista.add(montarRegistro(rs));
			}
		} catch (SQLException e) {
			throw new DAOException();
		}
		return lista;
		
	}
	
	private T montarRegistro(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}




	
	
}
