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
//import entiteti.osobe.Predavac;
import entiteti.osobe.Sekretar;
import entiteti.osobe.Zaposleni.StrucnaSprema;

public class SekretarManager {
	
	private List<Sekretar> sekretari;
	private Map<String, Sekretar> mapSekretari;

	private String sekretariFile;
	
	public SekretarManager() {
		this.sekretari = new ArrayList<Sekretar>();
		this.mapSekretari = new HashMap<String, Sekretar>();
	}

	public SekretarManager(String sekretariFile) {
		this();
		this.sekretariFile = sekretariFile;
		loadData(sekretariFile);
	}
	
	
	
	public boolean loadData(String file) {
		if (this.sekretariFile == null)
			this.sekretariFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.sekretariFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Sekretar sekretar = parseSekretar(linija);
				this.sekretari.add(sekretar);
				this.mapSekretari.put(sekretar.getId(), sekretar);
				KorisnikManager.getMapKorisnici().put(sekretar.getKorisnickoIme(), sekretar);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Sekretar parseSekretar(String linija) {
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
		Sekretar sekretar = new Sekretar(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, godStaza, plata);
		return sekretar;
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
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.sekretariFile), "utf-8"));
			
			out.println("# ID; DA_LI_JE_AKTIVAN; ime; prezime; pol; datumRodjenja; telefon; adresa; korisnickoIme; lozinka; strucnaSprema; godineStaza; plata");
			for (Sekretar sekretar : this.sekretari) {
//				System.out.println(uc.toFileString());
				out.println(sekretar.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addSekretar(Sekretar sek) {
		if (mapSekretari.containsKey(sek.getId()))
			return false;
		this.sekretari.add(sek);
		this.mapSekretari.put(sek.getId(), sek);
		return true;
	}
	
	public boolean removeSekretar(Sekretar sek) {
		if (!mapSekretari.containsKey(sek.getId()))
			return false;
		this.sekretari.remove(sek);
		this.mapSekretari.remove(sek.getId());
		return true;
	}
	
	
	public Map<String, Sekretar> getMapSekretari() {
		return mapSekretari;
	}
	
	
	public List<Sekretar> getSekretari() {
		return sekretari;
	}



	public static void main(String[] args) {
		SekretarManager sekretarManager = new SekretarManager("./data/sekretari.txt");
		
		for (Sekretar s : sekretarManager.getSekretari()) {
			System.out.println(s);
		}
		System.out.println(sekretarManager.getMapSekretari().get("0000"));

	}


}
