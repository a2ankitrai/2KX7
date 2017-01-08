class ThreadSingleton {
	private static ThreadSingleton instance = null;
	private int myCount;

	private ThreadSingleton() {
		myCount++;
	}

	public int getMyCount() {
		return myCount;
	}

	public static ThreadSingleton getInstance() {

		if (instance == null) {
			synchronized (ThreadSingleton.class) {
				if (instance == null) {
					instance = new ThreadSingleton();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {

		ThreadSingleton instance1 = ThreadSingleton.getInstance();
		System.out.println("Constructor count : " + instance1.getMyCount());

		ThreadSingleton instance2 = ThreadSingleton.getInstance();
		System.out.println("Constructor count : " + instance2.getMyCount());


	}
}