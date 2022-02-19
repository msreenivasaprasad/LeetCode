public class AR_Find_the_Middle_Index_in_Array {
	public static void main(String[] args) {
		int[] nums = { 1, -1, 4 };
		System.out.println(findMiddleIndex(nums));
	}

	public static int findMiddleIndex(int[] nums) {
		int[] leftsum = new int[nums.length];
		for (int i = nums.length - 2; i >= 0; i--) {
			leftsum[i] = leftsum[i + 1] + nums[i + 1];
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum == leftsum[i]) {
				return i;
			}
			sum += nums[i];
		}
		return -1;
	}
}
