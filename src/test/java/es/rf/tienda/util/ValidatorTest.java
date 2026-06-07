package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for Validator utility class.
 */
public class ValidatorTest {

	// --- isAlfanumeric ---

	@Test
	void testIsAlfanumeric_validAlphanumeric() {
		assertTrue(Validator.isAlfanumeric("abc123"));
		assertTrue(Validator.isAlfanumeric("ABC"));
		assertTrue(Validator.isAlfanumeric("999"));
	}

	@Test
	void testIsAlfanumeric_withSpecialChars() {
		assertFalse(Validator.isAlfanumeric("abc 123"));
		assertFalse(Validator.isAlfanumeric("abc@123"));
		assertFalse(Validator.isAlfanumeric("hello!"));
	}

	@Test
	void testIsAlfanumeric_empty() {
		assertFalse(Validator.isAlfanumeric(""));
	}

	// --- isVacio ---

	@Test
	void testIsVacio_null() {
		assertTrue(Validator.isVacio(null));
	}

	@Test
	void testIsVacio_empty() {
		assertTrue(Validator.isVacio(""));
	}

	@Test
	void testIsVacio_notEmpty() {
		assertFalse(Validator.isVacio("hello"));
		assertFalse(Validator.isVacio(" "));
	}

	// --- isCodigoProducto ---

	@Test
	void testIsCodigoProducto_valid() {
		assertTrue(Validator.isCodigoProducto("ABCDE"));
		assertTrue(Validator.isCodigoProducto("ZZZZZ"));
	}

	@Test
	void testIsCodigoProducto_invalidLowercase() {
		assertFalse(Validator.isCodigoProducto("abcde"));
		assertFalse(Validator.isCodigoProducto("Abcde"));
	}

	@Test
	void testIsCodigoProducto_invalidLength() {
		assertFalse(Validator.isCodigoProducto("ABCD"));
		assertFalse(Validator.isCodigoProducto("ABCDEF"));
	}

	@Test
	void testIsCodigoProducto_withNumbers() {
		assertFalse(Validator.isCodigoProducto("AB123"));
	}

	@Test
	void testIsCodigoProducto_nullOrEmpty() {
		assertFalse(Validator.isCodigoProducto(null));
		assertFalse(Validator.isCodigoProducto(""));
	}

	// --- isEmailValido ---

	@Test
	void testIsEmailValido_valid() {
		assertTrue(Validator.isEmailValido("user@example.com"));
		assertTrue(Validator.isEmailValido("test.user@domain.co.uk"));
		assertTrue(Validator.isEmailValido("name+tag@gmail.com"));
	}

	@Test
	void testIsEmailValido_invalid() {
		assertFalse(Validator.isEmailValido("userexample.com"));
		assertFalse(Validator.isEmailValido("user@"));
		assertFalse(Validator.isEmailValido("@example.com"));
		assertFalse(Validator.isEmailValido("user@example"));
	}

	@Test
	void testIsEmailValido_null() {
		assertFalse(Validator.isEmailValido(null));
	}

	// --- cumpleDNI ---

	@Test
	void testCumpleDNI_null() {
		assertFalse(Validator.cumpleDNI(null));
	}

	@Test
	void testCumpleDNI_wrongLength() {
		assertFalse(Validator.cumpleDNI("123"));
		assertFalse(Validator.cumpleDNI("12.345.678-ZZ"));
	}

	// --- cumpleRango int ---

	@Test
	void testCumpleRangoInt_inRange() {
		assertTrue(Validator.cumpleRango(5, 1, 10));
		assertTrue(Validator.cumpleRango(1, 1, 10));
		assertTrue(Validator.cumpleRango(10, 1, 10));
	}

	@Test
	void testCumpleRangoInt_outOfRange() {
		assertFalse(Validator.cumpleRango(0, 1, 10));
		assertFalse(Validator.cumpleRango(11, 1, 10));
	}

	// --- cumpleRango double ---

	@Test
	void testCumpleRangoDouble_inRange() {
		assertTrue(Validator.cumpleRango(5.5, 1, 10));
		assertTrue(Validator.cumpleRango(1.0, 1, 10));
		assertTrue(Validator.cumpleRango(10.0, 1, 10));
	}

	@Test
	void testCumpleRangoDouble_outOfRange() {
		assertFalse(Validator.cumpleRango(0.5, 1, 10));
		assertFalse(Validator.cumpleRango(10.1, 1, 10));
	}

	// --- cumpleLongitudMin ---

	@Test
	void testCumpleLongitudMin_meets() {
		assertTrue(Validator.cumpleLongitudMin("ab", 5));
	}

	@Test
	void testCumpleLongitudMin_null() {
		assertFalse(Validator.cumpleLongitudMin(null, 5));
	}

	// --- cumpleLongitudMax ---

	@Test
	void testCumpleLongitudMax_within() {
		assertTrue(Validator.cumpleLongitudMax("hi", 5));
		assertTrue(Validator.cumpleLongitudMax("hello", 5));
	}

	@Test
	void testCumpleLongitudMax_exceeds() {
		assertFalse(Validator.cumpleLongitudMax("exceeds", 5));
	}

	@Test
	void testCumpleLongitudMax_null() {
		assertFalse(Validator.cumpleLongitudMax(null, 5));
	}

	// --- cumpleLongitud ---

	@Test
	void testCumpleLongitud_null() {
		assertFalse(Validator.cumpleLongitud(null, 1, 10));
	}

	// --- esFechaValida ---

	@Test
	void testEsFechaValida_valid() {
		assertTrue(Validator.esFechaValida("01/01/2023"));
		assertTrue(Validator.esFechaValida("31/12/2020"));
	}

	@Test
	void testEsFechaValida_invalid() {
		assertFalse(Validator.esFechaValida("32/01/2023"));
		assertFalse(Validator.esFechaValida("01/13/2023"));
		assertFalse(Validator.esFechaValida("not-a-date"));
	}

	// --- esPasswordValida ---

	@Test
	void testEsPasswordValida_valid() {
		assertTrue(Validator.esPasswordValida("Abc123@xyz"));
		assertTrue(Validator.esPasswordValida("Pa$$w0rd"));
	}

	@Test
	void testEsPasswordValida_noUppercase() {
		assertFalse(Validator.esPasswordValida("abc123@xyz"));
	}

	@Test
	void testEsPasswordValida_noSpecialChar() {
		assertFalse(Validator.esPasswordValida("Abc12345"));
	}

	@Test
	void testEsPasswordValida_tooShort() {
		assertFalse(Validator.esPasswordValida("A1@b"));
	}

	// --- valDateMin ---

	@Test
	void testValDateMin_after() {
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.DAY_OF_YEAR, 5);
		Calendar min = Calendar.getInstance();
		assertTrue(Validator.valDateMin(fecha, min));
	}

	// --- valDateMax ---

	@Test
	void testValDateMax_before() {
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.DAY_OF_YEAR, -5);
		Calendar max = Calendar.getInstance();
		assertTrue(Validator.valDateMax(fecha, max));
	}

	@Test
	void testValDateMax_after() {
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.DAY_OF_YEAR, 5);
		Calendar max = Calendar.getInstance();
		assertFalse(Validator.valDateMax(fecha, max));
	}
}
