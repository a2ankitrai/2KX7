class GetNodeLevel {

	public static int getLevel(BTNode root, int key) {
		return getLevelR(root, key, 1) ;
	}

	public static int getLevelR(BTNode root, int key, int currentLevel) {
		if (root == null) {
			return 0;
		}

		if (root.data == key) {
			return currentLevel;
		}

		return  getLevelR(root.left, key, currentLevel + 1) + getLevelR(root.right, key, currentLevel + 1);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		/* Constructing tree given in the above figure */
		tree.root = new BTNode(3);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(5);
		tree.root.left.left = new BTNode(1);
		tree.root.left.right = new BTNode(4);
		for (int x = 1; x <= 5; x++) {
			int level = getLevel(tree.root, x);
			if (level != 0)
				System.out.println("Level of " + x + " is "
				                   + getLevel(tree.root, x));
			else
				System.out.println(x + " is not present in tree");
		}
	}

}