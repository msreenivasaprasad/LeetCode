public class STR_Adding_Spaces_to_a_String {
	public static void main(String[] args) {
		int[] spaces = { 6, 15, 17 };
		System.out.println(addSpaces("IndianInstituteofTechnology", spaces));
	}

	public static String addSpaces(String s, int[] spaces) {
		char[] res = new char[s.length() + spaces.length];
		int p = 0;
		int t = 0;
		int k = 0;
		int temp = 0;
		while (t < res.length) {
			if (p < spaces.length && t == spaces[p] + temp) {
				p++;
				res[t++] = ' ';
				temp++;
			} else if (k < s.length()) {
				res[t++] = s.charAt(k++);
			}
		}
		return new String(res);
	}
}
