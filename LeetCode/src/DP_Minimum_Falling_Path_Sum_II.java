public class DP_Minimum_Falling_Path_Sum_II {
	public static void main(String[] args) {
		int[][] grid = { { 7 } };
		System.out.println(minFallingPathSum(grid));
	}

	public static void mergeSort(int[] nums, int[] count, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(nums, count, start, mid);
		mergeSort(nums, count, mid, end);
		merge(nums, count, start, mid, end);
	}

	public static int minFallingPathSum(int[][] grid) {
		visited = new boolean[grid.length][grid[0].length];
		dyn = new int[grid.length][grid.length];
		return help(grid, 0, -1);
	}

	static int[][] dyn;
	static boolean[][] visited;

	public static int help(int[][] grid, int row, int prevColumn) {
		int max = 0;
		boolean flag = false;
		if (row == grid.length) {
			return 0;
		}
		if (prevColumn != -1 && visited[row][prevColumn]) {
			return dyn[row][prevColumn];
		}
		for (int i = 0; i < grid[0].length; i++) {
			if (i != prevColumn) {
				int t = help(grid, row + 1, i);
				if (!flag) {
					max = t + grid[row][i];
					flag = true;
				} else {
					max = Integer.min(max, t + grid[row][i]);
				}
			}
		}
		if (prevColumn != -1) {
			visited[row][prevColumn] = true;
			dyn[row][prevColumn] = max;
		}
		return max;
	}

	public static void merge(int[] nums, int[] count, int start, int mid, int end) {
		int[] temp = new int[end - start];
		int[] ctemp = new int[end - start];
		int i = start;
		int j = mid;
		int k = 0;
		while (i < mid && j < end) {
			if (nums[i] <= nums[j]) {
				ctemp[k] = count[i];
				temp[k++] = nums[i++];
			} else {
				ctemp[k] = count[j];
				temp[k++] = nums[j++];
			}
		}
		while (i < mid) {
			ctemp[k] = count[i];
			temp[k++] = nums[i++];
		}
		while (j < end) {
			ctemp[k] = count[j];
			temp[k++] = nums[j++];
		}
		i = start;
		for (k = 0; k < temp.length; k++) {
			count[i] = ctemp[k];
			nums[i++] = temp[k];
		}
	}
}
