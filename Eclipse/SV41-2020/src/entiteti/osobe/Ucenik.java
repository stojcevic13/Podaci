package entiteti.osobe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entiteti.Cjenovnik;
import entiteti.Kurs;
//import entiteti.OdrzavanjeKursa;
import entiteti.RezultatTesta;
import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.Uplata;
import entiteti.interfejsi.ImaTestove;
import main.Podaci;

public class Ucenik extends Korisnik implements ImaTestove {

	private List<Kurs> polozeniKursevi;
	private List<Kurs> nepolozeniKursevi;
	private List<Test> testovi;
	private List<TerminTesta> termini;
	private List<RezultatTesta> rezultati;
	private List<Uplata> uplate;
	private double ukupnoUplaceno;
	
	

	public Ucenik() {
		this.testovi = new ArrayList<Test>();
		this.termini = new ArrayList<TerminTesta>();
		this.rezultati = new ArrayList<RezultatTesta>();
		this.uplate = new ArrayList<Uplata>();
		this.polozeniKursevi = new ArrayList<Kurs>();
		this.nepolozeniKursevi = new ArrayList<Kurs>();
		this.setUloga(Uloge.UCENIK);
	}

	public Ucenik(String id, boolean aktivan, String ime, String prezime, Pol pol, String datumRodjenja, String telefon, String adresa,
			String korisnickoIme, String lozinka) {
		super(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka);
		this.setUloga(Uloge.UCENIK);
		
		this.polozeniKursevi = new ArrayList<Kurs>();
		this.nepolozeniKursevi = new ArrayList<Kurs>();
		
		this.testovi = new ArrayList<Test>();
		this.termini = new ArrayList<TerminTesta>();
		this.rezultati = new ArrayList<RezultatTesta>();
		this.uplate = new ArrayList<Uplata>();
	}

	
	
	
	
	public List<Kurs> getPolozeniKursevi() {
		return polozeniKursevi;
	}

	public void setPolozeniKursevi(List<Kurs> polozeniKursevi) {
		this.polozeniKursevi = polozeniKursevi;
	}

	public List<Kurs> getNepolozeniKursevi() {
		return nepolozeniKursevi;
	}

	public void setNepolozeniKursevi(List<Kurs> nepolozeniKursevi) {
		this.nepolozeniKursevi = nepolozeniKursevi;
	}


	
	
	
	@Override
	public List<Test> getTestovi() {
		return testovi;
	}

	@Override
	public void setTestovi(List<Test> testovi) {
		this.testovi = testovi;
	}
	
	public List<TerminTesta> getTermini() {
		return termini;
	}

	public void setTermini(List<TerminTesta> termini) {
		this.termini = termini;
	}

	public List<RezultatTesta> getRezultati() {
		return rezultati;
	}

	public void setRezultati(List<RezultatTesta> rezultati) {
		this.rezultati = rezultati;
	}

	public List<Uplata> getUplate() {
		return uplate;
	}

	public void setUplate(List<Uplata> uplate) {
		this.uplate = uplate;
	}

	public double getUkupnoUplaceno() {
		return ukupnoUplaceno;
	}

	public void setUkupnoUplaceno(double ukupnoUplaceno) {
		this.ukupnoUplaceno = ukupnoUplaceno;
	}

	
	
	
	@Override
	public String toString() {
		return "Ucenik [id=" + this.getId() + ", Ime=" + this.getIme() + ", Prezime=" + this.getPrezime() + "]";
//		return "Ucenik [" + super.toString() + ", polozenikursevi=" + polozeniKursevi.size() + ", nepolozeniKursevi=" + nepolozeniKursevi.size()
//				+ ", testovi=" + testovi.size() + ", termini=" + termini.size() + ", rezultatiTestova" + rezultati.size()
//				+ ", uplate=" + uplate.size() + ", ukupnoUplaceno=" + ukupnoUplaceno + "]";
	}

	
	
	
	public String toFileString() {
		// "# ID; DA_LI_JE_AKTIVAN; IME; PREZIME; POL; DATUM_RODJENJA; TELEFON; ADRESA; KORISNICKO_IME; LOZINKA"
		String ret = String.join("; ", this.getId(), ""+this.isAktivan(), this.getIme(), this.getPrezime(), this.getPolStr(),
				this.getDatumRodjenjaStr(), this.getTelefon(), this.getAdresa(), this.getKorisnickoIme(), this.getLozinka());
		return ret;
	}

	
	public void uplatiKurs(Kurs odabraniKurs) {   // SAMO ZA UPLATE
		double regularnaCijena = Cjenovnik.getCijene().get(odabraniKurs).getOsnovnaCijena();
		double cijenaPopust = Cjenovnik.getPopusti().get(odabraniKurs).getOsnovnaCijena();
		double cijena = (ukupnoUplaceno <= 500) ? regularnaCijena : cijenaPopust;
		Uplata novaUplata = new Uplata(odabraniKurs, this, LocalDate.now(), cijena);
		this.uplate.add(novaUplata);
		
		Podaci.getPodaci().getUplataManager().getUplate().add(novaUplata);
		Podaci.getPodaci().getUplataManager().getMapUplate().put(novaUplata.getId(), novaUplata);
		
		Administrator.svaUplacivanja.add(novaUplata);
		Administrator.prihodi += cijena;
		
	}
	
	
	public void platiPolaganjeKursa(Kurs odabraniKurs) {
		double regularnaCijenaPolaganja = Cjenovnik.getCijene().get(odabraniKurs).getCijenaTesta();
		double popustCijenaPolaganja = Cjenovnik.getPopusti().get(odabraniKurs).getCijenaTesta();
		double cijena = (this.ukupnoUplaceno <= 500) ? regularnaCijenaPolaganja : popustCijenaPolaganja;
		Uplata novaUplata = new Uplata(odabraniKurs, this, LocalDate.now(), cijena);
		this.uplate.add(novaUplata);
		
		Podaci.getPodaci().getUplataManager().getUplate().add(novaUplata);
		Podaci.getPodaci().getUplataManager().getMapUplate().put(novaUplata.getId(), novaUplata);    // hashMapUplate
		
		Administrator.svaUplacivanja.add(novaUplata);
		Administrator.prihodi += cijena;

	}
	
	
	public Object toCell(int columnIndex) {
		//{"Id učenika", "Ime", "Prezime", "Pol", "Datum rođenja", "Telefon", "Adresa", "Ukupno uplaceno"}
		switch (columnIndex) {
			case 0:
				return this.getId();
			case 1:
				return this.getIme();
			case 2:
				return this.getPrezime();
			case 3:
				return this.getPol();
			case 4:
				return this.getDatumRodjenjaStr();
			case 5:
				return this.getTelefon();
			case 6:
				return this.getAdresa();
			case 7:
				return this.ukupnoUplaceno;
			default:
				return null;
		}
	}
	
	public void setCell(Object value, int col) {
		
		switch (col) {
			case 1:
				this.setIme((String) value);
			case 2:
				this.setPrezime((String) value);
			case 5:
				this.setTelefon((String) value);
			case 6:
				this.setAdresa((String) value);
			default:
				return;
		}
	}
	




}
