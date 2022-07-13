package entiteti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Cjenovnik {
	
	private String id;
	private static LocalDate vaziOd;
	private static Map<Kurs, CijenaKursa> cijene = new HashMap<Kurs, CijenaKursa>();
	private static Map<Kurs, CijenaKursa> popusti = new HashMap<Kurs, CijenaKursa>();
	
	
	
	
	
	public Cjenovnik() {

	}
	
	public Cjenovnik(String id, String vaziOdStr) {
		this();
		this.id = id;
		vaziOd = LocalDate.parse(vaziOdStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static LocalDate getVaziOd() {
		return vaziOd;
	}
	
	public String getVaziOdStr() {
		return vaziOd.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public static void setVaziOd(LocalDate novoVaziOd) {
		vaziOd = novoVaziOd;
	}

	public static Map<Kurs, CijenaKursa> getCijene() {
		return cijene;
	}

	public static Map<Kurs, CijenaKursa> getPopusti() {
		return popusti;
	}


	
	
	
	
	@Override
	public String toString() {
		return "Cjenovnik [id=" + id + ", vaziOd=" + vaziOd + ", cijene=" + cijene + "]";
	}
	
	
	
	
	
	

}
