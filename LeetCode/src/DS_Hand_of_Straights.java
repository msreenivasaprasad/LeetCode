import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DS_Hand_of_Straights {
	public static void main(String[] args) {
		int[] hand = { 1, 2, 3, 4, 5, 6 };
		System.out.println(isNStraightHand(hand, 2));
	}

	public static boolean isNStraightHand(int[] hand, int groupSize) {
		Map<Integer, Integer> count = new TreeMap<Integer, Integer>();
		for (int i = 0; i < hand.length; i++) {
			if (count.containsKey(hand[i])) {
				count.replace(hand[i], count.get(hand[i]) + 1);
			} else {
				count.put(hand[i], 1);
			}
		}
		while (count.size() > 0) {
			int t = help(count, groupSize);
			if (t == -1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isOk(List<Integer> arr, int i) {
		int p = 1;
		while (p < i) {
			if (arr.get(p) != arr.get(p - 1) + 1) {
				return false;
			}
			p++;
		}
		return true;
	}

	public static int help(Map<Integer, Integer> count, int i) {
		Set<Integer> s = count.keySet();
		Iterator<Integer> p = s.iterator();
		List<Integer> arr = new ArrayList<Integer>();
		while (p.hasNext()) {
			arr.add(p.next());
		}
		if (arr.size() < i) {
			return -1;
		}
		if (!isOk(arr, i)) {
			return -1;
		}
		i--;
		int min = count.get(arr.get(0));
		count.remove(arr.get(0));
		for (int k = 1; k < arr.size(); k++) {
			i--;
			if (i < 0) {
				break;
			}
			int t = arr.get(k);
			if (count.get(t) < min) {
				return -1;
			} else {
				if (count.get(t) == min) {
					count.remove(t);
				} else {
					count.replace(t, count.get(t) - min);
				}
			}
		}
		while (i > 0 && p.hasNext()) {
			System.out.println(p.next());
		}
		if (i < 0 || (i == 0 && count.isEmpty())) {
			return min;
		}
		return -1;
	}

}