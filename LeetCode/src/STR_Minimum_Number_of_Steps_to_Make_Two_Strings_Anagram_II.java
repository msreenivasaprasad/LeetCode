public class STR_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram_II {
	public static void main(String[] args) {
		System.out.println(minSteps("leetcode", "coats"));
	}

	public static int minSteps(String s, String t) {
		int[] count1 = new int[26];
		int[] count2 = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count1[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			count2[t.charAt(i) - 'a']++;
		}
		int res = 0;
		for (int i = 0; i < count1.length; i++) {
			res += Math.abs(count1[i] - count2[i]);
		}
		return res;
	}

}