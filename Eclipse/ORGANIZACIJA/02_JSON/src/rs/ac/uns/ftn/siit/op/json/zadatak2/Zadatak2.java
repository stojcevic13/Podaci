package rs.ac.uns.ftn.siit.op.json.zadatak2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Zadatak2 {

	static final String CSV_FILE = "resources/countries_cities.csv";
	
	static List<Country> countries = new ArrayList<Country>();
	static Map<String, List<Country>> mapCountries = new HashMap<String, List<Country>>();
	
	
	public static void main(String[] args) {
		
		loadData();
		createMapCountries();
		saveData();
		
	}


	private static void saveData() {
		
		for (String continent : mapCountries.keySet()) {
			
			JsonFactory jsonFactory = new JsonFactory();
			try {
				JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File("resources/" + continent + ".json"), JsonEncoding.UTF8)
						.useDefaultPrettyPrinter();
				
				jsonGenerator.writeStartObject(); // {
				jsonGenerator.writeStringField("continent", continent); // "continent" : "Africa"
				
				jsonGenerator.writeArrayFieldStart("countries");
				for (Country country : mapCountries.get(continent)) {
					jsonGenerator.writeStartObject();
					
					jsonGenerator.writeStringField("countryName", country.getCountryName());
					jsonGenerator.writeStringField("capitalName", country.getCapitalName());
					jsonGenerator.writeStringField("capitalLatitude", country.getCapitalLatitude());
					jsonGenerator.writeStringField("capitalLongitude", country.getCapitalLongitude());
					jsonGenerator.writeStringField("countryCode", country.getCountryCode());
					jsonGenerator.writeStringField("continentName", country.getContientName());
					
					jsonGenerator.writeEndObject();
				}
				jsonGenerator.writeEndArray();
				
				jsonGenerator.writeEndObject(); // }
				jsonGenerator.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}


	private static void createMapCountries() {
		for (Country country : countries) {
			if (!mapCountries.containsKey(country.getContientName()))
				mapCountries.put(country.getContientName(), new ArrayList<Country>());
			mapCountries.get(country.getContientName()).add(country);
		}
	}


	private static void loadData() {

		try(Reader reader = new FileReader(CSV_FILE)){
			
			CsvToBean<Country> csvToBean = new CsvToBeanBuilder<Country>(reader)
					.withSeparator(',').withType(Country.class).withSkipLines(1).build();
			
			countries = csvToBean.parse();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
