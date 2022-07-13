package classes.relationship;

import java.util.ArrayList;
import java.util.List;

import classes.relationship.methods.ListMethods;

public class Subject {
	
	private int id;
	private String name;
	private int ESPB;
	private List<Professor> professors;		// profesori koji mogu da drze ovaj predmet
	private List<Student> students; 	// studenti koji trenutno polazu ovaj predmet
	
	
	private void initSubject() {
		this.professors = new ArrayList<Professor>();
		this.students = new ArrayList<Student>();
	}
	
	public Subject() {
		this.initSubject();
	}
	
	public Subject(int id, String name, int espb) {
		this();
		this.id = id;
		this.name = name;
		this.ESPB = espb;
	}

	public Subject(int id, String name, int espb, List<Professor> professors, List<Student> students) {
		this();
		this.id = id;
		this.name = name;
		this.ESPB = espb;
		this.professors = professors;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getESPB() {
		return ESPB;
	}

	public void setESPB(int eSPB) {
		ESPB = eSPB;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
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
		Subject other = (Subject) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", ESPB=" + ESPB + ", professors=" + ListMethods.getProfessorNames(professors)
		+ ", students=" + ListMethods.getStudentNames(students) + "]";
	}

	public String toFileString() {
		return String.join("; ", ""+id, name, ""+ESPB);
	}
	
	
	
	
	
	
	
	

}
