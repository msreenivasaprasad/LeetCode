public class AR_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid {
	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		int[] res = executeInstructions(2, nums, "LURD");
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] executeInstructions(int n, int[] startPos, String s) {
		int[] res = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			res[i] = help(s.toCharArray(), n, i, startPos[0], startPos[1]);
		}
		return res;
	}

	public static int help(char[] c, int n, int index, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= n) {
			return -1;
		}
		if (index == c.length) {
			return 0;
		}
		if (c[index] == 'U') {
			return help(c, n, index + 1, i - 1, j) + 1;
		} else if (c[index] == 'D') {
			return help(c, n, index + 1, i + 1, j) + 1;
		} else if (c[index] == 'L') {
			return help(c, n, index + 1, i, j - 1) + 1;
		}
		return help(c, n, index + 1, i, j + 1) + 1;
	}
}