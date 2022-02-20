public class STR_Reverse_Prefix_of_Word {
	public static void main(String[] args) {
		System.out.println(reversePrefix("Hello", 'l'));
	}

	public static String reversePrefix(String word, char ch) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch) {
				StringBuilder sb = new StringBuilder(word.substring(0, i + 1));
				return sb.reverse().toString() + word.substring(i + 1);
			}
		}
		return word;
	}
}
