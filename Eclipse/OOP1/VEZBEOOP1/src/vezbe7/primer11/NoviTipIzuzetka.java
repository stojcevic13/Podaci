package vezbe7.primer11;

public class NoviTipIzuzetka {

	public static void main(String[] args) {
		try {
			throw new MyException("Nasa greska");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
