package classes.relationship;

import java.util.ArrayList;
import java.util.List;

public class TestFaculty {

	public static void main(String[] args) {
		
		Student stud1 = new Student(1, "EM 25/2021", "Strahinja", "Erakovic", 22, 185, 80);
		Student stud2 = new Student(2, "IT 21/2019", "Mirko", "Ivanic", 28, 184, 80);
		Student stud3 = new Student(3, "SV 41/2010", "Sale", "Katai", 30, 185, 82);
		
		Professor prof1 = new Professor(1, "Deki", "Stankovic", 45, 182, 91);
		Professor prof2 = new Professor(2, "Mitar", "Mrkela", 55, 186, 90);
		
		Subject sub1 = new Subject(1, "SIMS", 6);
		Subject sub2 = new Subject(2, "NANS", 4);
		Subject sub3 = new Subject(3, "NASP", 4);
		
		stud1.addNewSubject(sub3);
		stud2.addNewSubject(sub3);
		stud3.addNewSubject(sub3);
		stud1.addNewSubject(sub2);
		stud2.addNewSubject(sub2);
		stud3.addNewSubject(sub2);
		stud1.addNewSubject(sub1);
		stud2.addNewSubject(sub1);
		stud3.addNewSubject(sub1);
		stud1.passExam(sub2);
		stud2.passExam(sub2);
		stud3.passExam(sub2);
		stud1.passExam(sub1);
		
		prof1.addSubject(sub1);
		prof1.addSubject(sub2);
		prof2.addSubject(sub1);
		prof2.addSubject(sub3);
		
		List<Professor> professors = new ArrayList<Professor>();
		professors.add(prof1);
		professors.add(prof2);
		
		List<Student> students = new ArrayList<Student>();
		students.add(stud1);
		students.add(stud2);
		students.add(stud3);
		
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(sub1);
		subjects.add(sub2);
		subjects.add(sub3);
		
		
		Faculty faculty = new Faculty("FTN", students, professors, subjects);
		System.out.println(faculty);
		
	}

}
