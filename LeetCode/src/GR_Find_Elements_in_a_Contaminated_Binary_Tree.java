public class GR_Find_Elements_in_a_Contaminated_Binary_Tree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-1);
		root.right = new TreeNode(-1);
		FindElements f = new FindElements(root);
		System.out.println(f.find(10));

		System.out.println("Hello World");
	}

}

class FindElements {

	public FindElements(TreeNode root) {
		this.root = root;
		root.val = 0;
		recover(root);
		System.out.println();
	}

	TreeNode root;

	public static void recover(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.val = (root.val * 2) + 1;
		}
		if (root.right != null) {
			root.right.val = (root.val * 2) + 2;
		}
		recover(root.left);
		recover(root.right);
	}

	public boolean find(int target) {
		return help(root, target);
	}

	public static boolean help(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		if (root.val == target) {
			return true;
		}
		return help(root.left, target) || help(root.right, target);
	}
}
