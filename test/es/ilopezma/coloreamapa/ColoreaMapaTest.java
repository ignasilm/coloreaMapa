package es.ilopezma.coloreamapa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ColoreaMapaTest {

	@Test
	@Order(1)
	@DisplayName("Recursivo: Test basico")
	void test() {
		ColoreaMapa nreinas = new ColoreaMapa();
		assertNotNull(nreinas);
	}

	
	@Test
	@Order(2)
	@DisplayName("Recursivo: Resolucion 4 reinas")
	void testResolucion4Reinas() {
		ColoreaMapa nreinas = new ColoreaMapa();
		nreinas.colocaReinas(4);
		assertNotNull(nreinas);
	}

	@Test
	@Order(3)
	@DisplayName("Recursivo: Resolucion 5 reinas")
	void testResolucion5Reinas() {
		ColoreaMapa nreinas = new ColoreaMapa();
		nreinas.colocaReinas(5);
		assertNotNull(nreinas);
	}

	@Test
	@Order(4)
	@DisplayName("Recursivo: Resolucion 6 reinas")
	void testResolucion6Reinas() {
		ColoreaMapa nreinas = new ColoreaMapa();
		nreinas.colocaReinas(6);
		assertNotNull(nreinas);
	}

	@Test
	@Order(5)
	@DisplayName("Recursivo: Resolucion 7 reinas")
	void testResolucion7Reinas() {
		ColoreaMapa nreinas = new ColoreaMapa();
		nreinas.colocaReinas(7);
		assertNotNull(nreinas);
	}
	
	@Test
	@Order(6)
	@DisplayName("Recursivo: Resolucion 8 reinas")
	void testResolucion8Reinas() {
		ColoreaMapa nreinas = new ColoreaMapa();
		nreinas.colocaReinas(8);
		assertNotNull(nreinas);
	}
	
}
