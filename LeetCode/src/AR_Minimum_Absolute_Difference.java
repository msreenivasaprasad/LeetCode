import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AR_Minimum_Absolute_Difference {
	public static void main(String[] args) {
	}

	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		int min = arr[1] - arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] < min) {
				min = arr[i] - arr[i - 1];
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] == min) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(arr[i - 1]);
				temp.add(arr[i]);
				res.add(new ArrayList<Integer>(temp));
			}
		}
		return res;
	}

}