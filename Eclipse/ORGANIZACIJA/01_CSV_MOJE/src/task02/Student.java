package task02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
	
	private String index;
	private String firstName;
	private String lastName;
	private Map<Integer, List<String>> coursesMap;
	private Map<String, Integer> passedCourses;
	
	
	public Student() {
		this.coursesMap = new HashMap<Integer, List<String>>();
		this.passedCourses = new HashMap<String, Integer>();
	}
	
	public Student(String index, String firstName, String lastName) {
		this();
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	


	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Map<Integer, List<String>> getCoursesMap() {
		return coursesMap;
	}

	public void setCoursesMap(Map<Integer, List<String>> coursesMap) {
		this.coursesMap = coursesMap;
	}

	public Map<String, Integer> getPassedCourses() {
		return passedCourses;
	}

	public void setPassedCourses(Map<String, Integer> passedCourses) {
		this.passedCourses = passedCourses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coursesMap == null) ? 0 : coursesMap.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((passedCourses == null) ? 0 : passedCourses.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		if (coursesMap == null) {
			if (other.coursesMap != null)
				return false;
		} else if (!coursesMap.equals(other.coursesMap))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (passedCourses == null) {
			if (other.passedCourses != null)
				return false;
		} else if (!passedCourses.equals(other.passedCourses))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [index=" + index + ", firstName=" + firstName + ", lastName=" + lastName + ", coursesMap="
				+ coursesMap + ", passedCourses=" + passedCourses + "]";
	}

	public static void main(String[] args) {
		Map<Integer, List<String>> mapa = new HashMap<Integer, List<String>>();
		mapa.put(5, new ArrayList<String>());
		mapa.get(5).add("Biologija");
		System.out.println(mapa);
	}
	

}
