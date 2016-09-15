class QueueAsArray {

	// underflow and overflow check remaining ..

	private int[] q;
	private int size = 5;
	int qHead, qTail;

	public QueueAsArray() {
		q = new int[size];
		qHead = 0;
		qTail = 0;
	}

	public boolean isOverFlow() {
		int qDiff = qHead - qTail;
		if (qDiff == 1 || qDiff == q.length)
			return true;
		else return false;
	}

	public boolean isUnderFlow() {
		if (qHead == qTail)
			return true;
		else return false;
	}

	public void enqueue(int x) {
		if (isOverFlow()) {
			System.out.println("Queue overflow");
			return;
		}
		System.out.println(x + " added to Queue");
		q[qTail] = x;
		if (qTail == (q.length - 1)) {
			qTail = 0;
		} else {
			qTail++;
		}
	}

	public int dequeue() {
		if (isUnderFlow()) {
			System.out.println("Queue underflow");
			return -1;
		}		

		int x = q[qHead];
		if (qHead == (q.length - 1)) {
			qHead = 0;
		} else {
			qHead++;
		}
		System.out.println(x +" removed from Queue");
		return x;
	}

	public void showQueueElements() {
		String s = "Head --> ";
		for (int i = qHead; i != (qTail); i++) {
			s += q[i] + " --> ";
			if (i == (q.length - 1)) {
				i = 0;
			}
		}
		s += "Tail";

		System.out.println(s);
	}

	public static void main(String[] args) {
		QueueAsArray q = new QueueAsArray();

		q.enqueue(5);
		q.enqueue(13);
		q.enqueue(2);
		q.enqueue(67);
		q.enqueue(42);

		q.showQueueElements();

		q.dequeue();

		q.showQueueElements();

		q.dequeue();
		q.dequeue();

		q.showQueueElements();

		q.enqueue(53);
		q.enqueue(77);

		q.showQueueElements();

	}

}