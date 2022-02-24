public class MA_Factorial_Trailing_Zeroes {
	public static void main(String[] args) {
		System.out.println(trailingZeroes(10000));
	}

	public static int trailingZeroes(int n) {
		int twos = 0;
		int fives = 0;
		for (int i = 1; i <= n; i++) {
			twos += two(i);
			fives += five(i);
		}
		return Integer.min(twos, fives);
	}

	public static int two(int n) {
		int res = 0;
		while (n % 2 == 0) {
			res++;
			n = n / 2;
		}
		return res;
	}

	public static int five(int n) {
		int res = 0;
		while (n % 5 == 0) {
			n = n / 5;
			res++;
		}
		return res;
	}
}
