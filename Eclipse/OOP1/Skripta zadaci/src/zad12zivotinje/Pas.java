package zad12zivotinje;

public class Pas extends Zivotinja {

	private String ime;
	private String rasa;
	
	public Pas() {}
	
	public Pas(String ime, String rasa) {
		super("pas");
		this.ime = ime;
		this.rasa = rasa;
	}
	
	public Pas(String ime) {
		this(ime, "Bernardinac");
	}
	
	public Pas(Pas pas) {
		this(pas.ime, pas.rasa);
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getRasa() {
		return rasa;
	}

	public void setRasa(String rasa) {
		this.rasa = rasa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((rasa == null) ? 0 : rasa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pas other = (Pas) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (rasa == null) {
			if (other.rasa != null)
				return false;
		} else if (!rasa.equals(other.rasa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", ime=" + ime + ", rasa=" + rasa;
	}

	@Override
	public void oglasavanje() {
		System.out.println("Av Av!");
	}

	@Override
	public void oglasavanjeULjutini() {
		System.out.println("Grrr Av!");
	}

	@Override
	public void nacinKretanja() {
		System.out.println("Krecem se trcanjem.");
	}
	
	
	
	
}
