package vezbe11.observer;

import java.util.ArrayList;
import java.util.Observable;

public class Course extends Observable {

	private String name;
	private ArrayList<String> notifications = new ArrayList<String>();

	public Course(String name) {
		this.name = name;
	}

	public void postAnnouncement(String announcement) {
		notifications.add(announcement);
		// markira objekat da je izmenjen
		setChanged();
		// ako je objekat markiran kako izmenjen
		// obavesti sve posmatrace
		notifyObservers(announcement);
		// marker je postavljen na false
		System.out.println(hasChanged());
	}

	public String getName() {
		return name;
	}
}
