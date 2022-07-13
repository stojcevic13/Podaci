package zadatak4b;


public class Test {

	public static void main(String[] args) {

		KlubManager klubManager = new KlubManager("klub.txt");
		IgracManager igracManager = new IgracManager(klubManager, "igracb.txt");
		
		for (Igrac i : igracManager.getIgraci())
			System.out.println(i);
		
		for (Klub k : klubManager.getKlubovi())
			System.out.println(k);

	}

}
