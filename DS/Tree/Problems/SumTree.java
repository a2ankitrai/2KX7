

class SumTree {

	public boolean isSumTree(BTNode root) {

		return isSumTreeUtil(root);

	}

	public boolean isSumTreeUtil(BTNode root) {

		if (root == null) {return true;}

		if (root.left == null && root.right == null) {return true;}

		if (root.data == (getSum(root.left) + getSum(root.right))) {
			return isSumTreeUtil(root.left) && isSumTreeUtil(root.right);
		} else {
			return false;
		}

	}

	public int getSum(BTNode root) {
		if (root == null) {
			return 0;
		}

		return root.data + getSum(root.left) + getSum(root.right);
	}

	public static void main(String[] args) {

		SumTree st = new SumTree();

		BTNode root = new BTNode(26);
		root.left = new BTNode(10);
		root.right = new BTNode(3);

		root.left.left = new BTNode(4);
		root.left.right = new BTNode(6);

		root.right.right = new BTNode(3);


		/*BTNode root = new BTNode(3);
		root.left = new BTNode(1);
		root.right = new BTNode(2);*/


		System.out.println(st.isSumTree(root));
	}

}