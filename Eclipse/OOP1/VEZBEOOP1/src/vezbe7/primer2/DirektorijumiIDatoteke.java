package vezbe7.primer2;

import java.io.File;
import java.io.IOException;

public class DirektorijumiIDatoteke {

	public static void main(String[] args) throws IOException {
		//kreiranje objekta
		File dir = new File("." + System.getProperty("file.separator") + "src1");
		//provera da li postoji
		if (dir.exists()) {
			System.out.println("Putanja apsolutna " + dir.getAbsolutePath());
			System.out.println("Putanja relativna " + dir.getPath());
			//provera da li je objekat File direktorijum
			if (dir.isDirectory()) {
				System.out.println(dir.getName() + " je direktorium");
				//broj fajlova u direktorijumu
				System.out.println(dir.listFiles().length);
			} else {
				if (dir.isFile())
					System.out.println(dir.getName() + " je datoteka");
			}
			dir.delete();
		} else {
			//dir.mkdir();
			//ili
			dir.createNewFile();
		}

	}

}
