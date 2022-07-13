package zadatak4c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class VezaKlubLigaManager {
	
	private KlubManager klubManager;
	private LigaManager ligaManager;
	private String vezaFile;

	public VezaKlubLigaManager(KlubManager klubManager, LigaManager ligaManager, String vezaFile) {
		this.klubManager = klubManager;
		this.ligaManager = ligaManager;
		this.vezaFile = vezaFile;
		loadData();
	}
	
	
	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.vezaFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				povezi(linija);
				
				
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}


	private void povezi(String linija) {
		String[] tokens = linija.split(";");
//		String kursId = tokens[0].trim();
//		String ucenikId = tokens[1].trim();
		Klub klub = this.klubManager.getMapKlubovi().get(tokens[0].trim());
		Liga liga = this.ligaManager.getMapLige().get(tokens[1].trim());
		
		klub.getLige().add(liga);
		liga.getKlubovi().add(klub);
	}

}
