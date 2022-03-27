package Standard;

public class Sum_of_all_sub_arrays {
	public static void main(String[] args) {
		System.out.println(countVowels("aa"));
	}

	public static long countVowels(String word) {
		long res = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u') {
				res += (word.length() - i) * (i + 1);
			}
		}
		return res;
	}

}