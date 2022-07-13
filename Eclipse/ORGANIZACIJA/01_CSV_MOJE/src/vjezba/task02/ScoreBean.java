package vjezba.task02;

import com.opencsv.bean.CsvBindByPosition;

public class ScoreBean {
	//		0		1	 2		 3		4
	// br_indeksa,ime,prezime,predmet,ocena

	@CsvBindByPosition(position = 0, required = true)
	private String index;
	@CsvBindByPosition(position = 1, required = true)
	private String firstname;
	@CsvBindByPosition(position = 2, required = true)
	private String lastname;
	@CsvBindByPosition(position = 3, required = true)
	private String course;
	@CsvBindByPosition(position = 4, required = true)
	private int score;
	
	
	public ScoreBean() {
		
	}


	public ScoreBean(String index, String firstname, String lastname, String course, int score) {
		this();
		this.index = index;
		this.firstname = firstname;
		this.lastname = lastname;
		this.course = course;
		this.score = score;
	}


	public String getIndex() {
		return index;
	}


	public void setIndex(String index) {
		this.index = index;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		ScoreBean other = (ScoreBean) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (score != other.score)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ScoreBean [index=" + index + ", firstname=" + firstname + ", lastname=" + lastname + ", course="
				+ course + ", score=" + score + "]";
	}
	
}
