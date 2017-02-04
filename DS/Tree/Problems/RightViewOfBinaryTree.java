import java.util.*;

class RightViewOfBinaryTree {

	int height(BTNode root) {

		if (root == null) {return 0;}

		int lHeight = height(root.left);
		int rHeight = height(root.right);

		if (lHeight > rHeight) {
			return lHeight + 1;
		} else {
			return rHeight + 1;
		}

	}

	void getLevelOrder(BTNode root) {

		int h = height(root);
		for (int i = 1; i <= h; i++) {
			List<Integer> al = new ArrayList<Integer>();
			getThisLevel(root, i, al);
			if (al != null) {
				for (int n : al) {
					System.out.print(n + " ");
				}
			}
			System.out.println();
		}
	}

	void getRightView(BTNode root) {

		int h = height(root);
		for (int i = 1; i <= h; i++) {
			List<Integer> al = new ArrayList<Integer>();
			getThisLevel(root, i, al);
			System.out.print(al.get(al.size() - 1) + " ");
		}
	}

	void getThisLevel(BTNode root, int i, List<Integer> al) {
		if (root == null) {
			return ;
		} else if (i == 1) {
			//	System.out.print(root.data + " ");
			al.add(root.data);
		} else if (i > 1) {
			getThisLevel(root.left, i - 1, al);
			getThisLevel(root.right, i - 1, al);
		}
	}

	//---------Approach 2--------/

	class MaxLevelSofar{
		int maxlevelSoFar;
	}

	public void getRightView2Util(BTNode root, int level, MaxLevelSofar mxl) {

		if (root == null) {
			return ;
		}

		if ( mxl.maxlevelSoFar < level ) {
			System.out.print(root.data + " ");
			mxl.maxlevelSoFar = level;
		}

		getRightView2Util(root.right, level + 1, mxl);
		getRightView2Util(root.left, level + 1, mxl);
	}

	public void getRightView2(BTNode root) {
		MaxLevelSofar mxl = new MaxLevelSofar();
		getRightView2Util(root, 1, mxl);
	}

	public static void main(String[] args) {

		RightViewOfBinaryTree rv = new RightViewOfBinaryTree();

		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);

		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);

		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);

		root.right.right.right = new BTNode(8);
//		root.right.left.left = new BTNode(9);

		//		rv.getRightView(root);
		rv.getRightView2(root);

	}

}