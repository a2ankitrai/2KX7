class StackAsArray {

	int size = 10;
	int arr[] = new int[size];
	int top = -1;


	public void push(int num) {
		if (top < size) {
			arr[++top] = num;
			System.out.println("Pushed "+num+" to Stack");
		} else {
			System.out.println("Stack overflow");
		}
	}

	public void pop() {
		if (top < 0) {
			System.out.println("Stack underflow");
		} else {
			arr[top--] = -1;
		}
	}

	public void peek(){
		if (top < 0) {
			System.out.println("Stack underflow");
		} else {
			System.out.println(arr[top]);
		}
	}

	public boolean isEmpty() {
		if (top < 0) {
			return true;
		} else return false;
	}

	public boolean isFull() {
		if (top == size) {
			return true;
		} else return false;
	}

	public void getStackValues() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			String value = "top=> ";
			for (int i = top ; i >= 0; i--) {
				if (i == 0) {
					value += arr[i];
				} else {
					value += arr[i] + ", ";
				}
			}
			value += " <=bottom";
			System.out.println(value);
		}
	}

	public static void main(String[] args) {
		
		StackAsArray sa = new StackAsArray();
	//	sa.getStackValues();

		sa.push(2);
		sa.push(5);
		sa.push(9);

		sa.getStackValues();

		sa.pop();
		sa.pop();
		sa.getStackValues();

		sa.pop();
		sa.getStackValues();

	}

}