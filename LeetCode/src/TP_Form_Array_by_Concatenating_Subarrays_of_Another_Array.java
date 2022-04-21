public class TP_Form_Array_by_Concatenating_Subarrays_of_Another_Array {
	public static void main(String[] args) {
		int[][] groups = { { 1, 0 }, { 1, 0 }, { 2 } };
		int[] nums = { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2 };
		System.out.println(canChoose(groups, nums));
	}

	public static boolean canChoose(int[][] groups, int[] nums) {
		int start = 0;
		int i = 0;
		while (i < groups.length) {
			if (check(groups[i], nums, start)) {
				start += groups[i].length;
				i++;
			} else {
				start++;
			}
			if (i >= groups.length) {
				return true;
			}
			if (start >= nums.length) {
				return false;
			}
		}
		return true;

	}

	public static boolean check(int[] arr, int[] nums, int index) {
		if (nums.length - index < arr.length) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if (nums[index] == arr[i]) {
				index++;
			} else {
				return false;
			}
		}
		return true;
	}

}
