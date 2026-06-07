package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.rf.tienda.exception.DAOException;

public class OracleJDBC{

	private static OracleJDBC instancia = null;
	private static Connection conn;
	
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USUARIO = "alumno";
	private final String PASSWORD = "Curso2022";

	public static void main(String[] args) {
		conn = null;
	}

public static OracleJDBC getInstance() throws DAOException {
	if (instancia ==null) {
		instancia = new OracleJDBC();
		
	}
		return instancia;
}

public OracleJDBC() throws DAOException {
	conexion();
}

private void conexion() throws DAOException {
	System.out.println("------Prueba de conexion a BBDD -------");
	
	try {
		Class.forName(JDBC_DRIVER);
	} catch (ClassNotFoundException e) {
		throw new DAOException("Driver Oracle JDBC no encontrado", e);
	}
			
	System.out.println("Driver oracle Registrado!");
	conn = null;
	try {
	     conn = DriverManager.getConnection(URL , USUARIO , PASSWORD);
		
	} catch (SQLException e) {
		throw new DAOException("No se pudo establecer conexion con la base de datos", e);
	}
}

public int ejecutar(String sql) throws DAOException {
	
	System.out.println("Ejecutar: " + sql);
	 
	Statement stm = null;
	int retorno;
	
	try {
		stm = conn.createStatement();
		retorno = stm.executeUpdate(sql);
		
	} catch (SQLException e) {
		throw new DAOException("Error ejecutando SQL: " + sql, e);
		
	} finally {
		closeStatement(stm);
	}
	
	return retorno;
}

private static void closeStatement(Statement stm) {
	if (stm != null) {
		try {
			stm.close();
		} catch (SQLException e) {
			System.err.println("Error cerrando Statement: " + e.getMessage());
		}
	}
}

public static ResultSet ejecutarQuery(String sql) throws DAOException {
	
	System.out.println("Ejecutar Query: " + sql);
	Statement stm = null;
	ResultSet retorno;
	
	try {
		stm = conn.createStatement();
		retorno = stm.executeQuery(sql);
		
	} catch (SQLException e) {
		closeStatement(stm);
		throw new DAOException("Error ejecutando query: " + sql, e);
	}
	
	return retorno;
}

public int consigueClave(String tabla, String campo) throws DAOException {
	String sql = "SELECT MAX(" + campo + ") FROM " + tabla;
	ResultSet rs = ejecutarQuery(sql);
	
	try {
		if (rs.next()) {
			return rs.getInt(1) + 1;
		} else {
			return 1;
		}
	} catch (SQLException e) {
		throw new DAOException("Error buscando PK: " + sql, e);
	}
}

public void closeConnection() throws DAOException {
	try {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	} catch (SQLException e) {
		throw new DAOException("Error al cerrar conexion a BD", e);
	} finally {
		conn = null;
	}
}
}
