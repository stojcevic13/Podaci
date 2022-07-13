package classes.relationship;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
	
	private String name;
	private List<Student> students;
	private List<Professor> professors;
	private List<Subject> subjects;
	
	
	private void initFaculty() {
		this.students = new ArrayList<Student>();
		this.professors = new ArrayList<Professor>();
		this.subjects = new ArrayList<Subject>();
	}
	
	public Faculty() {
		this.initFaculty();
	}
	
	public Faculty(String name) {
		this();
		this.name = name;
	}

	public Faculty(String name, List<Student> students, List<Professor> professors, List<Subject> subjects) {
		this();
		this.name = name;
		this.students = students;
		this.professors = professors;
		this.subjects = subjects;
	}
	
	public Faculty(Faculty other) {
		this(other.name, other.students, other.professors, other.subjects);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	

	@Override
	public String toString() {
		return "Faculty [name=" + name + ", students=" + students + ", professors=" + professors + ", subjects="
				+ subjects + "]";
	}
	
	
	public void addSubject(Subject subject, Professor professor) {
		this.subjects.add(subject);
		subject.getProfessors().add(professor);
		professor.getSubjects().add(subject);
	}
	
	public void removeSubject(Subject subject) {
		this.subjects.remove(subject);
		for (Professor prof : this.professors) {
			if (prof.getSubjects().contains(subject))
				prof.getSubjects().remove(subject);
		}
	}
	
	
	
	
}
