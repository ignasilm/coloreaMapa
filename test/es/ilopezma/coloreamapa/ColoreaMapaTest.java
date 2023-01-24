package es.ilopezma.coloreamapa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

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
		ColoreaMapa coloreaMapa = new ColoreaMapa();
		assertNotNull(coloreaMapa);
	}

	
	@Test
	@Order(2)
	@DisplayName("Recursivo: Leer json")
	void testLeerJson() {
		Map<String, List<String>> mapa = UtilsColoreaMapa.cargarMapa(null);
		assertNotNull(mapa);
	}

	@Test
	@Order(3)
	@DisplayName("Recursivo: llamada coloreaEspana ordenado alfabetico")
	void testColoreaMapa() {
		Map<String, List<String>> mapa = UtilsColoreaMapa.cargarMapa(null);
		ColoreaMapa coloreaMapa = new ColoreaMapa();
		Map<String, Integer> solucion = coloreaMapa.coloreaEspanya(mapa);
		
		assertNotNull(solucion);
	}

	@Test
	@Order(4)
	@DisplayName("Recursivo: llamada coloreaEspana ordenado por colindantes desde Madrid")
	void testColoreaMapaColindantesMadrid() {
		Map<String, List<String>> mapa = UtilsColoreaMapa.cargarMapa(null);
		ColoreaMapa coloreaMapa = new ColoreaMapa();
		Map<String, Integer> solucion = coloreaMapa.coloreaEspanyaColindantesMadrid(mapa);
		
		assertNotNull(solucion);
	}

	@Test
	@Order(5)
	@DisplayName("Recursivo: llamada coloreaEspana ordenado por colindantes desde Gerona")
	void testColoreaMapaColindantesGerona() {
		Map<String, List<String>> mapa = UtilsColoreaMapa.cargarMapa(null);
		ColoreaMapa coloreaMapa = new ColoreaMapa();
		Map<String, Integer> solucion = coloreaMapa.coloreaEspanyaColindantesGerona(mapa);
		
		assertNotNull(solucion);
	}

}
