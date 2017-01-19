package behavioral.observer;

public class ObserverPatternTest {

	public static void main(String[] args) {
		
		Subject subject = new ConcreteSubject();
		
		Observer ob1 = new ConcreteObserver("observer 1");
		Observer ob2 = new ConcreteObserver("observer 2");
		Observer ob3 = new ConcreteObserver("observer 3");
		
		ob1.subscribeToSubject(subject);
		ob2.subscribeToSubject(subject);
		ob3.subscribeToSubject(subject);
		
		subject.postMessage("Cars n Bikes");
		
		ob2.unSubscribeToSubject(subject);
		
		subject.postMessage("Poems");
		
		ob1.unSubscribeToSubject(subject);
		ob2.subscribeToSubject(subject);
		
		subject.postMessage("Movies");
		
	}
}
