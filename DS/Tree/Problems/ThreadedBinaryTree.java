class ThreadedBinaryTree<T> {

	private Node<T> root;

	static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		boolean rightThread;
	}

	private Node<T> leftMost(Node<T> root) {
		Node<T> temp = root;

		if (temp == null)
			return null;

		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	public void inOrder(Node<T> root) {
		Node<T> current = leftMost(root);

		while (current != null) {
			System.out.println(current.data);

			if (current.rightThread) {
				current = current.right;
			} else {
				current = leftMost(current.right);
			}
		}
	}
}