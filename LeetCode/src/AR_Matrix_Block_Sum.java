public class AR_Matrix_Block_Sum {
	public static void main(String[] args) {

	}

	public int[][] matrixBlockSum(int[][] mat, int k) {
		int[][] res = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				int count = 0;
				for (int p = i - k; p <= i + k; p++) {
					for (int q = j = k; q <= j + k; q++) {
						if ((p >= 0 && p < mat.length) && (q >= 0 && q < mat[0].length)) {
							count += mat[p][q];
						}
					}
				}
				res[i][j] = count;
			}
		}
		return res;
	}
}