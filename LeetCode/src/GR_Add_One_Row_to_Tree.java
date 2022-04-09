public class GR_Add_One_Row_to_Tree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		addOneRow(root, 1, 3);
		System.out.println();
	}

	public static TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (root == null) {
			return root;
		}
		if (depth == 1) {
			TreeNode nroot = new TreeNode(val);
			nroot.left = root;
			return nroot;
		}
		help(root, depth - 1, val);
		return root;
	}

	public static void help(TreeNode root, int depth, int val) {
		if (root == null) {
			return;
		}
		if (depth == 1) {
			TreeNode ltemp = root.left;
			root.left = new TreeNode(val);
			root.left.left = ltemp;
			TreeNode rtemp = root.right;
			root.right = new TreeNode(val);
			root.right.right = rtemp;
			return;
		}
		help(root.left, depth - 1, val);
		help(root.right, depth - 1, val);

	}
}