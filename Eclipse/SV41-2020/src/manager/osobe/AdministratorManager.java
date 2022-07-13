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

import entiteti.osobe.Administrator;
import entiteti.osobe.Osoba;
import entiteti.osobe.Osoba.Pol;
import entiteti.osobe.Zaposleni.StrucnaSprema;

public class AdministratorManager {
	
	private List<Administrator> administratori;
	private Map<String, Administrator> mapAdministratori;

	private String administratoriFile;
	
	public AdministratorManager() {
		this.administratori = new ArrayList<Administrator>();
		this.mapAdministratori = new HashMap<String, Administrator>();
	}

	public AdministratorManager(String administratoriFile) {
		this();
		this.administratoriFile = administratoriFile;
		loadData(administratoriFile);
	}

   

	public boolean loadData(String file) {
		if (this.administratoriFile == null)
			this.administratoriFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this.administratoriFile), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
//				System.out.println(linija);
				Administrator administrator = parseAdministrator(linija);
				this.administratori.add(administrator);
				this.mapAdministratori.put(administrator.getId(), administrator);
				KorisnikManager.getMapKorisnici().put(administrator.getKorisnickoIme(), administrator);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Administrator parseAdministrator(String linija) {
		//# ID; ime; prezime; pol; datumRodjenja; telefon; adresa; korisnickoIme; lozinka
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

		Administrator administrator = new Administrator(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, godStaza, plata);
		return administrator;
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
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.administratoriFile), "utf-8"));
			
			out.println("# ID; DA_LI_JE_AKTIVAN; ime; prezime; pol; datumRodjenja; telefon; adresa; korisnickoIme; lozinka; strucnaSprema, godStaza; plata");
			for (Administrator administrator : this.administratori) {
//				System.out.println(uc.toFileString());
				out.println(administrator.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	public boolean addAdministrator(Administrator ad) {
		if (mapAdministratori.containsKey(ad.getId()))
			return false;
		this.administratori.add(ad);
		this.mapAdministratori.put(ad.getId(), ad);
		return true;
	}
	
	public boolean removeAdministrator(Administrator ad) {
		if (!mapAdministratori.containsKey(ad.getId()))
			return false;
		this.administratori.remove(ad);
		this.mapAdministratori.remove(ad.getId());
		return true;
	}
	
	
	public Map<String, Administrator> getMapAdministratori() {
		return mapAdministratori;
	}
	
	
	public List<Administrator> getAdministratori() {
		return administratori;
	}



	public static void main(String[] args) {
		AdministratorManager administratorManager = new AdministratorManager("./data/administratori.txt");
		
		for (Administrator s : administratorManager.getAdministratori()) {
			System.out.println(s);
		}
		System.out.println(administratorManager.getMapAdministratori().get("0000"));

	}

}
