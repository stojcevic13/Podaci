package vezbe7.primer7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFormat {

	public static void main(String[] args) throws IOException {
		String sp = System.getProperty("file.separator");
		//ZipOutputStream za kreiranje zip fajla
		ZipOutputStream zip = new ZipOutputStream(
				new FileOutputStream("." + sp + "arhiva.zip"));
		
		//ZipEntry za kreiranje fajla u okviru zip fajla
		ZipEntry file = new ZipEntry("direktorijum" + sp + "datoteka.txt");
		zip.putNextEntry(file);
		
		byte[] buffer = new byte[1024];
		FileInputStream in = new FileInputStream("." + sp + "tmp.txt");
	
		int len;
		//upis podataka iz tmp.txt u fajl iz zip fajla
		while ((len = in.read(buffer)) > 0) {
			zip.write(buffer, 0, len);
		}
		in.close();
		zip.close();
	}

}
