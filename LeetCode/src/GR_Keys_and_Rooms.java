import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GR_Keys_and_Rooms {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] count = new boolean[rooms.size()];
		Queue<Integer> keys = new LinkedList<Integer>();
		for (int j = 0; j < rooms.get(0).size(); j++) {
			keys.add(rooms.get(0).get(j));
		}
		while (!keys.isEmpty()) {
			int t = keys.poll();
			if (!count[t]) {
				for (int j = 0; j < rooms.get(t).size(); j++) {
					keys.add(rooms.get(t).get(j));
				}
				count[t] = true;
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (!count[i]) {
				return false;
			}
		}
		return true;
	}
}
