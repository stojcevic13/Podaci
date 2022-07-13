package entiteti;

import entiteti.osobe.Ucenik;

public class RezultatTesta {

	private String id;
	private Test test;
	private Ucenik ucenik;
	private TerminTesta termin;
	private int osvojenoBodova;
	private int ocjena;
	
	
	
	
	
	public RezultatTesta() {
		
	}
	
	public RezultatTesta(String id, int osvojeniBodovi, int ocjena) {
		this.id = id;
		this.osvojenoBodova = osvojeniBodovi;
		this.ocjena = ocjena;
	}
	
	public RezultatTesta(String id, Test test, Ucenik ucenik, TerminTesta termin, int osvojenoBodova, int ocjena) {
		this();
		this.id = id;
		this.test = test;
		this.ucenik = ucenik;
		this.termin = termin;
		this.osvojenoBodova = osvojenoBodova;
		this.ocjena = ocjena;
	}
	

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public int getOsvojenoBodova() {
		return osvojenoBodova;
	}

	public void setOsvojenoBodova(int osvojenoBodova) {
		this.osvojenoBodova = osvojenoBodova;
	}

	public int getOcjena() {
		return ocjena;
	}

	public void setOcena(int ocena) {
		this.ocjena = ocena;
	}

	public TerminTesta getTermin() {
		return termin;
	}

	public void setTermin(TerminTesta termin) {
		this.termin = termin;
	}


	
	
	
	@Override
	public String toString() {
		return "RezultatTesta [id=" + id + ", test=" + test + ", termin=" + termin.getDatumVrijemeStr() + ", ucenik=" + ucenik + ", osvojenoBodova="
				+ osvojenoBodova + ", ocjena=" + ocjena + "]";
	}

	
	
	
	public String toFileString() {
		return String.join("; ", this.id, "" + this.osvojenoBodova, "" + this.ocjena, this.test.getId(), this.ucenik.getId(), this.termin.getId());
	}

	public Object toCell(int columnIndex) {
		// {"Id rezultata", "Kurs", "Test", "Učenik", "Osvojeno bodova", "Maksimalno bodova", "Ocjena"}
		
		switch (columnIndex) {
			case 0:
				return this.id;
			case 1:
				return this.test.getKurs().getJezikStr() + " " + this.test.getKurs().getNivo();
			case 2:
				return this.test.getId();
			case 3:
				return this.ucenik.getIme() + " " + this.ucenik.getPrezime();
			case 4:
				return this.osvojenoBodova;
			case 5:
				return this.test.getBrBodova();
			case 6:
				return this.ocjena;
			default:
				return null;
		}
	}
	
	
	
	
	
	
	
	
	
}
