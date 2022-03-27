import java.util.ArrayList;
import java.util.List;

public class STR_Camelcase_Matching {
	public static void main(String[] args) {
		String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		System.out.println(camelMatch(queries, "FoBa"));
	}

	public static List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> res = new ArrayList<Boolean>();
		for (int i = 0; i < queries.length; i++) {
			res.add(help(queries[i].toCharArray(), pattern.toCharArray(), 0, 0));
		}
		return res;
	}

	public static boolean help(char[] word, char[] pattern, int i, int j) {
		if (i == word.length) {
			return j == pattern.length;
		}
		if (word[i] >= 'A' && word[i] <= 'Z') {
			if (j >= pattern.length || pattern[j] != word[i]) {
				return false;
			}
			return help(word, pattern, i + 1, j + 1);
		} else if (j < pattern.length && word[i] == pattern[j]) {
			return help(word, pattern, i + 1, j + 1);
		}
		return help(word, pattern, i + 1, j);
	}
}
