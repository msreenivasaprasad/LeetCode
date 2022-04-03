public class SW_Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating {
	public static void main(String[] args) {
		System.out.println(minFlips("1110"));
	}

	public static int minFlips(String s) {
		char[] c = new char[s.length() * 2];
		for (int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(i);
		}
		for (int j = s.length(); j < c.length; j++) {
			c[j] = s.charAt(j - s.length());
		}
		int diff1 = 0;
		int diff2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0 && c[i] == '1') {
				diff1++;
			}

			if (i % 2 == 0 && c[i] == '0') {
				diff2++;
			}
			if (i % 2 != 0 && c[i] == '0') {
				diff1++;
			}
			if (i % 2 != 0 && c[i] == '1') {
				diff2++;
			}
		}
		int res = Integer.MAX_VALUE;
		for (int j = s.length(); j < c.length; j++) {
			int t = j - s.length();
			if (t % 2 == 0 && c[t] == '1') {
				diff1--;
			}

			if (t % 2 == 0 && c[t] == '0') {
				diff2--;
			}
			if (t % 2 != 0 && c[t] == '0') {
				diff1--;
			}
			if (t % 2 != 0 && c[t] == '1') {
				diff2--;
			}
			if (j % 2 == 0 && c[j] == '1') {
				diff1++;
			}

			if (j % 2 == 0 && c[j] == '0') {
				diff2++;
			}
			if (j % 2 != 0 && c[j] == '0') {
				diff1++;
			}
			if (j % 2 != 0 && c[j] == '1') {
				diff2++;
			}
			res = Integer.min(res, Integer.min(diff1, diff2));
		}
		return res;
	}
}
