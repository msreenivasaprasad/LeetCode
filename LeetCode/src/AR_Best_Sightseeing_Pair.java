public class AR_Best_Sightseeing_Pair {
	public static void main(String[] args) {
		int[] nums = { 1, 2 };
		System.out.println(maxScoreSightseeingPair(nums));

	}

	public static int maxScoreSightseeingPair(int[] values) {
		int val = 0;
		int res = 0;
		for (int i = 0; i < values.length; i++) {
			res = Integer.max(res, val + values[i] - i);
			val = Integer.max(i + values[i], val);
		}
		return res;
	}
}