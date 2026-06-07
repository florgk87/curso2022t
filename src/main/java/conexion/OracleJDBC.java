package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJDBC{

	private static OracleJDBC instancia = null;
	private static Connection conn;
	
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL_KEY = "db.url";
	private static final String USER_KEY = "db.user";
	private static final String PASS_KEY = "db.password";

	private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DEFAULT_USER = "alumno";
	private static final String DEFAULT_PASS = "Curso2022";

	public static void main(String[] args) {
		conn = null;
	}

	public static OracleJDBC getInstance() {
		if (instancia == null) {
			instancia = new OracleJDBC();
		}
		return instancia;
	}

	private OracleJDBC() {
		conexion();
	}

	private void conexion() {
		System.out.println("------Prueba de conexion a BBDD -------");
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Donde esta tu Driver Oracle");
			e.printStackTrace();
			return;
		}
				
		System.out.println("Driver oracle Registrado!");

		String url = System.getProperty(URL_KEY, DEFAULT_URL);
		String user = System.getProperty(USER_KEY, DEFAULT_USER);
		String pass = System.getProperty(PASS_KEY, DEFAULT_PASS);

		conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			System.out.println("Falló la conexion");
			e.printStackTrace();
			return;
		}
	}

	public int ejecutar(String sql) throws Exception {
		
		System.out.println("Ejecutar: " + sql);
		 
		Statement stm = null;
		int retorno;
		
		try {
			stm = conn.createStatement();
			retorno = stm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error en " + sql);
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retorno;
	}

	public static ResultSet ejecutarQuery(String sql) throws Exception {
		
		System.out.println("Ejecutar Query: " + sql);
		Statement stm = null;
		ResultSet retorno;
		
		try {
			stm = conn.createStatement();
			retorno = stm.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			throw new Exception("Error en " + sql);
		}
		
		return retorno;
	}

	public int consigueClave(String tabla, String campo) throws Exception {
		String sql = "SELECT MAX(" + campo + ") FROM " + tabla;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			if (rs.next()) {
				int maxVal = rs.getInt(1);
				if (rs.wasNull()) {
					return 1;
				}
				return maxVal + 1;
			} else {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error buscando PK : " + sql);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if (stm != null) {
				try { stm.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
	}

	public void closeConnection() throws Exception {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("No se ha podido cerrar la conexión a la BD");
			throw new Exception("Error al cerrar conexión a BD");
		} finally {
			conn = null;
		}
	}
}
