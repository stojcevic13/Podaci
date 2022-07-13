package vezbe6.primer7;

import java.util.Comparator;

public class OsnovniSorter implements Comparator{

	/** atribut koji definise smer sortiranja, 1 - rastuce, -1 - opadajuce */
	int direction = 1; 
	public int compare(Object o1, Object o2) {
		int retVal = 0;
		if(o1 != null && o2 != null && o1 instanceof Knjiga && o2 instanceof Knjiga) {
			Knjiga objKnjiga1 = (Knjiga)o1;
			Knjiga objKnjiga2 = (Knjiga)o2;
			retVal = objKnjiga1.getNaziv().compareTo(objKnjiga2.getNaziv());
		}
		// moguce definisati pravilo za sortiranje razlicitih tipova objekata
		/* if(o1 != null && o2 != null && o1 instanceof Student && o2 instanceof Student) {
		 * 		Student objStudent1 = (Student)o1;
		 * 		Student objStudent2 = (Student)o2;
		 * 		retVal = objStudent1.getIme().compareTo(objStudent2.getIme());
		 * }
		 */
		return retVal*direction;
	}
}
