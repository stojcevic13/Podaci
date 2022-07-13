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

import entiteti.Jezik;
import entiteti.Kurs;
//import entiteti.Jezik;
import entiteti.Test;
import entiteti.osobe.Predavac;
import manager.osobe.PredavacManager;

public class TestManager {

	private List<Test> testovi;
	private Map<String, Test> mapTestovi;

	private String testoviFile;
	private JezikManager jezikManager;
	private PredavacManager predavacManager;
	private KursManager kursManager;
	
	public TestManager(PredavacManager predavacManager, JezikManager jezikManager, KursManager kursManager) {
		this.jezikManager = jezikManager;
		this.predavacManager = predavacManager;
		this.kursManager = kursManager;
		this.testovi = new ArrayList<Test>();
		this.mapTestovi = new HashMap<String, Test>();
	}

	public TestManager(PredavacManager predavacManager, JezikManager jezikManager, KursManager kursManager, String testoviFile) {
		this(predavacManager, jezikManager, kursManager);
		this.testoviFile = testoviFile;
		loadData(testoviFile);
	}

   

	public boolean loadData(String file) {
		if (this.testoviFile == null)
			this.testoviFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.testoviFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Test t = parseTest(linija);
				this.testovi.add(t);
				this.mapTestovi.put(t.getId(), t);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Test parseTest(String linija) {
		// # ID_TESTA; OPIS; BROJ_BODOVA; LISTA_PITANJA; JEZIK; KURS; ID_PREDAVACA_KREATORA
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		String opis = tokens[1].trim();
		int brBodova = Integer.parseInt(tokens[2].trim());
		
		String[] pitanja = tokens[3].trim().split(",");
		
		String jezik = tokens[4].trim();
		String idKursa = tokens[5].trim();
		String idPredavaca = tokens[6].trim();
		
		Test t = new Test(id, opis, brBodova);
		
		// PITANJA
		for (String pitanje : pitanja)
			t.getPitanja().add(pitanje.trim());
		

		
		// PREDAVAC-KREATOR
		this.predavacManager.getMapPredavaci().get(idPredavaca).getTestovi().add(t);
		t.setPredavacKreator(this.predavacManager.getMapPredavaci().get(idPredavaca));
		
		// JEZIK
		t.setJezik(this.jezikManager.getMapJezici().get(jezik));
		this.jezikManager.getMapJezici().get(jezik).getTestovi().add(t);
		
		// KURS
		t.setKurs(this.kursManager.getMapKursevi().get(idKursa));
		this.kursManager.getMapKursevi().get(idKursa).getTestovi().add(t);
		
		return t;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.testoviFile), "utf-8"));

			out.println("# ID_TESTA; OPIS; BROJ_BODOVA; LISTA_PITANJA; JEZIK; KURS; ID_PREDAVACA_KREATORA");
			for (Test t : this.testovi) {
//				System.out.println(uc.toFileString());
				out.println(t.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addTest(Test t, Predavac p, Jezik jez, Kurs k) {
		if (mapTestovi.containsKey(t.getId()))
			return false;
		this.testovi.add(t);
		this.mapTestovi.put(t.getId(), t);
		
		// PREDAVAC-KREATOR
		p.getTestovi().add(t);
		t.setPredavacKreator(p);
		
		// JEZIK
		t.setJezik(jez);
		jez.getTestovi().add(t);
		
		// KURS
		t.setKurs(k);
		k.getTestovi().add(t);
		
		return true;
	}
	
	public boolean removeTest(Test t) {
		if (!mapTestovi.containsKey(t.getId()))
			return false;
		
		// PREDAVAC-KREATOR
		t.getPredavacKreator().getTestovi().remove(t);
		
		// JEZIK
		t.getJezik().getTestovi().remove(t);
		
		// KURS
		t.getKurs().getTestovi().remove(t);
		
		this.testovi.remove(t);
		this.mapTestovi.remove(t.getId());
		return true;
	}
	
	
	public Map<String, Test> getMapTestovi() {
		return mapTestovi;
	}
	
	
	public List<Test> getTestovi() {
		return testovi;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
		TestManager testManager = new TestManager(predavacManager, jezikManager, kursManager, "./data/testovi.txt");
		
		for (Test t : testManager.getTestovi()) {
			System.out.println(t);
		}
	}

	
}
