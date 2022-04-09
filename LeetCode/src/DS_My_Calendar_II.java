import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DS_My_Calendar_II {
	public static void main(String[] args) {
		MyCalendarTwo n = new MyCalendarTwo();
		System.out.println(n.book(10, 20));
		System.out.println(n.book(50, 60));
		System.out.println(n.book(10, 40));
		System.out.println(n.book(5, 15));
		System.out.println(n.book(5, 10));
		System.out.println(n.book(25, 55));
	}
}

class MyCalendarTwo {

	public MyCalendarTwo() {
		count = new TreeMap<Integer, Integer>();
		lower = new ArrayList<Integer>();
		upper = new ArrayList<Integer>();
	}

	List<Integer> lower;
	List<Integer> upper;
	Map<Integer, Integer> count;

	public boolean book(int start, int end) {

		if (count.containsKey(start)) {
			count.replace(start, count.get(start) + 1);
		} else {
			count.put(start, 1);
		}
		if (count.containsKey(end)) {
			count.replace(end, count.get(end) - 1);
		} else {
			count.put(end, -1);
		}
		if (!isPossible(start, end)) {
			count.replace(start, count.get(start) - 1);
			count.replace(end, count.get(end) + 1);
			return false;
		}
		return true;
	}

	public boolean isPossible(int start, int end) {

		Iterator<Integer> i = count.keySet().iterator();
		int sum = 0;
		while (i.hasNext()) {
			sum += count.get(i.next());
			if (sum >= 3) {
				return false;
			}
		}
		return true;
	}

	public static boolean inRange(int i, int left, int right) {
		return (i >= left && i <= right);
	}

}