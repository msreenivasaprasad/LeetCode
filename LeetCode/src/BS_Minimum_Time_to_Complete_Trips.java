public class BS_Minimum_Time_to_Complete_Trips {
	public static void main(String[] args) {
		int[] nums = { 39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50,
				13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100,
				15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26,
				63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25 };
		System.out.println(minimumTime(nums, 4187));
	}

	public static long minimumTime(int[] time, int totalTrips) {
		long end = Long.MAX_VALUE;
		long start = 0;
		long res = 0;
		while (start <= end) {
			long mid = start + (end - start) / 2;
			if (isPossible(time, mid, totalTrips)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	public static boolean isPossible(int[] nums, long i, int p) {
		if (i == 0) {
			return false;
		}
		long count = 0;
		for (int j = 0; j < nums.length; j++) {
			count += i / (long) nums[j];
			if (count >= (long) p) {
				return true;
			}
		}
		return false;
	}
}
