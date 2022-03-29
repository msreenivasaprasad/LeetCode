public class SW_Maximum_Alternating_Subsequence_Sum {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(maxAlternatingSum(nums));
	}

	public static long maxAlternatingSum(int[] nums) {
		int lastmin = 0;
		long res = 0;
		boolean flag = true;
		int right = 1;
		if (nums.length == 1) {
			return nums[0];
		}
		while (right < nums.length) {
			if (flag) {
				if (nums[right] < nums[right - 1]) {
					res += nums[right - 1] - lastmin;
					flag = false;
					right++;
				} else if (right == nums.length - 1) {
					res += nums[right] - lastmin;
					right++;
				} else {
					right++;
				}
			} else {
				if (nums[right] > nums[right - 1]) {
					lastmin = nums[right - 1];
					flag = true;
				} else {
					right++;
				}

			}
		}
		return res;
	}

}
