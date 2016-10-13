class BinarySearchTree {

	Node root;

	static class Node {
		int data;
		Node left;
		Node right;
		Node parent;

		Node(int data) {
			this.data = data;
		}
	}

	public void inorderTreeWalk(Node x) {
		if (x != null) {
			inorderTreeWalk(x.left);
			System.out.print("- " + x.data + " - ");			
			inorderTreeWalk(x.right);
		}
	}

	public Node treeSearchRecursive(Node root, int key) {
		if (root == null || root.data == key)
			return root;
		if (key < root.data)
			return treeSearchRecursive(root.left, key);
		else
			return treeSearchRecursive(root.right, key);
	}


	public Node treeSearchIterative(Node root, int key) {
		while (root != null || root.data != key) {
			if (key < root.data)
				root = root.left;
			else
				root = root.right;
		}
		return root;
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

	public Node treeMaximum(Node root) {
		if (root == null) {
			return null;
		}
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public Node treePredecessor(Node root) {
		if (root.left != null) {
			return treeMaximum(root.left);
		}
		Node parent = root.parent;
		while (parent != null && root == parent.left) {
			root = parent;
			parent = parent.parent;
		}
		return parent;
	}

	public Node treeSuccessor(Node root) {
		if (root.right != null) {
			return treeMinimum(root.right);
		}
		Node parent = root.parent;
		while (parent != null && root == parent.right) {
			root = parent;
			parent = parent.parent;
		}
		return parent;
	}

	public void treeInsert(int data) {
		Node y = null;
		Node x = root;
		Node z = new Node(data);

		while (x != null) {
			y = x;
			if (z.data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		z.parent = y;
		if (y == null) {
			root = z;
		} else if (z.data < y.data) {
			y.left = z;
		} else {
			y.right = z;
		}
	}

	public void treeInsertByNode(Node z) {
		Node y = null;
		Node x = root;
		// Node z = new Node(data);
		if (z == null) {
			return;
		}

		while (x != null) {
			y = x;
			if (z.data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		z.parent = y;
		if (y == null) {
			root = z;
		} else if (z.data < y.data) {
			y.left = z;
		} else {
			y.right = z;
		}
	}

	public void transplant(Node u, Node v) {
		if (u.parent == null) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		if (v != null) {
			v.parent = u.parent;
		}
	}

	public void delete(Node z) {
		if (z.left == null) {
			transplant(z, z.right);
		} else if (z.right == null) {
			transplant(z, z.left);
		} else {
			Node y = treeMinimum(z.right);
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
		}

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

		Node n1 = new Node(7);
		bst.treeInsertByNode(n1);

		bst.inorderTreeWalk(bst.root);

		bst.delete(n1);	
		System.out.println("");
		bst.inorderTreeWalk(bst.root);		

	}

}