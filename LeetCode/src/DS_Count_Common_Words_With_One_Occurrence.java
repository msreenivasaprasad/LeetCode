import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DS_Count_Common_Words_With_One_Occurrence {
	public static void main(String[] args) {
		String[] words1 = { "leetcode", "is", "amazing", "as", "is" };
		String[] words2 = { "amazing", "leetcode", "is" };
		System.out.println(countWords(words1, words2));

	}

	public static int countWords(String[] words1, String[] words2) {
		Map<String, Integer> count1 = new HashMap<String, Integer>();
		for (int i = 0; i < words1.length; i++) {
			if (!count1.containsKey(words1[i])) {
				count1.put(words1[i], 1);
			} else {
				count1.replace(words1[i], count1.get(words1[i]) + 1);
			}
		}
		Map<String, Integer> count2 = new HashMap<String, Integer>();
		for (int i = 0; i < words2.length; i++) {
			if (!count2.containsKey(words2[i])) {
				count2.put(words2[i], 1);
			} else {
				count2.replace(words2[i], count2.get(words2[i]) + 1);
			}
		}
		Set<String> s1 = count1.keySet();
		Iterator<String> i1 = s1.iterator();
		Set<String> uniq1 = new HashSet<String>();
		Set<String> uniq2 = new HashSet<String>();
		while (i1.hasNext()) {
			String t = i1.next();
			if (count1.get(t) == 1) {
				uniq1.add(t);
			}
		}
		Set<String> s2 = count2.keySet();
		Iterator<String> i2 = s2.iterator();
		while (i2.hasNext()) {
			String t = i2.next();
			if (count2.get(t) == 1) {
				uniq2.add(t);
			}
		}
		int count = 0;
		Iterator<String> i = uniq1.iterator();
		while (i.hasNext()) {
			String s = i.next();
			if (uniq2.contains(s)) {
				count++;
			}
		}
		return count;
	}
}
