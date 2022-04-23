public class DP_Minimum_Sideway_Jumps {
	public static void main(String[] args) {
		int[] nums = { 0, 2, 2, 1, 0, 3, 0, 3, 0, 1, 3, 1, 1, 0, 1, 3, 1, 1, 1, 0, 2, 0, 0, 3, 3, 0, 3, 2, 2, 0, 0, 3,
				3, 3, 0, 0, 2, 0, 0, 3, 3, 0, 3, 3, 0, 0, 3, 1, 0, 1, 0, 2, 3, 1, 1, 0, 3, 3, 0, 3, 1, 3, 0, 2, 2, 0, 1,
				3, 0, 1, 0, 3, 0, 1, 3, 1, 2, 2, 0, 0, 3, 0, 1, 3, 2, 3, 2, 1, 0, 3, 2, 2, 0, 3, 3, 0, 3, 0, 0, 1, 0, 2,
				0, 0, 0, 2, 1, 2, 0, 2, 2, 3, 3, 3, 0, 0, 1, 1, 3, 0, 0, 0, 1, 2, 2, 1, 2, 1, 3, 2, 2, 3, 1, 3, 0, 1, 1,
				1, 3, 0, 0, 0, 2, 0, 2, 0, 3, 1, 2, 3, 3, 2, 2, 2, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 2, 1, 2, 3,
				1, 0, 3, 3, 2, 0, 1, 1, 0, 1, 0, 2, 2, 2, 1, 3, 0, 3, 0, 2, 1, 1, 3, 1, 0, 1, 2, 2, 0, 2, 2, 0, 0, 3, 3,
				1, 3, 0, 1, 1, 0, 3, 0, 2, 1, 2, 2, 0, 0, 0, 1, 2, 3, 1, 2, 1, 1, 2, 2, 1, 1, 0, 2, 3, 3, 3, 0, 2, 3, 2,
				0, 0, 0, 1, 0, 2, 2, 0, 0, 2, 0, 2, 0, 1, 1, 0, 3, 1, 3, 3, 0, 1, 0, 3, 0, 3, 1, 2, 3, 1, 0, 0, 2, 3, 2,
				0, 0, 3, 1, 2, 3, 2, 2, 3, 1, 3, 3, 2, 0, 1, 3, 0, 3, 2, 2, 3, 2, 1, 2, 2, 0, 3, 2, 0, 2, 1, 2, 2, 3, 1,
				3, 2, 2, 0, 0, 1, 0, 3, 1, 3, 3, 0, 0, 2, 2, 2, 2, 0, 1, 0, 3, 1, 3, 3, 3, 0, 2, 3, 2, 0, 3, 3, 3, 3, 3,
				3, 2, 2, 1, 1, 0, 3, 1, 3, 2, 3, 0, 0, 0, 2, 1, 1, 3, 1, 3, 2, 1, 3, 0, 1, 1, 3, 2, 2, 1, 0, 0, 3, 2, 1,
				3, 2, 3, 3, 2, 1, 2, 0, 2, 2, 0, 2, 2, 3, 2, 0, 2, 3, 3, 1, 1, 2, 0, 1, 1, 1, 2, 3, 2, 1, 2, 1, 0, 2, 3,
				1, 1, 3, 3, 2, 0, 1, 3, 2, 3, 3, 0, 1, 2, 3, 2, 1, 1, 2, 1, 0, 0, 1, 0, 3, 1, 1, 1, 0, 2, 0, 2, 2, 3, 0,
				1, 0, 2, 0, 0, 3, 1, 1, 2, 0, 0, 2, 1, 1, 0, 2, 2, 2, 3, 1, 2, 0, 1, 2, 0, 1, 2, 1, 2, 3, 1, 1, 1, 1, 0,
				3, 3, 2, 1, 0, 0, 1, 0, 3, 0, 0, 2, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2, 0, 3, 1, 3, 2, 1, 2, 2, 3, 1, 0, 1, 1,
				1, 0, 0, 0, 1, 3, 3, 2, 2, 1, 2, 0, 0, 0, 3, 1, 3, 2, 3, 1, 3, 2, 3, 1, 3, 2, 0, 1, 2, 1, 1, 2, 1, 3, 0,
				1, 1, 1, 3, 3, 1, 0, 0, 3, 2, 2, 3, 1, 1, 0, 3, 0, 0, 3, 0, 3, 1, 2, 0, 2, 3, 2, 3, 0, 3, 2, 3, 0, 2, 2,
				3, 0, 3, 3, 3, 1, 0, 1, 2, 2, 0, 3, 3, 1, 3, 2, 2, 3, 2, 1, 1, 0, 0, 0, 0, 2, 1, 0, 1, 1, 1, 1, 0, 3, 0,
				1, 0, 0, 1, 0, 2, 0, 0, 1, 2, 0, 0, 0, 3, 3, 1, 0, 3, 2, 1, 2, 3, 2, 0, 3, 3, 0, 2, 3, 1, 1, 0, 2, 2, 3,
				3, 0, 1, 0, 0, 3, 1, 2, 3, 0, 1, 2, 3, 2, 2, 0, 1, 2, 0, 3, 0, 3, 0, 1, 1, 3, 2, 2, 2, 3, 1, 2, 0, 0, 3,
				0, 2, 3, 3, 1, 0, 3, 3, 0, 0, 0, 3, 2, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 0, 0, 1, 1, 1, 1, 2, 2, 0, 1,
				0, 2, 2, 0, 2, 1, 3, 1, 1, 1, 2, 1, 1, 0, 3, 1, 0, 2, 3, 0, 1, 2, 0, 0, 3, 1, 2, 3, 0, 0, 3, 1, 0, 2, 2,
				0, 1, 1, 2, 2, 1, 3, 1, 2, 1, 0, 1, 2, 3, 2, 3, 0, 3, 1, 3, 0, 2, 0, 3, 1, 1, 0, 3, 2, 0, 3, 0, 2, 0, 0,
				3, 3, 1, 1, 1, 0, 0, 1, 1, 1, 2, 3, 1, 3, 1, 2, 0, 0, 3, 3, 0, 3, 3, 0, 0, 0, 3, 3, 0, 3, 3, 2, 3, 3, 3,
				3, 1, 1, 1, 3, 1, 1, 3, 3, 1, 0, 0, 3, 1, 2, 0, 2, 0, 3, 0, 2, 1, 0, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 0, 0,
				0, 2, 2, 3, 0, 0, 3, 0, 2, 3, 0, 1, 3, 2, 1, 2, 0, 1, 3, 2, 2, 0, 1, 1, 3, 3, 0, 2, 3, 0, 3, 3, 1, 2, 3,
				2, 1, 0, 2, 3, 2, 2, 2, 3, 0, 1, 1, 3, 1, 0, 2, 1, 3, 2, 2, 2, 3, 3, 1, 1, 1, 3, 2, 3, 1, 0, 2, 3, 0, 2,
				3, 0, 1, 3, 3, 1, 1, 1, 1, 0, 1, 1, 2, 2, 0, 2, 1, 1, 0, 1, 0, 3, 1, 1, 1, 3, 3, 2, 1, 2, 3, 2, 2, 3, 1,
				0, 3, 2, 0, 1, 0, 1, 3, 3, 3, 0, 3, 3, 2, 3, 1, 2, 2, 1, 1, 0, 0, 3, 0 };
		System.out.println(minSideJumps(nums));
	}

	public static int minSideJumps(int[] obstacles) {
		dyn = new int[obstacles.length][3];
		visited = new boolean[obstacles.length][3];
		return help(obstacles, 0, 2);
	}

	static boolean[][] visited;
	static int[][] dyn;

	public static int help(int[] nums, int cindex, int pos) {
		if (cindex == nums.length - 1) {
			return 0;
		}
		if (visited[cindex][pos - 1]) {
			return dyn[cindex][pos - 1];
		}
		if (nums[cindex + 1] == pos) {
			if (nums[cindex] != 0) {
				int t = help(nums, cindex, 6 - pos - nums[cindex]) + 1;
				visited[cindex][pos - 1] = true;
				dyn[cindex][pos - 1] = t;
				return t;
			}
			if (nums[cindex] == 0) {
				if (pos == 1) {
					int t = Integer.min(help(nums, cindex, 2), help(nums, cindex, 3)) + 1;
					visited[cindex][pos - 1] = true;
					dyn[cindex][pos - 1] = t;
					return t;
				}
				if (pos == 2) {
					int t = Integer.min(help(nums, cindex, 1), help(nums, cindex, 3)) + 1;
					visited[cindex][pos - 1] = true;
					dyn[cindex][pos - 1] = t;
					return t;
				}
				if (pos == 3) {
					int t = Integer.min(help(nums, cindex, 1), help(nums, cindex, 2)) + 1;
					visited[cindex][pos - 1] = true;
					dyn[cindex][pos - 1] = t;
					return t;
				}
			}
		}
		int t = help(nums, cindex + 1, pos);
		visited[cindex][pos - 1] = true;
		dyn[cindex][pos - 1] = t;
		return t;
	}
}
