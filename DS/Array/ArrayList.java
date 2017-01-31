class ArrayList {

	public static final int INITIAL_CAPACITY = 10;

	int[] ar = new int[INITIAL_CAPACITY];
	int size = 0;


	public void add(int num) {

		if (size < ar.length - 1) {
			ar[size++] = num;
		} else {
			int[] tempArr = new int[2 * ar.length];
			for (int i = 0; i < ar.length; i++) {
				tempArr[i] = ar[i];
			}
			tempArr[size++] = num;
		}
	}


	public static void main(String[] args) {

		ArrayList al = new ArrayList();

		for (int i = 0 ; i < 10; i++) {
			al.add(i);
		}

		System.out.println(al.size);

		al.add(23);

		for (int i = 0 ; i <= al.size; i++) {
			System.out.println(al.ar[i]);
		}
		
	}

}