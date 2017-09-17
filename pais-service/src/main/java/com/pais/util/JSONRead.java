package com.pais.util;

import com.pais.model.Pais;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONRead {
	public static void main(String[] args) {

		List<Pais> paises = getDataPaises();
		for(Pais pais:paises) {
			System.out.println(pais);
		}
	}
	
	public static List<Pais> getDataPaises() {

		JSONParser parser = new JSONParser();
		List<Pais> paises = new ArrayList<Pais>();
		try {

			Object obj = parser.parse(new FileReader("src/main/resources/paises.json"));

			JSONObject jsonObject = (JSONObject) obj;
			JSONArray tags = (JSONArray) jsonObject.get("paises");
			Pais pais;
			for (int i=0; i<tags.size(); i++){
				JSONObject jsonObj = (JSONObject)tags.get(i);
				pais = new Pais();
				pais.setNombre(jsonObj.get("nombre").toString());
				pais.setCapital(jsonObj.get("capital").toString());
				pais.setMoneda(jsonObj.get("moneda").toString());
				pais.setIdioma(jsonObj.get("idioma").toString());
				paises.add(pais);
			}			
		} catch (Exception e) {
			System.out.println("getDataPaises - error: " + e.getMessage());
		}
		return paises;
	}
}
