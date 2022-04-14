import java.util.ArrayList;
import java.util.List;

public class DS_Serialize_and_Deserialize_BST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		deserialize(toStr(root));
	}

	public static String serialize(TreeNode root) {
		return toStr(root);
	}

	public static TreeNode deserialize(String data) {
		int prev = 0;
		List<String> num = new ArrayList<String>();
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == '*') {
				num.add(data.substring(prev, i));
				prev = i + 1;
			}
		}
		num.add(data.substring(prev, data.length()));

		int[] nums = new int[num.size()];
		for (int i = 0; i < nums.length; i++) {
			if (num.get(i).equals("N")) {
				nums[i] = -1;
			} else {
				nums[i] = Integer.parseInt(num.get(i));
			}
		}
		TreeNode t = toTree(nums, 0);
		System.out.println();
		return t;
	}

	static int lastnull;

	public static TreeNode toTree(int[] nums, int i) {
		if (nums[i] == -1) {
			lastnull = i;
			return null;
		}
		TreeNode t = new TreeNode(nums[i]);
		t.left = toTree(nums, i + 1);
		t.right = toTree(nums, lastnull + 1);
		return t;
	}

	public static String toStr(TreeNode root) {
		if (root == null) {
			return "N";
		}
		return Integer.toString(root.val) + "*" + toStr(root.left) + "*" + toStr(root.right);
	}
}
