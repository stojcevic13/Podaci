package automat.event;

/**
 * Publisher interfejs treba da implementiraju svi koji zele da omoguce 
 * drugima pracenje promena koje se desavaju nad njihovim podacima ili stanjem
 */
public interface Publisher {			
	//Metoda za dodavanje posmatra�?a (pretplata na praćenje promena) 
	public void addObserver(Observer observer);
	//Metoda za uklanjanje posmatra�?a  
	public void removeObserver(Observer observer);
	//Metoda za obaveštavanje svih koji posmatra�?a da je došlo do promene
	public void notifyObservers();
}
