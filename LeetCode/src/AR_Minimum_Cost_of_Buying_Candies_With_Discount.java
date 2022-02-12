import java.util.Arrays;

public class AR_Minimum_Cost_of_Buying_Candies_With_Discount {
	public static void main(String[] args) {
		int[] cost = { 6, 5, 7, 9, 2, 2 };
		System.out.println(minimumCost(cost));
	}

	public static int minimumCost(int[] cost) {
		Arrays.sort(cost);
		int res = 0;
		for (int i = cost.length - 1; i >= 0; i--) {
			if ((cost.length - i) % 3 != 0) {
				res += cost[i];
			}
		}
		return res;
	}
}
