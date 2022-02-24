import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class STR_Longest_Palindrome_by_Concatenating_Two_Letter_Words {
	public static void main(String[] args) {
		String[] words = { "aa", "ty", "yt", "lc", "cl", "aa", "bb", "aa" };
		System.out.println(longestPalindrome(words));
	}

	public static int longestPalindrome(String[] words) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		Set<String> uniq = new HashSet<String>();
		for (int i = 0; i < words.length; i++) {
			if (count.containsKey(words[i])) {
				count.replace(words[i], count.get(words[i]) + 1);
			} else {
				uniq.add(words[i]);
				count.put(words[i], 1);
			}
		}
		boolean flag = false;
		int res = 0;
		Iterator<String> i = uniq.iterator();
		while (i.hasNext()) {
			String temp = i.next();
			if (!ispal(temp) && count.containsKey(rev(temp))) {
				res += 2 * Integer.min(count.get(temp), count.get(rev(temp)));
			} else if (ispal(temp) && count.get(temp) > 1) {
				res += (count.get(temp) / 2) * 4;
				count.replace(temp, count.get(temp) - (count.get(temp) / 2) * 2);
			}
			if (ispal(temp) && count.get(temp) == 1 && !flag) {
				res += 2;
				flag = true;
			}
		}
		return res;
	}

	public static boolean ispal(String s) {
		return s.equals(rev(s));
	}

	public static String rev(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
}
