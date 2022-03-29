public class GR_Number_of_Enclaves {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	public int numEnclaves(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid[0].length; i++) {
			help(grid, visited, 0, i);
		}
		for (int i = 0; i < grid[0].length; i++) {
			help(grid, visited, grid.length - 1, i);
		}
		for (int i = 0; i < grid.length; i++) {
			help(grid, visited, i, 0);
		}
		for (int i = 0; i < grid.length; i++) {
			help(grid, visited, i, grid[0].length - 1);
		}
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					res++;
				}
			}
		}
		return res;
	}

	public static void help(int[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		help(grid, visited, i + 1, j);
		help(grid, visited, i - 1, j);
		help(grid, visited, i, j + 1);
		help(grid, visited, i, j - 1);
	}
}
