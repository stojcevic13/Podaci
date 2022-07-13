package zadatak4b;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UgovorManager {
	
	private List<Ugovor> ugovori;
	private Map<String, Ugovor> mapUgovori;

	private String ugovoriFile;

	public UgovorManager(String ugovoriFIle) {
		this.ugovoriFile = ugovoriFIle;
		this.ugovori = new ArrayList<Ugovor>();
		this.mapUgovori = new HashMap<String, Ugovor>();
		loadData();
	}

   

	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.ugovoriFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
				System.out.println(linija);
				Ugovor igrac = parseUgovor(linija);
				this.ugovori.add(igrac);
				this.mapUgovori.put(igrac.getId(), igrac);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Ugovor parseUgovor(String linija) {
		// # ID_UGOVORA; GODINA_OD; GODINA_DO; PLATA
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		int godinaOd = Integer.parseInt(tokens[1].trim());
		int godinaDo = Integer.parseInt(tokens[2].trim());
		int plata = Integer.parseInt(tokens[3].trim());
		Ugovor ugovor = new Ugovor(id, godinaOd, godinaDo, plata);
		return ugovor;
	}
	


	
	
	public Map<String, Ugovor> getMapUgovori() {
		return mapUgovori;
	}
	
	
	public List<Ugovor> getUgovori() {
		return ugovori;
	}

}
