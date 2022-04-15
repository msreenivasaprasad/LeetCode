public class DP_Max_Chunks_To_Make_Sorted {
	public static void main(String[] args) {
		int[] nums = { 0 };
		System.out.println(maxChunksToSorted(nums));
	}

	public static int maxChunksToSorted(int[] arr) {
		dyn = new int[10];
		visited = new boolean[10];
		return help(arr, 0);
	}

	static int[] dyn;
	static boolean[] visited;

	public static int help(int[] arr, int index) {
		if (index >= arr.length) {
			return 0;
		}
		if (visited[index]) {
			return dyn[index];
		}
		for (int i = index + 1; i <= arr.length; i++) {
			if (isPossible(arr, index, i)) {
				int t = help(arr, i);
				if (t != -1) {
					visited[index] = true;
					dyn[index] = t + 1;
					return t + 1;
				}
			}
		}
		visited[index] = true;
		dyn[index] = -1;
		return -1;
	}

	public static boolean isPossible(int[] arr, int left, int right) {
		boolean[] count = new boolean[10];
		for (int i = left; i < right; i++) {
			count[arr[i]] = true;
		}
		for (int i = left; i < right; i++) {
			if (!count[i]) {
				return false;
			}
		}
		return true;
	}
}
