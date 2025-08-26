
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
			displayHelper(root.left);
			System.out.println(root.data);
			displayHelper(root.right);
		}
	}
	public boolean search(int data) {
		return false;
	}
	private boolean searchHelper(BinaryTreeNode root, int data) {
		return false;
	}
	
	public void remove(int data) {
		
	}
	private BinaryTreeNode removeHelper(BinaryTreeNode root, int data) {
		return null;
	}
	
	private int successor(BinaryTreeNode root) {
		return -1;
	}
	private int predecessor(BinaryTreeNode root) {
		return -1;
	}
}
