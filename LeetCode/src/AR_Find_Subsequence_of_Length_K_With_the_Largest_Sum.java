public class AR_Find_Subsequence_of_Length_K_With_the_Largest_Sum {
	public static void main(String[] args) {
		int[] nums = { -1, -2, 3, 4 };
		int[] res = maxSubsequence(nums, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
//		mergeSort(nums, ind, 0, nums.length);
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}
//		for (int i = 0; i < ind.length; i++) {
//			System.out.println(ind[i]);
//		}
	}

	public static int[] maxSubsequence(int[] nums, int k) {
		int[] indices = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indices[i] = i;
		}
		mergeSort(nums, indices, 0, nums.length);
		int[] res = new int[k];
		int[] resi = new int[k];

		for (int i = 0; i < res.length; i++) {
			res[i] = nums[nums.length - i - 1];
			resi[i] = indices[nums.length - i - 1];
		}
		mergeSort(resi, res, 0, resi.length);
		return res;

	}

	public static void mergeSort(int[] nums, int[] count, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(nums, count, start, mid);
		mergeSort(nums, count, mid, end);
		merge(nums, count, start, mid, end);
	}

	public static void merge(int[] nums, int[] count, int start, int mid, int end) {
		int[] temp = new int[end - start];
		int[] ctemp = new int[end - start];
		int i = start;
		int j = mid;
		int k = 0;
		while (i < mid && j < end) {
			if (nums[i] <= nums[j]) {
				ctemp[k] = count[i];
				temp[k++] = nums[i++];
			} else {
				ctemp[k] = count[j];
				temp[k++] = nums[j++];
			}
		}
		while (i < mid) {
			ctemp[k] = count[i];
			temp[k++] = nums[i++];
		}
		while (j < end) {
			ctemp[k] = count[j];
			temp[k++] = nums[j++];
		}
		i = start;
		for (k = 0; k < temp.length; k++) {
			count[i] = ctemp[k];
			nums[i++] = temp[k];
		}
	}

}
