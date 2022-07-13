package classes.persons;

import java.util.ArrayList;

public class Faculty {

	private ArrayList<Student> students;
	
	public Faculty() {
		this.students = new ArrayList<Student>();
	}
	
	
	public Faculty(ArrayList<Student> students) {
		this();
		this.students = students;
	}
	
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	
	public void printStudents() {
		for (Student s : this.students) {
			System.out.println(s);
		}
	}
	
	


	public static void main(String[] args) {

		Student stud1 = new Student("Mitar", "Prdekana", 20, "mitar@gmail.com", 9.12);
		Student stud2 = new Student("Mitar", "Prdekana", 21, "mitar@gmail.com", 9.18);
		
		Faculty ftn = new Faculty();
		ftn.addStudent(stud1);
		ftn.addStudent(stud2);
		
		ftn.printStudents();
		
	}

}
