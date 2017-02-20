/**
* Level order traversal in spiral form
* Write a function to print spiral order traversal of a tree
*/
import java.util.*;

class SpiralPrint {

	public static void iterativeSpiral(BTNode root) {

		if (root == null) {
			return ;
		}

		// Use two stacks
	}

	public List<List<Integer>> zigzagLevelOrder(BTNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;

		Queue<BTNode> q = new LinkedList<>();
		q.add(root);
		boolean order = true;
		int size = 1;

		while (!q.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				BTNode n = q.poll();
				if (order) {
					tmp.add(n.data);
				} else {
					tmp.add(0, n.data);
				}
				if (n.left != null) q.add(n.left);
				if (n.right != null) q.add(n.right);
			}
			res.add(tmp);
			size = q.size();
			order = order ? false : true;
		}
		return res;
	}

	public static void main(String[] args) {

		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(7);
		root.left.right = new BTNode(6);
		root.right.left = new BTNode(5);
		root.right.right = new BTNode(4);

		iterativeSpiral(root);

	}

}