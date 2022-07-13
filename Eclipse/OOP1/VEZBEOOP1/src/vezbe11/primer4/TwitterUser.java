package vezbe11.primer4;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TwitterUser extends Observable implements Observer {

	private ArrayList<String> tweets = new ArrayList<String>();
	private String name;

	public TwitterUser(String name) {
		this.name = name;
	}

	public void postTweet(String tweet) {
		tweets.add(tweet);
		setChanged();
		notifyObservers(tweet);
	}

	public void countFollowers() {
		System.out.println("User " + name + " has " + countObservers() + " followers!");
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("User " + name + " update:");
		String followedPerson = ((TwitterUser) o).name;
		System.out.println("*" + followedPerson + " post:\n" + "*" + arg.toString());
	}

}
