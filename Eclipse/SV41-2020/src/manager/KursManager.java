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
import entiteti.Kurs.Nivo;
import entiteti.osobe.Predavac;
//import entiteti.osobe.Ucenik;
//import entiteti.osobe.Predavac;
//import entiteti.osobe.Osoba;
//import entiteti.osobe.Ucenik;
//import entiteti.osobe.Osoba.Pol;
import manager.osobe.PredavacManager;

public class KursManager {

	private List<Kurs> kursevi;
	private Map<String, Kurs> mapKursevi;

	private String kursFile;
	private PredavacManager predavacManager;
	private JezikManager jezikManager;
	
	public KursManager(PredavacManager predavacManager, JezikManager jezikManager) {
		this.predavacManager = predavacManager;
		this.jezikManager = jezikManager;
		this.kursevi = new ArrayList<Kurs>();
		this.mapKursevi = new HashMap<String, Kurs>();
	}

	public KursManager(PredavacManager predavacManager, JezikManager jezikManager, String kursFile) {
		this(predavacManager, jezikManager);
		this.kursFile = kursFile;
		loadData(kursFile);
	}

   

	public boolean loadData(String file) {
		if (this.kursFile == null)
			this.kursFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.kursFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Kurs kurs = parseKurs(linija);
				this.kursevi.add(kurs);
				this.mapKursevi.put(kurs.getId(), kurs);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Kurs parseKurs(String linija) {
		// # ID_KURSA; ID_JEZIKA; NIVO; ID_PREDAVACA; DA_LI_JE_AKTIVAN
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		String jezik = tokens[1].trim();
		Nivo nivo = Kurs.parseNivo(tokens[2].trim());
		String idPredavaca = tokens[3].trim();
		boolean aktivan = Boolean.parseBoolean(tokens[4].trim());
		Kurs kurs = new Kurs(id, nivo, aktivan);
		
		// PODESAVANJE PREDAVACA
		this.predavacManager.getMapPredavaci().get(idPredavaca).getKursevi().add(kurs);
		kurs.setPredavac(this.predavacManager.getMapPredavaci().get(idPredavaca));
		
		// PODESAVANJE JEZIKA
		this.jezikManager.getMapJezici().get(jezik).getKursevi().add(kurs);
		kurs.setJezik(this.jezikManager.getMapJezici().get(jezik));
		
		
		return kurs;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.kursFile), "utf-8"));
			
			out.println("# ID_KURSA; ID_JEZIKA; NIVO; ID_PREDAVACA; DA_LI_JE_AKTIVAN");
			for (Kurs kurs : this.kursevi) {
//				System.out.println(uc.toFileString());
				out.println(kurs.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addKurs(Kurs k, Jezik jez, Predavac p) {
		if (mapKursevi.containsKey(k.getId()))
			return false;
		this.kursevi.add(k);
		this.mapKursevi.put(k.getId(), k);
		
		// PODESAVANJE PREDAVACA
		p.getKursevi().add(k);
		k.setPredavac(p);
		
		// PODESAVANJE JEZIKA
		jez.getKursevi().add(k);
		k.setJezik(jez);
		
		return true;
	}
	
	public boolean removeKurs(Kurs k) {
		if (!mapKursevi.containsKey(k.getId()))
			return false;
		
		// PODESAVANJE PREDAVACA
		k.getPredavac().getKursevi().remove(k);
		
		// PODESAVANJE JEZIKA
		k.getJezik().getKursevi().remove(k);
		
		this.kursevi.remove(k);
		this.mapKursevi.remove(k.getId());
		return true;
	}
	
	
	public Map<String, Kurs> getMapKursevi() {
		return mapKursevi;
	}
	
	
	public List<Kurs> getKursevi() {
		return kursevi;
	}



	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
		
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
		for (Jezik jez : jezikManager.getJezici())
			System.out.println(jez);
		
		System.out.println();
		for (Kurs k : kursManager.kursevi)
			System.out.println(k);
	}

	
}
