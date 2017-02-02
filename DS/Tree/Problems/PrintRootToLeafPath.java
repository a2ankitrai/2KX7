class PrintRootToLeafPath {

	public static void printPath(BTNode root) {

		int[] path = new int[1000];
		printPathRecurs(root, path, 0);
	}

	public static void printPathRecurs(BTNode node, int[] path, int pathLen) {

		if (node == null) {
			return;
		}

		path[pathLen++] = node.data;

		if (node.left == null && node.right == null) {
			printArray(path, pathLen);
		} else {
			printPathRecurs(node.left, path, pathLen);
			printPathRecurs(node.right, path, pathLen);
		}

	}

	public static void printArray(int[] path, int length) {
		for (int i = 0 ; i < length; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new BTNode(10);
		tree.root.left = new BTNode(8);
		tree.root.right = new BTNode(2);
		tree.root.left.left = new BTNode(3);
		tree.root.left.right = new BTNode(5);
		tree.root.right.left = new BTNode(2);
		tree.root.right.right = new BTNode(6);

		printPath(tree.root);
	}
}