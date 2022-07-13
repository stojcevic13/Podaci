package vezbe11.observer;

public class Enastava {

	public static void main(String[] args) {

		Course c1 = new Course("OOP");
		Course c2 = new Course("NANS");

		Student s1 = new Student("Marko", "Markovic", "sw12345");
		Student s2 = new Student("Janko", "Jankovic", "sw34567");
		Student s3 = new Student("Branko", "Brankovic", "sw87654");

		c1.addObserver(s1);
		s1.addCourse(c1);

		c1.addObserver(s2);
		s2.addCourse(c1);

		c2.addObserver(s2);
		s2.addCourse(c2);
		c2.addObserver(s3);
		s3.addCourse(c2);

		c1.postAnnouncement("Rezultati ispita odrzanog...");
		c2.postAnnouncement("Teorijski dio ispita bice odrzan...");
		s2.listCourses();
	}

}
