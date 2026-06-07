package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Categoria domain class.
 */
public class CategoriaTest {

	private Categoria categoria;

	@BeforeEach
	void setUp() {
		categoria = new Categoria();
	}

	// --- isValid ---

	@Test
	void testIsValid_defaultState() {
		assertFalse(categoria.isValid());
	}

	@Test
	void testIsValid_withIdOnly() {
		categoria.setId_categoria(1);
		assertFalse(categoria.isValid());
	}

	// --- id_categoria getter/setter ---

	@Test
	void testGetSetIdCategoria() {
		categoria.setId_categoria(5);
		assertEquals(5, categoria.getId_categoria());
	}

	@Test
	void testGetSetIdCategoria_zero() {
		categoria.setId_categoria(0);
		assertEquals(0, categoria.getId_categoria());
	}

	// --- cat_descripcion getter/setter ---

	@Test
	void testGetSetCatDescripcion() {
		categoria.setCat_descripcion("Test description");
		assertEquals("Test description", categoria.getCat_descripcion());
	}

	@Test
	void testGetSetCatDescripcion_null() {
		categoria.setCat_descripcion(null);
		assertNull(categoria.getCat_descripcion());
	}

	// --- equals ---

	@Test
	void testEquals_same() {
		assertEquals(categoria, categoria);
	}

	@Test
	void testEquals_null() {
		assertNotEquals(null, categoria);
	}

	@Test
	void testEquals_differentClass() {
		assertNotEquals("string", categoria);
	}

	@Test
	void testEquals_equalObjects() {
		Categoria c1 = new Categoria();
		c1.setId_categoria(1);
		c1.setCat_descripcion("desc");

		Categoria c2 = new Categoria();
		c2.setId_categoria(1);
		c2.setCat_descripcion("desc");

		assertEquals(c1, c2);
	}

	@Test
	void testEquals_differentId() {
		Categoria c1 = new Categoria();
		c1.setId_categoria(1);

		Categoria c2 = new Categoria();
		c2.setId_categoria(2);

		assertNotEquals(c1, c2);
	}

	@Test
	void testEquals_differentDescripcion() {
		Categoria c1 = new Categoria();
		c1.setCat_descripcion("desc1");

		Categoria c2 = new Categoria();
		c2.setCat_descripcion("desc2");

		assertNotEquals(c1, c2);
	}

	@Test
	void testEquals_nullDescripcion() {
		Categoria c1 = new Categoria();
		c1.setCat_descripcion(null);

		Categoria c2 = new Categoria();
		c2.setCat_descripcion("desc");

		assertNotEquals(c1, c2);
	}

	// --- hashCode ---

	@Test
	void testHashCode_equalObjects() {
		Categoria c1 = new Categoria();
		c1.setId_categoria(1);
		c1.setCat_descripcion("desc");

		Categoria c2 = new Categoria();
		c2.setId_categoria(1);
		c2.setCat_descripcion("desc");

		assertEquals(c1.hashCode(), c2.hashCode());
	}

	// --- toString ---

	@Test
	void testToString() {
		categoria.setId_categoria(3);
		categoria.setCat_descripcion("Electronics");

		String result = categoria.toString();
		assertTrue(result.contains("3"));
		assertTrue(result.contains("Electronics"));
	}

	// --- getTabla ---

	@Test
	void testGetTabla_returnsNull() {
		assertNull(categoria.getTabla());
	}
}
