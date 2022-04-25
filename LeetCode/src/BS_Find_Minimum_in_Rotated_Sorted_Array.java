public class BS_Find_Minimum_in_Rotated_Sorted_Array {
	public static void main(String[] args) {
		int[] nums = { 8 };
		System.out.println(findMin(nums));
	}

	public static int findPivot(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		if (nums[start] <= nums[end]) {
			return -1;
		}
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return mid;
			}
			if (nums[mid] >= nums[start]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return 0;
	}

	public static int findMin(int[] nums) {
		return nums[(findPivot(nums) + 1)];
	}
}
