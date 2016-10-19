/**
* @Problem
* Write a function that takes as input the root of a binary tree whose
* nodes have a key field, and returns true iff the tree satisfies the BST property,
*/


class BSTPropertyTest {

	public static boolean test(BinarySearchTree.Node node) {

		if (node == null) {
			return true;
		}

		if ((node.left != null && node.data < node.left.data) ||
		        (node.right != null && node.data > node.right.data)) {
			return false;
		}

		return test(node.left) && test(node.right);
	}

	public static void main(String[] args) {
		BinarySearchTree bst  = new BinarySearchTree();
		bst.treeInsert(12);
		bst.treeInsert(5);
		bst.treeInsert(2);
		bst.treeInsert(9);
		bst.treeInsert(18);
		bst.treeInsert(15);
		bst.treeInsert(19);
		bst.treeInsert(13);

		System.out.println("IS BST: " + test(bst.root));

		BinarySearchTree bstFalse = new BinarySearchTree();
		bstFalse.treeInsert(24);
		
		BinarySearchTree.Node n1 = new BinarySearchTree.Node(12);
		bstFalse.root.right = n1;
		n1.parent = bstFalse.root;

		BinarySearchTree.Node n2 = new BinarySearchTree.Node(11);
		bstFalse.root.left = n2;
		n2.parent = bstFalse.root;

		System.out.println("IS BST2: " + test(bstFalse.root));



	}
}