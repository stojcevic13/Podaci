package entiteti;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//import entiteti.interfejsi.MozeDaKreiraTermin;
import entiteti.osobe.Predavac;
import entiteti.osobe.Ucenik;

public class TerminTesta {
	
	private String id;
	private LocalDateTime datumVrijeme;
	private Test test;
	private Kurs kurs;
	private List<Ucenik> ucenici;
	private Predavac predavac;
	
	
	
	
	
	public TerminTesta() {
		this.ucenici = new ArrayList<Ucenik>();
	}
	
	public TerminTesta(String id, String datumVrijeme) {
		this();
		this.id = id;
		this.datumVrijeme = LocalDateTime.parse(datumVrijeme, DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm"));
	}
	
	public TerminTesta(Kurs odabraniKurs, Test odabraniTest, LocalDateTime datumVrijeme) {
		this();
		this.kurs = odabraniKurs;
		this.test = odabraniTest;
		this.datumVrijeme = datumVrijeme;
	}

	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDatumVrijeme() {
		return datumVrijeme;
	}
	
	public String getDatumVrijemeStr() {
		return datumVrijeme.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm"));
	}

	public void setDatumVrijeme(LocalDateTime datumVrijeme) {
		this.datumVrijeme = datumVrijeme;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Ucenik> getUcenici() {
		return ucenici;
	}

	public void setUcenici(List<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}

	public Predavac getPredavac() {
		return predavac;
	}

	public void setPredavac(Predavac predavac) {
		this.predavac = predavac;
	}

	
	
	
	@Override
	public String toString() {
		return "TerminTesta [id=" + id + ", kurs=" + kurs.getJezikStr() + " " + kurs.getNivo() + ",  " + this.getDatumVrijemeStr() + ", test=" + test.getId() + "]";
	}
	
	
	
	
	public String toFileString() {
		return String.join("; ", this.id, this.getDatumVrijemeStr(), this.test.getId(), this.kurs.getId(), this.predavac.getId());
	}
	
	
	
	

	public static void main(String[] args) {
		String s = "10.08.2021 - 13:03";
		LocalDateTime sv = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm"));
		System.out.println(sv);
		System.out.println(s);
		LocalDateTime datumVrijeme = LocalDateTime.now();
		System.out.println(datumVrijeme.format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm")));
	}

	public Object toCell(int columnIndex) {
		// {"Id termina", "Datum", "Test", "Kurs"}
		switch (columnIndex) {
			case 0:
				return this.id;
			case 1:
				return this.getDatumVrijemeStr();
			case 2:
				return this.test.getOpis();
			case 3:
				return this.kurs.getJezikStr();
			default:
				return null;
		}
		
		
		
		
	}



}
