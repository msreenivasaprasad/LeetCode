import java.util.HashMap;
import java.util.Map;

public class STR_Longest_Word_in_Dictionary {
	public static void main(String[] args) {
		String[] words = { "w", "wo", "wor", "worl", "world" };
		System.out.println(longestWord(words));
	}

	public static String longestWord(String[] words) {
		String res = "";
		dyn = new HashMap<Integer, String>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() == 1) {
				String t = help(i, words);
				if (t.length() > res.length()) {
					res = new String(t);
				} else if (t.length() == res.length()) {
					res = findSmallest(res, t);
				}
			}
		}
		return res;
	}

	static Map<Integer, String> dyn;

	public static String help(int index, String[] words) {
		if (dyn.containsKey(index)) {
			return dyn.get(index);
		}
		String res = Character.toString(words[index].charAt(words[index].length() - 1));
		for (int i = 0; i < words.length; i++) {
			if (isNext(words[index], words[i])) {
				String s = words[index].charAt(words[index].length() - 1) + help(i, words);
				if (s.length() > res.length()) {
					res = s;
				} else if (s.length() == res.length()) {
					res = findSmallest(res, s);
				}
			}
		}
		dyn.put(index, res);
		return res;
	}

	public static String findSmallest(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) < b.charAt(i)) {
				return a;
			} else if (a.charAt(i) > b.charAt(i)) {
				return b;
			}
		}
		return a;
	}

	public static boolean isNext(String a, String b) {
		if (b.length() != a.length() + 1) {
			return false;
		}
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}