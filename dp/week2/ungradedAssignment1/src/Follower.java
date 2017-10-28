
public class Follower implements IObserver {
	private String followerName;
	private Channel channel;
	
	public Follower(String followerName, Channel channel) {
		this.followerName = followerName;
		this.channel = channel;
		this.channel.registerObserver(this);
	}
	
	@Override
	public void update() {
		play();
	}
	
	void play() {
		System.out.println(this.followerName + " playing \"" + this.channel.getChannelName() + "\" latest update");
	}

}
