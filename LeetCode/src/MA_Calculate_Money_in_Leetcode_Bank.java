public class MA_Calculate_Money_in_Leetcode_Bank {
	public static void main(String[] args) {
		System.out.println(totalMoney(0));
	}

	public static int totalMoney(int n) {
		int no_of_full_weeks = n / 7;
		int res = 0;
		for (int i = 0; i < no_of_full_weeks; i++) {
			res += 7 * (i + 4);
		}
		int no_of_extra_days = n % 7;
		for (int i = 0; i < no_of_extra_days; i++) {
			res += ++no_of_full_weeks;
		}
		return res;
	}

}