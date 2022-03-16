import java.util.Arrays;

public class AR_Minimum_Moves_to_Equal_Array_Elements_II {
	public static void main(String[] args) {
		int[] nums = { 1, 10, 2, 9 };
		System.out.println(minMoves2(nums));
		System.out.println("Hello World");
	}

	public static int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += Math.abs(nums[nums.length / 2] - nums[i]);
		}
		if (nums.length % 2 != 0) {
			return res;
		}
		int res2 = 0;
		for (int i = 0; i < nums.length; i++) {
			res2 += Math.abs(nums[(nums.length / 2) - 1] - nums[i]);
		}
		return Integer.min(res, res2);

	}
}