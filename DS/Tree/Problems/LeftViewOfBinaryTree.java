
import java.util.*;

class LeftViewOfBinaryTree {

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

	void getLeftView(BTNode root) {

		int h = height(root);
		for (int i = 1; i <= h; i++) {
			List<Integer> al = new ArrayList<Integer>();
			getThisLevel(root, i, al);
			System.out.print(al.get(0) + " ");
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

	///-------------Approach 2---------------

	class MinLevelSoFar {
		int minLevelSoFar;
	}

	public void getLeftView2(BTNode root) {
		MinLevelSoFar mls = new MinLevelSoFar();
		getLeftView2Util(root, 1, mls);
	}

	public void getLeftView2Util(BTNode root, int level,MinLevelSoFar mls) {

		if (root == null) {
			return ;
		}

		if ( mls.minLevelSoFar < level ) {
			System.out.print(root.data + " ");
			mls.minLevelSoFar = level;
		}

		getLeftView2Util(root.left, level + 1, mls);
		getLeftView2Util(root.right, level + 1, mls);

	}


	public static void main(String[] args) {

		LeftViewOfBinaryTree lv = new LeftViewOfBinaryTree();

		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);

		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);

		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);

		root.right.right.right = new BTNode(8);
		//root.right.left.left = new BTNode(9);

		//	lv.getLeftView(root);
		lv.getLeftView2(root);
	}

}