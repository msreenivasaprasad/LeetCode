package Standard;

public class Kadane_Algorithm_Max_Sub_Array {
	public static void main(String[] args) {
		int[] nums = { 2, -5, 1, -4, 3, -2 };
		System.out.println(maxAbsoluteSum(nums));
	}

	public static int maxAbsoluteSum(int[] nums) {
		int max = 0;
		int maxer = 0;
		//The max sub array either continues or starts with the current element
		for (int i = 0; i < nums.length; i++) {
			max = Integer.max(max + nums[i], nums[i]);
			maxer = Integer.max(maxer, max);
		}
		int min = 100001;
		int miner = 100001;
		for (int i = 0; i < nums.length; i++) {
			min = Integer.min(min + nums[i], nums[i]);
			miner = Integer.min(miner, min);
		}
		return Integer.max(Math.abs(maxer), Math.abs(miner));
	}

}