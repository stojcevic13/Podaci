package vezbe11.observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {

	private String name;
	private String surname;
	private String index;
	private ArrayList<Course> courses = new ArrayList<Course>();

	public Student(String name, String surname, String index) {
		this.name = name;
		this.surname = surname;
		this.index = index;
	}

	@Override
	public void update(Observable o, Object arg) {
		String courseName = ((Course) o).getName();
		System.out.println("Student profile: " + index + " " + name + " " + surname);
		System.out.println("*New notification in " + courseName + " course:");
		System.out.println("*" + arg.toString());
	}

	public void addCourse(Course c) {
		courses.add(c);
	}

	public void listCourses() {
		System.out.println("Student " + index + " " + name + " " + surname + " is involved in: ");
		for (Course c : courses) {
			System.out.println(c.getName());
		}
	}

}
