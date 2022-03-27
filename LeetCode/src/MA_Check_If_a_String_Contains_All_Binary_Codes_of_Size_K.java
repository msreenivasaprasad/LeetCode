public class MA_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
	public static void main(String[] args) {
		System.out.println(hasAllCodes("0110", 2));
	}

	public static boolean hasAllCodes(String s, int k) {
		char[] c = s.toCharArray();
		boolean[] count = new boolean[(int) Math.pow(2, k)];
		for (int i = 0; i <= s.length() - k; i++) {
			int t = toNum(c, i, i + k);
			if (t <= Math.pow(2, k) - 1) {
				count[t] = true;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (!count[i]) {
				return false;
			}
		}
		return true;
	}

	public static int toNum(char[] c, int i, int j) {
		int res = 0;
		for (int k = i; k < j; k++) {
			res += (c[k] - '0') * Math.pow(2, j - k - 1);
		}
		return res;
	}

}
