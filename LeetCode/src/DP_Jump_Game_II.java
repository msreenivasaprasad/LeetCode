public class DP_Jump_Game_II {
	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));
	}

	public static int jump(int[] nums) {
		int[] dyn = new int[nums.length];
		dyn[dyn.length - 1] = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE - 1;
			for (int j = i + 1; j <= i + nums[i]; j++) {
				if (j >= nums.length) {
					break;
				}
				if (nums[i] != 0) {
					min = Integer.min(min, dyn[j]);
				}
			}
			dyn[i] = min + 1;
		}
		return dyn[0];
	}

}
