package automat.event;

/**
 * Publisher interfejs treba da implementiraju svi koji zele da omoguce 
 * drugima pracenje promena koje se desavaju nad njihovim podacima ili stanjem
 */
public interface Publisher {			
	//Metoda za dodavanje posmatraÄ?a (pretplata na praÄ‡enje promena) 
	public void addObserver(Observer observer);
	//Metoda za uklanjanje posmatraÄ?a  
	public void removeObserver(Observer observer);
	//Metoda za obaveÅ¡tavanje svih koji posmatraÄ?a da je doÅ¡lo do promene
	public void notifyObservers();
}
