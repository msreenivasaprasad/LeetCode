public class DP_Longest_Increasing_Path_in_a_Matrix {
	public static void main(String[] args) {
		int[][] edges = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(longestIncreasingPath(edges));

	}

	public static int longestIncreasingPath(int[][] matrix) {
		int res = 0;
		dynvisited = new boolean[matrix.length][matrix[0].length];
		dyn = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				res = Integer.max(res, help(matrix, i, j, -1));
			}
		}
		return res;
	}

	static boolean[][] dynvisited;
	static int[][] dyn;

	public static int help(int[][] matrix, int i, int j, int prev) {

		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return -1;
		}
		if (matrix[i][j] <= prev) {
			return -1;
		}
		if (dynvisited[i][j]) {
			return dyn[i][j];
		}
		int t = 0;
		int a = help(matrix, i - 1, j, matrix[i][j]);
		if (a != -1) {
			t = Integer.max(t, a);
		}
		a = help(matrix, i + 1, j, matrix[i][j]);
		if (a != -1) {
			t = Integer.max(t, a);
		}
		a = help(matrix, i, j - 1, matrix[i][j]);
		if (a != -1) {
			t = Integer.max(t, a);
		}
		a = help(matrix, i, j + 1, matrix[i][j]);
		if (a != -1) {
			t = Integer.max(t, a);
		}
		dynvisited[i][j] = true;
		dyn[i][j] = t + 1;
		return t + 1;
	}
}
