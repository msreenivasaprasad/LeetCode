
public class BS_Capacity_To_Ship_Packages_Within_D_Days {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 4, 1, 4 };
		System.out.println(shipWithinDays(nums, 3));
	}

	public static int shipWithinDays(int[] weights, int days) {
		int max = 0;
		for (int i : weights) {
			max = Integer.max(max, i);
		}
		int start = max;
		int end = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (help(weights, mid, days)) {
				min = Integer.min(min, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return min;
	}

	public static boolean help(int[] weights, int cap, int days) {
		int i = 0;
		int sum = 0;
		while (i < weights.length) {
			sum += weights[i];
			if (sum > cap) {
				sum = weights[i];
				days--;
			}
			if (sum > cap) {
				return false;
			}
			i++;
		}
		return days > 0;
	}
}
