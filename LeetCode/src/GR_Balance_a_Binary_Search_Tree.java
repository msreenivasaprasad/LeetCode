import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GR_Balance_a_Binary_Search_Tree {
	public static void main(String[] args) {
		TreeNode root = null;
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		root.right.right.right.right = new TreeNode(5);
		balanceBST(root);
	}

	public static TreeNode balanceBST(TreeNode root) {
		List<Integer> nums = new ArrayList<Integer>();
		toarr(root, nums);
		int[] arr = new int[nums.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = nums.get(i);
		}
		Arrays.sort(arr);
		return help(arr, 0, arr.length - 1);
	}

	public static void toarr(TreeNode root, List<Integer> nums) {
		if (root == null) {
			return;
		}
		nums.add(root.val);
		toarr(root.left, nums);
		toarr(root.right, nums);
	}

	public static TreeNode help(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = help(nums, left, mid - 1);
		root.right = help(nums, mid + 1, right);
		return root;
	}
}