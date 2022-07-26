package es.rf.tienda.interfaces.daos;

import static es.rf.tienda.interfaces.daos.CategoriaDAO.INSERT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexion.OracleJDBC;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Rutinas;

public abstract class CategoriaDAO<Categoria> implements ICategoria {
	
	
	private static final String SELECT = "SELECT * FROM Categoria ";
	private static final String UPDATE = "UPDATE Categoria SET ";
	private static final String INSERT = "INSERT INTO Categoria VALUES ";
	private static final String DELETE = "DELETE FROM Categoria ";
	

	public CategoriaDAO(es.rf.tienda.dominio.Categoria categoria) {
		// TODO Auto-generated constructor stub
	}

	public list<Categoria> leerTodos() throws DAOException, DomainException {
		String sql = SELECT;
		return montarLista(sql);
		
	}
	
	public list<Categoria> leerRegistros() throws DAOException, DomainException {
		string where = obtenerWhere(clase);
		String sql = SELECT + where;
		return montarLista(sql);
		
	}
	
	@Override
	public boolean guardar(Categoria clase) throws DAOException {
		String salida = "";
		
		clase = setId_Categoria(RFDataConnection.consigueClave("Categoria", "id_Categoria"));
		salida = Rutinas.addCampo(salida, "", clase.getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_nombre(), ",");
		salida = Rutinas.addCampo(salida, "", clase.getCat_descripcion(), ",");
		String sql = INSERT + "(" + salida + ")";
		System.out.println(sql);
		int ret = OracleJDBC.ejecutar(sql);
		if (ret==0)
			throw new DAOException("Error en " + sql);
		return true;
	}
	
	public Categoria leer(Categoria clase) throws DAOException, DomainException {
		String where = obtenerWhere(clase);
		String sql = SELECT + where;
		ResultSet rs = RFDataConnection.ejecutarQuery(sql);
		try {
			rs.next();
			if (rs.isLast()) {
				return montarLista(rs);
			} else
				throw new DAOException("Muchos registros devueltos por " + sql);
			
		} catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + sql);
		}
		
		
		
	}
	
	public boolean actualizar(Categoria clase) throws DAOException, DomainException {
		String where = " WHERE id_Categoria = " + clase.getId_categoria();
		int tmp = clase.getId_Categoria();
		clase.setId_Categoria(0);
		String update = obtenUpdate(clase);
		String sql = UPDATE + update + where;
		return RFDataConnection.ejecutar(sql) >1;
		
	
	
	
	private String obtenerWhere(Categoria clase) {
		String salida = obtenerLista(clase, "AND");
		if (salida.length() >0 )
			salida = "WHERE " + salida;
		return salida;
	}
	

	
	private String obtenerLista(Categoria clase, String separador) {
		String salida = "";
		salida = Rutinas.addCampo(salida, "Id_categoria", clase.getId_categoria(, separador);
		salida = Rutinas.addCampo(salida, "Cat_nombre", clase.getCat_nombre(, separador);
		salida = Rutinas.addCampo(salida, "Cat_Descripcion", clase.getCat_descripcion(, separador);
		
		return salida;
	}

	
	private String obtenerUpdate(Categoria clase, String separador) {
		return obtenerLista(clase, ",");
	}
	


	
	
}
