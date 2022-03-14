public class AR_Check_if_Array_Is_Sorted_and_Rotated {
	public static void main(String[] args) {
		int[] nums = { 0 };
		System.out.println(check(nums));
	}

	public static boolean check(int[] nums) {
		boolean flag = false;
		if (nums.length <= 2) {
			return true;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1] && !flag) {
				flag = true;
			} else if (nums[i] < nums[i - 1] && flag) {
				return false;
			}
		}
		if (flag && nums[nums.length - 1] > nums[0]) {
			return false;
		}
		return true;
	}
}