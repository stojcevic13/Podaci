package example02;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class E1_CSVWriter1 {

	static final String outputFile_next = "resources/drzave_gradovi_next.csv";
	static final String outputFile_all = "resources/drzave_gradovi_all.csv";
	
	static final String[] header = {"Country", "City"};
	static final String[] content = {"Canada,Otava", "Rusija,Moskva", "Srbija,Beograd", "Ekvatorijalna Gvineja,Malabo"};
	
	public static void main(String[] args) {
		
		writeCSVNext();
		writeCSVAll();
	}

	private static void writeCSVAll() {
		List<String[]> all = new ArrayList<String[]>();
		all.add(header);
		for (String data : content) {
			all.add(data.split(","));
		}
		
		try(CSVWriter writer = new CSVWriter(new FileWriter(outputFile_all))) {
			
			writer.writeAll(all);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeCSVNext() {
		
		try(CSVWriter writer = new CSVWriter(new FileWriter(outputFile_next))) {
			writer.writeNext(header);
			for (String line : content) {
				writer.writeNext(line.split(","));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
