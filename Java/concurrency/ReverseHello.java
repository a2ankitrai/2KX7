/**
**Reverse hello
*
*Write a program called ReverseHello.java that creates a thread (let's call it Thread 1). Thread 1 creates another thread (Thread 2); Thread 2 creates Thread 3; and so on, up to Thread 50. Each thread should print "Hello from Thread <num>!", but you should structure your program such that the threads print their greetings in reverse order.
*/

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
