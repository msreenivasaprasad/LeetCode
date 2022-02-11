public class AR_Smallest_Range_I {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(smallestRangeI(nums, 0));
	}
	
	public static int smallestRangeI(int[] nums, int k) {
		int max = nums[0];
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return Integer.max(0, max - min - (2 * k));
	}
}
