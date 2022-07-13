package zadatak3;

import java.util.ArrayList;
import java.util.Arrays;

public class Autor {

	private String ime;
	private String prezime;
	private String jmbg;
	private Knjiga autorskaDjela;
	
	
	
	
	// KONSTRUKTORI
	
	public Autor() {}

	public Autor(String ime, String prezime, String jmbg, Knjiga autorskaDjela) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.autorskaDjela = autorskaDjela;
	};
	
	public Autor(Autor a) {
		this(a.ime, a.prezime, a.jmbg, a.autorskaDjela);
	}

	

	
	// GETTERI I SETTERI
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {

		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Knjiga getAutorskaDjela() {
		return autorskaDjela;
	}
	public void setAutorskaDjela(Knjiga autorskaDjela) {
		this.autorskaDjela = autorskaDjela;
	}



	
	
	// OVERRIDE
	
//	@Override
//	public String toString() {
//		return "Autor [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", autorskaDjela="
//				+ Arrays.toString(autorskaDjela) + "]";
//	}
	
	
	
	
	
	
	
	
}
