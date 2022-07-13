package example01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class E3_BufferedReader2 {
	
	static final String CSV_FILE = "resources/drzave_gradovi.csv";
	static final String DELMITER = ",";

	public static void main(String[] args) {
		
		try(BufferedReader bf = new BufferedReader(new FileReader(CSV_FILE))) {
			
			String line = "";
			while ((line = bf.readLine()) != null) {
				String[] tokens = line.split(DELMITER);
				for (String token : tokens) {
					System.out.print(token + " | ");
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

}
