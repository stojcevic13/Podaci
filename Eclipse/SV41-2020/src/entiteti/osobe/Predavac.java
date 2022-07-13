package entiteti.osobe;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entiteti.Jezik;
import entiteti.Kurs;
import entiteti.TerminTesta;
import entiteti.Test;
import entiteti.interfejsi.ImaTestove;

public class Predavac extends Zaposleni implements ImaTestove {
	
	private List<Kurs> kursevi;
	private List<Test> testovi;
	private List<Jezik> obuceniJezici;
	private List<TerminTesta> termini;

	
	
	
	public Predavac() {
		this.kursevi = new ArrayList<Kurs>();
		this.testovi = new ArrayList<Test>();
		this.obuceniJezici = new ArrayList<Jezik>();
		this.termini = new ArrayList<TerminTesta>();
		this.setUloga(Uloge.PREDAVAC);
	}

	public Predavac(String id, boolean aktivan, String ime, String prezime, Pol pol, String datumRodjenja, String telefon, String adresa,
			String korisnickoIme, String lozinka, StrucnaSprema strucnaSprema, int godineStaza, double plata) {
		super(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, godineStaza, plata);
		this.kursevi = new ArrayList<Kurs>();
		this.testovi = new ArrayList<Test>();
		this.obuceniJezici = new ArrayList<Jezik>();
		this.termini = new ArrayList<TerminTesta>();
		this.setUloga(Uloge.PREDAVAC);
	}


	
	
	
	public List<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}

	@Override
	public List<Test> getTestovi() {
		return testovi;
	}

	@Override
	public void setTestovi(List<Test> testovi) {
		this.testovi = testovi;
	}

	public List<Jezik> getObuceniJezici() {
		return obuceniJezici;
	}

	public void setObuceniJezici(List<Jezik> obuceniJezici) {
		this.obuceniJezici = obuceniJezici;
	}
	
	public List<TerminTesta> getTermini() {
		return termini;
	}

	public void setTermini(List<TerminTesta> termini) {
		this.termini = termini;
	}
	
	
	
	

	@Override
	public String toString() {
		
		return "Predavac [id=" + this.getId() + ", ime=" + this.getIme() + ", prezime=" + this.getPrezime() + "]";
	}
	
	
	
	


	public String toFileString() {
		String ret = String.join("; ", this.getId(), ""+this.isAktivan(), this.getIme(), this.getPrezime(), this.getPolStr(), this.getDatumRodjenjaStr(), 
				this.getTelefon(), this.getAdresa(), this.getKorisnickoIme(), this.getLozinka(), "" + this.getStrucnaSprema(), 
				"" + this.getGodinaStaza(), "" + this.getPlata());
		return ret;
	}
	
	
	public Object toCell(int columnIndex) {
		//{"Id predavača", "Ime", "Prezime", "Pol", "Datum rođenja", "Telefon", "Adresa", "Stručna sprema", "Godina staža", "Plata", "Obučeni jezici", "Kursevi"}
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
				return this.getStrucnaSprema();
			case 8:
				return this.getGodinaStaza();
			case 9:
				return this.getPlata();
			case 10:
				return this.obuceniJezici.size();
			case 11:
				return this.kursevi.size();
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
		case 9:
			this.setPlata((double) value);
		default:
			return;
	}
	}
	
	
	
	public static void main(String[] args) {
		
	}

	public double izraunajBonus() {
		double bonus = 0.0;
		for (TerminTesta termin : this.termini) {
			if (termin.getDatumVrijeme().isAfter(LocalDateTime.now().minusMonths(1))) {
				bonus += 1;
			}
		}
		return bonus * 10;
	}






	
}
