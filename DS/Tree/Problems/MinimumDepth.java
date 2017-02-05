
class MinimumDepth {

	public int getMinimumDepth(BTNode root) {
		 if (root == null) {
			return 0;
		} else {
			return Math.min(getMinimumDepth(root.left), getMinimumDepth(root.right)) + 1;
		}
	}

}