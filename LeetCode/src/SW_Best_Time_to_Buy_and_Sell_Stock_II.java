public class SW_Best_Time_to_Buy_and_Sell_Stock_II {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(maxProfit(nums));
	}

	public static int maxProfit(int[] prices) {
		boolean flag = false;
		int right = 1;
		int buy = 0;
		int res = 0;
		while (right <= prices.length) {
			if (!flag) {
				if (right < prices.length && prices[right] > prices[right - 1]) {
					buy = prices[right - 1];
					flag = true;
					right++;
				} else {
					right++;
				}
			} else {
				if (right < prices.length && prices[right] < prices[right - 1]) {
					res += prices[right - 1] - buy;
					flag = false;
					right++;
				} else if (right == prices.length) {
					res += prices[right - 1] - buy;
					right++;
				} else {
					right++;
				}
			}
		}
		return res;
	}

	public static long maxAlternatingSum(int[] nums) {
		int lastmin = 0;
		long res = 0;
		boolean flag = true;
		int right = 1;
		if (nums.length == 1) {
			return nums[0];
		}
		while (right < nums.length) {
			if (flag) {
				if (nums[right] < nums[right - 1]) {
					res += nums[right - 1] - lastmin;
					flag = false;
					right++;
				} else if (right == nums.length - 1) {
					res += nums[right] - lastmin;
					right++;
				} else {
					right++;
				}
			} else {
				if (nums[right] > nums[right - 1]) {
					lastmin = nums[right - 1];
					flag = true;
				} else {
					right++;
				}

			}
		}
		return res;
	}
}
