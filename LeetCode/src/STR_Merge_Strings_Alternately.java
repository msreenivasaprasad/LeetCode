public class STR_Merge_Strings_Alternately {
	public static void main(String[] args) {

	}

	public String mergeAlternately(String word1, String word2) {
		char[] c = new char[word1.length() + word2.length()];
		int i = 0, j = 0, k = 0;
		while (i < word1.length() && j < word2.length()) {
			c[k++] = word1.charAt(i++);
			c[k++] = word2.charAt(j++);
		}
		while (i < word1.length()) {
			c[k++] = word1.charAt(i++);
		}
		while (j < word2.length()) {
			c[k++] = word2.charAt(j++);
		}
		return new String(c);
	}
}