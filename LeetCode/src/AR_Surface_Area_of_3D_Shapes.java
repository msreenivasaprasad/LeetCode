public class AR_Surface_Area_of_3D_Shapes {
	public static void main(String[] args) {
		int[][] nums = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		System.out.println(surfaceArea(nums));
	}

	public static int surfaceArea(int[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int area = 0;
				if (i - 1 < 0) {
					area += grid[i][j];
				}
				if (i - 1 >= 0) {
					area += Integer.max(grid[i][j] - grid[i - 1][j], 0);
				}
				if (i + 1 >= grid.length) {
					area += grid[i][j];
				}
				if (i + 1 < grid.length) {
					area += Integer.max(grid[i][j] - grid[i + 1][j], 0);
				}
				if (j - 1 < 0) {
					area += grid[i][j];
				}
				if (j - 1 >= 0) {
					area += Integer.max(grid[i][j] - grid[i][j - 1], 0);
				}
				if (j + 1 >= grid[0].length) {
					area += grid[i][j];
				}
				if (j + 1 < grid[0].length) {
					area += Integer.max(grid[i][j] - grid[i][j + 1], 0);
				}
				res += area;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > 0) {
					res += 2;
				}
			}
		}
		return res;
	}
}
