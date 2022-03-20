import java.util.ArrayList;
import java.util.List;

public class AR_Shift_2D_Grid {
	public static void main(String[] args) {
		int[][] grid = { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
		List<List<Integer>> res = shiftGrid(grid, 4);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int[] res = new int[grid.length * grid[0].length];
		int p = 0;
		k = k % res.length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				res[p++] = grid[i][j];
			}
		}
		int j = 0;
		int kr = 0;
		int[][] res2 = new int[grid.length][grid[0].length];
		for (int i = res.length - k; i < res.length; i++) {
			if (kr == grid[0].length) {
				kr = 0;
				j++;
			}
			res2[j][kr++] = res[i];
		}
		for (int i = 0; i < res.length - k; i++) {
			if (kr == grid[0].length) {
				kr = 0;
				j++;
			}
			res2[j][kr++] = res[i];
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < res2.length; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int j1 = 0; j1 < res2[0].length; j1++) {
				temp.add(res2[i][j1]);
			}
			result.add(new ArrayList<Integer>(temp));
		}
		return result;
	}

	public static int numOfPairs(String[] nums, String target) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i].length() + nums[j].length() == target.length() && nums[i] + nums[j] == target) {
					res++;
				}
			}
		}
		return res;
	}
}