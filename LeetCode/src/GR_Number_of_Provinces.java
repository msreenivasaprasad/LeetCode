public class GR_Number_of_Provinces {
	public static void main(String[] args) {
		int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(isConnected));

	}

	public static int findCircleNum(int[][] isConnected) {
		boolean[] visited = new boolean[isConnected.length];
		int res = 0;
		for (int i = 0; i < isConnected.length; i++) {
			if (!visited[i]) {
				help(isConnected, visited, i);
				res++;
			}
		}
		return res;
	}

	public static void help(int[][] grid, boolean[] visited, int i) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		for (int j = 0; j < grid.length; j++) {
			if (grid[i][j] == 1) {
				help(grid, visited, j);
			}
		}
	}
}
