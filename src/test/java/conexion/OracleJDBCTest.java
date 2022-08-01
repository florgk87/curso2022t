package conexion;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OracleJDBCTest {

	
//	private static Conection conn;
	
	private static OracleJDBC ojdbc;
	
	public final static String CLAVE_1 = "AR";
	public final static String TEXTO_1 = "Argentina";
	public final static String REGION_1 = "2";
	
	public static String INSERT_1;
	public final static String SELECT_G = "SELECT * FROM COUNTRIES WHERE ";
	public final static String SELECT_COUNT = "SELECT COUNT(*) as contador FROM COUNTRIES WHERE";	
	public final static String SELECT_1 = "SELECT * FROM COUNTRIES";
	
	


	@BeforeAll
	public static void inicio() throws SQLException, Exception {
		ojdbc = OracleJDBC.getInstance();
		
		INSERT_1 = "INSERT INTO COUNTRIES VALUES ( '"+ CLAVE_1 + "','" + TEXTO_1 + "'," + REGION_1 + ")";
		int filas = ojdbc.ejecutar("DELETE COUNTRIES WHERE COUNTRY_ID LIKE '@_' ");
	
	// prueba elimino Canada: CA	Canada	2
	}
	

//	@Test
//	public void listado() throws SQLException, Exception  {
//		Resultset rs = ojdbc.ejecutarQuery(SELECT_1);
//	}
	
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ojdbc.closeConnection();
	}	
	
	@Test
	public void fin() throws SQLException, Exception  {
		ojdbc.closeConnection();
	}
	
	
}
