package manager.veze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//import entiteti.Kurs;
//import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.osobe.Ucenik;
import manager.JezikManager;
import manager.KursManager;
import manager.TestManager;
import manager.osobe.PredavacManager;
import manager.osobe.UcenikManager;

public class VezaTestUcenikManager {
	
	private UcenikManager ucenikManager;
	private TestManager testManager;
	private String vezaTestUcenikFile;

	public VezaTestUcenikManager(UcenikManager ucenikManager, TestManager testManager, String vezaFile) {
		this.ucenikManager = ucenikManager;
		this.testManager = testManager;
		this.vezaTestUcenikFile = vezaFile;
		loadData();
	}
	
	
	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.vezaTestUcenikFile), "utf-8"));
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

		Test test = this.testManager.getMapTestovi().get(tokens[0].trim());
		Ucenik uc = this.ucenikManager.getMapUcenici().get(tokens[1].trim());
		
		test.getUcenici().add(uc);
		uc.getTestovi().add(test);
	}
	
	
	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.vezaTestUcenikFile), "utf-8"));

			out.println("# ID_TESTA; ID_UCENIKA");
			for (Test t : this.testManager.getTestovi()) {
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

		
		VezaTestUcenikManager vezaTestUcenikManager = new VezaTestUcenikManager(ucenikManager, testManager, "./data/veza-test-ucenik.txt");
		
		for (Ucenik uc : ucenikManager.getUcenici()) {
			System.out.println(uc);
		}
		
		for (Test t : testManager.getTestovi()) {
			System.out.println(t);
		}
		
		vezaTestUcenikManager.saveData();
		
	}
	

}
