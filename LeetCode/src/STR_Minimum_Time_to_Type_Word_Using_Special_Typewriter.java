public class STR_Minimum_Time_to_Type_Word_Using_Special_Typewriter {
	public static void main(String[] args) {
		System.out.println(minTimeToType("zjpc"));
	}

	public static int minTimeToType(String word) {
		int point = 'a';
		int res = 0;
		for (int i = 0; i < word.length(); i++) {
			res += Integer.min(26 - Math.abs(point - word.charAt(i)), Math.abs(point - word.charAt(i)));
			res++;
			point = word.charAt(i);
		}
		return res;
	}
}
