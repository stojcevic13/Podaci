package classes.relationship.methods;

import java.util.List;

import classes.relationship.Professor;
import classes.relationship.Student;
import classes.relationship.Subject;

public class ListMethods {
	
	public static String getSubjectNames(List<Subject> subjects) {
		String names = "[";
		for (int i = 0; i < subjects.size(); i++) {
			names += subjects.get(i).getName();
			if (i < subjects.size()-1)
				names += ", ";
		}
		names += "]";
		return names;
	}
	
	public static String getProfessorNames(List<Professor> professors) {
		String names = "[";
		Professor prof;
		for (int i = 0; i < professors.size(); i++) {
			prof = professors.get(i);
			names += prof.getFirstname() + " " + prof.getLastname();
			if (i < professors.size()-1)
				names += ", ";
		}
		names += "]";
		return names;
	}

	public static String getStudentNames(List<Student> students) {
		String names = "[";
		Student stud;
		for (int i = 0; i < students.size(); i++) {
			stud = students.get(i);
			names += stud.getFirstname() + " " + stud.getLastname();
			if (i < students.size()-1)
				names += ", ";
		}
		names += "]";
		return names;
	}

	

}
