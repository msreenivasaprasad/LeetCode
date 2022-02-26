import java.util.HashMap;
import java.util.Map;

public class DP_Solving_Questions_With_Brainpower {
	public static void main(String[] args) {
		int[][] questions = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };
		System.out.println(mostPoints(questions));

	}

	public static long mostPoints(int[][] questions) {
		dyn = new HashMap<Integer, Long>();
		return help(questions, 0);
	}

	static Map<Integer, Long> dyn;

	public static long help(int[][] nums, int index) {
		if (dyn.containsKey(index)) {
			return dyn.get(index);
		}
		if (index >= nums.length) {
			return 0;
		}
		long t = Long.max(help(nums, index + 1), nums[index][0] + help(nums, index + 1 + nums[index][1]));
		dyn.put(index, t);
		return t;
	}
}