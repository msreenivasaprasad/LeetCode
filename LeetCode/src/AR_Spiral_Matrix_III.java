public class AR_Spiral_Matrix_III {
	public static void main(String[] args) {
		int[][] res = spiralMatrixIII(1, 1, 0, 0);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}

	public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int[][] res = new int[rows * cols][2];
		int k = 0;
		int radius = 3;
		int i = rStart;
		int j = cStart;
		if (i < rows && j < cols && k < res.length) {
			res[k][0] = i;
			res[k++][1] = j;
		}
		while (k < res.length) {
			j++;
			for (int t = i; t <= i + radius - 2; t++) {
				if (t >= 0 && j >= 0 && t < rows && j < cols && k < res.length) {
					res[k][0] = t;
					res[k++][1] = j;
				}
			}
			i = i + radius - 2;
			for (int t = j - 1; t >= j - radius + 1; t--) {
				if (t >= 0 && i >= 0 && t < cols && i < rows && k < res.length) {
					res[k][0] = i;
					res[k++][1] = t;
				}
			}
			j = j - radius + 1;
			for (int t = i - 1; t >= i - radius + 1; t--) {
				if (t >= 0 && j >= 0 && t < rows && j < cols && k < res.length) {
					res[k][0] = t;
					res[k++][1] = j;
				}
			}
			i = i - radius + 1;
			for (int t = j + 1; t <= j + radius - 1; t++) {
				if (t >= 0 && i >= 0 && t < cols && i < rows && k < res.length) {
					res[k][0] = i;
					res[k++][1] = t;
				}
			}
			j = j + radius - 1;
			radius += 2;
		}
		return res;
	}
}