public class AR_Largest_Plus_Sign {
	public static void main(String[] args) {
		int[][] nums = { { 4, 2 } };
		System.out.println(orderOfLargestPlusSign(5, nums));
	}

	public static int orderOfLargestPlusSign(int n, int[][] mines) {
		boolean[][] map = new boolean[n][n];
		for (int i = 0; i < mines.length; i++) {
			map[mines[i][0]][mines[i][1]] = true;
		}
		int res = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!map[i][j]) {
					flag = true;
					int temp = Integer.min(Integer.min(left(map, i, j), right(map, i, j)),
							Integer.min(up(map, i, j), bottom(map, i, j)));
					res = Integer.max(res, temp);
				}
			}
		}
		if (!flag) {
			return 0;
		}
		return res + 1;
	}

	public static int left(boolean[][] grid, int i, int j) {
		int count = 0;
		for (int p = j - 1; p >= 0; p--) {
			if (grid[i][p]) {
				break;
			}
			count++;
		}
		return count;
	}

	public static int right(boolean[][] grid, int i, int j) {
		int count = 0;
		for (int p = j + 1; p < grid[0].length; p++) {
			if (grid[i][p]) {
				break;
			}
			count++;
		}
		return count;
	}

	public static int up(boolean[][] grid, int i, int j) {
		int count = 0;
		for (int p = i - 1; p >= 0; p--) {
			if (grid[p][j]) {
				break;
			}
			count++;
		}
		return count;
	}

	public static int bottom(boolean[][] grid, int i, int j) {
		int count = 0;
		for (int p = i + 1; p < grid.length; p++) {
			if (grid[p][j]) {
				break;
			}
			count++;
		}
		return count;
	}
}