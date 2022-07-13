package manager.veze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//import entiteti.Jezik;
import entiteti.Kurs;
//import entiteti.osobe.Predavac;
import entiteti.osobe.Ucenik;
import manager.JezikManager;
import manager.KursManager;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

public class VezaKursUcenikManager {

	private UcenikManager ucenikManager;
	private KursManager kursManager;
	private String vezaFile;

	public VezaKursUcenikManager(UcenikManager ucenikManager, KursManager kursManager, String vezaFile) {
		this.ucenikManager = ucenikManager;
		this.kursManager = kursManager;
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
				
				
//				Kurs kurs = parseKurs(linija);
//				this.kursevi.add(kurs);
//				this.mapKursevi.put(kurs.getId(), kurs);
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
		Kurs kurs = this.kursManager.getMapKursevi().get(tokens[0].trim());
		Ucenik uc = this.ucenikManager.getMapUcenici().get(tokens[1].trim());
		boolean polozen = Boolean.parseBoolean(tokens[2].trim());
		
		kurs.getUcenici().add(uc);
		
		if (polozen)
			uc.getPolozeniKursevi().add(kurs);
		else
			uc.getNepolozeniKursevi().add(kurs);
	}
	
	
	
	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.vezaFile), "utf-8"));

			out.println("# ID_KURSA; ID_UCENIKA; DA_LI_JE_POLOZIO");
			for (Kurs k : this.kursManager.getKursevi()) {
				for (Ucenik uc : k.getUcenici()) {
					if (uc.getPolozeniKursevi().contains(k)) 
						out.println(k.getId() + "; " + uc.getId() + "; true");
					else
						out.println(k.getId() + "; " + uc.getId() + "; false");
				}
			}

			out.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	
	
	
	public static void main(String[] args) {
		UcenikManager ucenikManager = new UcenikManager("./data/ucenici.txt");
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");

		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");

		
		VezaKursUcenikManager vezaKursUcenikManager = new VezaKursUcenikManager(ucenikManager, kursManager, "./data/veza-kurs-ucenik.txt");
		
		for (Ucenik uc : ucenikManager.getUcenici()) {
			System.out.println(uc);
		}
		
		for (Kurs k : kursManager.getKursevi()) {
			System.out.println(k);
		}
		
		vezaKursUcenikManager.saveData();
		
	}
	
	
	
	
	
	
}
