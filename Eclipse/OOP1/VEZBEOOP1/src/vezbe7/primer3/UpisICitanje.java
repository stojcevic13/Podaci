package vezbe7.primer3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UpisICitanje {

	public static void main(String[] args) throws IOException {
		String sp = System.getProperty("file.separator");
		//kreiranje FileOutputStream-a
		FileOutputStream os = new FileOutputStream(new File("." + sp + "tmp.txt"),true);
		//FileOutputStream os = new FileOutputStream(".\\tmp.txt" ili unix "./tmp.txt");
		
		//funkcija write prima niz bajtova
		os.write(new byte[] {82, 83, 84});
		os.close();
		
		//FileInputStream za prethodno kreiran fajl
		FileInputStream is = new FileInputStream("." + sp + "tmp.txt");
		int b = 0;
		// funkcija available vraca broj preostalih bajtova
		System.out.println(is.available());
		// -1 predstavlja kraj fajla u funkciji read()
		while ((b = is.read()) != -1) {
			System.out.println(b + " ");
		}
		is.close();
	}

}
