package entiteti.osobe;

public class Zaposleni extends Korisnik {

	public static enum StrucnaSprema{osnovna, srednja, viša, visoka};
	
	private StrucnaSprema strucnaSprema;
	private int godinaStaza;
	private double bonus;
	private double plata;
	
	
	
	
	public Zaposleni() {
		
	}

	public Zaposleni(String id, boolean aktivan, String ime, String prezime, Pol pol, String datumRodjenja, String telefon,
			String adresa, String korisnickoIme, String lozinka, StrucnaSprema strucnaSprema, int godineStaza, double plata) {
		super(id, aktivan, ime, prezime, pol, datumRodjenja, telefon, adresa, korisnickoIme, lozinka);
		this.strucnaSprema = strucnaSprema;
		this.godinaStaza = godineStaza;
		this.plata = plata;
	}

	
	
	
	
	
	public StrucnaSprema getStrucnaSprema() {
		return strucnaSprema;
	}

	public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}

	public int getGodinaStaza() {
		return godinaStaza;
	}

	public void setGodinaStaza(int godinaStaza) {
		this.godinaStaza = godinaStaza;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return super.toString() + ", strucnaSprema=" + strucnaSprema + ", godinaStaza=" + godinaStaza + ", bonus=" + bonus
				+ ", plata=" + plata;
	}
	
	public static double koeficijentStrucneSpreme(StrucnaSprema strucnaSprema) {
		if (strucnaSprema.equals(StrucnaSprema.osnovna))
			return 1.0;
		else if (strucnaSprema.equals(StrucnaSprema.srednja))
			return 1.2;
		else if (strucnaSprema.equals(StrucnaSprema.viša))
			return 1.5;
		else if (strucnaSprema.equals(StrucnaSprema.visoka))
			return 1.8;
		
		return 1.0;
			
	}
	
	
	
	
	
	
	
}
