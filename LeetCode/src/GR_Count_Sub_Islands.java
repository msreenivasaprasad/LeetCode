public class GR_Count_Sub_Islands {
	public static void main(String[] args) {
		int[][] grid1 = { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 1 } };
		int[][] grid2 = { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 1 } };
		System.out.println(countSubIslands(grid1, grid2));
	}

	public static int countSubIslands(int[][] grid1, int[][] grid2) {
		boolean[][] visited = new boolean[grid1.length][grid1[0].length];
		int res = 0;
		for (int i = 0; i < grid2.length; i++) {
			for (int j = 0; j < grid2[0].length; j++) {
				if (grid2[i][j] == 1 && !visited[i][j] && isSun(grid1, grid2, i, j, visited)) {
					res++;
				}
			}
		}
		return res;
	}

	public static boolean isSun(int[][] grid1, int[][] grid2, int i, int j, boolean[][] visited) {
		if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
			return true;
		}
		if (grid2[i][j] == 0 || visited[i][j]) {
			return true;
		}
		if (grid2[i][j] == 1 && grid1[i][j] != 1) {
			return false;
		}
		visited[i][j] = true;
		return isSun(grid1, grid2, i + 1, j, visited) & isSun(grid1, grid2, i, j + 1, visited)
				& isSun(grid1, grid2, i - 1, j, visited) & isSun(grid1, grid2, i, j - 1, visited);

	}
}
