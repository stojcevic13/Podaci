package predavanje06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class NormalanRadSaTxtFajlovima {

	public static void main(String[] args) {
		try {
			
			BufferedReader in = new BufferedReader(new FileReader("podaci.txt"));
			String linija;
			while ((linija = in.readLine()) != null) {
				System.out.println(linija);
			}
			in.close();
			
			
			PrintWriter out = new PrintWriter(new FileWriter("podaci2.txt"));
			String[] ispis = {"Новак Ђоковић", "Тијана Богдановић", "Милица Мандић", "Маја Огњеновић"};
			for (String s : ispis) {
				out.println(s);
			}
			out.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
