package vezbe7.primer8;

import java.io.EOFException;

public class TryCatchBlok {

	public static void main(String[] args) {
		try {
			//kod koji moze da izazove izuzetak
			throw new EOFException();
		}
		catch (EOFException ex) {
			System.out.println("Kraj datoteke pre vremena!");
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Pristup van granica niza!");
		}
		catch (Exception ex) {
			System.out.println("Svi ostali izuzeci");
		}
		finally {
			// kod koji se izvrsava u svakom slucaju
			System.out.println("Finnaly deo bloka");
		}
	}

}
