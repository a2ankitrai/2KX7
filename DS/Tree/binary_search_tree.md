# Binary Search Tree

The keys in a binary search tree are always stored in such a way as to satisfy the **binary-search-tree property**:

Let `x` be a node in a binary search tree. If `y` is a node in the left subtree
of `x`, then `y.key <= x.key`. If `y` is a node in the right subtree of `x`, then `y.key >= x.key`.

The binary-search-tree property allows us to print out all the keys in a binary
search tree in sorted order by a simple recursive algorithm, called an inorder tree walk.

### Inorder Tree Walk Recursive

```java
	public void inorderTreeWalk(Node x){
			if(x!=null){
				inorderTreeWalk(x.left);
				System.out.println("- "+x.data+" - ");
				inorderTreeWalk(x.right);
			}
		}
```

### Binary Search Tree Insert

Just like the procedures **treeSearch** , **treeInsert** begins at the root of the
tree and the pointer `x` traces a simple path downward looking for a `null` to replace
with the input item. This `null` occupies the position where we wish to
place the input item. The procedure maintains the trailing pointer `y` as the parent of `x`. We need the trailing pointer `y`, because by the time we find
the `null` where  belongs, the search has proceeded one step beyond the node that
needs to be changed.

```java
public void treeInsert(int data) {
		Node y = null;
		Node x = root;
		Node z = new Node(data);

		while (x != null) {
			y = x;
			if (z.data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		z.parent = y;
		if (y == null) {
			root = z;
		} else if (z.data < y.data) {
			y.left = z;
		} else {
			y.right = z;
		}
	}
```

---

## Problems

Q: Inorder Tree Traversal without recursion and without stack!