package entiteti;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entiteti.osobe.Predavac;
import entiteti.osobe.Ucenik;
import main.Podaci;

public class Test {

	private String id;
	private String opis;
	private List<String> pitanja;
	private Jezik jezik;
	private Kurs kurs;
	private int brBodova;
	private Predavac predavacKreator;
	private List<TerminTesta> termini;
	private List<Ucenik> ucenici;
	private List<RezultatTesta> rezultati;
	
	
	
	
	
	public Test() {
		this.pitanja = new ArrayList<String>();
		this.termini = new ArrayList<TerminTesta>();
		this.jezik = new Jezik();
		this.ucenici = new ArrayList<Ucenik>();
		this.rezultati = new ArrayList<RezultatTesta>();
	}
	
	public Test(String id, String opis, int brBodova) {
		this();
		this.id = id;
		this.opis = opis;
		this.brBodova = brBodova;
	}


	public Test(String opis, Jezik jezik, int maxBodova, List<String> pitanja, Predavac predavac) {
		this();
		String poslednjId = Podaci.getPodaci().getTestManager().getTestovi().get(Podaci.getPodaci().getTestManager().getTestovi().size() - 1).getId();
		this.id = String.format("%04d", Integer.parseInt(poslednjId) + 1);
		this.opis = opis;
		this.jezik = jezik;
		this.brBodova = maxBodova;
		this.pitanja = pitanja;
		this.predavacKreator = predavac;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Predavac getPredavacKreator() {
		return predavacKreator;
	}

	public void setPredavacKreator(Predavac predavacKreator) {
		this.predavacKreator = predavacKreator;
	}

	public List<String> getPitanja() {
		return pitanja;
	}

	public void setPitanja(List<String> pitanja) {
		this.pitanja = pitanja;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}

	public int getBrBodova() {
		return brBodova;
	}

	public void setBrBodova(int brBodova) {
		this.brBodova = brBodova;
	}

	public List<TerminTesta> getTermini() {
		return termini;
	}

	public void setTermini(List<TerminTesta> termini) {
		this.termini = termini;
	}

	public List<Ucenik> getUcenici() {
		return ucenici;
	}

	public void setUcenici(List<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}

	public List<RezultatTesta> getRezultati() {
		return rezultati;
	}

	public void setRezultati(List<RezultatTesta> rezultati) {
		this.rezultati = rezultati;
	}
	
	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}
	
	
	

	@Override
	public String toString() {
		return "Test [id=" + id + ", opis=" + opis + ", pitanja=" + pitanja + ", jezik=" + jezik.getJezik() + ", brBodova="
				+ brBodova + ", predavacKreator=" + predavacKreator + ", termini=" + termini.size() + ", ucenici=" + ucenici.size() + "]";
	}
	
	
	
	

	public String toFileString() {
		String pitanja = String.join(", ", this.pitanja);
		return String.join("; ", this.id, this.opis, "" + this.brBodova, pitanja, this.jezik.getJezik(), this.kurs.getId(), this.predavacKreator.getId());
	}

	
	public Object toCell(int columnIndex) {
		//{"Id testa", "Opis", "Jezik", "Broj pitanja", "Maksimalno bodova", "Kreator"}
		switch (columnIndex) {
			case 0:
				return this.id;
			case 1:
				return this.opis;
			case 2:
				return this.jezik.getJezik();
			case 3:
				return this.pitanja.size();
			case 4:
				return this.brBodova;
			case 5:
				return this.predavacKreator.getIme() + " " + this.predavacKreator.getPrezime();
			default:
				return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
