package vezbe6.primer2;

public enum GodisnjaDoba {

	ZIMA(1), PROLECE(2), LETO(3), JESEN(4);

	int doba;

	private GodisnjaDoba() {
	}

	private GodisnjaDoba(int i) {
		this.doba = i;
	}

	private String [] opis = {"zima", "prolece", "leto", "jesen"};
	
	@Override
	public String toString() {
		return opis[this.ordinal()];
	}
}
