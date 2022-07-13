package classes.relationship.managers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.relationship.Student;


public class StudentManager {
	
	private List<Student> students;
	private Map<Integer, Student> mapStudents;
	private String studentsFile;
	private String delimiter = ";";
	
	
	
	public StudentManager() {
		this.students = new ArrayList<Student>();
		this.mapStudents = new HashMap<Integer, Student>();
	}
	
	public StudentManager(String studentsFile) {
		this.studentsFile = studentsFile;
		loadStudents();
	}
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Map<Integer, Student> getMapStudents() {
		return mapStudents;
	}

	public void setMapStudents(Map<Integer, Student> mapStudents) {
		this.mapStudents = mapStudents;
	}

	public String getStudentsFile() {
		return studentsFile;
	}

	public void setStudentsFile(String studentsFile) {
		this.studentsFile = studentsFile;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	
	
	public void loadStudents() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(studentsFile), "utf-8"));
			
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.startsWith("#"))
					continue;
				Student stud = parseStudent(line);
				addStudent(stud);
			}
			
			in.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Fajl " + studentsFile + " nije pronadjen!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void addStudent(Student stud) {
		this.students.add(stud);
		this.mapStudents.put(stud.getId(), stud);
	}
	
	
	public void removeStudent(Student stud) {
		this.students.remove(stud);
		this.mapStudents.remove(stud.getId());
	}
	
	
	public Student parseStudent(String line) {
		
		String[] tokens = line.split(delimiter);
		for (int i = 0; i < tokens.length; i++) tokens[i] = tokens[i].trim();
		// id, indexNum, firstname, lastname, age, height, weight, passed, noPassed
		int id = Integer.parseInt(tokens[0]);
		String indexNum = tokens[1];
		String firstname = tokens[2];
		String lastname = tokens[3];
		int age = Integer.parseInt(tokens[4]);
		int height = Integer.parseInt(tokens[5]);
		
		double weight = Double.parseDouble(tokens[6]);
		
		return new Student(id, indexNum, firstname, lastname, age, height, weight);
	}
	
	
	public void saveStudents() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(studentsFile), "utf-8"));
			
			out.println("# ID, indexNum, firstname, lastname, age, height, weight, passed");
			// Dalje znas sta se desilo...
			
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Fajl " + studentsFile + " nije pronadjen!");
		}
		
	}

	

}
