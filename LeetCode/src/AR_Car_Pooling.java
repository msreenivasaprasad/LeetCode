import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class AR_Car_Pooling {
	public static void main(String[] args) {
		int[][] nums = { { 2, 1, 5 }, { 3, 3, 7 } };
		System.out.println(carPooling(nums, 5));
	}

	public static boolean carPooling(int[][] trips, int capacity) {
		Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
		for (int i = 0; i < trips.length; i++) {
			if (count.containsKey(trips[i][1])) {
				count.replace(trips[i][1], count.get(trips[i][1]) + trips[i][0]);
			} else {
				count.put(trips[i][1], trips[i][0]);
			}
			if (count.containsKey(trips[i][2])) {
				count.replace(trips[i][2], count.get(trips[i][2]) - trips[i][0]);
			} else {
				count.put(trips[i][2], -trips[i][0]);
			}
		}
		Iterator<Integer> i = count.keySet().iterator();
		int res = 0;
		while (i.hasNext()) {
			res += count.get(i.next());
			if (res > capacity) {
				return false;
			}
		}
		return true;
	}
}