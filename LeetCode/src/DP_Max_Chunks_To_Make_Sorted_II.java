import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP_Max_Chunks_To_Make_Sorted_II {
	public static void main(String[] args) {
		int[] nums = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1 };
		System.out.println(maxChunksToSorted(nums));
	}

	public static int maxChunksToSorted(int[] arr) {
		finalArray = arr.clone();
		Arrays.sort(finalArray);
		dyn = new int[arr.length];
		visited = new boolean[arr.length];
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

	static int[] finalArray;

	public static boolean isPossible(int[] arr, int left, int right) {
		List<Integer> count = new ArrayList<Integer>();
		for (int i = left; i < right; i++) {
			count.add(arr[i]);
		}
		Collections.sort(count);
		for (int i = 0; i < count.size(); i++) {
			if (count.get(i) != finalArray[left]) {
				return false;
			}
			left++;
		}
		return true;
	}
}
