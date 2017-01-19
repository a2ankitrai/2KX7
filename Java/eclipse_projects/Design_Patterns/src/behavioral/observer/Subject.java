package behavioral.observer;

import java.util.Map;

public abstract class Subject {

	protected Map<String,Observer> observers;	
	
	public abstract void attachObserver(Observer observer);
	
	public abstract void detachObserver(Observer observer);
	
	public abstract void notifyObservers();
	
	public abstract Object getUpdate(Observer obj);
	
	public void postMessage(String message){
		System.out.println("Abstract class default post message");
	}
}
