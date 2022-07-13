package drzave;

import com.opencsv.bean.CsvBindByPosition;

public class Drzava {
	
	@CsvBindByPosition(position = 0, required = true)
	private String naziv;
	@CsvBindByPosition(position = 1, required = true)
	private String glavniGrad;
	@CsvBindByPosition(position = 2, required = true)
	private double povrsina;
	@CsvBindByPosition(position = 3, required = true)
	private int brStanovnika;
	@CsvBindByPosition(position = 4, required = true)
	private String kontinent;
	@CsvBindByPosition(position = 5, required = true)
	private String datumOsnivanja;

	
	public Drzava() {
		
	}


	public Drzava(String naziv, String glavniGrad, double povrsina, int brStanovnika, String kontinent,
			String datumOsnivanja) {
		this();
		this.naziv = naziv;
		this.glavniGrad = glavniGrad;
		this.povrsina = povrsina;
		this.brStanovnika = brStanovnika;
		this.kontinent = kontinent;
		this.datumOsnivanja = datumOsnivanja;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getGlavniGrad() {
		return glavniGrad;
	}


	public void setGlavniGrad(String glavniGrad) {
		this.glavniGrad = glavniGrad;
	}


	public double getPovrsina() {
		return povrsina;
	}


	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}


	public int getBrStanovnika() {
		return brStanovnika;
	}


	public void setBrStanovnika(int brStanovnika) {
		this.brStanovnika = brStanovnika;
	}


	public String getKontinent() {
		return kontinent;
	}


	public void setKontinent(String kontinent) {
		this.kontinent = kontinent;
	}


	public String getDatumOsnivanja() {
		return datumOsnivanja;
	}


	public void setDatumOsnivanja(String datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}


	@Override
	public String toString() {
		return "Drzava [naziv=" + naziv + ", glavniGrad=" + glavniGrad + ", povrsina=" + povrsina + ", brStanovnika="
				+ brStanovnika + ", kontinent=" + kontinent + ", datumOsnivanja=" + datumOsnivanja + "]";
	}
	
	
}
