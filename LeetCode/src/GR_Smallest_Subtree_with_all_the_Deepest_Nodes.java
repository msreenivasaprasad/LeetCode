import java.util.HashMap;
import java.util.Map;

public class GR_Smallest_Subtree_with_all_the_Deepest_Nodes {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(7);
		root.left.right.left.left = new TreeNode(9);
		root.left.right.left.right = new TreeNode(10);
		root.left.right.left.right.right = new TreeNode(11);
		root.left.right.right = new TreeNode(8);
		System.out.println(subtreeWithAllDeepest(root).val);
	}

	public static TreeNode subtreeWithAllDeepest(TreeNode root) {
		dyn = new HashMap<Integer, Integer>();
		return findNode(root);
	}

	static Map<Integer, Integer> dyn;

	public static int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (dyn.containsKey(root.val)) {
			return dyn.get(root.val);
		}
		int t = Integer.max(depth(root.left), depth(root.right)) + 1;
		dyn.put(root.val, t);
		return t;
	}

	public static TreeNode findNode(TreeNode root) {
		if (root == null) {
			return null;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if (left > right) {
			return findNode(root.left);
		} else if (right > left) {
			return findNode(root.right);
		}
		return root;
	}
}