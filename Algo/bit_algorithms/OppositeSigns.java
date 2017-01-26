class OppositeSigns {

	public static boolean areOppositeSigns(int x, int y) {
		return ((x ^ y) < 0);
	}

	public static void main(String[] args) {
		int x = 100, y = -100;

		if(areOppositeSigns(x,y)){
			System.out.println("Are Opposite Signs");
		}
		else {
			System.out.println("Signs are not Opposite");	
		}
	}
}