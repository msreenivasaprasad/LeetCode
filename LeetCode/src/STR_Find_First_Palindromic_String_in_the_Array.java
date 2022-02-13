public class STR_Find_First_Palindromic_String_in_the_Array {
	public static void main(String[] args) {
		String[] words = { "abc", "car", "ada", "racecar", "cool" };
		System.out.println(firstPalindrome(words));
	}

	public static String firstPalindrome(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (isPalindrome(words[i])) {
				return words[i];
			}
		}
		return "";
	}

	public static boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < (c.length) / 2; i++) {
			if (c[i] != c[c.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}
