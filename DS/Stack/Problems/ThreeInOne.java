class ThreeInOne {

	int ar[] =  new int[10];
	int top1 = 0;
	int top2 = ar.length - 1 ;

	public void push1(int num) {
		if (top1 < top2) {
			ar[top1++] = num;
		} else {
			System.out.println("Stack is full");
		}
	}

	public void push2(int num) {
		if (top2 > top1) {
			ar[top2--] = num;
		} else {
			System.out.println("Stack is full");
		}
	}

	public void pop1() {
		if (top1 == 0) {
			System.out.println("Stack underflow");
		} else {
			System.out.println(ar[top1 - 1]);
			top1--;
		}
	}

	public void pop2() {
		if (top2 == ar.length -	1) {
			System.out.println("Stack underflow");
		} else {
			System.out.println(ar[top2 + 1]);
			top2++;
		}
	}

	public void peek1() {
		if (top1 == 0) {
			System.out.println("Stack underflow");
		} else {
			System.out.println(ar[top1 - 1]);
		}
	}

	public void peek2() {
		if (top2 == ar.length - 1) {
			System.out.println("Stack underflow");
		} else {
			System.out.println(ar[top2 + 1]);
		}
	}

	public static void main(String[] args) {

		ThreeInOne t = new ThreeInOne();

		t.push1(1);
		t.push1(2);
		t.push1(3);

		t.push2(9);
		t.push2(8);
		t.push2(7);

		t.pop1();
		t.pop2();
		t.pop1();
		t.pop2();

		t.pop1();
		t.pop1();

	}
}