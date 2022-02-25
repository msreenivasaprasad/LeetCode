public class MA_Count_Integers_With_Even_Digit_Sum {
	public static void main(String[] args) {
		System.out.println(countEven(10));

	}

	public static int countEven(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (digitSum(i) % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	public static int digitSum(int n) {
		int res = 0;
		while (n > 0) {
			res += n % 10;
			n /= 10;
		}
		return res;
	}
}
