import java.util.ArrayList;
import java.util.List;

public class STR_Text_Justification {
	public static void main(String[] args) {
		String[] words = { "ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you",
				"can", "do", "for", "your", "country" };
		System.out.println(fullJustify(words, 16));
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		int i = 0;
		List<String> result = new ArrayList<String>();
		while (i < words.length) {
			int length = 0;
			int j = i;
			while (j < words.length && length <= maxWidth) {
				if (j != i) {
					length++;
				}
				length += words[j].length();
				j++;
			}
			if (j == words.length && length <= maxWidth) {
				result.add(leftJustify(words, i, maxWidth));
			} else {
				j--;
				length -= words[j].length();
				j--;
				length--;
				result.add(centerJustify(words, i, j, maxWidth));
			}
			i = j + 1;
		}
		return result;
	}

	public static String leftJustify(String[] words, int i, int maxLength) {
		String res = new String();
		for (int k = i; k < words.length; k++) {
			res += words[k];
			if (k < words.length - 1) {
				res += " ";
			}
		}
		while (res.length() < maxLength) {
			res += " ";
		}
		return res;
	}

	public static String centerJustify(String[] words, int i, int j, int maxLength) {
		String res = new String();
		if (j == i) {
			res += words[i];
			for (int k = 0; k < maxLength - words[i].length(); k++) {
				res += " ";
			}
			return res;
		}
		int length = 0;
		for (int k = i; k <= j; k++) {
			length += words[k].length();
		}
		int spaces = maxLength - length;
		int spaceafterword = spaces / (j - i);
		int extraSpaces = spaces - (spaceafterword * (j - i));
		for (int k = i; k <= j; k++) {
			res += words[k];
			if (k != j) {
				for (int s = 0; s < spaceafterword; s++) {
					res += " ";
				}
			}
			if (extraSpaces > 0) {
				res += " ";
				extraSpaces--;
			}
		}
		return res;
	}
}
