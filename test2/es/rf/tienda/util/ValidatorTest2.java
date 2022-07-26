package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ValidatorTest2 {	
	final String NOT_ALFANUMERIC = "jkhkhjk657675/&%/&%/?=)?)?cvx vcxcvxvc"; 
	final String ALFANUMERIC = "poiuytre wqasdf . hhhhh áéíóúàèìò , ; -"; 
	final String CODIGO_PRODUCTO_OK = "AB123"; 
	final String CODIGO_PRODUCTO_NO1 = "A123B"; 
	final String CODIGO_PRODUCTO_NO2 = "Ab123"; 
	final String CODIGO_PRODUCTO_NO3 = "A0123"; 
	final String CODIGO_PRODUCTO_FORMATO_ERR_NUM = "12345"; 
	final String CODIGO_PRODUCTO_FORMATO_ERR_ALF = "ABCDE"; 
	final String CODIGO_PRODUCTO_FORMATO_ERR_LON = "AB345678"; String STRING_NULA; 
	final String STRING_VACIA = ""; 
	final String CORREO_ELECTRONICO_CORRECTO = "migarcia@recursosformacion.com"; 
	final String CORREO_ELECTRONICO_ERRONEO_1 = "migarcia.recursosformacion.com"; 
	final String CORREO_ELECTRONICO_ERRONEO_2 = "migarcia@recursosformacion";
	
	final String NUMERO_DNI_OK = "12.345.678-Z"; 
	final String NUMERO_DNI_ERROR_LETRA = "12.345.678-A"; 
	final String NUMERO_DNI_ERROR_FORM_CORTO = "12.2.678-A"; 
	final String NUMERO_DNI_ERROR_FORM_CORTO2 = "122.678-A"; 
	final String NUMERO_DNI_ERROR_FORM_LARGO = "123.456.678-A"; 
	final String NUMERO_DNI_ERROR_FORM_ERR = "12345678A"; 
	final String NUMERO_DNI_ERROR_FORM_ERR2 = "12.345.678.A"; 
	final String CADENA1 = "a"; 
	final String CADENA5 = "Ansde"; 
	final String CADENA20 = "asmdjfoeirksndvieqaz"; 
	final String CADENA30 = "qazxswedcvfrtgbnhyujm,kiol.-ñp"; 
	final String CADENA50 = "poiuytrewqasdfghjklñmnbvcxzZXCVBNMÑLKJHGFDSAQWERTY"; 
	final String PHONENUMBER = "123456780";


	@Test
	public void testIsAlfanumericIS() {
		assertTrue(Validator.isAlfanumeric(ALFANUMERIC));
	}

	@Test
	void testIsAlfanumeric() {
		fail("Not yet implemented");
	}

	@Test
	void testIsCodigoProducto() {
		fail("Not yet implemented");
	}

	@Test
	void testIsVacio() {
		fail("Not yet implemented");
	}

	@Test
	void testCumplePhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testIsEmailValido() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleDNI() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleRangoIntIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleRangoDoubleIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleLongitudMin() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleLongitudMax() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleLongitud() {
		fail("Not yet implemented");
	}

	@Test
	void testValDateMin() {
		fail("Not yet implemented");
	}

	@Test
	void testValDateMax() {
		fail("Not yet implemented");
	}

	@Test
	void testValDateIgual() {
		fail("Not yet implemented");
	}

	@Test
	void testEsFechaValida() {
		fail("Not yet implemented");
	}

	@Test
	void testEsPasswordValida() {
		fail("Not yet implemented");
	}

}
