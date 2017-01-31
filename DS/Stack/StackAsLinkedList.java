public class StackAsLinkedList {

	Node top;
	Node bottom;

	static class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
		}
	}

	public void push(String n) {
		Node newNode = new Node(n);

		if (top == null) {
			top = newNode;
		} else {
			Node temp = top;
			top = newNode;
			newNode.next = temp;
		}
	}

	public String pop() {
		String topValue = null;
		if (top == null) {
			System.out.println("Stack is Empty");
		} else {
			topValue = top.data;
			top = top.next;
		}
		return topValue;
	}

	public String peek() {
		String topValue = null;
		if (top == null) {
			System.out.println("STack is empty");
		} else {
			System.out.println("top=> " + top.data);
			topValue =  top.data;
		}
		return topValue;
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else return false;
	}

	public void getStackValues() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			String value = "top=> ";
			Node temp = top;
			while(temp!= null){
				value += temp.data + ", ";
				temp = temp.next;
			} 	

			value += " <=bottom";
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		
		StackAsLinkedList sll = new StackAsLinkedList();

		sll.push("8");
		sll.push("1");
		sll.push("5");

		sll.getStackValues();
		sll.peek();
		sll.pop();
		sll.pop();

		sll.getStackValues();

		sll.pop();
		sll.getStackValues();

	}

}