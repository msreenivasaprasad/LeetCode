import java.util.ArrayList;
import java.util.List;

public class GR_Maximum_Binary_Tree_II {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-100);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(-7);
		root.right.right.right = new TreeNode(10000);
		root.left = new TreeNode(9);
	}

	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		List<Integer> count = new ArrayList<Integer>();
		preOrder(root, count);
		count.add(val);
		int[] nums = new int[count.size()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = count.get(i);
		}
		return constructMaximumBinaryTree(nums);
	}

	public static void preOrder(TreeNode root, List<Integer> nums) {
		if (root == null) {
			return;
		}
		preOrder(root.left, nums);
		nums.add(root.val);
		preOrder(root.right, nums);
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return helper(nums, 0, nums.length);

	}

	public static TreeNode helper(int[] nums, int left, int right) {
		int mindex = maxIndex(nums, left, right);
		TreeNode root = new TreeNode(nums[mindex]);
		if (left != mindex) {
			root.left = helper(nums, left, mindex);

		}
		if (right - 1 != mindex) {
			root.right = helper(nums, mindex + 1, right);
		}

		return root;
	}

	public static int maxIndex(int[] a, int left, int right) {
		int index = left;
		int max = a[left];
		for (int i = left; i < right; i++) {
			if (a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}
}
