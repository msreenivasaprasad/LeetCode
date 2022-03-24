public class STR_Find_Unique_Binary_String {
	public static void main(String[] args) {
		String[] nums = { "00", "01" };
		System.out.println(findDifferentBinaryString(nums));
	}

	public static String findDifferentBinaryString(String[] nums) {
		int n = nums[0].length();
		boolean[] count = new boolean[(int) Math.pow(2, n)];
		for (int i = 0; i < nums.length; i++) {
			count[toNum(nums[i])] = true;
		}
		String res = new String();
		for (int i = 0; i < count.length; i++) {
			if (!count[i]) {
				res = toBin(i);
				break;
			}
		}
		while (res.length() != n) {
			res = '0' + res;
		}
		return res;
	}

	public static String toBin(int n) {
		String res = new String();
		while (n > 0) {
			if (n % 2 == 0) {
				res = '0' + res;
			} else {
				res = '1' + res;
			}
			n = n / 2;
		}
		return res;
	}

	public static int toNum(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += (s.charAt(i) - '0') * Math.pow(2, s.length() - 1 - i);
		}
		return res;
	}

}
