package behavioral.observer;

import java.util.HashMap;
import java.util.Map;

public class ConcreteSubject extends Subject {

	String message = null;
	
	public ConcreteSubject() {
		this.observers = new HashMap<>();
	}	
	
	
	@Override
	public void attachObserver(Observer observer) {
		this.observers.put(observer.getName(),observer);
	}

	@Override
	public void detachObserver(Observer observer) {
		this.observers.remove(observer.getName());
	}

	@Override
	public void notifyObservers() {	
		
		for(Map.Entry<String, Observer> entry : this.observers.entrySet()){
			Observer ob = entry.getValue();
			ob.update(message);
		}
		
	}

	@Override
	public Object getUpdate(Observer obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void postMessage(String message){
		System.out.println("Message posted on: "+ message);
		this.message = message;
		notifyObservers();
	}

}
