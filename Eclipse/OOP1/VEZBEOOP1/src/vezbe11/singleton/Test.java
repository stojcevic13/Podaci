package vezbe11.singleton;

import java.util.ArrayList;

import vezbe4.primer5.Student;

public class Test {

	public static void main(String[] args) {

		ArrayList<Student> listaStudenata = new ArrayList<Student>();

		UIManager.lista.addAll(listaStudenata);
		UIManager.getInstance().writeToFile("student.txt");
		UIManager.getInstance().readFromFile("student.txt");
		listaStudenata.addAll((ArrayList) UIManager.lista);

		for (Student s : listaStudenata) {
			System.out.println(s);
		}
	}

}
