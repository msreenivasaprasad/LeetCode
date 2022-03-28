import java.util.ArrayList;
import java.util.List;

public class STR_Replace_Words {
	public static void main(String[] args) {
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("cat");
		dictionary.add("ca");
		dictionary.add("bat");
		dictionary.add("rat");
		System.out.println(replaceWords(dictionary, "the cattle was rattled by the bat"));
	}

	public static String replaceWords(List<String> dictionary, String sentence) {
		String[] words = sentence.split("\\s");
		for (int i = 0; i < words.length; i++) {
			String temp = new String();
			for (int j = 0; j < dictionary.size(); j++) {
				if (help(words[i], dictionary.get(j), 0, 0)) {
					if (temp.length() == 0) {
						temp = dictionary.get(j);
					} else if (temp.length() > dictionary.get(j).length()) {
						temp = dictionary.get(j);
					}
				}
			}
			if (temp.length() != 0) {
				words[i] = temp;
			}
		}
		String res = words[0];
		if (words.length == 1) {
			return res;
		}
		res += ' ';
		for (int i = 1; i < words.length - 1; i++) {
			res += words[i];
			res += ' ';
		}
		res += words[words.length - 1];
		return res;
	}

	public static boolean help(String word, String dict, int i, int j) {
		if (j == dict.length()) {
			return true;
		}
		if (i == word.length()) {
			return false;
		}
		if (j < dict.length() && i < word.length() && word.charAt(i) != dict.charAt(j)) {
			return false;
		}
		return help(word, dict, i + 1, j + 1);
	}

}
