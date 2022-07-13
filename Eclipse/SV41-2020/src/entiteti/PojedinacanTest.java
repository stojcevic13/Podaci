package entiteti;

import entiteti.osobe.Ucenik;

public class PojedinacanTest {

	private String id;
	private Ucenik ucenik;
	private TerminTesta termin;
	private boolean ocijenjen;
	
	
	
	public PojedinacanTest() {
		
	}
	
	public PojedinacanTest(String id, boolean ocijenjen) {
		this();
		this.id = id;
		this.ocijenjen = ocijenjen;
	}


	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public TerminTesta getTermin() {
		return termin;
	}

	public void setTermin(TerminTesta termin) {
		this.termin = termin;
	}

	public boolean isOcijenjen() {
		return ocijenjen;
	}

	public void setOcijenjen(boolean ocijenjen) {
		this.ocijenjen = ocijenjen;
	}




	@Override
	public String toString() {
		return "PojedinacanTest [id=" + id + ", ucenik=" + ucenik.getId() + ", termin=" + termin.getDatumVrijemeStr() + ", ocijenjen=" + ocijenjen + "]";
	}

	public String toFileString() {
		// # ID; ID_UCENIKA; ID_TERMINA; DA_LI_JE_OCIJENJEN
		return String.join("; ", id, ucenik.getId(), termin.getId(), "" + ocijenjen);
	}

	public Object toCell(int columnIndex) {
		// {"Id", "Test", "Ucenik", "Kurs", "Termin"}
		switch (columnIndex) {
			case 0:
				return this.id;
			case 1:
				return this.termin.getTest().getOpis();
			case 2:
				return this.ucenik.getIme() + " " + this.ucenik.getPrezime();
			case 3:
				return this.termin.getKurs().getJezik().getJezik();
			case 4:
				return this.termin.getDatumVrijemeStr();
			default:
				return null;
		}
	}
	
	
	
	
	
	
	
}
