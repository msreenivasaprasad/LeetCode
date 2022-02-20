public class STR_Construct_String_With_Repeat_Limit {
	public static void main(String[] args) {
		System.out.println(repeatLimitedString("aababab", 2));
	}

	public static String repeatLimitedString(String s, int repeatLimit) {
		char[] c = s.toCharArray();
		int[] count = new int[26];
		for (int i = 0; i < c.length; i++) {
			count[c[i] - 'a']++;
		}
		char[] result = new char[s.length()];
		String res = new String();
		int rem = repeatLimit;
		int t = 0;
		for (int j = count.length - 1; j >= 0 && t < result.length; j--) {
			rem = repeatLimit;
			while (count[j] > 0 && t < result.length) {
				if (rem > 0) {
					result[t++] = (char) (j + 'a');
					rem--;
					count[j]--;
				} else {
					if (!isthere(j, count)) {

						return new String(result).substring(0, t);
					}
					help(count, result, t, j, res);
					t++;

					rem = repeatLimit;
				}
			}
		}
		return new String(result);
	}

	public static boolean isthere(int index, int[] count) {
		for (int i = index - 1; i >= 0; i--) {
			if (count[i] > 0) {
				return true;
			}
		}
		return false;
	}

	public static void help(int[] count, char[] result, int t, int current, String res) {
		for (int i = current - 1; i >= 0; i--) {
			if (count[i] > 0) {
				count[i]--;
				result[t] = (char) (i + 'a');
				return;
			}
		}
		return;
	}
}
