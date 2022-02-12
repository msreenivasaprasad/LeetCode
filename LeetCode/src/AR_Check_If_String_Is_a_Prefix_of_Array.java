public class AR_Check_If_String_Is_a_Prefix_of_Array {
	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "apples" };
		System.out.println(isPrefixString("iloveleetcode", words));
	}

	public static boolean isPrefixString(String s, String[] words) {
		String prefix = new String();
		int i = 0;
		while (i < words.length && prefix.length() < s.length()) {
			prefix += words[i++];
		}
		if (prefix.length() < s.length()) {
			return false;
		}
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) != prefix.charAt(j)) {
				return false;
			}
		}
		int len = 0;
		for (int j = 0; j < words.length; j++) {
			len += words[j].length();
			if (len == s.length()) {
				return true;
			}
			if (len > s.length()) {
				return false;
			}
		}
		return true;
	}
}
