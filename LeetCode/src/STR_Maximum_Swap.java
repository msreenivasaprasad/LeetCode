public class STR_Maximum_Swap {
	public static void main(String[] args) {
		System.out.println(maximumSwap(10));

	}

	public static int maximumSwap(int num) {
		String s = Integer.toString(num);
		char[] c = s.toCharArray();
		String maxa = new String();
		for (int i = 0; i < c.length; i++) {
			for (int j = i + 1; j < c.length; j++) {
				char temp = c[i];
				c[i] = c[j];
				c[j] = temp;
				maxa = max(maxa, new String(c));
				temp = c[i];
				c[i] = c[j];
				c[j] = temp;
			}
		}

		return Integer.parseInt(max(maxa, s));
	}

	public static String help(char[] c, int index) {
		String max = new String();
		if (index >= c.length) {
			return c.toString();
		}
		for (int i = index + 1; i < c.length; i++) {
			char temp = c[i];
			c[i] = c[index];
			c[index] = temp;
			max = max(max, c.toString());
			temp = c[i];
			c[i] = c[index];
			c[index] = temp;
		}
		max = max(max, help(c, index + 1));
		return max;

	}

	public static String max(String a, String b) {
		if (a.length() == 0) {
			return b;
		}
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) > b.charAt(i)) {
				return a;
			} else if (a.charAt(i) < b.charAt(i)) {
				return b;
			}
		}
		return b;
	}
}
