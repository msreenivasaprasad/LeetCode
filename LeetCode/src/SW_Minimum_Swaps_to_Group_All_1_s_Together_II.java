public class SW_Minimum_Swaps_to_Group_All_1_s_Together_II {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 1, 1, 0, 0, 1 };
		System.out.println(minSwaps(nums));
	}

	public static int minSwaps(int[] nums) {
		int size = 0;
		for (int i = 0; i < nums.length; i++) {
			size += nums[i];
		}
		int left = 0;
		int right = size;
		int zeros = 0;
		for (int i = 0; i < size; i++) {
			if (nums[i] == 0) {
				zeros++;
			}
		}
		int min = zeros;
		if (min == 0) {
			return min;
		}
		boolean flag = false;
		while (!flag || left != 0) {
			if (nums[right] == 0) {
				zeros++;
			}
			right++;
			if (nums[left] == 0) {
				zeros--;
			}
			left++;
			if (zeros < min) {
				min = zeros;
			}
			if (right == nums.length) {
				right = 0;
			}
			if (left == nums.length) {
				flag = true;
				left = 0;
			}
		}
		return min;

	}

}