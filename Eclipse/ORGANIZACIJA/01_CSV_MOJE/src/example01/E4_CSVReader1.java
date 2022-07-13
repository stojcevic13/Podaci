package example01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class E4_CSVReader1 {
	
	static final String CSV_FILE = "resources/drzave_gradovi.csv";

	public static void main(String[] args) {
		
		readNextExample();
		
		readAllExample();
	}

	private static void readAllExample() {
		
		try (CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE))){
			List<String[]> rows = csvReader.readAll();
			
			for (String[] row : rows) {
				StringBuilder rowData = new StringBuilder();
				for (int i = 0; i < row.length; i++) {
					rowData.append(row[i]);
					if (i != row.length -1)
						rowData.append(" | ");
				}
				System.out.println(rowData);
			}
			
		}
		  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readNextExample() {
		
		try(CSVReader csvReader = new CSVReader(new FileReader(CSV_FILE))){
			String[] row;
			
			while ((row = csvReader.readNext()) != null) {
				StringBuilder rowData = new StringBuilder();
				// row = [data1, data2, data3...]
				for (int i = 0; i < row.length; i++) {
					rowData.append(row[i]);
					if (i != row.length-1)
						rowData.append(" | ");
				}
				System.out.println(rowData);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
