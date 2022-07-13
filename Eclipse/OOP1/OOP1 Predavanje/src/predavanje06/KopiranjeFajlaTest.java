package predavanje06;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class KopiranjeFajlaTest {

	public static void main(String[] args) {
		final int BUFFER = 1024;
		try {
		
			FileInputStream in = new FileInputStream("datoteka1.txt");
			FileOutputStream out = new FileOutputStream("datoteka2.txt");
			byte[] buffer = new byte[BUFFER];
			int read;
			while ((read = in.read(buffer, 0, BUFFER)) != -1) {
				System.out.println(read);
				out.write(buffer, 0, read);
			}
			in.close();
			out.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
