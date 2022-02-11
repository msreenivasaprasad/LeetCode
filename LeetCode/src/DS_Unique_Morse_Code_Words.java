import java.util.HashSet;
import java.util.Set;

public class DS_Unique_Morse_Code_Words {
	public static void main(String[] args) {
		String[] words = { "gin", "zen", "gig", "msg" };
		System.out.println(uniqueMorseRepresentations(words));
	}

	public static int uniqueMorseRepresentations(String[] words) {
		String[] data = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		Set<String> count = new HashSet<String>();
		for (int i = 0; i < words.length; i++) {
			String morse = new String();
			char[] c = words[i].toCharArray();
			for (int j = 0; j < c.length; j++) {
				morse += data[c[j] - 'a'];
			}
			count.add(morse);
		}

		return count.size();
	}
}
