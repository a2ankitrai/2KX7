class PrintAncestors {

	public static boolean printAncestorsFunc(BinaryTree.BTNode root, BinaryTree.BTNode target) {

		if (root == null) {
			return false;
		}

		if(root == target){
			return true;
		}

		if (printAncestorsFunc(root.left, target) || printAncestorsFunc(root.right, target)) {
			System.out.print(root.data + " ");
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		BinaryTree.BTNode root = new BinaryTree.BTNode(1);

		//Level 1 - nodes
		BinaryTree.BTNode l1e1 = new BinaryTree.BTNode(2);
		BinaryTree.BTNode l1e2 = new BinaryTree.BTNode(3);

		root.left = l1e1;
		root.right = l1e2;

		//-------------------------------------------
		//Level 2 - nodes
		BinaryTree.BTNode l2e1 = new BinaryTree.BTNode(4);
		BinaryTree.BTNode l2e2 = new BinaryTree.BTNode(5);
		BinaryTree.BTNode l2e3 = new BinaryTree.BTNode(6);
		BinaryTree.BTNode l2e4 = new BinaryTree.BTNode(7);

		l1e1.left = l2e1;
		l1e1.right = l2e2;
		l1e2.left = l2e3;
		l1e2.right = l2e4;

		//-------------------------------------------
		//Level 3 - nodes

		BinaryTree.BTNode l3e1 = new BinaryTree.BTNode(8);
		BinaryTree.BTNode l3e2 = new BinaryTree.BTNode(9);
		l2e1.left = l3e1;
		l2e1.right = l3e2;

		printAncestorsFunc(root,l2e4);
	}

}