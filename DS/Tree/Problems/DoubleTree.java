class DoubleTree {
	
	public static void makeDoubleTree(BTNode root){

		if(root == null){
			return;
		}

		BTNode tempLeft = root.left;
		BTNode tempRight = root.right;

		root.left = new BTNode(root.data);

		root.left.left = tempLeft;
		makeDoubleTree(tempLeft);
		makeDoubleTree(tempRight);

	}

	/* Given a binary tree, print its nodes in inorder*/
     static void printInorder(BTNode node) 
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
    	
    	BinaryTree tree = new BinaryTree();
        tree.root = new BTNode(1);
        tree.root.left = new BTNode(2);
        tree.root.right = new BTNode(3);
        tree.root.left.left = new BTNode(4);
        tree.root.left.right = new BTNode(5);
  
        System.out.println("Original tree is : ");
        printInorder(tree.root);
        makeDoubleTree(tree.root);
        System.out.println("");
        System.out.println("Inorder traversal of double tree is : ");
        printInorder(tree.root);

    }

}