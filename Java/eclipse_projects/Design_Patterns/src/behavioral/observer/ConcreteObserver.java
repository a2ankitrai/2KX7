package behavioral.observer;

public class ConcreteObserver implements Observer {

	private String name;
	
	public ConcreteObserver(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println(this.name + " Received Message : "+message);
	}

	@Override
	public void subscribeToSubject(Subject subject) {
		subject.attachObserver(this);	
	}
	
	@Override
	public void unSubscribeToSubject(Subject subject) {
		subject.detachObserver(this);	
	}
	
 

}
