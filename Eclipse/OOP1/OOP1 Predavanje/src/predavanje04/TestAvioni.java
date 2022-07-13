package predavanje04;

public class TestAvioni {

	public static void main(String[] args) {
		
		Pista pista = new Pista(6);
		
		Avion a1 = new Avion("MIG31", 300, "Japanac");
		BorbeniAvion a2 = new BorbeniAvion("MIG33", 350, "Japanac", "top34m2", 15);
		
		pista.polijetanjeAvionaSaPiste(a1);
		pista.slijetanjeNovogAviona(a1);
		pista.slijetanjeNovogAviona(a2);
		
		System.out.println(pista.getBrAviona());
		

	}

}
