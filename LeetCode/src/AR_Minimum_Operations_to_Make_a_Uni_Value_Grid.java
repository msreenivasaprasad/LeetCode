import java.util.Arrays;

public class AR_Minimum_Operations_to_Make_a_Uni_Value_Grid {
	public static void main(String[] args) {
		int[][] grid = { { 2, 4 }, { 6, 8 } };
		System.out.println(minOperations(grid, 2));
	}

	public static int minOperations(int[][] grid, int x) {
		int[] nums = new int[grid.length * grid[0].length];
		int k = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				nums[k++] = grid[i][j];
			}
		}
		Arrays.sort(nums);
		int res = 0;
		int mid = nums[nums.length / 2];
		for (int i = 0; i < nums.length; i++) {
			if (Math.abs(nums[i] - mid) % x != 0) {
				return -1;
			}
			res += Math.abs(nums[i] - mid) / x;
		}

		return res;
	}

}