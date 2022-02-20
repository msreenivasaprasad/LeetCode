import java.util.Arrays;

public class AR_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores {
	public static void main(String[] args) {
		int[] nums = { 9, 4, 1, 7 };
		System.out.println(minimumDifference(nums, 2));
	}

	public static int minimumDifference(int[] nums, int k) {
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < nums.length; i++) {
			min = Integer.min(min, nums[i + k - 1] - nums[i]);
		}
		return min;
	}
}
