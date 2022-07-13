package predavanje04;

public class NaplatnaRampaTest {

	public static void main(String[] args) {
		
		NaplatnaRampa nr = new NaplatnaRampa(2000);
		
		Auto a1 = new Auto();
		Kamion k1 = new Kamion();
		Traktor t1 = new Traktor();
		
		nr.naplati(a1);
		nr.naplati(k1);
		
		MozeDaPlatiPutarinu[] vozila = {new Auto(), new Kamion(), new Auto()};
		nr.naplati(vozila);
		
		System.out.println(nr.getTotal());
		
		t1.ori();

	}

}
