public class DP_Coin_Change {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 5 };
		System.out.println(coinChange(nums, 11));
	}

	public static int coinChange(int[] coins, int amount) {
		dyn = new int[amount + 1];
		visited = new boolean[amount + 1];
		return help(coins, amount);
	}

	static int[] dyn;
	static boolean[] visited;

	public static int help(int[] coins, int sum) {
		if (sum == 0) {
			return 0;
		}
		if (visited[sum]) {
			return dyn[sum];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= sum) {
				int t = help(coins, sum - coins[i]);
				if (t != -1) {
					min = Integer.min(t + 1, min);
				}
			}
		}
		visited[sum] = true;
		if (min == Integer.MAX_VALUE) {
			dyn[sum] = -1;
			return -1;
		}
		dyn[sum] = min;
		return min;
	}

}
