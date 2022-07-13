package zadatak4c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LigaManager {
	
	private List<Liga> lige;
	private Map<String, Liga> mapLige;

	private String ligeFile;

	public LigaManager(String ligeFile) {
		this.ligeFile = ligeFile;
		this.lige = new ArrayList<Liga>();
		this.mapLige = new HashMap<String, Liga>();
		loadData();
	}

   

	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.ligeFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
				System.out.println(linija);
				Liga liga = parseLiga(linija);
				this.lige.add(liga);
				this.mapLige.put(liga.getId(), liga);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Liga parseLiga(String linija) {
		// # ID_KLUBA; NAZIV
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		String naziv = tokens[1].trim();
		Liga liga = new Liga(id, naziv);
		return liga;
	}
	


	
	
	public Map<String, Liga> getMapLige() {
		return mapLige;
	}
	
	
	public List<Liga> getLige() {
		return lige;
	}

}
