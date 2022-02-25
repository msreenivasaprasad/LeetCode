public class STR_Redistribute_Characters_to_Make_All_Strings_Equal {
	public static void main(String[] args) {
		String[] words = {};
		System.out.println(makeEqual(words));

	}

	public static boolean makeEqual(String[] words) {
		int[] count = new int[26];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				count[words[i].charAt(j) - 'a']++;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] % words.length != 0) {
				return false;
			}
		}
		return true;
	}
}
