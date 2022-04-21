public class DP_Largest_Sum_of_Averages {
	public static void main(String[] args) {
		int[] nums = { 9, 1, 2, 3, 9 };
		System.out.println(largestSumOfAverages(nums, 3));
	}

	public static double largestSumOfAverages(int[] nums, int k) {
		visited = new boolean[nums.length][k];
		dyn = new double[nums.length][k];
		return help(nums, 0, k);
	}

	static boolean[][] visited;
	static double[][] dyn;

	public static double help(int[] nums, int i, int k) {
		if (i >= nums.length) {
			return 0;
		}
		if (visited[i][k - 1]) {
			return dyn[i][k - 1];
		}
		if (k <= 1) {
			double sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
			}
			return sum / (double) (nums.length - i);
		}
		double max = 0;
		double sum = 0;
		for (int j = i; j < nums.length; j++) {
			sum += nums[j];
			double t = help(nums, j + 1, k - 1);
			max = Double.max(max, t + sum / (double) (j - i + 1));
		}
		visited[i][k - 1] = true;
		dyn[i][k - 1] = max;
		return max;
	}
}
