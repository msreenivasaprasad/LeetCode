
public class AR_Count_Number_of_Pairs_With_Absolute_Difference_K {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 1 };
		System.out.println(countKDifference(nums, 1));

	}

	public static int countKDifference(int[] nums, int k) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (Math.abs(nums[i] - nums[j]) == k) {
					res++;
				}
			}
		}
		return res;
	}
}