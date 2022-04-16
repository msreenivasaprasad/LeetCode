public class BS_Maximum_Candies_Allocated_to_K_Children {
	public static void main(String[] args) {
		int[] nums = { 2, 5 };
		System.out.println(maximumCandies(nums, 11));
	}

	public static int maximumCandies(int[] candies, long k) {
		int end = Integer.MAX_VALUE;
		int start = 0;
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(candies, mid, k)) {
				res = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return res;
	}

	public static boolean isPossible(int[] nums, int i, long p) {
		if (i == 0) {
			return true;
		}
		for (int j = 0; j < nums.length; j++) {
			p -= nums[j] / i;
		}
		return p <= 0;
	}
}
