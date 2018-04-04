

class ThreadTest{

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + " is executing");

		MyThread t1 = new MyThread();
	//	MyThread t2 = new MyThread();

		t1.run();

		t1.start();


		t1.start();
	//	t2.start();
	}

}

class MyThread extends Thread{

	public void run(){

		System.out.println("Inside another thread " + Thread.currentThread().getName());

	}
}