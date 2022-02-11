public class AL_Count_Square_Sum_Triples {
	public static void main(String[] args) {
		System.out.println(countTriples(250));
	}

	public static int countTriples(int n) {
		int[] count = new int[n];
		for (int i = 1; i <= n; i++) {
			count[i - 1] = (int) Math.pow(i, 2);
		}
		int res = 0;
		for (int i = 0; i < count.length - 1; i++) {
			for (int j = i + 1; j < count.length; j++) {
				if (binary(count, j + 1, count.length - 1, count[i] + count[j]) != -1) {
					res = res + 2;
				}
			}
		}
		return res;
	}

	public static int binary(int[] nums, int left, int right, int target) {
		int mid = (left + right) / 2;
		if (left < 0 || right >= nums.length || left > right) {
			return -1;
		}
		if (nums[mid] > target) {
			return binary(nums, left, mid - 1, target);
		}
		if (nums[mid] < target) {
			return binary(nums, mid + 1, right, target);
		}
		return mid;
	}

}
