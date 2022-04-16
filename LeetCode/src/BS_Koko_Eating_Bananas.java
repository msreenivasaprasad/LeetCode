public class BS_Koko_Eating_Bananas {
	public static void main(String[] args) {
		int[] nums = { 30, 11, 23, 4, 20 };
		System.out.println(minEatingSpeed(nums, 6));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int end = Integer.MAX_VALUE;
		int start = 0;
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(piles, mid, h)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	public static boolean isPossible(int[] nums, int i, int p) {
		if (i == 0) {
			return false;
		}
		int count = 0;
		for (int j = 0; j < nums.length; j++) {
			count += nums[j] / i;
			if (nums[j] % i != 0) {
				count++;
			}
		}
		return count <= p;
	}
}
