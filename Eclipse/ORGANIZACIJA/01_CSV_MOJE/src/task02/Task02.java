package task02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class Task02 {
	
	static final String studentske_ocene_csv = "resources/task2/studentske_ocene.csv";
	
	static List<StudentScore> scores;
	
	static Map<String, Student> studentsMap = new HashMap<String, Student>();
	static Map<Integer, List<Student>> studentsGradesMap = new HashMap<Integer, List<Student>>();
	
	

	public static void main(String[] args) {
		
		try {
			
			loadData();
			for (StudentScore score : scores) {
				if (!studentsMap.containsKey(score.getIndex())) {
					studentsMap.put( score.getIndex(), new Student(score.getIndex(), score.getFirstName(), score.getLastName() ));
				}
				Student stud = studentsMap.get(score.getIndex());
				
				if (!stud.getCoursesMap().containsKey(score.getScore())) {
					stud.getCoursesMap().put(score.getScore(), new ArrayList<String>());
				}
				stud.getCoursesMap().get(score.getScore()).add(score.getCourse());
				
				if (!studentsGradesMap.containsKey(score.getScore())) {
					studentsGradesMap.put(score.getScore(), new ArrayList<Student>());
				}
				studentsGradesMap.get(score.getScore()).add(stud);
				if (score.getScore() >= 6)
					stud.getPassedCourses().put(score.getCourse(), score.getScore());
			}

			saveDataGrades();
			saveDataCourses();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	private static void saveDataCourses() throws IOException {
		
		try(@SuppressWarnings("deprecation")
		CSVWriter csvWriter = new CSVWriter(new FileWriter("resources/task2/studenti_predmet.csv")) ){
			
			csvWriter.writeNext("BrIndeksa,Ime,Prezime,BrojPolozenihPredmeta,ProsjecnaOcjena".split(","));
			for (Student stud : studentsMap.values()) {
				String[] line = new String[5];
				line[0] = stud.getIndex();
				line[1] = stud.getFirstName();
				line[2] = stud.getLastName();
				line[3] = stud.getPassedCourses().size() + "";
				
				int sum_grades = 0;
				for (int grade : stud.getPassedCourses().values())
					sum_grades += grade;
				line[4] = String.format("%.2f", sum_grades*1.0 / stud.getPassedCourses().size());
				
				csvWriter.writeNext(line);
			}
		}
	}

	private static void saveDataGrades() throws IOException {
		for (int grade = 5; grade <= 10; grade++) {
			try(CSVWriter csvWriter = new CSVWriter(new FileWriter("resources/task2/studenti_ocena_" + grade + ".csv"))){
				
				csvWriter.writeNext("brIndeksa,Ime,Prezime,BrojPredmeta".split(","));
				for (Student stud : studentsMap.values()) {
					String[] line = new String[4];
					line[0] = stud.getIndex();
					line[1] = stud.getFirstName();
					line[2] = stud.getLastName();
					if (!stud.getCoursesMap().containsKey(grade))
						line[3] = "0";
					else
						line[3] = stud.getCoursesMap().get(grade).size() + "";
					csvWriter.writeNext(line);
				}
				
			}
		}
	}

	private static void loadData() throws FileNotFoundException, IOException {
		
		try(Reader reader = new FileReader(studentske_ocene_csv)){
			CsvToBean<StudentScore> csvToBean = new CsvToBeanBuilder<StudentScore>(reader)
					.withType(StudentScore.class).withSkipLines(1).build();
			scores = csvToBean.parse();
		}
	}

}
