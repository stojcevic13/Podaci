package vezbe7.primer5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpisICitanjeUzBRiPW {

	public static void main(String[] args) throws IOException {
		String sp = System.getProperty("file.separator");
		//kreiranje PrintWriter-a
		PrintWriter out = new PrintWriter(new FileWriter("." + sp + "tmp.txt", true));
		//upis u fajl preko printf funkcije
		out.printf("Rezultat je : %.3f \n", 3.123456);
		out.close();
		String sCurrentLine;
		//BufferedReader za citanje fajla
		BufferedReader br = new BufferedReader(new FileReader("." + sp + "tmp.txt"));
		
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
		}
		
		br.close();
	}

}
