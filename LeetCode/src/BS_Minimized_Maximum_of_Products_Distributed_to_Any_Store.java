public class BS_Minimized_Maximum_of_Products_Distributed_to_Any_Store {
	public static void main(String[] args) {
		int[] nums = { 10, 1 };
		System.out.println(minimizedMaximum(4, nums));
	}

	public static int minimizedMaximum(int n, int[] quantities) {
		int end = Integer.MAX_VALUE;
		int start = 0;
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(quantities, mid, n)) {
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
