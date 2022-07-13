package manager;

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

import entiteti.RezultatTesta;
import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.osobe.Ucenik;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

public class RezultatTestaManager {

	private List<RezultatTesta> rezultati;
	private Map<String, RezultatTesta> mapRezultati;

	private String rezultatiFile;
	private TestManager testManager;
	private UcenikManager ucenikManager;
	private TerminManager terminManager;

	public RezultatTestaManager(UcenikManager ucenikManager, TestManager testManager, TerminManager terminManager) {
		this.ucenikManager = ucenikManager;
		this.testManager = testManager;
		this.terminManager = terminManager;
		this.rezultati = new ArrayList<RezultatTesta>();
		this.mapRezultati = new HashMap<String, RezultatTesta>();
	}

	public RezultatTestaManager(UcenikManager ucenikManager, TestManager testManager, TerminManager terminManager, String rezultatiFile) {
		this(ucenikManager, testManager, terminManager);
		this.rezultatiFile = rezultatiFile;
		loadData(rezultatiFile);
	}

   

	public boolean loadData(String file) {
		if (this.rezultatiFile == null)
			this.rezultatiFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.rezultatiFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				RezultatTesta rezultat = parseRezultat(linija);
				this.rezultati.add(rezultat);
				this.mapRezultati.put(rezultat.getId(), rezultat);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private RezultatTesta parseRezultat(String linija) {
		//# ID_REZULTATA; OSVOJENO_BODOVA; OCJENA; ID_TESTA; ID_UCENIKA
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		int osvojenoBodova = Integer.parseInt(tokens[1].trim());
		int ocjena = Integer.parseInt(tokens[2].trim());
		String idTesta = tokens[3].trim();
		String idUcenika = tokens[4].trim();
		String idTermina = tokens[5].trim();
		
		RezultatTesta rezultat = new RezultatTesta(id, osvojenoBodova, ocjena);
		
		// TEST I TERMIN
		rezultat.setTest(this.testManager.getMapTestovi().get(idTesta));
		rezultat.setTermin(this.terminManager.getMapTermini().get(idTermina));
		this.testManager.getMapTestovi().get(idTesta).getRezultati().add(rezultat);
		
		// UCENIK
		this.ucenikManager.getMapUcenici().get(idUcenika).getRezultati().add(rezultat);
		rezultat.setUcenik(this.ucenikManager.getMapUcenici().get(idUcenika));
		
		
		return rezultat;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.rezultatiFile), "utf-8"));

			out.println("# ID_REZULTATA; OSVOJENO_BODOVA; OCJENA; ID_TESTA; ID_UCENIKA; ID_TERMINA");
			for (RezultatTesta rezultat : this.rezultati) {
//				System.out.println(uc.toFileString());
				out.println(rezultat.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addRezultat(RezultatTesta r, Ucenik uc, Test t, TerminTesta termin) {
		if (mapRezultati.containsKey(r.getId()))
			return false;
		this.rezultati.add(r);
		this.mapRezultati.put(r.getId(), r);
		
		// TEST I TERMIN
		r.setTest(t);
		r.setTermin(termin);
		t.getRezultati().add(r);
		
		// UCENIK
		uc.getRezultati().add(r);
		r.setUcenik(uc);
		
		return true;
	}
	
	public boolean removeRezultat(RezultatTesta r) {
		if (!mapRezultati.containsKey(r.getId()))
			return false;
		
		// TEST I TERMIN
		r.getTest().getRezultati().remove(r);
		
		// UCENIK
		r.getUcenik().getRezultati().remove(r);
		
		this.rezultati.remove(r);
		this.mapRezultati.remove(r.getId());
		return true;
	}
	
	
	public Map<String, RezultatTesta> getMapRezultati() {
		return mapRezultati;
	}
	
	
	public List<RezultatTesta> getRezultati() {
		return rezultati;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
		TestManager testManager = new TestManager(predavacManager, jezikManager, kursManager, "./data/testovi.txt");
		UcenikManager ucenikManager = new UcenikManager("./data/ucenici.txt");
		TerminManager terminManager = new TerminManager(predavacManager, testManager, kursManager, "./data/termini.txt");
				
		RezultatTestaManager rezultatTestaManager = new RezultatTestaManager(ucenikManager, testManager, terminManager, "./data/rezultati-testa.txt");
		
		for (RezultatTesta rezultat : rezultatTestaManager.getRezultati()) {
			System.out.println(rezultat);
		}
		
		System.out.println();
		
		for (Ucenik uc : ucenikManager.getUcenici()) {
			System.out.println(uc);
		}
	}

	
}
