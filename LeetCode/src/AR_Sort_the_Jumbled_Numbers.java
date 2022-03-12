import java.util.ArrayList;
import java.util.List;

public class AR_Sort_the_Jumbled_Numbers {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] mapping = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] res = sortJumbled(mapping, nums);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] sortJumbled(int[] mapping, int[] nums) {
		int[] nums2 = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			nums2[i] = help(mapping, nums[i]);
		}
		mergeSort(nums2, nums, 0, nums.length);
		return nums;
	}

	public static void mergeSort(int[] nums, int[] count, int left, int right) {
		if (left + 1 >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(nums, count, left, mid);
		mergeSort(nums, count, mid, right);
		merge(nums, count, left, mid, right);
	}

	public static void merge(int[] nums, int[] count, int left, int mid, int right) {
		int[] temp = new int[right - left];
		int[] tempo = new int[right - left];

		int i = left;
		int j = mid;
		int k = 0;
		while (i < mid && j < right) {
			if (nums[i] <= nums[j]) {
				tempo[k] = count[i];
				temp[k++] = nums[i++];
			} else {
				tempo[k] = count[j];
				temp[k++] = nums[j++];
			}
		}
		while (i < mid) {
			tempo[k] = count[i];
			temp[k++] = nums[i++];
		}
		while (j < right) {
			tempo[k] = count[j];
			temp[k++] = nums[j++];
		}
		k = 0;
		for (i = left; i < right; i++) {
			count[i] = tempo[k];
			nums[i] = temp[k++];
		}
	}

	public static int help(int[] map, int num) {
		List<Integer> count = new ArrayList<Integer>();
		if (num == 0) {
			return map[0];
		}
		while (num > 0) {
			count.add(map[num % 10]);
			num /= 10;
		}
		int res = 0;
		for (int i = 0; i < count.size(); i++) {
			res += count.get(i) * Math.pow(10, i);
		}
		return res;
	}
}