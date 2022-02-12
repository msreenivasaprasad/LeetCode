import java.util.Arrays;

public class AR_Count_Elements_With_Strictly_Smaller_and_Greater_Elements {
	public static void main(String[] args) {
		int[] nums = { 5, 5 };
		System.out.println(countElements(nums));
	}

	public static int countElements(int[] nums) {
		Arrays.sort(nums);
		if (nums[0] == nums[nums.length - 1]) {
			return 0;
		}
		int rightcount = 0;
		int i = nums.length - 1;
		while (i >= 0 && nums[i] == nums[nums.length - 1]) {
			rightcount++;
			i--;
		}
		int leftcount = 0;
		i = 0;
		while (i < nums.length && nums[i] == nums[0]) {
			leftcount++;
			i++;
		}
		return nums.length - leftcount - rightcount;
	}
}