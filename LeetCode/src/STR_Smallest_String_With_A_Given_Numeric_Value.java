public class STR_Smallest_String_With_A_Given_Numeric_Value {
	public static void main(String[] args) {

		System.out.println(getSmallestString(96014, 2095650));
	}

	public static String getSmallestString(int n, int k) {

		char[] res = new char[n];
		int j = 0;
		for (int i = 0; i < n; i++) {
			int rem = n - 1 - i;
			// System.out.println(rem * 26);
			if (k <= rem * 26) {
				res[j++] = 'a';
				k--;
			} else {
				int t = k - (rem * ('z' - 'a' + 1));
				res[j++] = (char) (t + 'a' - 1);
				k -= t;
			}
		}
//		for (int i = 0; i < res.length; i++) {
//			System.out.println(res[i]);
//		}
		return new String(res);
	}
}
