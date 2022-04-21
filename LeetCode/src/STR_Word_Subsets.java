import java.util.ArrayList;
import java.util.List;

public class STR_Word_Subsets {
	public static void main(String[] args) {
		String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] words2 = { "e", "l" };
		System.out.println(wordSubsets(words1, words2));
	}

	public static List<String> wordSubsets(String[] words1, String[] words2) {
		int[][] count1 = new int[words1.length][26];
		int[][] count2 = new int[words2.length][26];
		for (int i = 0; i < words1.length; i++) {
			for (int j = 0; j < words1[i].length(); j++) {
				count1[i][words1[i].charAt(j) - 'a']++;
			}
		}
		for (int i = 0; i < words2.length; i++) {
			for (int j = 0; j < words2[i].length(); j++) {
				count2[i][words2[i].charAt(j) - 'a']++;
			}
		}
		int[] scount = new int[26];
		for (int i = 0; i < scount.length; i++) {
			int max = 0;
			for (int j = 0; j < count2.length; j++) {
				max = Integer.max(max, count2[j][i]);
			}
			scount[i] = max;
		}
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < words1.length; i++) {
			if (isUniversal(scount, count1[i])) {
				res.add(words1[i]);
			}
		}
		return res;

	}

	public static boolean isUniversal(int[] count, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < count[i]) {
				return false;
			}
		}
		return true;
	}
}
