package vjezba.example03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CsvToBeanLoad {
	
	static final String CSV_FILE_INPUT = "resources/drzave_gradovi.csv";
	static final String CSV_FILE_OUTPUT = "resources/drzave_gradovi_output.csv";

	static List<CountryBean> countries;
	
	public static void main(String[] args) {
		
		loadCsvToBean();

		saveBeanToCsv();
	}


	private static void loadCsvToBean() {
		
		try(Reader reader = new FileReader(CSV_FILE_INPUT)){
			
			CsvToBean<CountryBean> csvToBean = new CsvToBeanBuilder<CountryBean>(reader)
					.withSkipLines(1).withSeparator(',').withType(CountryBean.class).build();
			
			countries = csvToBean.parse();
			for (CountryBean country : countries)
				System.out.println(country);
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronadjen.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	
	

	private static void saveBeanToCsv() {
		
		try(Writer writer = new FileWriter(CSV_FILE_OUTPUT)){
			
			StatefulBeanToCsv<CountryBean> beanToCsv = new StatefulBeanToCsvBuilder<CountryBean>(writer)
					.withSeparator(',').withApplyQuotesToAll(false).build();
			
			beanToCsv.write(countries);
			
		} catch (IOException e) {
			System.out.println("Десила се грешка!");
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
