import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AR_Append_K_Integers_With_Minimal_Sum {
	public static void main(String[] args) {
		int[] nums = { 96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21,
				72, 100, 40, 84 };
		System.out.println(minimalKSum(nums, 35));
	}

	public static long minimalKSum(int[] nums, int k) {
		long sum = 0;
		Set<Integer> dist = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			dist.add(nums[i]);
		}
		int[] nums2 = new int[dist.size()];
		Iterator<Integer> i = dist.iterator();
		int t = 0;
		while (i.hasNext()) {
			nums2[t++] = i.next();
		}
		Arrays.sort(nums2);
		if (k % 2 == 0) {
			sum = (long) (k + 1) * (long) (k / 2);
		} else {
			sum = (long) (((long) (k + 1) / (long) 2) * (long) k);
		}

		int curr = k;
		for (t = 0; t < nums2.length; t++) {
			if (nums2[t] <= curr) {
				sum -= nums2[t];
				curr++;
				sum += curr;
			}
		}
		return sum;
	}
}