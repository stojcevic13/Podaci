package entiteti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entiteti.interfejsi.ImaZahtjeve;
import entiteti.osobe.Korisnik;
import entiteti.osobe.Osoba;

//import java.util.ArrayList;
//import java.util.List;

//import entiteti.osobe.Osoba;
//import entiteti.osobe.Sekretar;
import entiteti.osobe.Ucenik;
import main.Podaci;

public class Zahtjev {

	public static enum Stanje {KREIRAN, U_OBRADI, PRIHVACEN, ODBIJEN};
	
	private String id;
	private Ucenik ucenik;
	private Kurs kurs;
	private Stanje stanje;
	private LocalDate datumSlanja;
	private LocalDate datumObrade;
	private ImaZahtjeve obradjivac;
	
	
	
	
	
	public Zahtjev() {

	}
	
	// ZA UCITAVANJE IZ FAJLA - NEOBRADJEN    FORMAT: # ID_ZAHTJEVA; ID_UCENIKA; ID_KURSA; STANJE; DATUM_SLANJA; datum_obrade; id_sekretara
	public Zahtjev(String id, Stanje stanje, String datumSlanja) {
		this();
		this.id = id;
		this.stanje = stanje;
		this.datumSlanja = LocalDate.parse(datumSlanja, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}
	
	// ZA UCITAVANJE IZ FAJLA - OBRADJEN    FORMAT: # ID_ZAHTJEVA; ID_UCENIKA; ID_KURSA; STANJE; DATUM_SLANJA; datum_obrade; id_sekretara
	public Zahtjev(String id, Stanje stanje, String datumSlanja, String datumObrade) {
		this(id, stanje, datumSlanja);
		this.datumObrade = LocalDate.parse(datumObrade, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}
	
	public Zahtjev(Ucenik ucenik, Kurs kurs) {
		this();
		this.ucenik = ucenik;
		this.kurs = kurs;
	}
	
	public Zahtjev(Ucenik ucenik, Kurs kurs, Stanje stanje, LocalDate datumSlanja) {
		this();
		this.id = String.format("%04d", Podaci.getPodaci().getZahtjevManager().getZahtjevi().size());
		this.ucenik = ucenik;
		this.kurs = kurs;
		this.stanje = stanje;
		this.datumSlanja = datumSlanja;
	}

	
//	public Zahtjev(Ucenik ucenik2, OdrzavanjeKursa odabranoOdrzavanje, Stanje kreiran, LocalDate now) {
//		// TODO Auto-generated constructor stub
//	}

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

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	public LocalDate getDatumSlanja() {
		return datumSlanja;
	}
	
	public String getDatumSlanjaStr() {
		return datumSlanja.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public void setDatumSlanja(LocalDate datumSlanja) {
		this.datumSlanja = datumSlanja;
	}

	public LocalDate getDatumObrade() {
		return datumObrade;
	}
	
	public String getDatumObradeStr() {
		return datumObrade.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
	}

	public void setDatumObrade(LocalDate datumObrade) {
		this.datumObrade = datumObrade;
	}

	public ImaZahtjeve getObradjivac() {
		return obradjivac;
	}

	public void setObradjivac(ImaZahtjeve obradjivac) {
		this.obradjivac = obradjivac;
	}

	
	
	
	
	
	@Override
	public String toString() {
		String datObrade = (datumObrade == null) ? "nije obradjen" : getDatumObradeStr();
		String idObradjivaca = (obradjivac == null) ? "nije obradjen" : ((Osoba) obradjivac).getId();
		return "Zahtjev [id=" + id + ", ucenik=" + ucenik + ", kurs=" + kurs.getNaziv() + ", stanje=" + stanje + ", datumSlanja="
				+ getDatumSlanjaStr() + ", datumObrade=" + datObrade + ", obradjivac=" + idObradjivaca + "]";
	}

	
	
	
	public String toFileString() {
		// ZA UCITAVANJE IZ FAJLA - NEOBRADJEN    FORMAT: # ID_ZAHTJEVA; ID_UCENIKA; ID_ODRZAVANJA; STANJE; DATUM_SLANJA; datum_obrade; id_obradjivaca; uloga
		String datObrade = (datumObrade == null) ? "" : getDatumObradeStr();
		String idObradjivaca = (obradjivac == null) ? "" : ((Osoba) obradjivac).getId();
		String uloga = (obradjivac == null) ? "" : "" + ((Korisnik) obradjivac).getUloga();
		return String.join("; ", id, ucenik.getId(), kurs.getId(), "" + stanje, getDatumSlanjaStr(), datObrade, idObradjivaca, uloga);
	}

	public static Stanje parseStanje(String strStanje) {
		if (strStanje.equals("KREIRAN"))
			return Stanje.KREIRAN;
		else if (strStanje.equals("U_OBRADI"))
			return Stanje.U_OBRADI;
		else if (strStanje.equals("PRIHVACEN"))
			return Stanje.PRIHVACEN;
		else 
			return Stanje.ODBIJEN;
	}

	public Object toCell(int columnIndex) {
		// {"Id zahtjeva", "Ucenik", "Kurs", "Datum slanja"};
		switch (columnIndex) {
			case 0:
				return this.id;
			case 1:
				return this.ucenik.getIme() + " " + this.ucenik.getPrezime();
			case 2:
				return this.kurs.getNaziv();
			case 3:
				return this.getDatumSlanjaStr();
			default:
				return null;
		}
	}
	
	
	

	
	
	
	
	
	
}
