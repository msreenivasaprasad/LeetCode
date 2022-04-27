import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AR_Range_Frequency_Queries {
	public static void main(String[] args) {
		int[] num = { 0, 2, 1, 4, 5, 6, 1, 1 };
		RangeFreqQuery r = new RangeFreqQuery(num);
		System.out.println(r.query(6, num.length - 1, 1));

	}
}

class RangeFreqQuery {
	int[][] counter;
	Map<Integer, Integer> data;

	public RangeFreqQuery(int[] arr) {
		Set<Integer> count = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			count.add(arr[i]);
		}
		int i = 0;
		data = new HashMap<Integer, Integer>();
		Iterator<Integer> t = count.iterator();
		while (t.hasNext()) {
			data.put(t.next(), i);
			i++;
		}
		counter = new int[data.size()][arr.length];
		for (int j = 0; j < arr.length; j++) {
			int key = data.get(arr[j]);
			counter[key][j] = 1;
		}
		for (int j = 0; j < counter.length; j++) {
			int sum = 0;
			for (int k = 0; k < counter[0].length; k++) {
				sum += counter[j][k];
				counter[j][k] = sum;
			}
		}

	}

	public int query(int left, int right, int value) {
		if (!data.containsKey(value)) {
			return 0;
		}
		int key = data.get(value);
		if (left == 0) {
			return counter[key][right];
		}
		return counter[key][right] - counter[key][left - 1];
	}
}
