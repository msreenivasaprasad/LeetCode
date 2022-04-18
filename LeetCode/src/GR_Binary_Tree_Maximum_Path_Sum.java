public class GR_Binary_Tree_Maximum_Path_Sum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-100);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(-7);
		root.right.right.right = new TreeNode(10000);
		root.left = new TreeNode(9);
		System.out.println(maxPathSum(root));
	}

	public static int maxPathSum(TreeNode root) {
		max = 0;
		int maxee = findMax(root);
		if (maxee < 0) {
			return maxee;
		}
		return Integer.max(maxer(root), max);
	}

	public static int findMax(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		return Integer.max(Integer.max(root.val, findMax(root.left)), findMax(root.right));
	}

	static int max;

	public static int maxer(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxer(root.left);
		int right = maxer(root.right);

		int t = Integer.max(Integer.max(0, root.val), Integer.max(left + root.val, right + root.val));
		max = Integer.max(Integer.max(max, t), left + right + root.val);
		return t;
	}

	public static int findRadius(int[] houses, int[] heaters) {
		int end = Integer.MAX_VALUE;
		int start = 0;
		int res = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(houses, heaters, mid)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;

	}

	public static boolean isPossible(int[] nums, int[] heaters, int i) {
		int t = 0;
		int j = 0;
		while (t < nums.length) {
			if (j >= heaters.length) {
				return t >= nums.length;
			}
			if (nums[t] >= (long) heaters[j] - (long) i && nums[t] <= (long) heaters[j] + (long) i) {
				t++;
			} else {
				j++;
			}
		}
		return t >= nums.length;
	}
}
