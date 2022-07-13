package example03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class E1_CsvToBean {
	
	static final String CSV_FILE = "resources/drzave_gradovi.csv";

	public static void main(String[] args) {
		
		csvToBeanColumnNames();
		
		System.out.println("\n\n############################################\n\n");
		
		csvToBeanPositionNames();

	}

	private static void csvToBeanPositionNames() {
		
		try(Reader reader = new FileReader(CSV_FILE)){
			
			CsvToBean<E1_Country_PositionNames> csvToBean = new CsvToBeanBuilder<E1_Country_PositionNames>(reader)
					.withType(E1_Country_PositionNames.class).withSeparator(',').build();
			
			List<E1_Country_PositionNames> countries = csvToBean.parse();
			
			for (E1_Country_PositionNames country : countries) {
				System.out.println(country);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void csvToBeanColumnNames() {
		
		try(Reader reader = new FileReader(CSV_FILE)){
			
			CsvToBean<E1_Country_ColumnNames> csvToBean = new CsvToBeanBuilder<E1_Country_ColumnNames>(reader)
					.withType(E1_Country_ColumnNames.class).withSeparator(',').withSkipLines(1).build();
			
			List<E1_Country_ColumnNames> countries = csvToBean.parse();
			
			for (E1_Country_ColumnNames country : countries) {
				System.out.println(country);
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
