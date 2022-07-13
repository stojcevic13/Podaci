package zadatak4c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KlubManager {

	private List<Klub> klubovi;
	private Map<String, Klub> mapKlubovi;

	private String kluboviFIle;

	public KlubManager(String kluboviFile) {
		this.kluboviFIle = kluboviFile;
		this.klubovi = new ArrayList<Klub>();
		this.mapKlubovi = new HashMap<String, Klub>();
		loadData();
	}

   

	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.kluboviFIle), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
				System.out.println(linija);
				Klub klub = parseKlub(linija);
				this.klubovi.add(klub);
				this.mapKlubovi.put(klub.getId(), klub);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Klub parseKlub(String linija) {
		// # ID_KLUBA; NAZIV
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		String naziv = tokens[1].trim();
		Klub klub = new Klub(id, naziv);
		return klub;
	}
	


	
	
	public Map<String, Klub> getMapKlubovi() {
		return mapKlubovi;
	}
	
	
	public List<Klub> getKlubovi() {
		return klubovi;
	}
	
}
