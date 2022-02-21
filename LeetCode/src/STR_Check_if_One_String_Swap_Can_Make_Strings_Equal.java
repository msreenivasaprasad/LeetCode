public class STR_Check_if_One_String_Swap_Can_Make_Strings_Equal {
	public static void main(String[] args) {
		System.out.println(areAlmostEqual("bank", "kanb"));
	}

	public static boolean areAlmostEqual(String s1, String s2) {

		if (s1.equals(s2)) {
			return true;
		}
		if (!maxtwodiff(s1, s2)) {
			return false;
		}
		char[] notequals1 = new char[2];
		char[] notequals2 = new char[2];
		int t = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				notequals1[t] = s1.charAt(i);
				notequals2[t++] = s2.charAt(i);

			}
		}
		return (notequals1[0] == notequals2[1]) && (notequals1[1] == notequals2[0]);
	}

	public static boolean maxtwodiff(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
			if (count > 2) {
				return false;
			}
		}
		return true;
	}
}
