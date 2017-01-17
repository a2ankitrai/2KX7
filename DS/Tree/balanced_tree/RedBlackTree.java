
class RedBlackTree {
	private static final boolean RED   = true;
	private static final boolean BLACK = false;

	private Node root;

	static class Node {
		int data;
		Node left;
		Node right;
		Node parent;
		boolean color;

		Node(int data) {
			this.data = data;
		}
	}

	public void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left; 	//turn y’s left subtree into x’s right subtree

		if (y.left != null) {
			y.left.parent = x;
		}

		y.parent = x.parent; // link x's parent to y
		if (x.parent == null) {
			root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;			// put x on y’s left
		x.parent = y;
	}


	public void rightRotate(Node y) {
		Node x = y.left;
		y.left = x.right;

		if (x.right != null) {
			x.right.parent = y;
		}

		x.parent = y.parent;

		if (y.parent == null) {
			root = x;
		} else if (y == y.parent.left) {
			y.parent.left = x;
		} else {
			y.parent.right = x;
		}
		x.right = y;
		y.parent = x;
	}

	public void insert(int key) {
		Node y = null;
		Node x = root;
		Node z = new Node(key);

		while (x != null) {
			y = x;
			if (x.data > z.data) {
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

		z.color = RED;

		insertFixUp(z);

	}

	public void insertFixUp(Node z) {
		while (z.parent.color == RED) {
			if (z.parent == z.parent.parent.left) {
				Node y = z.parent.parent.right;  //  z's uncle
				if (y.color == RED) {
					z.parent.color = BLACK;
					y.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else if (z == z.parent.right) {
					z = z.parent;
					leftRotate(z);
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					rightRotate(z.parent.parent);
				}
			} else {
				Node x = z.parent.parent.left;
				if(x.color == RED){
					z.parent.color = BLACK;
					x.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				}
				else if (z == z.parent.left) {
					z = z.parent;
					rightRotate(z);
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					leftRotate(z.parent.parent);
				}
			}
		}
		root.color = BLACK;
	}

 
}