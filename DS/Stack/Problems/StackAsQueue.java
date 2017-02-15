import java.util.*;

class StackAsQueue {

	Queue<Integer> queue;

	public StackAsQueue() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.offer(x);
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.offer(queue.poll());
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int peek() {
		return queue.peek();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {

		StackAsQueue s = new StackAsQueue();

		s.push(2);
		s.push(3);
		s.push(6);
		s.push(7);
		s.push(8);

		System.out.println(s.peek());

		s.pop(); s.pop();

		System.out.println(s.peek());

		s.push(12);

		System.out.println(s.peek());

	}

}