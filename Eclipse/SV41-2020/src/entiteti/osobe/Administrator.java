package entiteti.osobe;

import java.util.ArrayList;
import java.util.List;

import entiteti.TerminTesta;
import entiteti.Uplacivanje;

import entiteti.Zahtjev;
import entiteti.interfejsi.ImaZahtjeve;
import entiteti.interfejsi.MozeDaKreiraTermin;

public class Administrator extends Zaposleni implements ImaZahtjeve, MozeDaKreiraTermin {

	
	public static List<Uplacivanje> svaUplacivanja = new ArrayList<Uplacivanje>();
	
	public static double prihodi = 0;
	public static double rashodi = 0;
	

	
	private List<Zahtjev> obradjeniZahtjevi = new ArrayList<Zahtjev>();
	private List<TerminTesta> termini = new ArrayList<TerminTesta>();

	
	
	
	
	public Administrator() {
		
	}

	public Administrator(String id, boolean aktivan, String ime, String prezime, Pol pol, String datumRodjenja, String telefon,
			String adresa, String korisnickoIme, String lozinka, StrucnaSprema strucnaSprema, int godineStaza, double plata) {
		super(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, godineStaza, plata);
		this.setUloga(Uloge.ADMINISTRATOR);
	}
	
	
	
	
	
	@Override
	public List<Zahtjev> getObradjeniZahtjevi() {
		return obradjeniZahtjevi;
	}

	@Override
	public void setObradjeniZahtjevi(List<Zahtjev> obradjeniZahtjevi) {
		this.obradjeniZahtjevi = obradjeniZahtjevi;
	}

	@Override
	public List<TerminTesta> getTermini() {
		return this.termini;
	}

	@Override
	public void setTermini(List<TerminTesta> termini) {
		this.termini = termini;
	}
	
	
	
	

	public String toFileString() {
		String ret = String.join("; ",this.getId(), ""+this.isAktivan(), this.getIme(), this.getPrezime(), this.getPolStr(), this.getDatumRodjenjaStr(), 
				this.getTelefon(), this.getAdresa(), this.getKorisnickoIme(), this.getLozinka(), ""+this.getStrucnaSprema(), ""+this.getGodinaStaza(),
				"" + this.getPlata());
		return ret;
	}

	@Override
	public String toString() {
		return "Administrator [" + super.toString() + "]";
	}

	public Object toCell(int columnIndex) {
		//{"Id administratora", "Ime", "Prezime", "Pol", "Datum rođenja", "Telefon", "Adresa", "Strucna sprema", "Godine staza"}
		
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
