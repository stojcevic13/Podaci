package zadatak4c;


public class Test {

	public static void main(String[] args) {

		LigaManager ligaManager = new LigaManager("liga.txt");
		KlubManager klubManager = new KlubManager("klub.txt");
		new VezaKlubLigaManager(klubManager, ligaManager, "veza-klub-liga.txt");
		
		for (Liga l : ligaManager.getLige())
			System.out.println(l);
		
		for (Klub k : klubManager.getKlubovi())
			System.out.println(k);

	}

}
