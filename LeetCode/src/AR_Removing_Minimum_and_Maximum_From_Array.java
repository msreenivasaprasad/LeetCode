public class AR_Removing_Minimum_and_Maximum_From_Array {
	public static void main(String[] args) {
		int[] nums = { 101, 1, 3, -1, 111 };
		System.out.println(minimumDeletions(nums));
	}

	public static int minimumDeletions(int[] nums) {
		int max = nums[0], min = nums[0], maxindex = 0, minindex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxindex = i;
			}
			if (nums[i] < min) {
				min = nums[i];
				minindex = i;
			}
		}
		maxindex++;
		minindex++;
		int maxright = nums.length - maxindex + 1;
		int minright = nums.length - minindex + 1;
		int t = Integer.min(Integer.max(maxindex, minindex), Integer.max(maxright, minright));
		t = Integer.min(t, maxright + minindex);
		t = Integer.min(t, minright + maxindex);
		return t;

	}

}