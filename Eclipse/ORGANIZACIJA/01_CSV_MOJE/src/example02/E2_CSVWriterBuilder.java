package example02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;

public class E2_CSVWriterBuilder {
	
	static final String outputFile = "resources/drzave_gradovi_configured.csv";
	
	static final String[] header = {"Country", "City"};
	static final String[] countries = {"Australia,Canberra", "Canada,Ottawa", "China,Beijing", "France,Paris"};
			
	public static void main(String[] args) {
		
		List<String[]> content = new ArrayList<String[]>();
		
		content.add(header);
		for (String country : countries) {
			content.add(country.split(","));
		}
		
		try(CSVWriter writer = (CSVWriter) new CSVWriterBuilder(new FileWriter(outputFile))
				.withSeparator('#')
				.build()) {
			
			writer.writeAll(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
