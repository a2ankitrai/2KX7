package behavioral.observer;

public interface Observer {
	
	public String getName();
	
	public void setName(String name);
	
	public void update(String message);
	
	public void subscribeToSubject(Subject subject);
	
	public void unSubscribeToSubject(Subject subject);
}
