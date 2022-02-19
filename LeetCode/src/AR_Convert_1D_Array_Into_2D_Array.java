public class AR_Convert_1D_Array_Into_2D_Array {
	public static void main(String[] args) {
		int[] original = { 1, 2 };
		System.out.println(construct2DArray(original, 1, 1));
	}

	public static int[][] construct2DArray(int[] original, int m, int n) {
		int[][] res = new int[m][n];
		if (original.length > (m * n)) {
			int[][] resu = new int[0][0];
			return resu;
		}
		int j = 0, k = 0;
		for (int i = 0; i < original.length; i++) {
			if (k < n) {
				res[j][k++] = original[i];
			} else {
				k = 0;
				j++;
				i--;
			}

		}
		return res;
	}

}
