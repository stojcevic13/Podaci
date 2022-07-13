package vjezba.task02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


public class TaskSolution {
	
	static final String CSV_INPUT = "resources/task2/studentske_ocene.csv";
	
	static List<ScoreBean> scoreBeans;
	static Map<String, Student> mapStudents = new HashMap<String, Student>();
	//         OCJENA, 		INDEX, 	BR_PREDMETA
	static Map<Integer, Map<String, List<String>>> mapPerScore = new HashMap<Integer, Map<String, List<String>>>();
	
	public static void main(String[] args) {
		
		loadData(CSV_INPUT);
		createStructures();
		saveData();
		
	}


	private static void saveData() {
	
		for (int i = 5; i <= 10; i++) {
			try( CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(new FileWriter("s" + i + ".csv"))
					.withSeparator(',').withQuoteChar(ICSVWriter.NO_QUOTE_CHARACTER).build() ) {
				
				csvWriter.writeNext("br_indeksa,ime,prezime,br_predmeta".split(","));
				
				String[] line = new String[5];
				for (Entry<String, List<String>> entry : mapPerScore.get(i).entrySet()) {
					String index = entry.getKey();
					line[0] = index; // index
					line[1] = mapStudents.get(index).getFirstname();
					line[2] = mapStudents.get(index).getLastname();
					line[3] = mapPerScore.get(i).get(index).size() + "";
					csvWriter.writeNext(line);
				}
				
			} catch (IOException e) {
				System.out.println("Desila se greska!");
			}
		}
	}


	private static void createStructures() {
		
		for (ScoreBean s : scoreBeans) {
			mapStudents.put(s.getIndex(), new Student(s.getIndex(), s.getFirstname(), s.getLastname()));
			
			if (!mapPerScore.containsKey(s.getScore()))
				mapPerScore.put(s.getScore(), new HashMap<String, List<String>>());
			if (!mapPerScore.get(s.getScore()).containsKey(s.getIndex()))
				mapPerScore.get(s.getScore()).put(s.getIndex(), new ArrayList<String>());
			mapPerScore.get(s.getScore()).get(s.getIndex()).add(s.getCourse());
		}
		
		System.out.println(mapPerScore);
	}


	private static void loadData(String csvInput) {
		
		try(Reader reader = new FileReader(csvInput)){
			
			CsvToBean<ScoreBean> csvToBean = new CsvToBeanBuilder<ScoreBean>(reader)
					.withSeparator(',').withType(ScoreBean.class).withSkipLines(1).build();
			
			scoreBeans = csvToBean.parse();

			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronadjen!");
		} catch (IOException e) {
			System.out.println("Desila se greska!");
		}
	}

}
