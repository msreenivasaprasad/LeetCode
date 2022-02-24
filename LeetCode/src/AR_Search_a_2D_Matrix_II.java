public class AR_Search_a_2D_Matrix_II {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix(matrix, 5));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] <= target) {
				if (binary(matrix[i], 0, matrix[i].length - 1, target) != -1) {
					return true;
				}
			}
		}
		return false;
	}

	public static int binary(int[] nums, int left, int right, int target) {
		int mid = (left + right) / 2;
		if (left < 0 || right >= nums.length || left > right) {
			return -1;
		}
		if (nums[mid] > target) {
			return binary(nums, left, mid - 1, target);
		}
		if (nums[mid] < target) {
			return binary(nums, mid + 1, right, target);
		}
		return mid;
	}

}
