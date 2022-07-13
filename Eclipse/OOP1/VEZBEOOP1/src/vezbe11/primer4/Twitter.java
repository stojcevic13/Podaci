package vezbe11.primer4;

public class Twitter {

	public static void main(String[] args) {

		TwitterUser user = new TwitterUser("James Gosling");

		TwitterUser s1 = new TwitterUser("OOP Student1");
		TwitterUser s2 = new TwitterUser("OOP Student2");
		TwitterUser s3 = new TwitterUser("OOP Student3");

		user.addObserver(s1);
		user.addObserver(s2);
		user.addObserver(s3);

		user.countFollowers();
		user.postTweet("Java is C++ without the guns, knives, and clubs!");

	}

}
