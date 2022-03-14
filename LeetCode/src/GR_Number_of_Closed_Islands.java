public class GR_Number_of_Closed_Islands {
	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 } };
		System.out.println(closedIsland(grid));
	}

	public static int closedIsland(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && !visited[i][j] && help(i, j, grid, visited)) {
					res++;
				}
			}
		}
		return res;
	}

	public static boolean help(int i, int j, int[][] grid, boolean[][] visited) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return false;
		}
		if (grid[i][j] == 1 || (grid[i][j] == 0 && visited[i][j])) {
			return true;
		}
		visited[i][j] = true;
		return help(i - 1, j, grid, visited) & help(i + 1, j, grid, visited) & help(i, j - 1, grid, visited)
				& help(i, j + 1, grid, visited);
	}
}