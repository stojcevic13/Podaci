package zadatak3;

import java.util.ArrayList;

public class Knjiga {
	
	private String sifra;
	private String naslov;
	private Integer godinaIzdanja;
	private Autor autori;
	private Double cijena;
	
	
	
	
	// KONSTRUKTORI
	
	public Knjiga() {}

	public Knjiga(String sifra, String naslov, int godinaIzdanja, Autor autori, Double cijena) {
		this();
		this.sifra = sifra;
		this.naslov = naslov;
		this.godinaIzdanja = godinaIzdanja;
		this.autori = autori;
		this.cijena = cijena;
	};
	
	public Knjiga (Knjiga k) {
		this(k.sifra, k.naslov, k.godinaIzdanja, k.autori, k.cijena);
	}

	
	
	
	// GETTERI I SETTERI
	
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Integer getGodinaIzdanja() {
		return godinaIzdanja;
	}
	public void setGodinaIzdanja(Integer godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}
	
	public Autor getAutori() {
		return autori;
	}
	public void setAutori(Autor autori) {
		this.autori = autori;
	}

	public Double getCijena() {
		return cijena;
	}
	public void setCijena(Double cijena) {

		this.cijena = cijena;
	}

	
	
	
	
	// OVERRIDE
	
	@Override
	public String toString() {
		return "Knjiga [sifra=" + sifra + ", naslov=" + naslov + ", godinaIzdanja=" + godinaIzdanja + ", autori="
				+ autori + ", cijena=" + cijena + "]";
	}


	
	

}
