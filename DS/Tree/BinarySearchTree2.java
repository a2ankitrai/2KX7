class BinarySearchTree2 {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	Node root;

	BinarySearchTree2() {
		root = null;
	}

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}

		Node n = new Node(data);
		Node temp = root;
		Node y = null ;
		while (temp != null) {
			y = temp;
			if (temp.data > n.data) {
				temp = temp.left;
			} else if (temp.data <= n.data) {
				temp = temp.right;
			}
		}

		if (y.data > n.data) {
			y.left = n;
		} else {
			y.right = n;
		}

	}

	public int treeMinimumValue(Node root) {
		if (root == null) {
			return 0;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}


	public void deleteKey(int key) {
		root = deleteRec(root, key);
	}

	private Node deleteRec(Node root, int key) {

		if (root == null) {
			return root;
		}

		if (key < root.data) {
			root.left = deleteRec(root.left, key);
		} else if (key > root.data) {
			root.right = deleteRec(root.right, key);
		}

		else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			root.data = treeMinimumValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}
		return root;
	}

	public void inOrderTraversalRecursive(Node root) {

		if (root != null) {
			inOrderTraversalRecursive(root.left);
			System.out.print(root.data + " --> ");
			inOrderTraversalRecursive(root.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree2 tree = new BinarySearchTree2();

		/* Let us create following BST
		      50
		   /     \
		  30      70
		 /  \    /  \
		20   40  60   80 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder traversal of the given tree");
		tree.inOrderTraversalRecursive(tree.root);

		System.out.println("\nDelete 20");
		tree.deleteKey(20);
		System.out.println("Inorder traversal of the modified tree");
		tree.inOrderTraversalRecursive(tree.root);

		System.out.println("\nDelete 30");
		tree.deleteKey(30);
		System.out.println("Inorder traversal of the modified tree");
		tree.inOrderTraversalRecursive(tree.root);

		System.out.println("\nDelete 50");
		tree.deleteKey(50);
		System.out.println("Inorder traversal of the modified tree");
		tree.inOrderTraversalRecursive(tree.root);
	}
}