
public class BinarySearchTree {
	BinaryTreeNode root;
	
	public void insert(BinaryTreeNode node) {
		root = insertHelper(root,node);
	}
	private BinaryTreeNode insertHelper(BinaryTreeNode root, BinaryTreeNode node) {
		int data = node.data;
		if(root == null) {
			root = node;
			return root;
		}else if(data < root.data) {
			root.left = insertHelper(root.left, node);
		}else {
			root.right = insertHelper(root.right,node);
		}
		return root;
		
	}
	public void display() {
		displayHelper(root);
	}
	private void displayHelper(BinaryTreeNode root) {
		if(root != null) {
			//in order traversal
			//can change to right then left for decreasing order
			displayHelper(root.left);
			System.out.println(root.data);
			displayHelper(root.right);
		}
	}
	public boolean search(int data) {
		return searchHelper(root,data);
	}
	private boolean searchHelper(BinaryTreeNode root, int data) {
		if(root == null) {
			return false;
		}else if(root.data == data) {
			return true;
		}else if(root.data > data) {
			return searchHelper(root.left,data);
		}else {
			return searchHelper(root.right,data);
		}
	}
	
	public void remove(int data) {
		if(search(data)) {
			removeHelper(root,data);
		}else {
			System.out.println(data + " could not be found");
		}
	}
	private BinaryTreeNode removeHelper(BinaryTreeNode root, int data) {
		if(root == null) {
			return root;
		}else if(data < root.data) {
			root.left = removeHelper(root.left,data);
		}else if(data > root.data) {
			root.right = removeHelper(root.right,data);
		}else {
			//found the node
			if(root.left == null && root.right == null) {//if its a leaf node
				root = null;
			}
			else if(root.right != null) {
				//right child find a successor to replace this node
				root.data = successor(root);
				root.right = removeHelper(root.right,root.data);
			}else {
				//find a predecessor to replace thios node
				//left child
				root.data = predecessor(root);
				root.left = removeHelper(root.left,root.data);
			}
		}
		return root;
	}
	
	private int successor(BinaryTreeNode root) {
		//find the least value below the right child of this root node
		root = root.right;
		while(root.left != null) {
			root = root.left;
		}
		return root.data;
	}
	private int predecessor(BinaryTreeNode root) {
		//find the greatest value below the left child
		root = root.left;
		while(root.right != null) {
			root = root.right;
		}
		return root.data;
	}
	
	public void inOrderTraverseTree(BinaryTreeNode root) {
		//left root right
		//
		inOrderTraverseTree(root.left);
		System.out.println(root.data);
		inOrderTraverseTree(root.right);
	}
	public void postOrderTraversal(BinaryTreeNode root) {
		//left right root
		//userd to delete a tree from leaf to root
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
	}
	
	public void preOrderTraversal(BinaryTreeNode root) {
		//root left right 
		//used to create a copy of a tree
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
}
