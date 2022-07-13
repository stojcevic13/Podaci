package zadatak4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IgracManager {
	private List<Igrac> igraci;
	private Map<String, Igrac> mapIgraci;

	private String igraciFile;
	private UgovorManager ugovorManager;

	public IgracManager(UgovorManager ugovorManager, String igraciFile) {
		this.ugovorManager = ugovorManager;
		this.igraciFile = igraciFile;
		this.igraci = new ArrayList<Igrac>();
		this.mapIgraci = new HashMap<String, Igrac>();
		loadData();
	}

   

	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.igraciFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Igrac igrac = parseIgrac(linija);
				this.igraci.add(igrac);
				this.mapIgraci.put(igrac.getId(), igrac);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Igrac parseIgrac(String linija) {
		//# ID_IGRACA; IME; PREZIME; ID_UGOVORA
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		String ime = tokens[1].trim();
		String prezime = tokens[2].trim();
		String idUgovora = tokens[3].trim();
		Igrac igrac = new Igrac(id, ime, prezime);
		igrac.setUgovor(this.ugovorManager.getMapUgovori().get(idUgovora));
		return igrac;
	}
	


	
	
	public Map<String, Igrac> getMapIgraci() {
		return mapIgraci;
	}
	
	
	public List<Igrac> getIgraci() {
		return igraci;
	}
}
