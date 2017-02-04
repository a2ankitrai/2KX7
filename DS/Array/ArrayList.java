class ArrayList {

	public static final int INITIAL_CAPACITY = 10;

	int[] ar = new int[INITIAL_CAPACITY];
	int size = 0;
	int length = INITIAL_CAPACITY;

	public void add(int num) {

		if (size < ar.length) {
			ar[size++] = num;
		} else {
			int[] tempArr = new int[2 * ar.length];
			length = tempArr.length;
			for (int i = 0; i < ar.length; i++) {
				tempArr[i] = ar[i];
			}
			tempArr[size++] = num;
			ar = tempArr;
		}
	}

	public int remove() {
		return remove(0);
	}

	public int remove(int index) {

		if (index < 0 || index > size) {
			throw new  IndexOutOfBoundsException("invalid index");
		}

		int val  = ar[index] ;

		for (int i = index ; i < size ; i++) {
			ar[i] = ar[i + 1];
		}
		size--;

		if (size < ar.length / 4 ) {
			int[] tempArr = new int[ar.length / 2];
			length = tempArr.length;
			for (int i = 0; i < size; i++) {
				tempArr[i] = ar[i];
			}
			ar = tempArr;
		}
		return val;
	}


	public static void main(String[] args) {

		ArrayList al = new ArrayList();

		for (int i = 1 ; i <= 10; i++) {
			al.add(i);
		}

		System.out.println("Current size: " + al.size);

		al.add(23);

		for (int i = 0 ; i < al.size; i++) {
			System.out.print(al.ar[i] + " ");
		}

		System.out.println("Current size: " + al.size);
		System.out.println("Current capacity: " + al.length);

		

	}

}