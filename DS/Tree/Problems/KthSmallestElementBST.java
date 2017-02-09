import java.util.Stack;
import java.util.*;

class KthSmallestElementBST {

	class Counter {
		int count;
	}

	public void getKthSmallest(BTNode root, int k) {

		if (root == null || k < 0) {return ;}

		Counter c = new Counter();
		BTNode kNode = getKthSmallestUtil(root, c, k);

		//BTNode kNode = getKthSmallestUtilRecursive(root, c, k);

		if (kNode != null) {
			System.out.println (k + " position element is: " + kNode.data);
		} else {
			System.out.println (k + " position element NOT found ");
		}
	}

	public BTNode getKthSmallestUtil(BTNode root, Counter c, int k) {

		BTNode current = root;
		Stack<BTNode> s = new Stack<>();
		int counter = 0;
		BTNode kthNode = null;

		while (current != null) {
			s.push(current);
			current = current.left;
		}

		while (!s.isEmpty() && counter <= k) {
			BTNode temp = s.pop();
			counter++;
			if (counter == k) {
				kthNode = temp;
			}

			if (temp.right != null) {
				temp = temp.right;

				while (temp != null) {
					s.push(temp);
					temp = temp.left;
				}
			}

		}
		return kthNode;
	}

	public void getKthSmallestUtilRecursive(BTNode root, Counter c, int k) {
		if (root != null) {
			getKthSmallestUtilRecursive(root.left, c, k);
			c.count++;
			if (c.count == k) {
				System.out.println (k + " position element is: " + root.data);
			}
			getKthSmallestUtilRecursive(root.right, c, k);
		}
	}

	public void getKthSmallestRecursiveWrap(BTNode root, int k) {
		Counter c = new Counter();
		getKthSmallestUtilRecursive(root, c, k);
	}


	public static void main(String[] args) {

		BTNode root = new BTNode(20);
		root.left = new BTNode(8);
		root.right = new BTNode(22);

		root.left.left = new BTNode(4);
		root.left.right = new BTNode(12);

		root.left.right.left = new BTNode(10);
		root.left.right.right = new BTNode(14);

		KthSmallestElementBST ks = new KthSmallestElementBST();
		ks.getKthSmallest(root, 3);
		ks.getKthSmallest(root, 5);

		ks.getKthSmallestRecursiveWrap(root, 3);

		ks.getKthSmallestRecursiveWrap(root, 5);
	}

}