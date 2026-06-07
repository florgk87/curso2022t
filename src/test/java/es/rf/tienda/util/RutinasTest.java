package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for Rutinas utility class.
 */
public class RutinasTest {

	// --- convierteACalendar ---

	@Test
	void testConvierteACalendar_validDate() {
		Calendar result = Rutinas.convierteACalendar("15/03/2023");
		assertNotNull(result);
		assertEquals(15, result.get(Calendar.DAY_OF_MONTH));
		assertEquals(Calendar.MARCH, result.get(Calendar.MONTH));
		assertEquals(2023, result.get(Calendar.YEAR));
	}

	@Test
	void testConvierteACalendar_invalidDate() {
		Calendar result = Rutinas.convierteACalendar("not-a-date");
		assertNull(result);
	}

	@Test
	void testConvierteACalendar_anotherValidDate() {
		Calendar result = Rutinas.convierteACalendar("01/01/2000");
		assertNotNull(result);
		assertEquals(1, result.get(Calendar.DAY_OF_MONTH));
		assertEquals(Calendar.JANUARY, result.get(Calendar.MONTH));
		assertEquals(2000, result.get(Calendar.YEAR));
	}

	// --- convierteAString ---

	@Test
	void testConvierteAString() {
		Calendar cal = Calendar.getInstance();
		cal.set(2023, Calendar.MARCH, 15);
		String result = Rutinas.convierteAString(cal);
		assertEquals("15/03/2023", result);
	}

	@Test
	void testConvierteAString_newYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(2000, Calendar.JANUARY, 1);
		String result = Rutinas.convierteAString(cal);
		assertEquals("01/01/2000", result);
	}

	// --- addCampo (double) ---

	@Test
	void testAddCampoDouble_positiveValue() {
		String result = Rutinas.addCampo("", "precio", 10.0, ",");
		assertTrue(result.contains("precio"));
		assertTrue(result.contains("10"));
	}

	@Test
	void testAddCampoDouble_zeroValue() {
		String result = Rutinas.addCampo("", "precio", 0.0, ",");
		assertEquals("", result);
	}

	@Test
	void testAddCampoDouble_negativeValue() {
		String result = Rutinas.addCampo("", "precio", -5.0, ",");
		assertEquals("", result);
	}

	// --- addCampo (String) ---

	@Test
	void testAddCampoString_nonEmpty() {
		String result = Rutinas.addCampo("", "nombre", "test", ",");
		assertTrue(result.contains("nombre"));
		assertTrue(result.contains("test"));
	}

	@Test
	void testAddCampoString_null() {
		String result = Rutinas.addCampo("", "nombre", (String) null, ",");
		assertEquals("", result);
	}

	@Test
	void testAddCampoString_empty() {
		String result = Rutinas.addCampo("", "nombre", "", ",");
		assertEquals("", result);
	}

	// --- addSalida (int) ---

	@Test
	void testAddSalidaInt() {
		String result = Rutinas.addSalida("", "cantidad", 42, ",");
		assertTrue(result.contains("42"));
	}

	// --- addSalida (double) ---

	@Test
	void testAddSalidaDouble() {
		String result = Rutinas.addSalida("", "precio", 9.99, ",");
		assertTrue(result.contains("9.99"));
	}

	// --- addSalida (long) ---

	@Test
	void testAddSalidaLong() {
		String result = Rutinas.addSalida("", "total", 100L, ",");
		assertTrue(result.contains("100"));
	}

	// --- addSalida (String) ---

	@Test
	void testAddSalidaString() {
		String result = Rutinas.addSalida("", "nombre", "valor", ",");
		assertTrue(result.contains("'valor'"));
	}

	// --- addSalidaSencilla ---

	@Test
	void testAddSalidaSencilla_emptyStart() {
		String result = Rutinas.addSalidaSencilla("", "campo", "val", ",");
		assertTrue(result.contains("campo"));
		assertTrue(result.contains("val"));
	}

	@Test
	void testAddSalidaSencilla_withExistingContent() {
		String result = Rutinas.addSalidaSencilla("existing", "campo", "val", "AND");
		assertTrue(result.contains("AND"));
		assertTrue(result.contains("campo"));
	}

	@Test
	void testAddSalidaSencilla_nullFieldName() {
		String result = Rutinas.addSalidaSencilla("", null, "val", ",");
		assertTrue(result.contains("val"));
		assertFalse(result.contains("="));
	}

	@Test
	void testAddSalidaSencilla_emptyFieldName() {
		String result = Rutinas.addSalidaSencilla("", "", "val", ",");
		assertTrue(result.contains("val"));
		assertFalse(result.contains("="));
	}
}
