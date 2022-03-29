public class DP_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public static void main(String[] args) {
		int[] nums = { 2, 1, 4 };
		System.out.println(maxProfit(nums));
	}

	public static int maxProfit(int[] prices) {
		dyn = new int[prices.length];
		visited = new boolean[prices.length];
		return help(prices, 0);

	}

	static int[] dyn;
	static boolean[] visited;

	public static int help(int[] prices, int index) {
		if (index >= prices.length) {
			return 0;
		}
		if (visited[index]) {
			return dyn[index];
		}
		int max = 0;
		for (int i = index + 1; i < prices.length; i++) {
			if (prices[i] > prices[index]) {
				max = Integer.max(max, help(prices, i + 2) + prices[i] - prices[index]);
			}
		}
		max = Integer.max(max, help(prices, index + 1));
		visited[index] = true;
		dyn[index] = max;
		return max;
	}
}
