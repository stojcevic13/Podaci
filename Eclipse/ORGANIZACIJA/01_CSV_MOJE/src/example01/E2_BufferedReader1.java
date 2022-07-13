package example01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class E2_BufferedReader1 {
	
	static final String CSV_FILE = "resources/drzave_gradovi.csv";
	static final String DELIMITER = ",";

	public static void main(String[] args) {
		
		BufferedReader bufferedReader = null;
		try {
			String line = "";
			bufferedReader = new BufferedReader(new FileReader(CSV_FILE));
			while ((line = bufferedReader.readLine()) != null) {
				String[] tokens = line.split(DELIMITER);
				for (String token : tokens) {
					System.out.print(token + " | ");
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			}
		}

	}

}
