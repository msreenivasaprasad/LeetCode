public class AR_Check_if_Every_Row_and_Column_Contains_All_Numbers {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
		System.out.println(checkValid(matrix));
	}

	public static boolean checkValid(int[][] matrix) {
		boolean[] count = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int c = 0; c < count.length; c++) {
				count[c] = false;
			}
			for (int j = 0; j < matrix[0].length; j++) {
				if (count[matrix[i][j] - 1]) {
					return false;
				}
				count[matrix[i][j] - 1] = true;
			}
		}
		for (int j = 0; j < matrix.length; j++) {
			for (int c = 0; c < count.length; c++) {
				count[c] = false;
			}
			for (int i = 0; i < matrix[0].length; i++) {
				if (count[matrix[i][j] - 1]) {
					return false;
				}
				count[matrix[i][j] - 1] = true;
			}
		}
		return true;
	}
}
