
class Node {
	int key;
	int height;
	Node left;
	Node right;

	Node(int key) {
		this.key = key;
		height = 1;
	}
}

public class AVLTree {

	Node root;

	// A utility function to get height of the tree
	int height(Node n) {
		if (n == null) {
			return 0;
		}
		return n.height;
	}

	Node rightRotate(Node y) {
		Node x = y.left;
		y.left = x.right;
		x.right = y;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		return x;
	}

	Node leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		return y;
	}

	int getBalance(Node n) {
		if (n == null) {return 0;}

		return height(n.left) - height(n.right);
	}

	public Node insert(Node root, int key) {


		/*1. Perform the normal BST insertion */
		if (root == null) {
			return new Node(key);
		}

		if (key < root.key) {
			root.left = insert(root.left, key);
		} else if (key > root.key) {
			root.right = insert(root.right, key);
		} else { // Duplicate keys not allowed
			return root;
		}

		/* 2. Update height of this ancestor node */
		root.height = 1 + Math.max(height(root.left), height(root.right));

		/* 3. Get the balance factor of this ancestor
		      node to check whether this node became
		      unbalanced */
		int balance = getBalance(root);


		// If this node becomes unbalanced, then there are 4 cases.

		// Left Left Case
		if (balance > 1 && key < root.left.key) {
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && key > root.right.key) {
			return leftRotate(root);
		}

		// Left Right Case
		if (balance > 1 && key > root.left.key) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Left Case
		if (balance < -1 && key < root.right.key) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	Node minValueNode(Node node) {
		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null)
			current = current.left;

		return current;
	}

	public Node delete(Node root, int key) {

		if (root == null) {return root;}

		if (key < root.key) {
			root.left = delete(root.left, key);
		} else if (key > root.key) {
			root.right = delete(root.right, key);
		}

		// if key is same as root's key, then this is the node
		// to be deleted
		else {
			if (root.left == null || root.right == null) {
				Node temp = null;

				if (temp == root.left) {
					temp = root.right;
				} else {
					temp = root.left;
				}

				// No child case
				if (temp == null) {
					root = null;
				} else {
					root = temp;
				}

			} else {
				// node with two children: Get the inorder
				// successor (smallest in the right subtree)
				Node temp = minValueNode(root.right);

				// Copy the inorder successor's data to this node
				root.key = temp.key;

				// Delete the inorder successor
				root.right = delete(root.right, temp.key);

			}
		}

		// If the tree had only one node then return
		if (root == null) {return root;}

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.height = 1 + Math.max(height(root.left), height(root.right));

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		//  this node became unbalanced)
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && getBalance(root.left) >= 0 ) {
			return rightRotate(root);
		}

		// Left Right Case
		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		// Right Left Case
		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args) {

		AVLTree tree = new AVLTree();

		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

		/* The constructed AVL Tree would be
		     30
		    /  \
		  20   40
		 /  \     \
		10  25    50
		*/
		System.out.println("Preorder traversal of constructed tree is : ");
		tree.preOrder(tree.root);

		tree.root = tree.delete(tree.root, 20);


		System.out.println("\nPreorder traversal of constructed tree is : ");
		tree.preOrder(tree.root);
	}
}