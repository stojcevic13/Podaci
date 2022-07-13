package entiteti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Uplacivanje {

	private String id;
	private LocalDate datum;
	private double iznos;
	
	
	public Uplacivanje() {
		
	}
	
	public Uplacivanje(String id, LocalDate datum, double iznos) {
		this();
		this.id = id;
		this.datum = datum;
		this.iznos = iznos;
	}
	
	public Uplacivanje(String id, String datumStr, double iznos) {
		this();
		this.id = id;
		this.datum = LocalDate.parse(datumStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		this.iznos = iznos;
	}

	
	
	
	
	public Uplacivanje(LocalDate datumUplate, double cijena) {
		this.datum = datumUplate;
		this.iznos = cijena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDatum() {
		return datum;
	}
	
	public String getDatumStr() {
		return this.datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	
	public void setDatumStr(String datumStr) {
		this.datum = LocalDate.parse(datumStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	
	
	
	@Override
	public String toString() {
		return "Uplacivanje [id=" + id + ", datum=" + getDatumStr() + ", iznos=" + iznos + "]";
	}
	
	
	
	
	
	
	
	
}
