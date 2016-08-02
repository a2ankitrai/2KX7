 
#Trees 

Tree is a non-linear data structure.

### Binary Tree
In Binary Tree each node has zero child, one child or two children.

***Strict Binary Tree***:
If each node has exactly two children or no children.

___Full Binary Tree___: 
If each node has exactly two children and all leaf nodes are at same level.	

***Complete Binary Tree***: 
If all leaf nodes are at height `h` or `h-1` and also without any missing number of sequence.  
	
	
## Binary tree implementation
```
public class BinaryTree {

	public BTNode root;

	static class BTNode {
		public int data;
		public BTNode left;
		public BTNode right;

		public BTNode(int data) {
			this.data = data;
			left =  null;
			right = null;
		}
	}

	public BinaryTree(BTNode root) {
		this.root = root;
	}
}	
```	

## Binary tree traversals
**Preorder**: Each node is preocessed before (pre) either of its sub-trees.  
_Recursive approach_
```
public void preOrderTraversalRecursive(BTNode root) {
		if (root != null) {
			System.out.print(root.data + " --> ");
			preOrderTraversalRecursive(root.left);
			preOrderTraversalRecursive(root.right);
		}
	}
```

_Iterative approach_  
This code works but it is heavily under optimal. This was your 1st attempt.
```
public void preOrderTraversal() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}
		String treeElements = "";
		BTNode temp = root;

		Stack<BTNode> s = new Stack<BTNode>();

		while (temp != null || !s.empty()) {

			if (temp == null) {
				temp = s.pop();
			}
			System.out.println(treeElements);
			treeElements += temp.data + " --> ";
			if (temp.right != null) {
				s.push(temp.right);
			}
			temp = temp.left;
		}

		System.out.println(treeElements);
	}
```

A more optimal code
```
public void preOrderTraversal() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}
		String treeElements = "";

		Stack<BTNode> s = new Stack<BTNode>();
		s.push(root);
		while (!s.empty()) {
			BTNode temp = s.pop();
			treeElements += temp.data + " --> ";
			if (temp.right != null) {
				s.push(temp.right);
			}
			if (temp.left != null) {
				s.push(temp.left);
			}
		}
		System.out.println(treeElements);
	}
```

**Inorder Iterative Traversal**
```
public void inOrderTraversalIterative() {
		if (root == null) {
			System.out.println("Empty tree");
			return ;
		}
		BTNode curr = root;
		Stack<BTNode> s = new Stack<BTNode>();
		String treeElements = "";
		boolean done =  false;

		while (!done) {
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				if (s.empty()) {
					done = true;
				} else {
					curr = s.pop();
					treeElements += " --> " + curr.data;
					curr = curr.right;
				}
			}
		}
		System.out.println(treeElements);
	}
```

**Postorder Traversal of Binary tree**  
There is one more approach other than below but this one is optimal
```
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
 
    if(root==null) {
        return res;
    }
 
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
 
    while(!stack.isEmpty()) {
        TreeNode temp = stack.peek();
        if(temp.left==null && temp.right==null) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
        }
        else {
            if(temp.right!=null) {
                stack.push(temp.right);
                temp.right = null;
            }
 
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left = null;
            }
        }
    }
 
    return res;
}
```
