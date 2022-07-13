package entiteti.osobe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entiteti.Zahtjev;
import entiteti.interfejsi.ImaZahtjeve;

public class Sekretar extends Zaposleni implements ImaZahtjeve {

	private static List<Zahtjev> neobradjeniZahtjevi = new ArrayList<Zahtjev>();
	private List<Zahtjev> obradjeniZahtjevi = new ArrayList<Zahtjev>();
	
	
	
	
	
	public Sekretar() {
		this.setUloga(Uloge.SEKRETAR);
	}

	public Sekretar(String id, boolean aktivan, String ime, String prezime, Pol pol, String datumRodjenja, String telefon, String adresa,
			String korisnickoIme, String lozinka, StrucnaSprema strucnaSprema, int godineStaza, double plata) {
		super(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka, strucnaSprema, godineStaza, plata);
		this.setUloga(Uloge.SEKRETAR);
	}

	
	
	
	
	public static List<Zahtjev> getNeobradjeniZahtjevi() {
		return neobradjeniZahtjevi;
	}

	public static void setNeobradjeniZahtjevi(List<Zahtjev> zahtjevi) {
		Sekretar.neobradjeniZahtjevi = zahtjevi;
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
	public String toString() {
		return "Sekretar[" + super.toString() + ", obradjeniZahtjevi=" + obradjeniZahtjevi.size()
			+ ", neobradjeniZahtjevi=" + neobradjeniZahtjevi.size() + "]";
	}
	
	
	
	public String toFileString() {
		String ret = String.join("; ",this.getId(), ""+this.isAktivan(), this.getIme(), this.getPrezime(), this.getPolStr(), this.getDatumRodjenjaStr(), 
				this.getTelefon(), this.getAdresa(), this.getKorisnickoIme(), this.getLozinka(), "" + this.getStrucnaSprema(), 
				"" + this.getGodinaStaza(), "" + this.getPlata());
		return ret;
	}
	
	
	public Object toCell(int columnIndex) {
		//{"Id sekretara", "Ime", "Prezime", "Pol", "Datum rođenja", "Telefon", "Adresa", "Stručna sprema",
		//	"Godina staža", "Plata", "Obrađeni zahtjevi"}
		
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
				return this.obradjeniZahtjevi.size();
			default:
				return null;
		}
	}	
	
	
	
	public void setCell(Object value, int col) {
		switch (col) {
		case 0:
			this.setId((String) value);
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
		
		

	public double izraunajBonus() {
		double bonus = 0.0;
		for (Zahtjev zahtjev : this.obradjeniZahtjevi)
			if (zahtjev.getDatumObrade().isAfter(LocalDate.now().minusMonths(1))) {
				bonus += 1;
			}
		return bonus * 2;
	}






	
	
	
	
	
	
	
}
