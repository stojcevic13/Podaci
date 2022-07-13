package vezbe7.primer910;

public class IzazivanjeIzuzetka {

	public static void main(String[] args) throws Exception {

		metoda();
	}
	
	static void func (boolean dat) throws Exception {
		if (dat != true) {
			throw new Exception("dat je false");
		}
	}
	
	static void metoda() throws Exception {
		boolean dat = true;
		//try {
			func(dat);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
	}

}
