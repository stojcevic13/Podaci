package classes.relationship;

import java.util.ArrayList;
import java.util.List;

import classes.relationship.methods.ListMethods;

public class Student extends Person {

	private int id;
	private String indexNum;
	private List<Subject> passedSubjects;
	private List<Subject> noPassedSubjects;
	
	
	
	private void initStudent() {
		this.passedSubjects = new ArrayList<Subject>();
		this.noPassedSubjects = new ArrayList<Subject>();
	}
	
	public Student() {
		this.initStudent();
	}

	public Student(int id, String indexNum, String firstname, String lastname, int age, int height, double weight) {
		super(firstname, lastname, age, height, weight);
		this.id = id;
		this.indexNum = indexNum;
		this.initStudent();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}

	public List<Subject> getPassedSubjects() {
		return passedSubjects;
	}

	public void setPassedSubjects(List<Subject> passedSubjects) {
		this.passedSubjects = passedSubjects;
	}

	public List<Subject> getNoPassedSubjects() {
		return noPassedSubjects;
	}

	public void setNoPassedSubjects(List<Subject> noPassedSubjects) {
		this.noPassedSubjects = noPassedSubjects;
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", indexNum=" + indexNum + super.toString() + ", passedSubjects=" + ListMethods.getSubjectNames(passedSubjects)
				+ ", noPassedSubjects=" + ListMethods.getSubjectNames(noPassedSubjects) + "]";
	}
	
	
	public void addNewSubject(Subject subject) {
		this.noPassedSubjects.add(subject);
		subject.getStudents().add(this);
	}
	
	public void passExam(Subject subject) {
		this.passedSubjects.add(subject);
		this.noPassedSubjects.remove(subject);
		subject.getStudents().remove(this);
	}
	
	
	
	
	
}
