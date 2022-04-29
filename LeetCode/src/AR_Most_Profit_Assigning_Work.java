import java.util.Arrays;

public class AR_Most_Profit_Assigning_Work {
	public static void main(String[] args) {
		int[] difficulty = { 1, 1, 1, 1, 100 };
		int[] profit = { 1, 1, 1, 1, 100 };
		int[] worker = { 101, 101, 101 };
		System.out.println(maxProfitAssignment(difficulty, profit, worker));
	}

	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		mergeSort(profit, difficulty, 0, profit.length);
		Arrays.sort(worker);
		int start = worker.length - 1;
		int res = 0;
		for (int i = profit.length - 1; i >= 0; i--) {
			int t = firstGreaterIndex(worker, start, difficulty[i]);
			res += (profit[i] * t);
			start -= t;
		}
		return res;
	}

	public static int firstGreaterIndex(int[] arr, int end, int num) {
		int start = 0;
		int temp = end;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] < num) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return temp - start + 1;
	}

	public static void mergeSort(int[] profit, int[] difficulty, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(profit, difficulty, start, mid);
		mergeSort(profit, difficulty, mid, end);
		merge(profit, difficulty, start, mid, end);
	}

	public static void merge(int[] profit, int[] difficulty, int start, int mid, int end) {
		int[] temp = new int[end - start];
		int[] tempo = new int[end - start];
		int i = start;
		int j = mid;
		int k = 0;
		while (i < mid && j < end) {
			if (profit[i] < profit[j]) {
				tempo[k] = difficulty[i];
				temp[k++] = profit[i++];
			} else if (profit[i] > profit[j]) {
				tempo[k] = difficulty[j];
				temp[k++] = profit[j++];
			} else {
				if (difficulty[i] <= difficulty[j]) {
					tempo[k] = difficulty[i];
					temp[k++] = profit[i++];
				} else {
					tempo[k] = difficulty[j];
					temp[k++] = profit[j++];
				}
			}
		}
		while (i < mid) {
			tempo[k] = difficulty[i];
			temp[k++] = profit[i++];
		}
		while (j < end) {
			tempo[k] = difficulty[j];
			temp[k++] = profit[j++];
		}
		k = 0;
		for (i = start; i < end; i++) {
			difficulty[i] = tempo[k];
			profit[i] = temp[k++];
		}
	}
}
