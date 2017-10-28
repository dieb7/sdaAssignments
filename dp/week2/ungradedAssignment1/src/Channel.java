import java.util.ArrayList;

public class Channel implements ISubject {
	private ArrayList<IObserver> observers;
	private String channelName;
	private String status;
	
	public Channel(String channelName) {
		this.observers = new ArrayList<IObserver>();
		this.channelName = channelName;
		this.status = "Idle";
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String newStatus) {
		this.status = newStatus;
		this.notifyObservers();
	}
	
	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.update();
		}

	}
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
}
