import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DP_Uncrossed_Lines {
	public static void main(String[] args) {
		int[] nums1 = new int[500];
		int[] nums2 = new int[500];
		Random r = new Random();
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = r.nextInt(10);
			nums2[i] = r.nextInt(10);
		}

		System.out.println(maxUncrossedLines(nums1, nums2));
	}

	public static int maxUncrossedLines(int[] nums1, int[] nums2) {
		dyn = new HashMap<String, Integer>();
		return help(nums1, nums2, 0, 0);
	}

	static Map<String, Integer> dyn;

	public static int help(int[] nums1, int[] nums2, int i, int j) {
		String key = Integer.toString(i) + "*" + Integer.toString(j);
		if (dyn.containsKey(key)) {
			return dyn.get(key);
		}
		if (i == nums1.length || j == nums2.length) {
			return 0;
		}
		int max = 0;
		for (int p = i; p < nums1.length; p++) {
			for (int q = j; q < nums2.length; q++) {
				if (nums1[p] == nums2[q]) {
					max = Integer.max(help(nums1, nums2, p + 1, q + 1) + 1, max);
				}
			}
		}
		dyn.put(key, max);
		return max;
	}

}