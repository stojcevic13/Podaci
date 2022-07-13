package entiteti;


import java.util.ArrayList;
import java.util.List;

import entiteti.osobe.Predavac;
//import entiteti.osobe.Predavac;
import entiteti.osobe.Ucenik;
import main.Podaci;

public class Kurs {
	
	public static enum Nivo {a1, a2, a3};
	
	private String id;
	private Jezik jezik;
	private Nivo nivo;
	private Predavac predavac;
	private List<Ucenik> ucenici;
	private List<Test> testovi;
	private List<TerminTesta> dostupniTermini;
	private List<TerminTesta> zavrseniTermini;
	private List<PojedinacanTest> neocijenjeniTestovi;
	private boolean aktivan;
	
	
	
	public Kurs() {
		this.ucenici = new ArrayList<Ucenik>();
		this.testovi = new ArrayList<Test>();
		this.dostupniTermini = new ArrayList<TerminTesta>();
		this.zavrseniTermini = new ArrayList<TerminTesta>();
		this.neocijenjeniTestovi = new ArrayList<PojedinacanTest>();
	}
	
	public Kurs(String id, Nivo nivo, boolean aktivan) {
		this();
		this.id = id;
		this.nivo = nivo;
		this.aktivan = aktivan;
	}
	

	

	public Kurs(Jezik jezik, Nivo nivo, Predavac predavac) {
		this();
		this.id = String.format("%04d", Podaci.getPodaci().getKursManager().getKursevi().size());
		this.jezik = jezik;
		this.nivo = nivo;
		this.predavac = predavac;
		this.aktivan = true;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Jezik getJezik() {
		return jezik;
	}
	
	public String getJezikStr() {
		return jezik.getJezik();
	}

	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}

	public List<Ucenik> getUcenici() {
		return ucenici;
	}

	public void setUcenici(List<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}
	
	public Predavac getPredavac() {
		return this.predavac;
	}
	
	public void setPredavac(Predavac p) {
		this.predavac = p;
	}

	public List<Test> getTestovi() {
		return testovi;
	}

	public void setTestovi(List<Test> testovi) {
		this.testovi = testovi;
	}

	public List<TerminTesta> getDostupniTermini() {
		return dostupniTermini;
	}

	public void setDostupniTermini(List<TerminTesta> dostupniTermini) {
		this.dostupniTermini = dostupniTermini;
	}

	public List<TerminTesta> getZavrseniTermini() {
		return zavrseniTermini;
	}

	public void setZavrseniTermini(List<TerminTesta> zavrseniTermini) {
		this.zavrseniTermini = zavrseniTermini;
	}
	
	public List<PojedinacanTest> getNeocijenjeniTestovi() {
		return neocijenjeniTestovi;
	}

	public void setNeocijenjeniTestovi(List<PojedinacanTest> neocijenjeniTestovi) {
		this.neocijenjeniTestovi = neocijenjeniTestovi;
	}


	public Nivo getNivo() {
		return nivo;
	}

	public void setNivo(Nivo nivo) {
		this.nivo = nivo;
	}
	

	
	
	public String getNaziv() {
		return jezik.getJezik() + " " + nivo;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	
	
	
	public static Nivo parseNivo(String nivo) {
		if (nivo.equals("a1"))
			return Nivo.a1;
		else if (nivo.equals("a2"))
			return Nivo.a2;
		else if (nivo.equals("a3"))
			return Nivo.a3;
		else
			return null;		
	}
	
	
	@Override
	public String toString() {
		return "Kurs [id=" + id + ", jezik=" + jezik.getJezik() + ", nivo=" + nivo + "]";
//		return "Kurs [id=" + id + ", jezik=" + jezik.getJezik() + ", predavac=" + predavac + ", ucenici=" + ucenici.size() + 
//				", dostupniTermini=" + dostupniTermini.size() + ", zavrseniTermini=" + zavrseniTermini.size() + "]";
	}
	
	
	
	
	
	public String toFileString() {
		// # ID_KURSA; ID_JEZIKA; NIVO; ID_PREDAVACA; DA_LI_JE_AKTIVAN
		String ret = String.join("; ", this.id, this.jezik.getJezik(), "" + this.nivo, this.predavac.getId(), "" + this.aktivan);
		return ret;
	}
	
	
	public Object toCell(int columnIndex) {
		// "Id kursa", "Jezik", "Nivo", "Cijena", "Cijena dodatnog polaganja", "Predavač", "Broj učenika"
		switch (columnIndex) {
			case 0:
				return this.id;
			case 1:
				return this.jezik.getJezik();
			case 2:
				return this.nivo;
			case 3:
				return Cjenovnik.getCijene().get(this).getOsnovnaCijena();
			case 4:
				return Cjenovnik.getCijene().get(this).getCijenaTesta();
			case 5:
				return this.predavac.getIme() + " " + this.predavac.getPrezime();	
			case 6:
				return this.ucenici.size();
				
			default:
				return null;
		}
	}
	
	
	






}
