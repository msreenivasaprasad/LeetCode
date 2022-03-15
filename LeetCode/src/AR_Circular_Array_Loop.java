import java.util.ArrayList;
import java.util.List;

public class AR_Circular_Array_Loop {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -1, -2, -2 };
		System.out.println(circularArrayLoop(nums));
	}

	public static boolean circularArrayLoop(int[] nums) {
		// boolean[] visited = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {

			boolean[] visited = new boolean[nums.length];
			boolean flag = false;
			List<Boolean> ispos = new ArrayList<Boolean>();
			boolean temp = nums[i] > 0;
			int t = isCycle(nums, i, visited, ispos);
			for (int j = 0; j < ispos.size(); j++) {
				if (ispos.get(j) != temp) {
					flag = true;
					break;
				}
			}
			if (t != i) {
				flag = true;
			}
			if (ispos.size() == 1) {
				flag = true;
			}
			if (!flag) {
				return true;
			}

		}
		return false;
	}

	public static int isCycle(int[] nums, int index, boolean[] visited, List<Boolean> ispos) {
		if (index < 0) {
			index = index % nums.length;
			index = nums.length + index;
		}
		if (index >= nums.length) {
			index = index % nums.length;
		}
		if (visited[index]) {
			return index;
		}
		ispos.add(nums[index] > 0);
		visited[index] = true;
		return isCycle(nums, index + nums[index], visited, ispos);
	}

}