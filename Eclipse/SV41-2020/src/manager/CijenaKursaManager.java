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

import entiteti.CijenaKursa;
import entiteti.Cjenovnik;
//import entiteti.Test;
import manager.osobe.PredavacManager;

public class CijenaKursaManager {


	private List<CijenaKursa> cijeneKurseva;
	private Map<String, CijenaKursa> mapCijeneKurseva;

	private String cijeneKursevaFile;
	private KursManager kursManager;
	
	public CijenaKursaManager(KursManager kursManager) {
		this.kursManager = kursManager;
		this.cijeneKurseva = new ArrayList<CijenaKursa>();
		this.mapCijeneKurseva = new HashMap<String, CijenaKursa>();
	}

	public CijenaKursaManager(KursManager kursManager, String cijeneFile) {
		this(kursManager);
		this.cijeneKursevaFile = cijeneFile;
		loadData(cijeneFile);
	}

   

	public boolean loadData(String file) {
		if (this.cijeneKursevaFile == null)
			this.cijeneKursevaFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.cijeneKursevaFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				CijenaKursa cijenaKursa = parseCijenaKursa(linija);
				this.cijeneKurseva.add(cijenaKursa);
				this.mapCijeneKurseva.put(cijenaKursa.getKurs().getId(), cijenaKursa);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private CijenaKursa parseCijenaKursa(String linija) {
		//# ID_KURSA; CIJENA; CIJENA_JEDNOG_POLAGANJA
		String[] tokens = linija.split(";");
		String idKursa = tokens[0].trim();
		double cijena = Double.parseDouble(tokens[1].trim());
		double cijenaJednogPolaganja = Double.parseDouble(tokens[2].trim());
		
		CijenaKursa cijenaKursa = new CijenaKursa(cijena, cijenaJednogPolaganja);
		CijenaKursa cijenaKursaPopust = new CijenaKursa( (cijena - cijena*0.1), (cijenaJednogPolaganja - cijenaJednogPolaganja*0.1) );
		
		cijenaKursa.setKurs(this.kursManager.getMapKursevi().get(idKursa));
		Cjenovnik.getCijene().put(this.kursManager.getMapKursevi().get(idKursa), cijenaKursa);
		Cjenovnik.getPopusti().put(this.kursManager.getMapKursevi().get(idKursa), cijenaKursaPopust);
		
		return cijenaKursa;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.cijeneKursevaFile), "utf-8"));

			out.println("# ID_KURSA; CIJENA; CIJENA_JEDNOG_POLAGANJA");
			for (CijenaKursa cijenaKursa : this.cijeneKurseva) {
//				System.out.println(uc.toFileString());
				out.println(cijenaKursa.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public Map<String, CijenaKursa> getMapCijeneKurseva() {
		return mapCijeneKurseva;
	}
	
	
	public List<CijenaKursa> getCijeneKurseva() {
		return cijeneKurseva;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");
//		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
//		TestManager testManager = new TestManager(predavacManager, jezikManager, "./data/testovi.txt");
		
		
		
		KursManager kursManager = new KursManager(predavacManager, jezikManager, "./data/kursevi.txt");
		
		CijenaKursaManager cijenaKursaManager = new CijenaKursaManager(kursManager, "./data/cijene-kurseva.txt");
		
		for (CijenaKursa cijenaKursa : cijenaKursaManager.getCijeneKurseva()) {
			System.out.println(cijenaKursa);
		}
	}
	
}
