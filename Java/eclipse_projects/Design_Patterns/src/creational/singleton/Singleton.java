package creational.singleton;

public class Singleton {

	private static Singleton instance = null;

	private Singleton() {}

	public Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}