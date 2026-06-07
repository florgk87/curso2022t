package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.rf.tienda.exception.DAOException;

public class OracleJDBC{

	private static OracleJDBC instancia = null;
	private static Connection conn;
	
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = System.getenv("DB_URL") != null
			? System.getenv("DB_URL")
			: System.getProperty("db.url", "jdbc:oracle:thin:@localhost:1521:xe");
	private final String USUARIO = System.getenv("DB_USER") != null
			? System.getenv("DB_USER")
			: System.getProperty("db.user", "");
	private final String PASSWORD = System.getenv("DB_PASSWORD") != null
			? System.getenv("DB_PASSWORD")
			: System.getProperty("db.password", "");

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
	try {
		Class.forName(JDBC_DRIVER);
	} catch (ClassNotFoundException e) {
		throw new DAOException("Driver Oracle JDBC no encontrado", e);
	}

	conn = null;
	try {
	     conn = DriverManager.getConnection(URL , USUARIO , PASSWORD);
		
	} catch (SQLException e) {
		throw new DAOException("No se pudo establecer conexion con la base de datos", e);
	}
}

public int ejecutar(String sql) throws DAOException {
	Statement stm = null;
	int retorno;
	
	try {
		stm = conn.createStatement();
		retorno = stm.executeUpdate(sql);
		
	} catch (SQLException e) {
		throw new DAOException("Error executing update", e);
		
	} finally {
		closeStatement(stm);
	}
	
	return retorno;
}

public int ejecutar(String sql, Object... params) throws DAOException {
	PreparedStatement pstm = null;
	int retorno;
	
	try {
		pstm = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			pstm.setObject(i + 1, params[i]);
		}
		retorno = pstm.executeUpdate();
		
	} catch (SQLException e) {
		throw new DAOException("Error executing parameterized update", e);
		
	} finally {
		if (pstm != null) {
			try { pstm.close(); } catch (SQLException ignored) { }
		}
	}
	
	return retorno;
}

private static void closeStatement(Statement stm) {
	if (stm != null) {
		try {
			stm.close();
		} catch (SQLException ignored) { }
	}
}


public static ResultSet ejecutarQuery(String sql) throws DAOException {
	Statement stm = null;
	ResultSet retorno;
	
	try {
		stm = conn.createStatement();
		retorno = stm.executeQuery(sql);
		
	} catch (SQLException e) {
		closeStatement(stm);
		throw new DAOException("Error executing query", e);
	}
	
	return retorno;
}

public static ResultSet ejecutarQuery(String sql, Object... params) throws DAOException {
	PreparedStatement pstm = null;
	ResultSet retorno;
	
	try {
		pstm = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			pstm.setObject(i + 1, params[i]);
		}
		retorno = pstm.executeQuery();
		
	} catch (SQLException e) {
		throw new DAOException("Error executing parameterized query", e);
	}
	
	return retorno;
}


public int consigueClave(String tabla, String campo) throws DAOException {
	if (!tabla.matches("[a-zA-Z_]+") || !campo.matches("[a-zA-Z_]+")) {
		throw new IllegalArgumentException("Invalid table or column name");
	}
	String sql = "SELECT MAX(" + campo + ") FROM " + tabla;
	ResultSet rs = ejecutarQuery(sql);
	
	try {
		if (rs.next()) {
			return rs.getInt(1) + 1;
		} else {
			return 1;
		}
	} catch (SQLException e) {
		throw new DAOException("Error looking up primary key", e);
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
