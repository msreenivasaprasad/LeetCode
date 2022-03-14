public class STR_Minimum_Swaps_to_Make_Strings_Equal {
	public static void main(String[] args) {
		System.out.println(minimumSwap("xxxx", "xxyy"));
	}

	public static int minimumSwap(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int xy = 0;
		int yx = 0;
		int res = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (c1[i] == 'x' && c2[i] == 'y') {
				xy++;
			} else if (c1[i] == 'y' && c2[i] == 'x') {
				yx++;
			}
		}
		res += xy / 2;
		res += yx / 2;
		if ((xy % 2 == 0 && yx % 2 != 0) || (yx % 2 == 0 && xy % 2 != 0)) {
			return -1;
		}
		if (xy % 2 != 0) {
			return res + 2;
		}
		return res;
	}
}