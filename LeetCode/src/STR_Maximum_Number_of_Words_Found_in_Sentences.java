public class STR_Maximum_Number_of_Words_Found_in_Sentences {
	public static void main(String[] args) {
		String []sentences= {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
		System.out.println(mostWordsFound(sentences));
	}

	public static int mostWordsFound(String[] sentences) {
		int max = 0;
		for (int i = 0; i < sentences.length; i++) {
			int t = sentences[i].split("\\W+").length;
			max = Integer.max(t, max);
		}
		return max;
	}
}
