
import java.util.HashMap;
import java.util.Map;

public class DS_Roman_to_Integer {
	public static void main(String[] args) {
		System.out.println(romanToInt("LVIII"));
	}

	public static int romanToInt(String s) {

		Map<Character, Integer> data = new HashMap<Character, Integer>();
		data.put('I', 1);
		data.put('V', 5);
		data.put('X', 10);
		data.put('L', 50);
		data.put('C', 100);
		data.put('D', 500);
		data.put('M', 1000);
		char[] c = s.toCharArray();
		int res = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'I' && i + 1 < c.length && c[i + 1] == 'V') {
				res += 4;
				i++;
			} else if (c[i] == 'I' && i + 1 < c.length && c[i + 1] == 'X') {
				res += 9;
				i++;
			} else if (c[i] == 'X' && i + 1 < c.length && c[i + 1] == 'L') {
				res += 40;
				i++;
			} else if (c[i] == 'X' && i + 1 < c.length && c[i + 1] == 'C') {
				res += 90;
				i++;
			} else if (c[i] == 'C' && i + 1 < c.length && c[i + 1] == 'D') {
				res += 400;
				i++;
			} else if (c[i] == 'C' && i + 1 < c.length && c[i + 1] == 'M') {
				res += 900;
				i++;
			} else {
				res += data.get(c[i]);
			}
		}
		return res;
	}
}
