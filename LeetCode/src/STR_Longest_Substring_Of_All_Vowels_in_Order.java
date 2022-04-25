import java.util.ArrayList;
import java.util.List;

public class STR_Longest_Substring_Of_All_Vowels_in_Order {
	public static void main(String[] args) {
		System.out.println(longestBeautifulSubstring("aieou"));

	}

	public static int longestBeautifulSubstring(String word) {
		char[] c = word.toCharArray();
		int start = 0;
		int max = 0;
		List<Character> vowels = new ArrayList<Character>();
		List<Integer> count = new ArrayList<Integer>();
		while (start < word.length()) {
			int t = findLength(c, start);
			vowels.add(c[start]);
			count.add(t - start);
			start = t;
		}

		for (int j = 0; j + 4 < vowels.size(); j++) {
			if (isOk(vowels, j)) {
				int sum = 0;
				for (int i = j; i <= j + 4; i++) {
					sum += count.get(i);
				}
				max = Integer.max(max, sum);
			}
		}
		return max;
	}

	public static boolean isOk(List<Character> vowels, int start) {
		return (vowels.get(start) == 'a' && vowels.get(start + 1) == 'e' && vowels.get(start + 2) == 'i'
				&& vowels.get(start + 3) == 'o' && vowels.get(start + 4) == 'u');
	}

	static int end;

	public static int findLength(char[] c, int index) {
		int i = index;
		while (i < c.length && c[i] == c[index]) {
			i++;
		}
		return i;
	}
}
