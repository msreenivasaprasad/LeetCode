public class AR_Two_Furthest_Houses_With_Different_Colors {
	public static void main(String[] args) {
		int[] colors = { 0, 1 };
		System.out.println(maxDistance(colors));
	}

	public static int maxDistance(int[] colors) {
		int max = 0;
		for (int i = 0; i < colors.length; i++) {
			for (int j = colors.length - 1; j >= i; j--) {
				if (colors[j] != colors[i]) {
					if (j - i > max) {
						max = j - i;
						break;
					}
				}
			}
		}
		return max;
	}
}
