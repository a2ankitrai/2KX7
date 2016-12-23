package thread.exercises;

class MyThread extends Thread {

	private static int counter = 0;

	@Override
	public void run() {
		if (counter < 8) {
			counter++;
			MyThread t = new MyThread();
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
		}
		System.out.println("Hello from Thread " + Thread.currentThread().getName());
	}
}

public class ReverseHello {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}	
		
}
