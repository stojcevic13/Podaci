package task02;

import com.opencsv.bean.CsvBindByPosition;

public class StudentScore {
	
	@CsvBindByPosition(position = 0, required = true)
	private String index;
	@CsvBindByPosition(position = 1, required = true)
	private String firstName;
	@CsvBindByPosition(position = 2, required = true)
	private String lastName;
	@CsvBindByPosition(position = 3, required = true)
	private String course;
	@CsvBindByPosition(position = 4, required = true)
	private int score;
	
	
	public StudentScore() {
		
	}


	public StudentScore(String index, String firstName, String lastName, String course, int score) {
		super();
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.score = score;
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


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	
	


	@Override
	public String toString() {
		return "StudentScore [index=" + index + ", firstName=" + firstName + ", lastName=" + lastName + ", course="
				+ course + ", score=" + score + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + score;
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
		StudentScore other = (StudentScore) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
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
		if (score != other.score)
			return false;
		return true;
	}
	
	
	
	

}
