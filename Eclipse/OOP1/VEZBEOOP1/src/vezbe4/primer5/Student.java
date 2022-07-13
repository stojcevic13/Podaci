package vezbe4.primer5;

public class Student {

	private String ime;
	private String indeks;
	private String grad;

	public Student() {
		this.ime = "";
		this.indeks = "";
		this.grad = "";
	}

	public Student(String ime, String indeks, String grad) {
		this.ime = ime;
		this.indeks = indeks;
		this.grad = grad;
	}

	public Student(Student s) {
		this.ime = s.ime;
		this.indeks = s.indeks;
		this.grad = s.grad;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	/**
	 * Ispisuje podatke o studentu
	 */
	void prikaziPodatke() {
		System.out.println("Student (Ime: " + ime + ", indeks: " + indeks + ", grad: " + grad + ")");
	}

}
