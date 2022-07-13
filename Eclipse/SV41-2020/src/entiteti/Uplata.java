package entiteti;

import java.time.LocalDate;

import entiteti.osobe.Ucenik;
import main.Podaci;

public class Uplata extends Uplacivanje {

	private Ucenik ucenik;
	private Kurs kurs;
	
	
	
	
	public Uplata() {

	}
	
	public Uplata(String id, String datumUplate, double iznos) {
		super(id, datumUplate, iznos);
	}
	
	public Uplata(Kurs kurs, Ucenik ucenik, LocalDate datumUplate, double cijena) {
		super(datumUplate, cijena);
		String poslednjId = Podaci.getPodaci().getUplataManager().getUplate().get(Podaci.getPodaci().getUplataManager().getUplate().size() - 1).getId();
		this.setId(String.format("%04d", Integer.parseInt(poslednjId) + 1));
		this.ucenik = ucenik;
		this.kurs = kurs;
	}

	
	
	
	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}
	
	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}


	
	
	
	

	@Override
	public String toString() {
		return "Uplata [id=" + this.getId() + ", ucenik=" + ucenik + ", kurs=" + kurs + ", datumUplate=" + this.getDatumStr()
				+ ", iznos=" + this.getIznos() + "]";
	}
	
	

	
	
	public String toFileString() {
		//# ID_UPLATE; DATUM_UPLATE; IZNOS; ID_UCENIKA; ID_KURSA
		String idUcenika = (ucenik == null) ? "" : ucenik.getId();
		String idKursa = (kurs == null) ? "" : kurs.getId();
		return String.join("; ", this.getId(), this.getDatumStr(), "" + this.getIznos(), idUcenika, idKursa);
	}

	public Object toCell(int columnIndex) {
		// {"Id uplate", "Kurs", "Datum uplate", "Iznos"}
		switch (columnIndex) {
			case 0:
				return this.getId();
			case 1:
				return this.kurs.getJezik().getJezik() + " " + this.kurs.getNivo();
			case 2:
				return this.getDatumStr();
			case 3:
				return this.getIznos();
			default:
				return null;
		}
	}
}
