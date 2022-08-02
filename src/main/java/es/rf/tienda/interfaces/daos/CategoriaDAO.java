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


public class CategoriaDAO {
	
	
	private static final String SELECT = "SELECT * FROM Categoria ";
	private static final String UPDATE = "UPDATE Categoria SET ";
	private static final String INSERT = "INSERT INTO Categoria VALUES ";
	private static final String DELETE = "DELETE FROM Categoria ";
	
	OracleJDBC odbc = new OracleJDBC();

	
	public List<Categoria>  leerTodos(Categoria cat) throws Exception {
		String sql = SELECT;
		return montarLista(sql);
		
	}
	
	public List<Categoria> leerRegistros(Categoria cat) throws Exception {
		String where = obtenerWhere(null);
		String sql = SELECT + where;
		return montarLista(sql);
		
	}
	

	public boolean guardar(Categoria cat) throws Exception {
		String salida = "";
		
		int clave = odbc.consigueClave("Categoria", "id_Categoria");
		salida = Rutinas.addCampo(salida, "", ((es.rf.tienda.dominio.Categoria) cat).getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "", ((es.rf.tienda.dominio.Categoria) cat).getCat_nombre(salida), ",");
		salida = Rutinas.addCampo(salida, "", ((es.rf.tienda.dominio.Categoria) cat).getCat_descripcion(), ",");
		String sql = INSERT + "(" + salida + ")";
		System.out.println(sql);
		int ret = odbc.ejecutar(sql);
		if (ret==0)
			throw new DAOException();
		return true;
	}
	
/**
 * Recibe un objeto Categoria y devuelve
 * @param cat
 * @return
 * @throws Exception
 
	public Categoria leer(Categoria cat) throws Exception {
		String where = obtenerWhere(null);
		String sql = SELECT + where;
		ResultSet rs = OracleJDBC.ejecutarQuery(sql);
		try {
			rs.next();
			if (rs.isLast()) {
				return montarLista(rs);
			} else
				throw new DAOException();
			
		} catch (SQLException e) {
			throw new DAOException();
		}
		
	
	}
*/


	

	public boolean actualizar(Categoria cat) throws Exception {
		String where = " WHERE ID_CATEGORIA = " + ((es.rf.tienda.dominio.Categoria) cat).getId_categoria();
		int tmp = ((es.rf.tienda.dominio.Categoria) cat).getId_categoria();
		((es.rf.tienda.dominio.Categoria) cat).setId_categoria(0);
		String update = "" ;
		obtenerUpdate(cat, update);
		String sql = UPDATE + update + where;
		return odbc.ejecutar(sql) >1;
	}	
	
	
	
	private String obtenerWhere(Categoria cat) {
		
		String salida = obtenerLista(cat, "AND");
		//String salida = "id_categoria = 1 ";
		if (salida.length() >0 )
			salida = "WHERE " + salida;
		return salida;
	}
	
	private String obtenerUpdate(Categoria cat, String separador) {
		return obtenerLista(cat, ",");
	}
	

	
	private String obtenerLista(Categoria cat, String separador) {
		String salida = "";
		salida = Rutinas.addCampo(salida, "id_categoria", ((es.rf.tienda.dominio.Categoria) cat).getId_categoria(), separador);
		salida = Rutinas.addCampo(salida, "cat_nombre", ((es.rf.tienda.dominio.Categoria) cat).getCat_nombre(separador), separador);
		salida = Rutinas.addCampo(salida, "cat_descripcion", ((es.rf.tienda.dominio.Categoria) cat).getCat_descripcion(), separador);
		
		return salida;
	}
	
	public boolean borrarRegistro(Categoria cat) throws Exception{
		String where = obtenerWhere(cat);
		String sql = DELETE + ((es.rf.tienda.dominio.Categoria) cat).getTabla() + where;
		return odbc.ejecutar(sql) >0;
	}

	

	private List<Categoria> montarLista(String sql) throws Exception {
		
		ResultSet rs = OracleJDBC.ejecutarQuery(sql);
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			while (rs.next()) {
				lista.add(montarRegistro(rs));
			}
		} catch (SQLException e) {
			throw new DAOException();
		}
		return lista;
		
	}
	

	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	
	private Categoria montarRegistro(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Categoria cat = new Categoria();
		cat.setId_categoria(rs.getInt("id_categoria"));
		cat.getCat_nombre(rs.getString("cat_nombre"));
		cat.getCat_descripcion(rs.getString("cat_descripcion"));
		return cat;
	
		
	}




	
	
}
