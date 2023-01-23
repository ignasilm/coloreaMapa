package es.ilopezma.coloreamapa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class UtilsColoreaMapa {

	public static Map<String, List<String>> cargarMapa(String fileName) {
		
		Map<String, List<String>> mapa = null;
		String nomProvincia = null;
		JSONArray colindantes = null;
		String nomColindante = null;
		ArrayList<String> mapColindante = new ArrayList<String>();
		String linea = null;
		StringBuilder sb = new StringBuilder();
		
		String jsonString = "{\"areas\":[{\"nombre\":\"Álava\",\"limita_con\":[\"Burgos\",\"Guipúzcoa\",\"Navarra\",\"La Rioja\",\"Vizcaya\"]},{\"nombre\":\"Albacete\",\"limita_con\":[\"Alicante\",\"Ciudad Real\",\"Cuenca\",\"Granada\",\"Jaén\",\"Murcia\",\"Valencia\"]},{\"nombre\":\"Alicante\",\"limita_con\":[\"Albacete\",\"Murcia\",\"Valencia\"]},{\"nombre\":\"Almería\",\"limita_con\":[\"Granada\",\"Murcia\"]},{\"nombre\":\"Asturias\",\"limita_con\":[\"Cantabria\",\"León\",\"Lugo\"]},{\"nombre\":\"Ávila\",\"limita_con\":[\"Cáceres\",\"Madrid\",\"Salamanca\",\"Segovia\",\"Toledo\",\"Valladolid\"]},{\"nombre\":\"Badajoz\",\"limita_con\":[\"Cáceres\",\"Ciudad Real\",\"Córdoba\",\"Huelva\",\"Sevilla\",\"Toledo\"]},{\"nombre\":\"Barcelona\",\"limita_con\":[\"Gerona\",\"Lérida\",\"Tarragona\"]},{\"nombre\":\"Burgos\",\"limita_con\":[\"Álava\",\"Cantabria\",\"Palencia\",\"La Rioja\",\"Segovia\",\"Soria\",\"Valladolid\",\"Vizcaya\"]},{\"nombre\":\"Cáceres\",\"limita_con\":[\"Ávila\",\"Badajoz\",\"Salamanca\",\"Toledo\"]},{\"nombre\":\"Cádiz\",\"limita_con\":[\"Huelva\",\"Málaga\",\"Sevilla\"]},{\"nombre\":\"Cantabria\",\"limita_con\":[\"Asturias\",\"Burgos\",\"León\",\"Palencia\",\"Vizcaya\"]},{\"nombre\":\"Castellón\",\"limita_con\":[\"Tarragona\",\"Teruel\",\"Valencia\"]},{\"nombre\":\"Ciudad Real\",\"limita_con\":[\"Albacete\",\"Badajoz\",\"Córdoba\",\"Cuenca\",\"Jaén\",\"Toledo\"]},{\"nombre\":\"Córdoba\",\"limita_con\":[\"Badajoz\",\"Ciudad Real\",\"Granada\",\"Jaén\",\"Málaga\",\"Sevilla\"]},{\"nombre\":\"La Coruña\",\"limita_con\":[\"Lugo\",\"Pontevedra\"]},{\"nombre\":\"Cuenca\",\"limita_con\":[\"Albacete\",\"Ciudad Real\",\"Guadalajara\",\"Madrid\",\"Teruel\",\"Toledo\",\"Valencia\"]},{\"nombre\":\"Gerona\",\"limita_con\":[\"Barcelona\",\"Lérida\"]},{\"nombre\":\"Granada\",\"limita_con\":[\"Albacete\",\"Almería\",\"Córdoba\",\"Jaén\",\"Málaga\",\"Murcia\"]},{\"nombre\":\"Guadalajara\",\"limita_con\":[\"Cuenca\",\"Madrid\",\"Segovia\",\"Soria\",\"Teruel\",\"Zaragoza\"]},{\"nombre\":\"Guipúzcoa\",\"limita_con\":[\"Álava\",\"Navarra\",\"Vizcaya\"]},{\"nombre\":\"Huelva\",\"limita_con\":[\"Badajoz\",\"Cádiz\",\"Sevilla\"]},{\"nombre\":\"Huesca\",\"limita_con\":[\"Lérida\",\"Navarra\",\"Zaragoza\"]},{\"nombre\":\"Islas Baleares\",\"limita_con\":[]},{\"nombre\":\"Jaén\",\"limita_con\":[\"Albacete\",\"Ciudad Real\",\"Córdoba\",\"Granada\"]},{\"nombre\":\"León\",\"limita_con\":[\"Asturias\",\"Cantabria\",\"Lugo\",\"Orense\",\"Palencia\",\"Valladolid\",\"Zamora\"]},{\"nombre\":\"Lérida\",\"limita_con\":[\"Barcelona\",\"Gerona\",\"Huesca\",\"Tarragona\",\"Zaragoza\"]},{\"nombre\":\"Lugo\",\"limita_con\":[\"Asturias\",\"La Coruña\",\"León\",\"Orense\",\"Pontevedra\"]},{\"nombre\":\"Madrid\",\"limita_con\":[\"Ávila\",\"Cuenca\",\"Guadalajara\",\"Segovia\",\"Toledo\"]},{\"nombre\":\"Málaga\",\"limita_con\":[\"Cádiz\",\"Córdoba\",\"Granada\",\"Sevilla\"]},{\"nombre\":\"Murcia\",\"limita_con\":[\"Albacete\",\"Alicante\",\"Almería\",\"Granada\"]},{\"nombre\":\"Navarra\",\"limita_con\":[\"Álava\",\"Guipúzcoa\",\"Huesca\",\"La Rioja\",\"Zaragoza\"]},{\"nombre\":\"Orense\",\"limita_con\":[\"León\",\"Lugo\",\"Pontevedra\",\"Zamora\"]},{\"nombre\":\"Palencia\",\"limita_con\":[\"Burgos\",\"Cantabria\",\"León\",\"Valladolid\"]},{\"nombre\":\"Las Palmas\",\"limita_con\":[\"Santa Cruz de Tenerife\"]},{\"nombre\":\"Pontevedra\",\"limita_con\":[\"La Coruña\",\"Lugo\",\"Orense\"]},{\"nombre\":\"La Rioja\",\"limita_con\":[\"Álava\",\"Burgos\",\"Navarra\",\"Soria\",\"Zaragoza\"]},{\"nombre\":\"Salamanca\",\"limita_con\":[\"Ávila\",\"Cáceres\",\"Valladolid\",\"Zamora\"]},{\"nombre\":\"Segovia\",\"limita_con\":[\"Ávila\",\"Burgos\",\"Guadalajara\",\"Madrid\",\"Soria\",\"Valladolid\"]},{\"nombre\":\"Sevilla\",\"limita_con\":[\"Badajoz\",\"Cádiz\",\"Córdoba\",\"Huelva\",\"Málaga\"]},{\"nombre\":\"Soria\",\"limita_con\":[\"Burgos\",\"Guadalajara\",\"La Rioja\",\"Segovia\",\"Zaragoza\"]},{\"nombre\":\"Tarragona\",\"limita_con\":[\"Barcelona\",\"Castellón\",\"Lérida\",\"Teruel\",\"Zaragoza\"]},{\"nombre\":\"Santa Cruz de Tenerife\",\"limita_con\":[\"Las Palmas\"]},{\"nombre\":\"Teruel\",\"limita_con\":[\"Castellón\",\"Cuenca\",\"Guadalajara\",\"Tarragona\",\"Valencia\",\"Zaragoza\"]},{\"nombre\":\"Toledo\",\"limita_con\":[\"Ávila\",\"Badajoz\",\"Cáceres\",\"Ciudad Real\",\"Cuenca\",\"Madrid\"]},{\"nombre\":\"Valencia\",\"limita_con\":[\"Albacete\",\"Alicante\",\"Castellón\",\"Cuenca\",\"Teruel\"]},{\"nombre\":\"Valladolid\",\"limita_con\":[\"Ávila\",\"Burgos\",\"León\",\"Palencia\",\"Salamanca\",\"Segovia\",\"Zamora\"]},{\"nombre\":\"Vizcaya\",\"limita_con\":[\"Álava\",\"Burgos\",\"Cantabria\",\"Guipúzcoa\"]},{\"nombre\":\"Zamora\",\"limita_con\":[\"León\",\"Orense\",\"Salamanca\",\"Valladolid\"]},{\"nombre\":\"Zaragoza\",\"limita_con\":[\"Guadalajara\",\"Huesca\",\"Lérida\",\"Navarra\",\"La Rioja\",\"Soria\",\"Tarragona\",\"Teruel\"]}]}";

		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Dev\\workspaceJavaLocal\\coloreaMapa\\mapas\\provincias.json");
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			linea = br.readLine();
			while (linea != null) {
				sb.append(linea);
				linea = br.readLine();
			}
			
			jsonString = sb.toString();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Se ha producido una excelcion al abrir el archivo " + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR: Se ha producido una excelcion al leer el archivo " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("ERROR: Se ha producido una excelcion la convertir un valor a Double " + e.getMessage());
		}  


		//https://github.com/stleary/JSON-java
		//http://theoryapp.com/parse-json-in-java/
		JSONObject json = new JSONObject(jsonString);
		JSONArray areas = json.getJSONArray("areas");
		mapa = new HashMap<String, List<String>>();
		for (Object provincia : areas) {
			nomProvincia = ((JSONObject)provincia).getString("nombre");
			System.out.println(nomProvincia);
			colindantes = ((JSONObject)provincia).getJSONArray("limita_con");
			mapColindante = new ArrayList<String>();
			for (Object provColindante : colindantes) {
				nomColindante = (String)provColindante;
				System.out.println("----" + nomColindante);
				mapColindante.add(nomColindante);
			}
			mapa.put(nomProvincia, mapColindante);
			
		}
		
		return mapa;
		
	}
	
	public static void pintarProvincias(Map<String, Integer> provinciaColores) {
		
		//pasamos la linkedhashmap a un set para obtener el orden
        Set<String> provinciaColoresSet = provinciaColores.keySet();
 
        //convertios a array y buscamos la provincia actual
        String[] keyProvinciasArray = provinciaColoresSet.toArray(new String[provinciaColoresSet.size()]);

		StringBuilder mensaje = new StringBuilder();
		mensaje.append("\n\nEstado actual del mapa: ").append("\n\n");

        for (String provincia : keyProvinciasArray) {
        	mensaje.append(provincia).append(" - ").append(provinciaColores.get(provincia)).append("\n");
		}
		
        System.out.println(mensaje.toString() );

	}

}
