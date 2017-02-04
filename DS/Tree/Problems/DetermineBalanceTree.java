/* Java program to determine if binary tree is
   height balanced or not */

/* A binary tree node has data, pointer to left child,
  and a pointer to right child */


// A wrapper class used to modify height across
// recursive calls.
class Height {
	int height = 0;
}

class DetermineBalanceTree {

	BTNode root;


	/* Returns true if binary tree with root as root is height-balanced */
	boolean isBalanced(BTNode root, Height height) {
		/* If tree is empty then return true */
		if (root == null) {
			height.height = 0;
			return true;
		}

		/* Get heights of left and right sub trees */
		Height lheight = new Height(), rheight = new Height();
		boolean l = isBalanced(root.left, lheight);
		boolean r = isBalanced(root.right, rheight);
		int lh = lheight.height, rh = rheight.height;

		/* Height of current node is max of heights of
		   left and right subtrees plus 1*/
		height.height = (lh > rh ? lh : rh) + 1;

		/* If difference between heights of left and right
		   subtrees is more than 2 then this node is not balanced
		   so return 0 */
		if ((lh - rh >= 2) ||
		        (rh - lh >= 2))
			return false;

		/* If this node is balanced and left and right subtrees
		   are balanced then return true */
		else return l && r;
	}


	/*  The function Compute the "height" of a tree. Height is the
	    number of nodes along the longest path from the root node
	    down to the farthest leaf node.*/
	int height(BTNode node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

		/* If tree is not empty then height = 1 + max of left
		 height and right heights */
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public static void main(String args[]) {
		Height height = new Height();

		/* Constructed binary tree is
		           1
		         /   \
		        2      3
		      /  \    /
		    4     5  6
		    /
		   7         */
		DetermineBalanceTree tree = new DetermineBalanceTree();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.root.left.right = new BTNode(5);
		tree.root.right.right = new BTNode(6);
		tree.root.left.left.left = new BTNode(7);

		if (tree.isBalanced(tree.root, height))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
