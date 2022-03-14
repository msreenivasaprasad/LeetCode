public class AR_Find_the_Highest_Altitude {
	public static void main(String[] args) {
		int[] nums = { -5, 1, 5, 0, -7 };
		System.out.println(largestAltitude(nums));
	}

	public static int largestAltitude(int[] gain) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < gain.length; i++) {
			sum += gain[i];
			max = Integer.max(sum, max);
		}
		return max;
	}

}