package predavanje05;

public class TestIzuzeci {
	
	public void test() {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Program je trenutno puko.");
			//e.printStackTrace();
		}
	}
	
	public void f() throws MojException {
		if (Math.random() > 0.5) {
			throw new MojException();
		} else {
			System.out.println("f");
		}
	}
	
	public static void main(String[] args) {
		
		TestIzuzeci t = new TestIzuzeci();
		
		t.test();
		System.out.println("Posle");
		System.out.println("I je jednako nula.");
	}

}
