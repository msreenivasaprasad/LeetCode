import java.util.HashSet;
import java.util.Set;

public class DP_Frog_Jump {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 5, 6, 8, 12, 17 };
		System.out.println(canCross(nums));
		System.out.println();
	}

	static boolean[][] visited;

	public static boolean canCross(int[] stones) {
		if (stones[1] != 1) {
			return false;
		}
		dyn = new HashSet<String>();
		return help(stones, 1, 1);
	}

	static Set<String> dyn;

	public static boolean help(int[] stones, int index, int jump) {
		if (index == stones.length - 1) {
			return true;
		}
		String key = Integer.toString(index) + "*" + Integer.toString(jump);
		if (dyn.contains(key)) {
			return false;
		}
		for (int i = index + 1; i < stones.length; i++) {
			if (stones[i] - stones[index] == jump - 1 || stones[i] - stones[index] == jump + 1
					|| stones[i] - stones[index] == jump) {
				if (help(stones, i, stones[i] - stones[index])) {
					return true;
				}
			}
		}
		dyn.add(key);
		return false;
	}

}
