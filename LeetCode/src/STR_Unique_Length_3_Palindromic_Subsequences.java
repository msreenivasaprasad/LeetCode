public class STR_Unique_Length_3_Palindromic_Subsequences {
	public static void main(String[] args) {
		System.out.println(countPalindromicSubsequence("aabca"));
	}

	public static int countPalindromicSubsequence(String s) {
		boolean[][] isCounted = new boolean[26][26];
		boolean[][] leftCount = new boolean[s.length()][26];
		boolean[][] rightCount = new boolean[s.length()][26];
		boolean[] counter = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			copyCounter(leftCount[i], counter);
			counter[s.charAt(i) - 'a'] = true;
		}
		for (int i = 0; i < counter.length; i++) {
			counter[i] = false;
		}

		for (int i = s.length() - 1; i >= 0; i--) {
			copyCounter(rightCount[i], counter);
			counter[s.charAt(i) - 'a'] = true;
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (leftCount[i][j] && rightCount[i][j] && !isCounted[s.charAt(i) - 'a'][j]) {
					res++;
					isCounted[s.charAt(i) - 'a'][j] = true;
				}
			}
		}
		return res;
	}

	public static void copyCounter(boolean[] arr, boolean[] counter) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = counter[i];
		}
	}
}
