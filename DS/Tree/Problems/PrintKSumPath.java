/* A binary tree and a number, say k are given. 
Print every path in the tree with sum of the nodes in the path as k*/

class PrintKSumPath {
	
	public static void printPath(BTNode root, int k){		
		printPath(root,0,"",k);
	}

	public static void printPath(BTNode root, int pathSum, String path, int k){

		pathSum += root.data;
		path += root.data +" ";

		if(pathSum == k){
			System.out.println(path);
		}

		if(root.left != null){
			printPath(root.left,pathSum,path,k);
			printPath(root.left,0,"",k);
		}

		if(root.right != null){
			printPath(root.right,pathSum,path,k);
			printPath(root.right,0,"",k);
		}

	}

	public static void main(String[] args) {
		
		BTNode root = new BTNode(1);

		root.left = new BTNode(3); 
		root.left.left = new BTNode(2);
		root.left.right = new BTNode(1);
		root.left.right.left = new BTNode(1);

		root.right = new BTNode(-1); 
		root.right.left = new BTNode(4);
		root.right.right = new BTNode(5);
		
		root.right.left.left = new BTNode(1);
		root.right.left.right = new BTNode(2);
		
		root.right.right.right = new BTNode(6);

		printPath(root,5);
	}
}