package example01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class E5_CSVReaderWithCSVParser {
	
	static final String CSV_FILE = "resources/indijska_hrana.csv";

	public static void main(String[] args) {
		
		CSVParser parser = new CSVParserBuilder().withSeparator(';').withQuoteChar('\'').build();
		
		try(CSVReader csvReader = new CSVReaderBuilder(new FileReader(CSV_FILE)).withCSVParser(parser).withSkipLines(1).build()) {
			String[] row;
			while ((row = csvReader.readNext()) != null) {
				StringBuilder rowData = new StringBuilder();
				for (int i = 0; i < row.length; i++) {
					rowData.append(row[i]);
					if (i != row.length - 1)
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
