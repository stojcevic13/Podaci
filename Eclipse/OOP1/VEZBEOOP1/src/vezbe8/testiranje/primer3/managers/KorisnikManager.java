package vezbe8.testiranje.primer3.managers;

import java.util.ArrayList;
import java.util.List;

import vezbe8.testiranje.primer3.models.Korisnik;

public class KorisnikManager {

	private static KorisnikManager instance = new KorisnikManager();
	private String korisnikFile;
	private List<Korisnik> korisnici;

	public KorisnikManager() {
		this.korisnici = new ArrayList<Korisnik>();
	}

	public void addKorisnik(String ime, String prezime, String id, String username, String password,
			String tipKorisnika) {
		Korisnik korisnik = new Korisnik(username, password, ime, prezime, id, tipKorisnika);
		korisnici.add(korisnik);
	}

	public void readFromFileString() {

	}

	// provjerava da li postoji korisnik sa prosledjenim korisnickim imenom i sifrom
	public Korisnik tryLogin(String username, String password) {
		for (Korisnik k : this.korisnici) {
			if (k.getUsername().equals(username) && k.getPassword().equals(password))
				return k;
		}
		return null;
	}

	public void editKorisnik() {

	}

	// pronadji korisnika po id
	public Korisnik getKorisnik(String id) {
		for (Korisnik k : this.korisnici) {
			if (k.getId().equals(id)) {
				return k;
			}
		}
		return null;
	}

	public static KorisnikManager getInstance() {
		if (instance == null) {
			instance = new KorisnikManager();
		}
		return instance;
	}

	public String getKorisnikFile() {
		return korisnikFile;
	}

	public void setKorisnikFile(String korisnikFile) {
		this.korisnikFile = korisnikFile;
	}

	public List<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

}
