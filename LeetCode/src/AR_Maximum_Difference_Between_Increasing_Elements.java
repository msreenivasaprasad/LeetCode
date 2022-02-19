public class AR_Maximum_Difference_Between_Increasing_Elements {
	public static void main(String[] args) {
		int[] nums = { 1, 5, 2, 10 };
		System.out.println(maximumDifference(nums));
	}

	public static int maximumDifference(int[] nums) {
		int[] mintillhere = new int[nums.length];
		int[] maxfromnow = new int[nums.length];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			mintillhere[i] = min;
		}
		int max = Integer.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > max) {
				max = nums[i];
			}
			maxfromnow[i] = max;
		}
		int res = -1;
		for (int i = 0; i < nums.length; i++) {
			if (maxfromnow[i] - mintillhere[i] > res && maxfromnow[i] - mintillhere[i] != 0) {
				res = maxfromnow[i] - mintillhere[i];
			}
		}
		return res;
	}

}
