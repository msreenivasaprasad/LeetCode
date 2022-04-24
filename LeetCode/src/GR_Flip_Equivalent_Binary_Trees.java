public class GR_Flip_Equivalent_Binary_Trees {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.left.left = new TreeNode(3);
		System.out.println(flipEquiv(root1, root2));
	}

	public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
		return help(root1, root2);
	}

	public static boolean help(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val == root2.val) {
			return (help(root1.left, root2.left) && help(root1.right, root2.right))
					|| (help(root1.left, root2.right) && help(root1.right, root2.left));
		}
		return false;
	}
}
