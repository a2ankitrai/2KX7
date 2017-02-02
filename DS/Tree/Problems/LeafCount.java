class LeafCount {

	public static int getLeafCount(BTNode BTNode) {
		if (BTNode == null)
			return 0;
		if (BTNode.left == null && BTNode.right == null)
			return 1;
		else
			return getLeafCount(BTNode.left) + getLeafCount(BTNode.right);
	}

	public static void main(String[] args) {

		/* create a tree */
		BinaryTree tree = new BinaryTree();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.root.left.right = new BTNode(5);

		/* get leaf count of the abve tree */
		System.out.println("The leaf count of binary tree is : "
		                   + getLeafCount(tree.root));
	}

}