public class MA_Next_Greater_Numerically_Balanced_Number {
	public static void main(String[] args) {
		System.out.println(nextBeautifulNumber(748601));
	}

	public static int nextBeautifulNumber(int n) {
		for (int i = n + 1; i <= Integer.MAX_VALUE; i++) {
			if (isOK(i)) {
				return i;
			}
		}
		return 0;
	}

	public static boolean isOK(int n) {
		int[] count = new int[10];
		while (n > 0) {
			count[n % 10]++;
			n = n / 10;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0 && i != count[i]) {
				return false;
			}
		}
		return true;
	}

}