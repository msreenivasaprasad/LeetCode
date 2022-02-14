public class AR_Partition_Array_According_to_Given_Pivot {
	public static void main(String[] args) {
		int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
		int[] res = pivotArray(nums, 10);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] pivotArray(int[] nums, int pivot) {
		int[] result = new int[nums.length];
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < pivot) {
				result[k++] = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == pivot) {
				result[k++] = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > pivot) {
				result[k++] = nums[i];
			}
		}
		return result;
	}

}
