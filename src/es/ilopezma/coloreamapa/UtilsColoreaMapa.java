package es.ilopezma.coloreamapa;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class UtilsColoreaMapa {

	public static Map<String, List<String>> cargarMapa(String fileName) {
		
		Map<String, List<String>> mapa = null;
		
		//TODO https://mkyong.com/java/json-simple-how-to-parse-json/
		
		return mapa;
		
	}
	
	public static void pintarTablero(int[][] tablero) {
		
		int N = tablero.length;
		
		StringBuilder mensaje = new StringBuilder();
		mensaje.append("\n\nEstado actual del tablero: ");

		for (int i = 0; i < N; i++) {
			mensaje.append(" \n").append(StringUtils.repeat("-", N*5)).append("\n");
			for (int j = 0; j < N; j++) {
				mensaje.append("|").append(StringUtils.leftPad(String.valueOf(tablero[i][j]), 4));
			}
		}
		mensaje.append(" \n").append(StringUtils.repeat("-", N*5)).append("\n");

		System.out.println(mensaje.toString() );

	}

}
