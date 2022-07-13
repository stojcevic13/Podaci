package predavanje03;

public class TestAuto {

	public static void main(String[] args) {
		
		Auto a1 = new Auto(5, 5, 5, 5);
		
		System.out.println("a1.prednjiDesni.pritisak = " + a1.prednjiDesni.pritisak);
		Auto a2 = a1.copy();
		System.out.println("a2.prednjiDesni.pritisak = " + a2.prednjiDesni.pritisak);
		
		a2.prednjiDesni.pritisak = 90;
		
		System.out.println("a1.prednjiDesni.pritisak = " + a1.prednjiDesni.pritisak);
		System.out.println("a2.prednjiDesni.pritisak = " + a2.prednjiDesni.pritisak);

		
	}

}
