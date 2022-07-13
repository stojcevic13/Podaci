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

import entiteti.PojedinacanTest;
//import entiteti.RezultatTesta;
import entiteti.TerminTesta;
import entiteti.osobe.Ucenik;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

public class PojedinacanTestManager {
	
	private List<PojedinacanTest> pojedinacniTestovi;
	private Map<String, PojedinacanTest> mapPojedinacniTestovi;

	private String pojedinacniTestoviFile;
	private UcenikManager ucenikManager;
	private TerminManager terminManager;


	public PojedinacanTestManager(UcenikManager ucenikManager, TerminManager terminManager, String pojTestFile) {
		this.ucenikManager = ucenikManager;
		this.terminManager = terminManager;
		this.pojedinacniTestoviFile = pojTestFile;
		this.pojedinacniTestovi = new ArrayList<PojedinacanTest>();
		this.mapPojedinacniTestovi = new HashMap<String, PojedinacanTest>();
		loadData();
	}

   

	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.pojedinacniTestoviFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				PojedinacanTest pojedinacanTest = parsePojedinacanTest(linija);
				this.pojedinacniTestovi.add(pojedinacanTest);
				this.mapPojedinacniTestovi.put(pojedinacanTest.getId(), pojedinacanTest);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private PojedinacanTest parsePojedinacanTest(String linija) {
		//# ID; ID_UCENIKA; ID_TERMINA; DA_LI_JE_OCIJENJEN
		String[] tokens = linija.split(";");
		String idPojTesta = tokens[0].trim();
		String idUcenika = tokens[1].trim();
		String idTermina = tokens[2].trim();
		boolean ocijenjen = Boolean.parseBoolean(tokens[3].trim());
		
		PojedinacanTest pojedinacanTest = new PojedinacanTest(idPojTesta, ocijenjen);
		TerminTesta termin = this.terminManager.getMapTermini().get(idTermina);
		Ucenik ucenik = this.ucenikManager.getMapUcenici().get(idUcenika);
		
		// UCENIK
		pojedinacanTest.setUcenik(ucenik);
//		ucenik.getTermini().add(termin);
		
		
		// TERMIN
		pojedinacanTest.setTermin(termin);
//		termin.getUcenici().add(ucenik);
		
		if (!ocijenjen)
			termin.getKurs().getNeocijenjeniTestovi().add(pojedinacanTest);
		
		
		
		
		return pojedinacanTest;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.pojedinacniTestoviFile), "utf-8"));

			out.println("# ID; ID_UCENIKA; ID_TERMINA; DA_LI_JE_OCIJENJEN");
			for (PojedinacanTest pojedinacanTest : this.pojedinacniTestovi) {
//				System.out.println(uc.toFileString());
				out.println(pojedinacanTest.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public Map<String, PojedinacanTest> getMapPojedinacniTestovi() {
		return mapPojedinacniTestovi;
	}
	
	
	public List<PojedinacanTest> getPojedinacniTestovi() {
		return pojedinacniTestovi;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
		TestManager testManager = new TestManager(predavacManager, jezikManager, kursManager, "./data/testovi.txt");
		UcenikManager ucenikManager = new UcenikManager("./data/ucenici.txt");
		TerminManager terminManager = new TerminManager(predavacManager, testManager, kursManager, "./data/termini.txt");
				
		PojedinacanTestManager pojedinacanTestManager = new PojedinacanTestManager(ucenikManager, terminManager, "./data/pojedinacni-testovi.txt");
		
		for (PojedinacanTest pojedinacanTest : pojedinacanTestManager.getPojedinacniTestovi()) {
			System.out.println(pojedinacanTest);
		}
		
		System.out.println();
		
		for (Ucenik uc : ucenikManager.getUcenici()) {
			System.out.println(uc);
		}
	}


}
