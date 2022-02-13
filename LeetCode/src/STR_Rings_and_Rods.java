public class STR_Rings_and_Rods {
	public static void main(String[] args) {
		System.out.println(countPoints("B0B6G0R6R0R6G9"));
	}

	public static int countPoints(String rings) {
		char[] c = rings.toCharArray();
		boolean[] red = new boolean[10];
		boolean[] green = new boolean[10];
		boolean[] blue = new boolean[10];

		for (int i = 0; i < c.length; i = i + 2) {
			if (c[i] == 'R') {
				red[Integer.parseInt(Character.toString(c[i + 1]))] = true;
			}
			if (c[i] == 'G') {
				green[Integer.parseInt(Character.toString(c[i + 1]))] = true;
			}
			if (c[i] == 'B') {
				blue[Integer.parseInt(Character.toString(c[i + 1]))] = true;
			}
		}
		int count = 0;
		for (int i = 0; i < red.length; i++) {
			if (red[i] & green[i] && blue[i]) {
				count++;
			}
		}
		return count;
	}
}
