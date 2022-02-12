public class STR_Check_if_All_Characters_Have_Equal_Number_of_Occurrences {
	public static void main(String[] args) {
		System.out.println(areOccurrencesEqual("aaabb"));
	}

	public static boolean areOccurrencesEqual(String s) {
		int[] count = new int[26];
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			count[c[i] - 'a']++;
		}
		int freq = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0 && freq == 0) {
				freq = count[i];
			}
			if (count[i] != 0 && freq != 0 && freq != count[i]) {
				return false;
			}
		}
		return true;
	}
}
