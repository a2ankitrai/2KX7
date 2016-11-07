class ThreadSingleton {
	private static ThreadSingleton instance = null;

	private ThreadSingleton() {}

	public ThreadSingleton getInstance() {

		if (instance == null) {
			synchronized (ThreadSingleton.class) {
				if (instance == null) {
					instance = new ThreadSingleton();
				}
			}
		}
		return instance;
	}
}