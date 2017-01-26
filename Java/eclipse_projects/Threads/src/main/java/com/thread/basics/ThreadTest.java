package com.thread.basics;

class MyThread implements Runnable{
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ ": "+ i);
			
		}

	}
}

public class ThreadTest {
	
	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		Thread t3 = new Thread(mt);
		
		//t1.start();
		t1.join(0,50);
		t1.start();
		t2.start();
		/*t2.join(0,50);
		t3.start();*/
		
		/*try {
			t2.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
	
}
