public class AR_Partition_Array_into_Disjoint_Intervals {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(partitionDisjoint(nums));
	}

	public static int partitionDisjoint(int[] nums) {
		int[] minsFromRight = new int[nums.length];
		int[] maxFromLeft = new int[nums.length];
		maxFromLeft[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxFromLeft[i] = Integer.max(nums[i], maxFromLeft[i - 1]);
		}
		minsFromRight[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			minsFromRight[i] = Integer.min(nums[i], minsFromRight[i + 1]);
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (minsFromRight[i + 1] >= maxFromLeft[i]) {
				return i + 1;
			}
		}
		return -1;
	}
}