public class AR_Check_if_All_the_Integers_in_a_Range_Are_Covered {
	public static void main(String[] args) {
		int[][] ranges = { { 1, 10 }, { 10, 20 } };
		System.out.println(isCovered(ranges, 21, 21));
	}

	public static boolean isCovered(int[][] ranges, int left, int right) {
		boolean[] count = new boolean[right - left + 1];
		for (int i = 0; i < ranges.length; i++) {
			for (int j = ranges[i][0] - left; j <= ranges[i][1] - left; j++) {
				if (j >= 0 && j < count.length) {
					count[j] = true;
				}
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (!count[i]) {
				return false;
			}
		}
		return true;
	}
}