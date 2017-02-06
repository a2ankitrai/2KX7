class ConvertToSumTree {

	public void toSumTree(BTNode root) {

		toSumTreeAux( root);
	}

	public int toSumTreeAux(BTNode root) {

		if (root == null) {return 0;}

		int oldVal = root.data;

		root.data = toSumTreeAux(root.left) + toSumTreeAux(root.right);

		return oldVal + root.data;
	}

	// A utility function to print inorder traversal of a Binary Tree
	void printInorder(BTNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String args[]) {

		ConvertToSumTree cts = new ConvertToSumTree();

		/* Constructing tree given in the above figure */
		BTNode root = new BTNode(10);
		root.left = new BTNode(-2);
		root.right = new BTNode(6);
		root.left.left = new BTNode(8);
		root.left.right = new BTNode(-4);
		root.right.left = new BTNode(7);
		root.right.right = new BTNode(5);

		cts.toSumTree(root);

		// Print inorder traversal of the converted tree to test result
		// of toSumTree()
		System.out.println("Inorder Traversal of the resultant tree is:");
		cts.printInorder(root);
	}

}