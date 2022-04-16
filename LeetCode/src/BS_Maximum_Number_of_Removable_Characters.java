import java.util.HashSet;
import java.util.Set;

public class BS_Maximum_Number_of_Removable_Characters {
	public static void main(String[] args) {
		int[] nums = { 3, 1, 0 };
		System.out.println(maximumRemovals("abcacb", "ab", nums));
	}

	public static int maximumRemovals(String s, String p, int[] removable) {
		int end = removable.length;
		int start = 0;
		int res = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(s.toCharArray(), p.toCharArray(), mid, removable)) {
				res = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return res;
	}

	public static boolean isPossible(char[] s, char[] p, int k, int[] removable) {
		Set<Integer> count = new HashSet<Integer>();
		for (int i = 0; i < k; i++) {
			count.add(removable[i]);
		}
		int start = 0;
		while (count.contains(start)) {
			start++;
		}
		int i = 0;
		while (i < p.length) {
			while (count.contains(start)) {
				start++;
			}
			if (start >= s.length) {
				break;
			}
			if (p[i] == s[start]) {
				i++;
			}
			start++;
			if (start >= s.length) {
				break;
			}
		}
		return i >= p.length;
	}
}
