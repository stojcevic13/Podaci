package manager.veze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import entiteti.Jezik;
//import entiteti.Kurs;
import entiteti.osobe.Predavac;
import manager.JezikManager;
//import entiteti.osobe.Ucenik;
import manager.osobe.PredavacManager;

public class VezaJezikPredavacManager {
	
	private PredavacManager predavacManager;
	private JezikManager jezikManager;
	private String vezaJezikPredavacFile;

	public VezaJezikPredavacManager(PredavacManager predavacManager, JezikManager jezikManager, String vezaJezikPredavacFile) {
		this.predavacManager = predavacManager;
		this.jezikManager = jezikManager;
		this.vezaJezikPredavacFile = vezaJezikPredavacFile;
		loadData();
	}
	
	
	public boolean loadData() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.vezaJezikPredavacFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
				
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

		Jezik jezik = this.jezikManager.getMapJezici().get(tokens[0].trim());
		Predavac predavac = this.predavacManager.getMapPredavaci().get(tokens[1].trim());
		
		jezik.getPredavaci().add(predavac);
		predavac.getObuceniJezici().add(jezik);
		
//		kurs.getUcenici().add(uc);
//		uc.getKursevi().add(kurs);
	}
	
	
	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.vezaJezikPredavacFile), "utf-8"));

			out.println("# JEZIK; ID_PREDAVACA");
			for (Jezik jez : this.jezikManager.getJezici()) {
				for (Predavac p : jez.getPredavaci()) {
					out.println(jez.getJezik() + "; " + p.getId());
				}
			}

			out.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		JezikManager jezikManager = new JezikManager("./data/jezici.txt");

		
		VezaJezikPredavacManager vezaJezikPredavacManager = new VezaJezikPredavacManager(predavacManager, jezikManager, "./data/veza-jezik-predavac.txt");
		
		for (Predavac predavac : predavacManager.getPredavaci()) {
			System.out.println(predavac);
		}
		
		for (Jezik jez : jezikManager.getJezici()) {
			System.out.println(jez);
		}
		
		vezaJezikPredavacManager.saveData();
		
	}


}
