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

import classes.relationship.Subject;



public class SubjectManager {

	private List<Subject> subjects;
	private Map<Integer, Subject> mapSubjects;
	private String subjectsFile;
	private String delimiter = ";";
	
	
	public SubjectManager() {
		this.subjects = new ArrayList<Subject>();
		this.mapSubjects = new HashMap<Integer, Subject>();
	}
	
	public SubjectManager(String subjFile) {
		this();
		this.subjectsFile = subjFile;
		loadSubjects();
	}
	
	

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Map<Integer, Subject> getMapSubjects() {
		return mapSubjects;
	}

	public void setMapSubjects(Map<Integer, Subject> mapSubjects) {
		this.mapSubjects = mapSubjects;
	}

	public String getSubjectsFile() {
		return subjectsFile;
	}

	public void setSubjectsFile(String subjectsFile) {
		this.subjectsFile = subjectsFile;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	
	private void loadSubjects() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(subjectsFile), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.startsWith("#"))
					continue;
				Subject subject = parseSubject(line);
				addSubject(subject);
			}
			in.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Fajl " + subjectsFile + " nije pronadjen!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
		this.mapSubjects.put(subject.getId(), subject);
	}
	
	
	public void removeSubject(Subject subject) {
		this.subjects.remove(subject);
		this.mapSubjects.remove(subject.getId());
	}

	
	private Subject parseSubject(String line) {
		String[] tokens = line.split(delimiter);
		for (int i = 0; i < tokens.length; i++) tokens[i] = tokens[i].trim();
		int id = Integer.parseInt(tokens[0]);
		String name = tokens[1];
		int espb = Integer.parseInt(tokens[2]);
		return new Subject(id, name, espb);
	}
	
	
	public void saveSubjects() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(subjectsFile), "utf-8"));
			
			out.println("#ID; NAME;	ESBP");
			for (Subject subject : this.subjects) {
				out.println(subject.toFileString());
			}
			
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Fajl " + subjectsFile + " nije pronadjen!");
		}
		
	}

	
	
	public static void main(String[] args) {
		SubjectManager subjectManager = new SubjectManager("data/subjects.txt");
		System.out.println(subjectManager.subjects);
		subjectManager.subjects.get(0).setName("NENSI");
		subjectManager.saveSubjects();
	}
}
