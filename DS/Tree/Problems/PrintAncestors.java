class PrintAncestors {

	public static boolean printAncestorsFunc(BTNode root, BTNode target) {

		if (root == null) {
			return false;
		}

		if(root == target){
			return true;
		}

		if (printAncestorsFunc(root.left, target) || printAncestorsFunc(root.right, target)) {
			System.out.print(root.data + " ");
			return true;
		}

		return false;
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
		l2e1.left = l3e1;
		l2e1.right = l3e2;

		printAncestorsFunc(root,l3e1);
	}

}