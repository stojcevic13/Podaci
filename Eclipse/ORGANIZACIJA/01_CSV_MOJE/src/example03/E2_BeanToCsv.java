package example03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class E2_BeanToCsv {
	
	static final String CSV_FILE = "resources/drzave_gradovi_beans.csv";
	
	static final String[] countries = { "Srbija,Beograd", "Bolivija,Sukre", "Venecuela,Karakas", "Sent Vinsent i Grenandini,Sent Dzordz" };

	public static void main(String[] args) {
		
		writeToCsv();
	}

	private static void writeToCsv() {
		
		List<E2_Country> countryBeans = new ArrayList<E2_Country>();
		for (String country : countries) {
			String[] countryAttributes = country.split(",");
			countryBeans.add(new E2_Country(countryAttributes[0], countryAttributes[1]));
		}
		
		try(Writer writer = new FileWriter(CSV_FILE)){
			
			StatefulBeanToCsv<E2_Country> beanToCsv = new StatefulBeanToCsvBuilder<E2_Country>(writer)
					.withApplyQuotesToAll(false).build();
			
			beanToCsv.write(countryBeans);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
