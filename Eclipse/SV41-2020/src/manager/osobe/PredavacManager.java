package manager.osobe;

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

import entiteti.osobe.Osoba;
import entiteti.osobe.Osoba.Pol;
import entiteti.osobe.Zaposleni.StrucnaSprema;
import entiteti.osobe.Predavac;

public class PredavacManager {
	
	private List<Predavac> predavaci;
	private Map<String, Predavac> mapPredavaci;

	private String predavacFile;
	
	public PredavacManager() {
		this.predavaci = new ArrayList<Predavac>();
		this.mapPredavaci = new HashMap<String, Predavac>();
	}

	public PredavacManager(String predavacFile) {
		this();
		this.predavacFile = predavacFile;
		loadData(predavacFile);
	}

   

	public boolean loadData(String file) {
		if (this.predavacFile == null)
			this.predavacFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Predavac predavac = parsePredavac(linija);
				this.predavaci.add(predavac);
				this.mapPredavaci.put(predavac.getId(), predavac);
				KorisnikManager.getMapKorisnici().put(predavac.getKorisnickoIme(), predavac);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Predavac parsePredavac(String linija) {
		String[] tokens = linija.split(";");
		String id = tokens[0].trim();
		boolean aktivan = Boolean.parseBoolean(tokens[1].trim());
		String ime = tokens[2].trim();
		String prezime = tokens[3].trim();
		Pol pol = (tokens[4].trim().equals("muško")) ? Osoba.Pol.muško : Osoba.Pol.žensko;
		String datumRodjenja = tokens[5].trim();
		String telefon = tokens[6].trim();
		String adresa = tokens[7].trim();
		String korisnickoIme = tokens[8].trim();
		String lozinka = tokens[9].trim();
		StrucnaSprema strucnaSprema = parseStrucnaSprema(tokens[10].trim());
		Integer godStaza = Integer.parseInt(tokens[11].trim());
		Double plata = Double.parseDouble(tokens[12].trim());
		Predavac predavac = new Predavac(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, godStaza, plata);
		return predavac;
	}
	

	private StrucnaSprema parseStrucnaSprema(String ss) {
		switch (ss) {
			case "osnovna":
				return StrucnaSprema.osnovna;
			case "srednja":
				return StrucnaSprema.srednja;
			case "viša":
				return StrucnaSprema.viša;
			default:
				return StrucnaSprema.visoka;
		}
	}	


	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.predavacFile), "utf-8"));
			
			out.println("# ID; DA_LI_JE_AKTIVAN; ime; prezime; pol; datumRodjenja; telefon; adresa; korisnickoIme; lozinka; strucnaSprema; godineStaza; plata");
			for (Predavac predavac : this.predavaci) {
//				System.out.println(uc.toFileString());
				out.println(predavac.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addPredavac(Predavac p) {
		if (mapPredavaci.containsKey(p.getId()))
			return false;
		this.predavaci.add(p);
		this.mapPredavaci.put(p.getId(), p);
		return true;
	}
	
	public boolean removePredavac(Predavac p) {
		if (!mapPredavaci.containsKey(p.getId()))
			return false;
		this.predavaci.remove(p);
		this.mapPredavaci.remove(p.getId());
		return true;
	}
	
	
	public Map<String, Predavac> getMapPredavaci() {
		return mapPredavaci;
	}
	
	public List<Predavac> getPredavaci() {
		return predavaci;
	}



	public static void main(String[] args) {
		PredavacManager predavacManager = new PredavacManager("./data/predavaci.txt");
		
		for (Predavac p : predavacManager.getPredavaci()) {
			System.out.println(p);
		}
		System.out.println(predavacManager.getMapPredavaci().get("0000"));

	}


}
