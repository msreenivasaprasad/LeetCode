public class BM_Total_Hamming_Distance {
	public static void main(String[] args) {
		int[] nums = { 4, 14, 4 };
		System.out.println(totalHammingDistance(nums));
	}

	public static int totalHammingDistance(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int k = 1 << i;
			int zeros = 0;
			int ones = 0;
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & k) == 0) {
					zeros++;
				} else {
					ones++;
				}
			}
			res += zeros * ones;
		}
		return res;
	}
}