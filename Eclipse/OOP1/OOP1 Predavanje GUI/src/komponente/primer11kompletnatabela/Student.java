package komponente.primer11kompletnatabela;

public class Student {
	
	private String brIndeksa;
	private String ime;
	private String prezime;
	private int godUpisa;
	private boolean budzet;
	
	
	public Student() {}

	public Student(String brIndeksa, String ime, String prezime, int godUpisa, boolean budzet) {
		this();
		this.brIndeksa = brIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.godUpisa = godUpisa;
		this.budzet = budzet;
	}
	
	public Student(Student s) {
		this(s.brIndeksa, s.ime, s.prezime, s.godUpisa, s.budzet);
	}

	
	
	
	
	
	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

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

	public int getGodUpisa() {
		return godUpisa;
	}

	public void setGodUpisa(int godUpisa) {
		this.godUpisa = godUpisa;
	}

	public boolean isBudzet() {
		return budzet;
	}

	public void setBudzet(boolean budzet) {
		this.budzet = budzet;
	}

	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brIndeksa == null) ? 0 : brIndeksa.hashCode());
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
		Student other = (Student) obj;
		if (brIndeksa == null) {
			if (other.brIndeksa != null)
				return false;
		} else if (!brIndeksa.equals(other.brIndeksa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [brIndeksa=" + brIndeksa + ", ime=" + ime + ", prezime=" + prezime + ", godUpisa=" + godUpisa
				+ ", budzet=" + budzet + "]";
	}
	
	
	
	
	
	public Object toCell(int col) {
		switch (col) {
			case 0: return this.brIndeksa;
			case 1: return this.ime;
			case 2: return this.prezime;
			case 3: return this.godUpisa;
			case 4: return this.budzet;
			default: return null;
		}
	}
	
	public void setCell(Object value, int col) {
		switch (col) {
			case 0:
				this.brIndeksa = (String) value;
				break;
			case 1:
				this.ime = (String) value;
				break;
			case 2:
				this.prezime = (String) value;
				break;
			case 3:
				this.godUpisa = (Integer) value;
				break;
			case 4:
				this.budzet = (Boolean) value;
				break;
		}
	}
	
	
	
	
	

}
