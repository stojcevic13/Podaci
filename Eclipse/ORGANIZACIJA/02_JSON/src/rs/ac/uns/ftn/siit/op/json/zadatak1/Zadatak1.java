package rs.ac.uns.ftn.siit.op.json.zadatak1;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Zadatak1 {

	static final String JSON_FILE = "resources/Bookstore.json";
	
	static Bookstore bookstore = new Bookstore();
	
	public static void main(String[] args) {
		loadData();
	}

	private static void loadData() {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		try {
			bookstore = mapper.readValue(new File(JSON_FILE), Bookstore.class);
			
			System.out.println(bookstore);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
