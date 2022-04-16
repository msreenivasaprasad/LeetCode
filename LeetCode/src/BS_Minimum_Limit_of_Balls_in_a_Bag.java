public class BS_Minimum_Limit_of_Balls_in_a_Bag {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(minimumSize(nums, 1));
	}

	public static int minimumSize(int[] nums, int maxOperations) {
		int end = Integer.MAX_VALUE;
		int start = 0;
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(nums, mid, maxOperations)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;

	}

	public static boolean isPossible(int[] nums, int i, int operations) {
		if (i == 0) {
			for (int k = 0; k < nums.length; k++) {
				if (nums[k] != 0) {
					return false;
				}
			}
			return true;
		}
		for (int j = 0; j < nums.length; j++) {
			operations -= nums[j] / i;
			if (nums[j] % i == 0) {
				operations++;
			}

		}
		return operations >= 0;
	}
}
