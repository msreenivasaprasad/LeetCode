public class AR_Smallest_Index_With_Equal_Value {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		System.out.println(smallestEqual(nums));

	}

	public static int smallestEqual(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (i % 10 == nums[i]) {
				return i;
			}
		}
		return -1;
	}
}
