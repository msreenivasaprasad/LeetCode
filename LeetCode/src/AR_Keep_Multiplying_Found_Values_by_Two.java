import java.util.Arrays;

public class AR_Keep_Multiplying_Found_Values_by_Two {
	public static void main(String[] args) {
		int[] nums = { 5, 3, 6, 1, 12 };
		System.out.println(findFinalValue(nums, 3));
	}

	public static int findFinalValue(int[] nums, int original) {
		Arrays.sort(nums);
		int current = original;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == current) {
				current = current * 2;
			}
		}
		return current;
	}
}