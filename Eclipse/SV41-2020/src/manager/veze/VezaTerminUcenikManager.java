package manager.veze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//import entiteti.Kurs;
import entiteti.TerminTesta;
//import entiteti.Test;
import entiteti.osobe.Ucenik;
import manager.JezikManager;
import manager.KursManager;
import manager.TerminManager;
import manager.TestManager;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

public class VezaTerminUcenikManager {
	
	private UcenikManager ucenikManager;
	private TerminManager terminManager;
	private String vezaTerminUcenikFile;

	public VezaTerminUcenikManager(UcenikManager ucenikManager, TerminManager terminManager, String vezaTerminUcenikFile) {
		this.ucenikManager = ucenikManager;
		this.terminManager = terminManager;
		this.vezaTerminUcenikFile = vezaTerminUcenikFile;
		loadData();
	}
	
	
	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.vezaTerminUcenikFile), "utf-8"));
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
		
		String idTermina = tokens[0].trim();
		String idUcenika = tokens[1].trim();
//		boolean ocijenjen = Boolean.parseBoolean(tokens[2].trim());

		TerminTesta termin = this.terminManager.getMapTermini().get(idTermina);
		Ucenik uc = this.ucenikManager.getMapUcenici().get(idUcenika);
		
		

			
		
		termin.getUcenici().add(uc);
		uc.getTermini().add(termin);
	}
	
	
	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.vezaTerminUcenikFile), "utf-8"));

			out.println("# ID_TERMINA; ID_UCENIKA");
			for (TerminTesta t : this.terminManager.getTermini()) {
				for (Ucenik uc : t.getUcenici()) {
					out.println(t.getId() + "; " + uc.getId());
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
		TestManager testManager = new TestManager(predavacManager, jezikManager, kursManager, "./data/testovi.txt");
		
		TerminManager terminManager = new TerminManager(predavacManager, testManager, kursManager, "./data/termini.txt");
		
		
		VezaTerminUcenikManager vezaTerminUcenikManager = new VezaTerminUcenikManager(ucenikManager, terminManager, "./data/veza-termin-ucenik.txt");
		
		for (Ucenik uc : ucenikManager.getUcenici()) {
			System.out.println(uc);
		}
		
		for (TerminTesta termin : terminManager.getTermini()) {
			System.out.println(termin);
		}
		
		vezaTerminUcenikManager.saveData();
		
	}
	

}
