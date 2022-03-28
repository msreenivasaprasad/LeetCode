public class STR_Maximum_Number_of_Words_You_Can_Type {
	public static void main(String[] args) {
	}

	public int canBeTypedWords(String text, String brokenLetters) {
		boolean[] counter = new boolean[26];
		for (int i = 0; i < brokenLetters.length(); i++) {
			counter[brokenLetters.charAt(i) - 'a'] = true;
		}
		String[] words = text.split("\\s");
		int res = 0;
		for (int i = 0; i < words.length; i++) {
			boolean flag = false;
			for (int j = 0; j < words[i].length(); j++) {
				if (counter[words[i].charAt(j) - 'a']) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				res++;
			}
		}
		return res;
	}
}
