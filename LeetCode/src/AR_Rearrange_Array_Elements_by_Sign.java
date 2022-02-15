public class AR_Rearrange_Array_Elements_by_Sign {
	public static void main(String[] args) {
		int[] nums = { 3, 1, -2, -5, 2, -4 };
		int[] res = rearrangeArray(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] rearrangeArray(int[] nums) {
		int[] res = new int[nums.length];
		int k = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				res[k] = nums[i];
				k += 2;
			}
		}
		k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res[k] = nums[i];
				k += 2;
			}
		}
		return res;
	}
}
