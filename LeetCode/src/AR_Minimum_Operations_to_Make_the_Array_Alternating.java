import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AR_Minimum_Operations_to_Make_the_Array_Alternating {
	public static void main(String[] args) {
		int[] nums = { 4, 2, 1, 4, 4, 4, 1, 3, 4, 1, 1, 4, 4 };
		System.out.println(minimumOperations(nums));
	}

	public static int minimumOperations(int[] nums) {
		Map<Integer, Integer> counteven = new HashMap<Integer, Integer>();
		Map<Integer, Integer> countodd = new HashMap<Integer, Integer>();
		int even_max = 0, even_max_count = 0, odd_max = 0, odd_max_count = 0;
		int even_max_count_2 = 0, odd_max_count_2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				counteven.putIfAbsent(nums[i], 0);
				counteven.replace(nums[i], counteven.get(nums[i]) + 1);
				if (counteven.get(nums[i]) > even_max_count) {
					even_max = nums[i];
					even_max_count = counteven.get(nums[i]);
				}

			} else {
				countodd.putIfAbsent(nums[i], 0);
				countodd.replace(nums[i], countodd.get(nums[i]) + 1);
				if (countodd.get(nums[i]) > odd_max_count) {
					odd_max = nums[i];
					odd_max_count = countodd.get(nums[i]);
				}

			}
		}
		Iterator<Integer> i = counteven.keySet().iterator();
		while (i.hasNext()) {
			int t = i.next();
			if ((counteven.get(t) > even_max_count_2 && counteven.get(t) < even_max_count)
					|| counteven.get(t) == even_max_count && t != even_max) {
				even_max_count_2 = counteven.get(t);
			}
		}
		i = countodd.keySet().iterator();
		while (i.hasNext()) {
			int t = i.next();
			if ((countodd.get(t) > odd_max_count_2 && countodd.get(t) < odd_max_count)
					|| countodd.get(t) == odd_max_count && t != odd_max) {
				odd_max_count_2 = countodd.get(t);
			}
		}
		if (even_max != odd_max) {
			return nums.length - even_max_count - odd_max_count;
		}
		if (even_max != odd_max) {
			return nums.length - even_max_count - odd_max_count;
		}
		return Integer.min(nums.length - even_max_count - odd_max_count_2,
				nums.length - odd_max_count - even_max_count_2);
	}
}
