public class GR_Check_if_There_is_a_Valid_Path_in_a_Grid {
	public static void main(String[] args) {
		int[][] grid = { { 2, 4, 3 }, { 6, 5, 2 } };
		System.out.println(hasValidPath(grid));
	}

	public static boolean hasValidPath(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		if (help(0, 0, 1, grid, visited)) {
			return true;
		}
		visited = new boolean[grid.length][grid[0].length];
		if (help(0, 0, 2, grid, visited)) {
			return true;
		}
		visited = new boolean[grid.length][grid[0].length];
		if (help(0, 0, 3, grid, visited)) {
			return true;
		}
		visited = new boolean[grid.length][grid[0].length];
		if (help(0, 0, 4, grid, visited)) {
			return true;
		}
		return false;
	}

	public static boolean help(int i, int j, int direction, int[][] grid, boolean[][] visited) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
			return false;
		}
		visited[i][j] = true;
		if (grid[i][j] == 1 && direction == 1) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i, j + 1, 1, grid, visited);
		}
		if (grid[i][j] == 2 && direction == 3) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i + 1, j, 3, grid, visited);
		}

		if (grid[i][j] == 1 && direction == 2) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i, j - 1, 2, grid, visited);
		}
		if (grid[i][j] == 2 && direction == 4) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i - 1, j, 4, grid, visited);
		}

		if (grid[i][j] == 3 && direction == 1) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i + 1, j, 3, grid, visited);
		}
		if (grid[i][j] == 4 && direction == 4) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i, j + 1, 1, grid, visited);
		}
		if (grid[i][j] == 5 && direction == 1) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i - 1, j, 4, grid, visited);
		}
		if (grid[i][j] == 6 && direction == 3) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i, j + 1, 1, grid, visited);
		}
		if (grid[i][j] == 3 && direction == 4) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i, j - 1, 2, grid, visited);
		}
		if (grid[i][j] == 4 && direction == 2) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i + 1, j, 3, grid, visited);
		}
		if (grid[i][j] == 5 && direction == 3) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i, j - 1, 2, grid, visited);
		}
		if (grid[i][j] == 6 && direction == 2) {
			if (i == grid.length - 1 && j == grid[0].length - 1) {
				return true;
			}
			return help(i - 1, j, 4, grid, visited);
		}
		return false;
	}
}