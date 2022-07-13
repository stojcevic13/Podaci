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
import entiteti.osobe.Ucenik;


public class UcenikManager {
	
	private List<Ucenik> ucenici;
	private Map<String, Ucenik> mapUcenici;

	private String ucenikFile;
	
	public UcenikManager() {
		this.ucenici = new ArrayList<Ucenik>();
		this.mapUcenici = new HashMap<String, Ucenik>();
	}

	public UcenikManager(String ucenikFile) {
		this();
		this.ucenikFile = ucenikFile;
		loadData(ucenikFile);
	}

   

	public boolean loadData(String file) {
		if (ucenikFile == null)
			ucenikFile = file;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			String linija;
			while ((linija = in.readLine()) != null) {
				linija = linija.trim();
				if (linija.equals("") || linija.startsWith("#"))
					continue;
				Ucenik uc = parseUcenik(linija);
				this.ucenici.add(uc);
				this.mapUcenici.put(uc.getId(), uc);
				KorisnikManager.getMapKorisnici().put(uc.getKorisnickoIme(), uc);
				
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	
	private Ucenik parseUcenik(String linija) {
		// # ID; DA_LI_JE_AKTIVAN; IME; PREZIME; POL; DATUM_RODJENJA; TELEFON; ADRESA; KORISNICKO_IME; LOZINKA
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
		String lozinka = (tokens.length == 10) ? tokens[9].trim() : "";
		Ucenik uc = new Ucenik(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka);
		return uc;
	}
	

	public boolean saveData() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.ucenikFile), "utf-8"));

			out.println("# ID; DA_LI_JE_AKTIVAN; IME; PREZIME; POL; DATUM_RODJENJA; TELEFON; ADRESA; KORISNICKO_IME; LOZINKA");
			for (Ucenik uc : this.ucenici) {
				out.println(uc.toFileString());
			}
			out.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean addUcenik(Ucenik uc) {
		if (mapUcenici.containsKey(uc.getId()))
			return false;
		this.ucenici.add(uc);
		this.mapUcenici.put(uc.getId(), uc);
		return true;
	}
	
	public boolean removeUcenik(Ucenik uc) {
		if (!mapUcenici.containsKey(uc.getId()))
			return false;
		this.ucenici.remove(uc);
		this.mapUcenici.remove(uc.getId());
		return true;
	}
	
	
	public Map<String, Ucenik> getMapUcenici() {
		return mapUcenici;
	}
	
	public List<Ucenik> getUcenici() {
		return ucenici;
	}
	
	public String getUcenikFile() {
		return ucenikFile;
	}



	public static void main(String[] args) {
		UcenikManager ucenikManager = new UcenikManager("./data/ucenici.txt");
		
		for (Ucenik uc : ucenikManager.getUcenici())
			System.out.println(uc);
	}





}
