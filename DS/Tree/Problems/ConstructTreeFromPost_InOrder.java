class ConstructTreeFromPost_InOrder {


	class Index {
		int index;
	}

	public BTNode constructTree(int[] in, int[] post) {

		int n = in.length;
		Index pIndex = new Index();
		pIndex.index = n - 1;
		return buildUtil(in, post, 0, n - 1, pIndex);
	}

	private BTNode buildUtil(int[] in, int[] post, int start, int end, Index pIndex) {
		if (start > end) {
			return null;
		}

		/* Pick current node from Preorder traversal using
		           postIndex and decrement postIndex */
		BTNode node = new BTNode(post[pIndex.index]);
		pIndex.index--;

		/* If this node has no children then return */
		if (start == end) {
			return node;
		}

		/* Else find the index of this node in Inorder
		   traversal */
		int iIndex = search(in, start, end, node.data);

		/* Using index in Inorder traversal, construct left and
		   right subtress */
		node.right = buildUtil(in, post, iIndex + 1, end, pIndex);
		node.left = buildUtil(in, post, start, iIndex - 1, pIndex);

		return node;
	}

	int search(int arr[], int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				break;
		}
		return i;
	}

	public static void reverse(int[] data) {
		int left = 0;
		int right = data.length - 1;

		while ( left < right ) {
			// swap the values at the left and right indices
			int temp = data[left];
			data[left] = data[right];
			data[right] = temp;

			// move the left and right index pointers in toward the center
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		ConstructTreeFromPost_InOrder ct = new ConstructTreeFromPost_InOrder();
		int in[]   = {2, 1, 3};
		int post[] = {2, 3, 1};
		ct.constructTree(in, post);
	}

}