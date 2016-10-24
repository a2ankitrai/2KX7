/**
*@Problem
*Write a function that takes as input the root of a binary tree and returns true or false depending on whether the tree is balanced. Use 0(h) additional storage, where h is the height of the tree.
*
*/

class BalancedBinaryTreeTest {

	public int getHeight(BinaryTree.BTNode node) {

		if (node == null || (node.left == null && node.right == null)) {
			return 0;
		}
		int lHeight = getHeight(node.left);
		int rHeight =  getHeight(node.right);

		if (lHeight > rHeight) {
			return lHeight + 1;
		} else {
			return rHeight + 1;
		}
	}

	public boolean isBalanced(BinaryTree.BTNode node) {
		if (node == null || node.left == null && node.right == null) {
			return true;
		}
		int lHeight = getHeight(node.left);
		int rHeight =  getHeight(node.right);

		int difference = lHeight - rHeight;
		if (Math.abs(difference) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		} else {
			return false;
		}
	}

	/*** EPI CODE
	*/

	public int getHeight2(BinaryTree.BTNode node) {
		if (node == null) {
			return -1;
		}

		int lHeight = getHeight2(node.left);
		if (lHeight == -2) {
			return -2;
		}

		int rHeight = getHeight2(node.right);
		if (rHeight == -2) {
			return -2;
		}

		if (Math.abs(lHeight - rHeight) > 1) {
			return -2;
		} else {
			return Math.max(lHeight, rHeight) + 1;
		}
	}

	public boolean isBalanced2(BinaryTree.BTNode node) {
		return getHeight2(node) != -2;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.root = new BinaryTree.BTNode(1);
		tree.root.left = new BinaryTree.BTNode(2);
		tree.root.right = new BinaryTree.BTNode(3);
		tree.root.left.left = new BinaryTree.BTNode(4);
		tree.root.left.right = new BinaryTree.BTNode(5);
		tree.root.left.left.left = new BinaryTree.BTNode(8);

		// tree.root.right.left = new BinaryTree.BTNode(6);

		BalancedBinaryTreeTest bbtTest =  new BalancedBinaryTreeTest();

		if (bbtTest.isBalanced2(tree.root)) {
			System.out.println("Tree is balanced");
		} else {
			System.out.println("Tree is not balanced");
		}


	}

}