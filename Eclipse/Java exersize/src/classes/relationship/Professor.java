package classes.relationship;

import java.util.ArrayList;
import java.util.List;

import classes.relationship.methods.ListMethods;

public class Professor extends Person {

	private int id;
	private List<Subject> subjects;
	
	
	private void initProfessor() {
		this.subjects = new ArrayList<Subject>();
	}
	
	public Professor() {
		this.initProfessor();
	}

	public Professor(int id, String firstname, String lastname, int age, int height, double weight) {
		super(firstname, lastname, age, height, weight);
		this.initProfessor();
		this.id = id;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + super.toString() + ", subjects=" + ListMethods.getSubjectNames(subjects) + "]";
	}
	
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
		subject.getProfessors().add(this);
	}
	
	
	
	
	
}
