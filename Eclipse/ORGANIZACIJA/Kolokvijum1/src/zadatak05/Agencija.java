package zadatak05;

import java.util.ArrayList;
import java.util.List;

public class Agencija {

	private List<Iznajmljivanje> iznajmljivanja;
	
	public Agencija() {
		this.iznajmljivanja = new ArrayList<Iznajmljivanje>();
	}

	public Agencija(List<Iznajmljivanje> iznajmljivanja) {
		this();
		this.iznajmljivanja = iznajmljivanja;
	}

	public List<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}

	public void setIznajmljivanja(List<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iznajmljivanja == null) ? 0 : iznajmljivanja.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencija other = (Agencija) obj;
		if (iznajmljivanja == null) {
			if (other.iznajmljivanja != null)
				return false;
		} else if (!iznajmljivanja.equals(other.iznajmljivanja))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agencija [iznajmljivanja=" + iznajmljivanja + "]";
	}
	
	
}
