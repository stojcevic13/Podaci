package manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entiteti.Kurs;
import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.osobe.Predavac;
import manager.osobe.PredavacManager;

public class TerminManager {

	private List<TerminTesta> termini;
	private Map<String, TerminTesta> mapTermini;

	private String terminiFile;
	private TestManager testManager;
	private KursManager kursManager;
	private PredavacManager predavacManager;

	public TerminManager(PredavacManager predavacManager, TestManager testManager, KursManager kursManager) {
		this.predavacManager = predavacManager;
		this.testManager = testManager;
		this.kursManager = kursManager;
		this.termini = new ArrayList<TerminTesta>();
		this.mapTermini = new HashMap<String, TerminTesta>();
	}

	public TerminManager(PredavacManager predavacManager, TestManager testManager, KursManager kursManager, String terminiFile) {
		this(predavacManager, testManager, kursManager);
		this.terminiFile = terminiFile;
		loadData(terminiFile);
	}

   

	public boolean loadData(String file) {
		if (this.terminiFile == null)
			this.terminiFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.terminiFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				TerminTesta termin = parseTermin(linija);
				this.termini.add(termin);
				this.mapTermini.put(termin.getId(), termin);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private TerminTesta parseTermin(String linija) {
		// # ID_TERMINA; DATUM_I_VRIJEME; ID_TESTA; ID_KURSA; ID_PREDAVACA
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		String datumVrijemeStr = tokens[1].trim();
		String idTesta = tokens[2].trim();
		String idKursa = tokens[3].trim();
		String idPredavaca = tokens[4].trim();
//		Boolean ocijenjen = Boolean.parseBoolean(tokens[4].trim());
		
		
		TerminTesta termin = new TerminTesta(id, datumVrijemeStr);
		
		// TEST
		this.testManager.getMapTestovi().get(idTesta).getTermini().add(termin);
		termin.setTest(this.testManager.getMapTestovi().get(idTesta));
		
		// KURS
		if ( LocalDate.now().isAfter(LocalDateTime.parse(datumVrijemeStr, DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm")).toLocalDate()) )
			this.kursManager.getMapKursevi().get(idKursa).getZavrseniTermini().add(termin);
		else
			this.kursManager.getMapKursevi().get(idKursa).getDostupniTermini().add(termin);
		termin.setKurs(this.kursManager.getMapKursevi().get(idKursa));
		
		// PREDAVAC
		termin.setPredavac(this.predavacManager.getMapPredavaci().get(idPredavaca));
		this.predavacManager.getMapPredavaci().get(idPredavaca).getTermini().add(termin);
		
		return termin;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.terminiFile), "utf-8"));

			out.println("# ID_TERMINA; DATUM_I_VRIJEME; ID_TESTA; ID_KURSA; ID_PREDAVACA");
			for (TerminTesta termin : this.termini) {
//				System.out.println(uc.toFileString());
				out.println(termin.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addTermin(TerminTesta termin, Predavac p, Test t, Kurs k) {
		if (mapTermini.containsKey(termin.getId()))
			return false;
		this.termini.add(termin);
		this.mapTermini.put(termin.getId(), termin);
		
		// PREDAVAC-KREATOR
		p.getTermini().add(termin);
		termin.setPredavac(p);
		
		// TEST
		t.getTermini().add(termin);
		termin.setTest(t);
		
		// KURS
		if ( LocalDate.now().isAfter(termin.getDatumVrijeme().toLocalDate()) )
			k.getZavrseniTermini().add(termin);
		else
			k.getDostupniTermini().add(termin);
		termin.setKurs(k);
		
		return true;
	}
	
	public boolean removeTermin(TerminTesta termin) {
		if (!mapTermini.containsKey(termin.getId()))
			return false;
		
		// PREDAVAC-KREATOR
		termin.getPredavac().getTermini().remove(termin);
		
		// TEST
		termin.getTest().getTermini().remove(termin);
		
		// KURS
		termin.getKurs().getDostupniTermini().remove(termin);
		
		this.termini.remove(termin);
		this.mapTermini.remove(termin.getId());
		return true;
	}
	
	
	public Map<String, TerminTesta> getMapTermini() {
		return mapTermini;
	}
	
	
	public List<TerminTesta> getTermini() {
		return termini;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
		TestManager testManager = new TestManager(predavacManager, jezikManager, kursManager, "./data/testovi.txt");
		
		
		TerminManager terminManager = new TerminManager(predavacManager, testManager, kursManager, "./data/termini.txt");
		
		for (TerminTesta termin : terminManager.getTermini()) {
			System.out.println(termin);
		}
		
		System.out.println();
		
		for (Test test : testManager.getTestovi()) {
			System.out.println(test);
		}
	}

}
