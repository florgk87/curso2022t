package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for ErrorMessages utility class.
 */
public class ErrorMessagesTest {

	@Test
	void testMensajes_singlePlaceholder() {
		String result = ErrorMessages.mensajes("El campo ? es obligatorio", new String[]{"nombre"});
		assertEquals("El campo nombre es obligatorio", result);
	}

	@Test
	void testMensajes_multiplePlaceholders() {
		String result = ErrorMessages.mensajes(
				ErrorMessages.PROERR_003,
				new String[]{"Nombre", "5", "50"});
		assertEquals("La longitud de Nombre ha de estar entre 5 y 50", result);
	}

	@Test
	void testMensajes_noPlaceholders() {
		String result = ErrorMessages.mensajes("Mensaje sin placeholder", new String[]{});
		assertEquals("Mensaje sin placeholder", result);
	}

	@Test
	void testMensajes_PROERR_004() {
		String result = ErrorMessages.mensajes(
				ErrorMessages.PROERR_004,
				new String[]{"Precio", "0", "100"});
		assertEquals("El rango de Precio ha de estar entre 0 y 100", result);
	}

	@Test
	void testMensajes_PROERR_016() {
		String result = ErrorMessages.mensajes(
				ErrorMessages.PROERR_016,
				new String[]{"AB123"});
		assertEquals("El ID de Producto AB123 no existe", result);
	}

	@Test
	void testConstants_notNull() {
		assertNotNull(ErrorMessages.PROERR_001);
		assertNotNull(ErrorMessages.PROERR_002);
		assertNotNull(ErrorMessages.PROERR_003);
		assertNotNull(ErrorMessages.PROERR_004);
		assertNotNull(ErrorMessages.PROERR_005);
		assertNotNull(ErrorMessages.PROERR_006);
		assertNotNull(ErrorMessages.PROERR_007);
		assertNotNull(ErrorMessages.PROERR_008);
		assertNotNull(ErrorMessages.PROERR_009);
		assertNotNull(ErrorMessages.PROERR_010);
		assertNotNull(ErrorMessages.PROERR_011);
		assertNotNull(ErrorMessages.PROERR_012);
		assertNotNull(ErrorMessages.PROERR_013);
		assertNotNull(ErrorMessages.PROERR_014);
		assertNotNull(ErrorMessages.PROERR_015);
		assertNotNull(ErrorMessages.PROERR_016);
		assertNotNull(ErrorMessages.PROERR_017);
		assertNotNull(ErrorMessages.PROERR_018);
		assertNotNull(ErrorMessages.PROERR_019);
		assertNotNull(ErrorMessages.PROERR_020);
		assertNotNull(ErrorMessages.PROERR_027);
	}
}
