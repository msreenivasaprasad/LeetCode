import java.util.Arrays;

public class AR_Sum_of_Unique_Elements {
	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		System.out.println(sumOfUnique(nums));
	}

	public static int sumOfUnique(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 1) {
			return nums[0];
		}
		int res = 0;
		if (nums[1] != nums[0]) {
			res += nums[0];
		}
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] != nums[i - 1] & nums[i] != nums[i + 1]) {
				res += nums[i];
			}
		}
		if (nums[nums.length - 1] != nums[nums.length - 2]) {
			res += nums[nums.length - 1];
		}
		return res;
	}

}