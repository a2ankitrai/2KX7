
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

	public void insert(int key) {

		Node n = new Node(key);

		if (root == null) {
			n.color = BLACK;
			root = n;
		} else {
			n.color = RED;

			Node x = root;
			Node y = null;
			while (x != null) {
				y = x;
				if (x.data < n.data) {
					x = x.left;
				} else {
					x = x.right;
				}
			}

			n.parent = y;
			if (n.data > y.data) {
				y.right = n;
			} else {
				y.left = n;
			}

			if (y.color == RED) {
				
			}


		}



	}
}