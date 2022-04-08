public class DP_Knight_Probability_in_Chessboard {
	public static void main(String[] args) {
		System.out.println(knightProbability(8, 30, 6, 4));
	}

	public static double knightProbability(int n, int k, int row, int column) {
		dyn = new double[n][n][k];
		visited = new boolean[n][n][k];
		return help(row, column, k, n);

	}

	static double[][][] dyn;
	static boolean[][][] visited;

	public static double help(int i, int j, int k, int n) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return 0;
		}
		if (k == 0) {
			return 1;
		}
		if (visited[i][j][k - 1]) {
			return dyn[i][j][k - 1];
		}
		double res = 0;
		res += help(i - 2, j + 1, k - 1, n);
		res += help(i - 1, j + 2, k - 1, n);
		res += help(i + 1, j + 2, k - 1, n);
		res += help(i + 2, j + 1, k - 1, n);
		res += help(i - 1, j - 2, k - 1, n);
		res += help(i - 2, j - 1, k - 1, n);
		res += help(i + 1, j - 2, k - 1, n);
		res += help(i + 2, j - 1, k - 1, n);
		double r = res / (double) 8;
		visited[i][j][k - 1] = true;
		dyn[i][j][k - 1] = r;
		return r;
	}

}