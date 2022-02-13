public class MA_Three_Divisors {
	public static void main(String[] args) {
		System.out.println(isThree(10000));
	}

	public static boolean isThree(int n) {
		boolean flag = false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0 && !flag) {
				flag = true;
			} else if (flag && n % i == 0) {
				return false;
			}
		}
		if (flag) {
			return true;
		}
		return false;
	}
}
