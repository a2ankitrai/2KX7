import java.util.*;

class IdenticalTreesIterative {


	public static boolean isIdentical(BinaryTree tree1, BinaryTree tree2) {

		BTNode root1 = tree1.root;
		BTNode root2 = tree2.root;

		if (root1 == null && root2 == null) {
			return true;
		}

		Queue<BTNode> q1 = new LinkedList<BTNode>();
		Queue<BTNode> q2 = new LinkedList<BTNode>();

		q1.offer(root1);
		q2.offer(root2);

		while (!q1.isEmpty() && !q2.isEmpty()) {

			BTNode temp1 = q1.poll();
			BTNode temp2 = q2.poll();

			if (temp1.data == temp2.data) {

				if (temp1.left != null) {
					q1.offer(temp1.left);
				}
				if (temp1.right != null) {
					q1.offer(temp1.right);
				}
				if (temp2.left != null) {
					q2.offer(temp2.left);
				}
				if (temp2.right != null) {
					q2.offer(temp2.right);
				}
			} else {
				return false;
			}
		}

		if (q1.isEmpty() && q2.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {

		BTNode root1 = new BTNode(1);
		root1.left = new BTNode(2);
		root1.right = new BTNode(3);
		root1.left.left = new BTNode(4);
		root1.left.right = new BTNode(5);

		BTNode root2 = new BTNode(1);
		root2.left = new BTNode(2);
		root2.right = new BTNode(3);
		root2.left.left = new BTNode(4);
		root2.left.right = new BTNode(5);
//		root2.right.left = new BTNode(6);

		BinaryTree t1 = new BinaryTree(root1);
		BinaryTree t2 = new BinaryTree(root2);

		System.out.println(isIdentical(t1, t2));

	}

}