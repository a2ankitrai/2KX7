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
needs to be changed.**TREE-INSERT** runs in `O(h)` time on a tree of height `h`.

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

### Binary Search Tree Delete

The overall strategy for deleting a node from a binary search tree `T` has three basic cases:

- If `Z` has no children, then we simply remove it by modifying its parent to replace `Z` with `NIL` as its child.

- If `Z` has just one child, then we elevate that child to take `Z’s` position in the tree
by modifying `Z’s` parent to replace `Z` by `Z’s` child.

- If `Z` has two children, then we find `Z’s` successor `y`—which must be in `Z’s` right subtree—and have `y` take `Z’s` position in the tree. The rest of `Z’s` original right subtree becomes `y’s` new right subtree, and `Z’s` left subtree becomes `y’s` new left subtree.

In order to move subtrees around within the binary search tree, we define a
subroutine **TRANSPLANT**, which replaces one subtree as a child of its parent with
another subtree. When **TRANSPLANT** replaces the subtree rooted at node `u` with
the subtree rooted at node `v`, node `u’s` parent becomes node `v’s` parent, and `u’s`
parent ends up having v as its appropriate child.

```java
public void transplant(Node u, Node v) {
		if (u.parent == null) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		if (v != null) {
			v.parent = u.parent;
		}
	}
```

With the TRANSPLANT procedure in hand, here is the procedure that deletes
node `Z` from binary search tree T :

```java
public void delete(Node z) {
		if (z.left == null) {
			transplant(z, z.right);
		} else if (z.right == null) {
			transplant(z, z.left);
		} else {
			Node y = treeMinimum(z.right);
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
		}

	}
```

---

## Problems

Q: Inorder Tree Traversal without recursion and without stack!