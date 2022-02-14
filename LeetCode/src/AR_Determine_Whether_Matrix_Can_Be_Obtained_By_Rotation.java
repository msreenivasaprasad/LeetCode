public class AR_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {
	public static void main(String[] args) {
		int[][] mat = { { 0, 1 }, { 1, 0 } };
		int[][] target = { { 1, 0 }, { 0, } };
		System.out.println(findRotation(mat, target));
	}

	public static boolean findRotation(int[][] mat, int[][] target) {
		if (isEqual(mat, target)) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			rotate90(mat);
			if (isEqual(mat, target)) {
				return true;
			}
		}
		return false;
	}

	public static void rotate90(int[][] nums) {

		int[][] copy = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				copy[i][j] = nums[i][j];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				nums[i][j] = copy[nums.length - j - 1][i];
			}
		}
	}

	public static boolean isEqual(int[][] nums, int[][] mat) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i][j] != mat[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
