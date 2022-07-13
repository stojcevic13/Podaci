package entiteti;

import java.util.ArrayList;
import java.util.List;

import entiteti.osobe.Predavac;

public class Jezik {
	
	private String jezik;
	private boolean aktivan;
	private List<Kurs> kursevi;
	private List<Predavac> predavaci;
	private List<Test> testovi;
	
	
	
	
	public Jezik() {
		this.kursevi = new ArrayList<Kurs>();
		this.predavaci = new ArrayList<Predavac>();
		this.testovi = new ArrayList<Test>();
	}

	public Jezik(String jezik, boolean aktivan) {
		this();
		this.jezik = jezik;
		this.aktivan = aktivan;
	}

	
	
	
	
	
	public String getJezik() {
		return jezik;
	}

	public void setJezik(String jezik) {
		this.jezik = jezik;
	}

	public List<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
	public List<Predavac> getPredavaci() {
		return predavaci;
	}

	public void setPredavaci(List<Predavac> predavaci) {
		this.predavaci = predavaci;
	}
	
	public List<Test> getTestovi() {
		return testovi;
	}

	public void setTestovi(List<Test> testovi) {
		this.testovi = testovi;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Jezik [jezik=" + jezik + "]";
	}

	
	
	
	
	public String toFileString() {
		return this.jezik + "; " + this.aktivan;
	}

	public Object toCell(int columnIndex) {
		//{"Jezik", "Broj kurseva", "Broj predavača", "Broj testova"}
		
		switch (columnIndex) {
			case 0:
				return this.jezik;
			case 1:
				return this.kursevi.size();
			case 2:
				return this.predavaci.size();
			case 3:
				return this.testovi.size();
			default:
				return null;
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
