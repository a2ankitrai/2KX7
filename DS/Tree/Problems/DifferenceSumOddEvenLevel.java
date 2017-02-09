class DifferenceSumOddEvenLevel {

	class LevelSum {
		int odd;
		int even;
	}

	int height(BTNode root) {

		if (root == null) {return 0;}

		return 1 + Math.max(height(root.left), height(root.right));

	}

	public int getSumDifference(BTNode root) {
		int rootHeight = height(root);

		LevelSum ls = new LevelSum();
		boolean isEven = false;

		for (int i = 1 ; i <= rootHeight; i++) {
			if (i % 2 == 0) {
				isEven = true;
			} else {
				isEven = false;
			}
			updateLevelSum(root, i, ls, isEven);
		}
		return ls.odd - ls.even;
	}

	public void updateLevelSum(BTNode root, int level, LevelSum ls, boolean isEven) {
		if (root == null) {return ;}
		if (level == 1) {
			if (!isEven) {
				ls.odd += root.data;
			} else {
				ls.even += root.data;
			}
		} else {
			updateLevelSum(root.left, level - 1, ls, isEven);
			updateLevelSum(root.right, level - 1, ls, isEven);
		}
	}

	// simple approach
	int getLevelDiff(BTNode node) {
		// Base case
		if (node == null)
			return 0;

		// Difference for root is root's data - difference for
		// left subtree - difference for right subtree
		return node.data - getLevelDiff(node.left) -
		       getLevelDiff(node.right);
	}


	public void levelOrderTraversal(BTNode root) {

		int rootHeight = height(root);

		for (int i = 1 ; i <= rootHeight ; i++) {
			printLevel(root, i);
			System.out.println();
		}
	}

	public void printLevel(BTNode root, int level) {

		if (root == null) {return;}
		if (level == 1 ) {
			System.out.print(root.data + " ");
		} else {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	public static void main(String[] args) {

		DifferenceSumOddEvenLevel ds = new DifferenceSumOddEvenLevel();

		BTNode root = new BTNode(5);
		root.left = new BTNode(2);
		root.right = new BTNode(6);

		root.left.left = new BTNode(1);
		root.left.right = new BTNode(4);
		root.left.right.left = new BTNode(3);

		root.right.right = new BTNode(8);
		root.right.right.left = new BTNode(7);
		root.right.right.right = new BTNode(9);

		ds.levelOrderTraversal(root);

		System.out.println("Odd Even Difference : " + ds.getSumDifference(root));

		System.out.println("Odd Even Difference recursive: " + ds.getLevelDiff(root));
	}

}