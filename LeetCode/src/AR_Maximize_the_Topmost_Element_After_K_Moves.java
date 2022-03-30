public class AR_Maximize_the_Topmost_Element_After_K_Moves {
	public static void main(String[] args) {
		int[] nums = { 100, 1, 1, 2100 };
		System.out.println(maximumTop(nums, 33));
	}

	public static int maximumTop(int[] nums, int k) {
		if (k == 0) {
			return nums[0];
		}
		if (k == 1 && nums.length > 1) {
			return nums[1];
		}

		if (nums.length == 1) {
			if (k % 2 != 0) {
				return -1;
			}
			return nums[0];
		}
		if (nums.length >= k - 1) {
			int max = nums[0];
			for (int i = 0; i < k - 1; i++) {
				max = Integer.max(max, nums[i]);
			}
			if (k < nums.length) {
				return Integer.max(max, nums[k]);
			}
			return max;
		} else {
			int max = nums[0];
			for (int i = 0; i < nums.length; i++) {
				max = Integer.max(max, nums[i]);
			}
			return max;
		}
	}
}
