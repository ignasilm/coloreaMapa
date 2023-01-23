package es.ilopezma.coloreamapa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Soluci�n al Reto de Programacion de "El problema de N-Reinas" utilizando Vuelta atr�s
 * 
 * @author ilopezma
 *
 */
public class ColoreaMapa {

	public ColoreaMapa() {
		super();	
	}
	

	Map<String, Integer> coloreaEspanya(Map<String, List<String>> mapa) {
		
		LinkedHashMap<String, Integer> provinciaColores = new LinkedHashMap<String, Integer>();
		
		Set<String> listaProvincias = mapa.keySet();
		TreeSet provinciasOrdenadas = new TreeSet<String>(mapa.keySet());


		for (Object provincias : provinciasOrdenadas) {
			provinciaColores.put((String) provincias, null);
		}
		
		boolean estaResuelto = resolverColoreaMapa (mapa, 0, 4, provinciaColores);
		
		UtilsColoreaMapa.pintarProvincias(provinciaColores);
		
		return provinciaColores;
	}
	
	
	private boolean resolverColoreaMapa(Map<String, List<String>> mapa, int etapa, int numColores, LinkedHashMap<String, Integer> provinciaColores) {
		
		boolean esSolucion = false;
		
		//pasamos la linkedhashmap a un set para obtener el orden
        Set<String> provinciaColoresSet = provinciaColores.keySet();
 
        //convertios a array y buscamos la provincia actual
        String[] keyProvinciasArray = provinciaColoresSet.toArray(new String[provinciaColoresSet.size()]);
        String provinciaActual = keyProvinciasArray[etapa];
        
        //calculo posibles soluciones para la provincia actual
		List<Integer> candidatos = prepararCandidatos(mapa, provinciaActual, numColores, provinciaColores);
		Integer color = null;

		//recorremos las posibles soluciones hasta recorrerlas todas o encontrar una solucion
		Iterator<Integer> it = candidatos.iterator();
		while (it.hasNext() && !esSolucion) {
			
			//asignamos el color como solucion
			color = it.next();
			provinciaColores.put(provinciaActual, color);
			
			//si ya es la solucion final, hemos terminado
			if(totalmentePintado(provinciaColores)) {
				esSolucion = true;

			//Si no es la solucion final, nos llamamos recursivamente para la siguiente provincia
			} else {
				esSolucion = resolverColoreaMapa(mapa, etapa +1, 4, provinciaColores);
				//Si al volver no es solucion, deshacemos la asignacion de solucion para probar la siguiente
				if (!esSolucion) {
					provinciaColores.put(provinciaActual, null);
				}
			}
		}
		
		return esSolucion;
	}


	/** comprueba si ya esta completamente pintado si no hay ninguna provincia sin color asignado
	 * 
	 * @param provinciaColores
	 * @return
	 */
	private boolean totalmentePintado(LinkedHashMap<String, Integer> provinciaColores) {
		
		boolean sinNull = true;
		
		for (Integer color : provinciaColores.values()) {
			if (color == null) {
				sinNull = false;
			}
		}
		return sinNull ;
	}


	private List<Integer> prepararCandidatos(Map<String, List<String>> mapa, String provinciaActual, int numColores, LinkedHashMap<String, Integer> provinciaColores) {

		List<Integer> posiblesColores = new ArrayList<Integer>();

		List<String> listaColindantes = mapa.get(provinciaActual);
		//llenamos la lista de posibles colores
		for (int i = 1; i <= numColores; i++) {
			posiblesColores.add(i);			
		}
		
		//recorremos la listaColindantes para eliminar los colores que no son posibles porque se usan en las provincias colindantes
		for (String provincia : listaColindantes) {
			if (posiblesColores.contains(provinciaColores.get(provincia))) {
				posiblesColores.remove(provinciaColores.get(provincia));
			}
		}
		
		return posiblesColores ;
	}
}
