package es.rf.tienda.interfaces.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.OracleJDBC;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Rutinas;


public class CategoriaDAO {
	
	
	private static final String SELECT = "SELECT * FROM Categoria ";
	private static final String UPDATE = "UPDATE Categoria SET ";
	private static final String INSERT = "INSERT INTO Categoria VALUES ";
	private static final String DELETE = "DELETE FROM Categoria ";
	
	private OracleJDBC odbc = OracleJDBC.getInstance();

	
	public List<Categoria> leerTodos() throws Exception {
		String sql = SELECT;
		return montarLista(sql);
	}
	
	public List<Categoria> leerRegistros(Categoria cat) throws Exception {
		String where = obtenerWhere(cat);
		String sql = SELECT + where;
		return montarLista(sql);
	}
	

	public boolean guardar(Categoria cat) throws Exception {
		String salida = "";
		
		int clave = odbc.consigueClave("Categoria", "id_Categoria");
		salida = Rutinas.addCampo(salida, "", cat.getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "", cat.getCat_nombre(), ",");
		salida = Rutinas.addCampo(salida, "", cat.getCat_descripcion(), ",");
		String sql = INSERT + "(" + salida + ")";
		System.out.println(sql);
		int ret = odbc.ejecutar(sql);
		if (ret == 0)
			throw new DAOException("Error al guardar Categoria");
		return true;
	}
	
	/**
	 * Recibe un objeto Categoria y devuelve el registro correspondiente
	 * @param cat Categoria con los criterios de busqueda
	 * @return Categoria encontrada
	 * @throws Exception si ocurre un error de acceso a datos
	 */
	public Categoria leer(Categoria cat) throws Exception {
		String where = obtenerWhere(cat);
		String sql = SELECT + where;
		ResultSet rs = OracleJDBC.ejecutarQuery(sql);
		try {
			rs.next();
			if (rs.isLast()) {
				return montarRegistro(rs);
			} else {
				throw new DAOException("Se esperaba un unico registro");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en leer: " + e.getMessage());
		}
	}


	public boolean actualizar(Categoria cat) throws Exception {
		String where = " WHERE ID_CATEGORIA = " + cat.getId_categoria();
		int tmp = cat.getId_categoria();
		cat.setId_categoria(0);
		String update = obtenerUpdate(cat, ",");
		cat.setId_categoria(tmp);
		String sql = UPDATE + update + where;
		return odbc.ejecutar(sql) > 0;
	}	
	
	
	
	private String obtenerWhere(Categoria cat) {
		if (cat == null) {
			return "";
		}
		String salida = obtenerLista(cat, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}
	
	private String obtenerUpdate(Categoria cat, String separador) {
		return obtenerLista(cat, separador);
	}
	

	
	private String obtenerLista(Categoria cat, String separador) {
		String salida = "";
		salida = Rutinas.addCampo(salida, "id_categoria", cat.getId_categoria(), separador);
		salida = Rutinas.addCampo(salida, "cat_nombre", cat.getCat_nombre(), separador);
		salida = Rutinas.addCampo(salida, "cat_descripcion", cat.getCat_descripcion(), separador);
		
		return salida;
	}
	
	public boolean borrarRegistro(Categoria cat) throws Exception {
		String where = obtenerWhere(cat);
		String sql = DELETE + where;
		return odbc.ejecutar(sql) > 0;
	}

	

	private List<Categoria> montarLista(String sql) throws Exception {
		
		ResultSet rs = OracleJDBC.ejecutarQuery(sql);
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			while (rs.next()) {
				lista.add(montarRegistro(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("Error al montar lista: " + e.getMessage());
		}
		return lista;
	}
	

	/**
	 * Monta un objeto Categoria a partir de un ResultSet
	 * @param rs ResultSet posicionado en el registro a montar
	 * @return Categoria con los datos del registro
	 * @throws SQLException si ocurre un error al acceder al ResultSet
	 */
	private Categoria montarRegistro(ResultSet rs) throws SQLException {
		Categoria cat = new Categoria();
		cat.setId_categoria(rs.getInt("id_categoria"));
		try {
			cat.setCat_nombre(rs.getString("cat_nombre"));
		} catch (DomainException e) {
			System.out.println("Advertencia: nombre de categoria invalido en BD - " + e.getMessage());
		}
		cat.setCat_descripcion(rs.getString("cat_descripcion"));
		return cat;
	}

}
