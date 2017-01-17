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

	public Node treeMinimum(Node root) {
		if (root == null) {
			return null;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public void transplant(Node parent, Node u, Node v) {
		if (u == parent.left) {
			parent.left = v;
		} else {
			parent.right = v;
		}
	}

	public void delete(int data) {
		if (root == null) {return;}

		Node temp = root;
		Node parent = null;

		while (temp != null || temp.data == data) {
			parent = temp;
			if (temp.data > temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}

		if (temp == null) {
			System.out.println("Entered data does not exists");
			return;
		}

		if (temp.left == null) {
			transplant(parent, temp, temp.right);
		} else if (temp.right == null) {
			transplant(parent, temp, temp.left);
		}
		else {
			
		}


	}
}