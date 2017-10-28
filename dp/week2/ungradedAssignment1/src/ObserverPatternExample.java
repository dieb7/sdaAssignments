
public class ObserverPatternExample {

	public static void main(String[] args) {
		System.out.println("Observer pattern example");
		
		Channel channel = new Channel("Some channel");
		Follower follower = new Follower("Some follower name", channel);
		
		channel.setStatus("newStatus");
	}

}
