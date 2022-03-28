import java.util.ArrayList;
import java.util.List;

public class STR_Print_Words_Vertically {
	public static void main(String[] args) {
		System.out.println(printVertically("CONTEST IS COMING"));
	}

	public static List<String> printVertically(String s) {
		String[] words = s.split("\\s");
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			max = Integer.max(max, words[i].length());
		}
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < max; i++) {
			String temp = new String();
			for (int j = 0; j < words.length; j++) {
				if (words[j].length() >= i + 1) {
					temp += words[j].charAt(i);
				} else {
					temp += ' ';
				}
			}
			int k = temp.length() - 1;
			while (k >= 0 && temp.charAt(k) == ' ') {
				k--;
			}
			res.add(new String(temp.substring(0, k + 1)));

		}
		return res;
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
