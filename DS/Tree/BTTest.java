import java.util.*;

class BTTest extends BinaryTree {

	public BTTest(BTNode root) {
		super(root);
	}

	public void myLevelOrderTraversal() {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.offer(root);
		ArrayList<Integer> res = new ArrayList<Integer>();

		while (!q.isEmpty()) {
			BTNode temp = q.poll();
			res.add(temp.data);
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
		}

		for (int data : res) {
			System.out.print(data + " -> ");
		}

	}

	int height(BTNode root) {
		if (root == null)
			return 0;
		else {
			/* compute  height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else return (rheight + 1);
		}
	}

	public void myLevelOrderLineByLine() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			System.out.println("Level " + i + ": ");
			printGivenLevel(root, i);
			System.out.println("\n");
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel (BTNode root , int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void main(String[] args) {
		BTNode root = new BTNode(1);

		//Level 1 - nodes
		BTNode l1e1 = new BTNode(2);
		BTNode l1e2 = new BTNode(3);

		root.left = l1e1;
		root.right = l1e2;

		//-------------------------------------------
		//Level 2 - nodes
		BTNode l2e1 = new BTNode(4);
		BTNode l2e2 = new BTNode(5);
		BTNode l2e3 = new BTNode(6);
		BTNode l2e4 = new BTNode(7);

		l1e1.left = l2e1;
		l1e1.right = l2e2;
		l1e2.left = l2e3;
		l1e2.right = l2e4;

		//-------------------------------------------
		//Level 3 - nodes
		BTNode l3e1 = new BTNode(8);
		BTNode l3e2 = new BTNode(9);
		BTNode l3e3 = new BTNode(10);
		BTNode l3e4 = new BTNode(11);
		BTNode l3e5 = new BTNode(12);
		BTNode l3e6 = new BTNode(13);
		BTNode l3e7 = new BTNode(14);
		BTNode l3e8 = new BTNode(15);

		l2e1.left = l3e1;
		l2e1.right = l3e2;
		l2e2.left = l3e3;
		l2e2.right = l3e4;
		l2e3.left = l3e5;
		l2e3.right = l3e6;
		l2e4.left = l3e7;
		l2e4.right = l3e8;

		BTTest bt = new BTTest(root);

		bt.myLevelOrderLineByLine();
	}
}