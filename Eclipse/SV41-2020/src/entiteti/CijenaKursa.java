package entiteti;

public class CijenaKursa {
	
	private double osnovnaCijena;
	private double cijenaTesta;
	private Kurs kurs;
	
	
	
	
	
	public CijenaKursa() {
		
	}
	
	public CijenaKursa(double osnovnaCijena, double cijenaTesta) {
		this();
		this.osnovnaCijena = osnovnaCijena;
		this.cijenaTesta = cijenaTesta;
	}
	
	
	
	
	public double getOsnovnaCijena() {
		return osnovnaCijena;
	}
	public void setOsnovnaCijena(double osnovnaCijena) {
		this.osnovnaCijena = osnovnaCijena;
	}
	public double getCijenaTesta() {
		return cijenaTesta;
	}
	public void setCijenaTesta(double cijenaTesta) {
		this.cijenaTesta = cijenaTesta;
	}
	public Kurs getKurs() {
		return kurs;
	}
	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}

	
	
	
	@Override
	public String toString() {
		return "CijenaKursa [osnovnaCijena=" + osnovnaCijena + ", cijenaTesta=" + cijenaTesta + ", kurs=" + kurs + "]";
	}

	
	
	
	public String toFileString() {
		return String.join("; ", this.kurs.getId(), "" + this.osnovnaCijena, "" + this.cijenaTesta);
	}
	
	
	
	
	
	

}
