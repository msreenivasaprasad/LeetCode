import java.util.ArrayList;
import java.util.List;

public class STR_Check_if_Numbers_Are_Ascending_in_a_Sentence {
	public static void main(String[] args) {
		System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
	}

	public static boolean areNumbersAscending(String s) {
		char[] c = s.toCharArray();
		List<Integer> count = new ArrayList<Integer>();
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= '0' && c[i] <= '9') {
				if (i + 1 < c.length && c[i + 1] != ' ') {
					count.add(Integer.parseInt(s.substring(i, i + 2)));
					i++;
				} else {
					count.add(Integer.parseInt(s.substring(i, i + 1)));
				}
			}
		}
		for (int i = 1; i < count.size(); i++) {
			if (count.get(i) <= count.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

}
