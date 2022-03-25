public class GR_Minimum_Falling_Path_Sum {
	public static void main(String[] args) {
		int[][] matrix = { { -19, 57 }, { -40, -5 } };
		System.out.println(minFallingPathSum(matrix));
	}

	public static int minFallingPathSum(int[][] matrix) {
		int min = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int[][] dyn = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			min = Integer.min(min, help(matrix, 0, i, visited, dyn));
		}
		return min;
	}

	public static int help(int[][] matrix, int i, int j, boolean[][] visited, int[][] dyn) {
		if (i == matrix.length) {
			return 0;
		}
		if (visited[i][j]) {
			return dyn[i][j];
		}
		visited[i][j] = true;
		int b = Integer.MAX_VALUE;
		if (j + 1 < matrix[0].length) {
			b = help(matrix, i + 1, j + 1, visited, dyn);
		}
		int c = Integer.MAX_VALUE;
		if (j - 1 >= 0) {
			c = help(matrix, i + 1, j - 1, visited, dyn);
		}
		int a = help(matrix, i + 1, j, visited, dyn);
		dyn[i][j] = Integer.min(a, Integer.min(b, c)) + matrix[i][j];
		return dyn[i][j];

	}
}
