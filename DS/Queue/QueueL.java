class QueueL {

	Node front;
	Node rear;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void enQueue(int data) {
		Node node = new Node(data);
		if (rear == null) {
			front = node;
			rear = node;
		} else {
			Node temp = rear;
			temp.next = node;
			rear = node;
		}
	}

	public Node deQueue() {
		Node temp = null;
		if (front == null) {
			System.out.println("empty Queue");
		} else {
			temp = front;
			front = front.next;

			if (front == null) {
				rear = null;
			}
		}
		return temp;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return ;
		}
		StringBuilder sb = new StringBuilder("Front --> ");
		Node temp = front;
		sb.append(temp.data + " ");
		while (temp != rear) {			 
			temp = temp.next;
			sb.append(temp.data + " ");
		}
		sb.append(" <-- Rear");

		System.out.println(sb.toString());
	}

	public Node getFront() {return front;}
	public Node getRear() {return rear;}

	public static void main(String[] args) {
		QueueL q = new QueueL();
		q.enQueue(10);
		q.enQueue(20);
		q.deQueue(); 
		q.enQueue(30);
		q.enQueue(40);
		q.deQueue();
		q.enQueue(50);

		q.printQueue();

		q.deQueue();
		q.printQueue();

		q.deQueue();
		q.printQueue();

		q.deQueue();
		q.printQueue();

		q.enQueue(99);
		q.printQueue();

	}
}