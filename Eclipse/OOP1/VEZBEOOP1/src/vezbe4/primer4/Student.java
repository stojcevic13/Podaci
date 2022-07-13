package vezbe4.primer4;

public class Student {

	/*
	 * Modifikatori pristupa definišu dostupnost podataka – klase, atributa, metoda i konstruktora.
	 * Postoje četiri tipa java modifikatora pristupa:
	 * 		private – dostupnost unutar klase
	 * 		protected – dostupnost unutar paketa i u klasama naslednicama. Primenljivo nad atributima, metodama i konstruktorima, a ne i nad klasama.
	 * 		public – dostupnost u svim klasama i paketima
	 * 		nespecificirani – dostupnost unutar paketa (package‐private)
	 */
	private String ime;
	private String indeks;
	private String grad;

	/**
	 * Ispisuje podatke o studentu
	 */
	void prikaziPodatke() {
		System.out.println("Student (Ime: " + ime + ", indeks: " + indeks + ", grad: " + grad + ")");
	}
	
	// kontrolisan pristup atributima pomocu get i set metoda
	// get za citanje vrednosti
	// set za izmenu vrednosti
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

}
