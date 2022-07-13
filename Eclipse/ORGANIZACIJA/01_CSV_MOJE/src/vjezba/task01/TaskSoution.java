package vjezba.task01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class TaskSoution {
	
	static final String CSV_INPUT = "resources/task1/tacke.csv";
	static final String CSV_OUTPUT_A = "resources/task1/vjezba_tacke_output_A.csv";
	static final String CSV_OUTPUT_B = "resources/task1/vjezba_tacke_output_B.csv";
	
	static List<TackaBean> tacke;

	public static void main(String[] args) {
		
		loadTacke();
		
		for (TackaBean tacka : tacke)
			tacka.calculateDistance();
		
		try {
			saveTackeA(CSV_OUTPUT_A);
			
			// SORTIRANJE
			Collections.sort(tacke, new Comparator<TackaBean>() {
				@Override
				public int compare(TackaBean o1, TackaBean o2) {
					if (o1.getDistance() < o2.getDistance())
						return 1;
					else if (o1.getDistance() > o2.getDistance())
						return -1;
	
					return 0;
				}
			});

			saveTackeA(CSV_OUTPUT_B);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
		
	}

	private static void saveTackeA(String csvFile) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		
		try(Writer writer = new FileWriter(csvFile)){
			
			StatefulBeanToCsv<TackaBean> beanToCsv = new StatefulBeanToCsvBuilder<TackaBean>(writer)
					.withSeparator('#').withApplyQuotesToAll(false).build();
			
			beanToCsv.write(tacke);
		}
		
	}

	private static void loadTacke() {
		
		try(Reader reader = new FileReader(CSV_INPUT)){
			
			CsvToBean<TackaBean> csvToBean = new CsvToBeanBuilder<TackaBean>(reader)
					.withSeparator(',').withType(TackaBean.class).build();
			
			tacke = csvToBean.parse();

			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronadjen.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Desila se greska!");
			e.printStackTrace();
		}
	}

}
