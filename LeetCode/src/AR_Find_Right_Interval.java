public class AR_Find_Right_Interval {
	public static void main(String[] args) {
		int[][] intervals = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		int[] ind = findRightInterval(intervals);
		for (int i = 0; i < ind.length; i++) {
			System.out.println(ind[i]);
		}
	}

	public static int[] findRightInterval(int[][] intervals) {
		int[] res = new int[intervals.length];
		int[] indeces = new int[intervals.length];
		int[] starts = new int[intervals.length];
		for (int i = 0; i < starts.length; i++) {
			starts[i] = intervals[i][0];
			indeces[i] = i;
		}
		mergeSort(starts, indeces, 0, starts.length);
		for (int i = 0; i < intervals.length; i++) {
			int t = findIndex(starts, intervals[i][1]);
			if (t == -1) {
				res[i] = -1;
			} else {
				res[i] = indeces[t];
			}
		}
		return res;
	}

	public static void mergeSort(int[] nums, int[] indices, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(nums, indices, start, mid);
		mergeSort(nums, indices, mid, end);
		merge(nums, indices, start, mid, end);
	}

	public static void merge(int[] nums, int[] indices, int start, int mid, int end) {
		int i = start;
		int j = mid;
		int[] temp = new int[end - start];
		int[] tempo = new int[end - start];
		int k = 0;
		while (i < mid && j < end) {
			if (nums[i] < nums[j]) {
				tempo[k] = indices[i];
				temp[k++] = nums[i++];
			} else {
				tempo[k] = indices[j];
				temp[k++] = nums[j++];
			}
		}
		while (i < mid) {
			tempo[k] = indices[i];
			temp[k++] = nums[i++];
		}
		while (j < end) {
			tempo[k] = indices[j];
			temp[k++] = nums[j++];
		}
		k = 0;
		for (i = start; i < end; i++) {
			indices[i] = tempo[k];
			nums[i] = temp[k++];
		}
	}

	public static int findIndex(int[] nums, int i) {
		int start = 0;
		if (i > nums[nums.length - 1] || i < nums[0]) {
			return -1;
		}
		int end = nums.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= i) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}