public class STR_Minimum_Moves_to_Convert_String {
	public static void main(String[] args) {
		System.out.println(minimumMoves("OXOX"));
	}

	public static int minimumMoves(String s) {
		char[] c = s.toCharArray();
		int res = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'X') {
				res++;
				i += 2;
			}
		}
		return res;
	}

}
