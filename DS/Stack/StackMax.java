/*
Design a stack that supports a max operation which returns the
maximum value stored in the stack, and throws an exception if the stack is empty. Assume
elements are comparable. All operations must be 0(1) time. You can use 0(n) additional
space, beyond what is required for the elements themselves.

Below code does not handles duplicate element cases.
*/

class StackMax {

	private Node top;

	static class Node {
		int data;
		Node next;
		int max;

		Node(int data) {
			this.data = data;
		}
	}

	public void push(int n) {
		Node newNode = new Node(n);

		if (top == null) {
			top = newNode;
			newNode.max = newNode.data;
		} else {
			Node temp = top;
			int topMax = top.max;
			top = newNode;
			newNode.next = temp;
			if (newNode.data > topMax) {
				newNode.max = newNode.data;
			} else {
				newNode.max = topMax;
			}
		}
	}

	public int pop() {
		int topValue = Integer.MIN_VALUE;
		if (top == null) {
			System.out.println("STack is empty");
		} else {
			topValue = top.data;
			top = top.next;
		}
		return topValue;
	}

	public int peek() {
		if (top == null) {
			System.out.println("STack is empty");
			return -1;
		} else {
			System.out.println("top=> " + top.data);
			return top.data;
		}
	}

	public int getMax() {
		if (top == null) {
			System.out.println("STack is empty");
			return -1;
		} else {
			System.out.println("Max value=> " + top.max);
			return top.max;
		}
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else return false;
	}

	public static void main(String[] args) {
		StackMax sm = new StackMax();

		sm.push(5);
		sm.push(3);
		sm.push(1);
		sm.push(17);
		sm.push(23);
		sm.push(26);
		sm.push(7);

		sm.getMax();
		sm.pop();

		sm.getMax();
		sm.pop();

		sm.getMax();
		sm.pop();

		sm.getMax();
		sm.pop();

		sm.getMax();
		sm.pop();
	}
}