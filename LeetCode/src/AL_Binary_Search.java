public class AL_Binary_Search {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 9 };
		System.out.println(search(nums, 9));
	}

	public static int search(int[] nums, int target) {
		return binary(nums, 0, nums.length - 1, target);
	}

	public static int binary(int[] nums, int left, int right, int target) {
		int mid = (left + right) / 2;
		if (left < 0 || right >= nums.length || left > right) {
			return -1;
		}
		if (nums[mid] > target) {
			return binary(nums, left, mid - 1, target);
		}
		if (nums[mid] < target) {
			return binary(nums, mid + 1, right, target);
		}
		return mid;
	}

}