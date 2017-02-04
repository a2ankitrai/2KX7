class CheckTreesForMirror {

	public static boolean isMirror(BTNode r1, BTNode r2) {

		if (r1 == null && r2 == null) {return true;}
		if (r1 == null || r2 == null) {return false;}

		if (r1.data != r2.data) {
			return false;
		} else {

			boolean check1 = isMirror(r1.left, r2.right);
			boolean check2 = isMirror(r1.right, r2.left);

			return check1 && check2;

			/*if (r1.left != null && r2.right != null) {
				isMirror(r1.left, r2.right);
			} else if ((r1.left != null && r2.right == null) || (r1.left == null && r2.right != null)) {
				return false;
			}

			if (r1.right != null && r2.left != null) {
				isMirror(r1.right, r2.left);
			} else if ((r1.right != null && r2.left == null) || (r1.right == null && r2.left != null)) {
				return false;
			}*/
		}

	}

	public static void main(String[] args) {

		BTNode a = new BTNode(1);
		BTNode b = new BTNode(1);

		a.left = new BTNode(2);
		a.right = new BTNode(3);
		a.left.left = new BTNode(4);
		a.left.right = new BTNode(5);

		b.left = new BTNode(3);
		b.right = new BTNode(2);
		b.right.left = new BTNode(5);
		b.right.right = new BTNode(4);
		b.left.left = new BTNode(9);

		System.out.println(isMirror(a, b));

	}

}