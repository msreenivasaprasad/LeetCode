import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DS_Finding_the_Users_Active_Minutes {
	public static void main(String[] args) {
		int[][] nums = { { 0, 5 }, { 1, 2 }, { 0, 2 }, { 0, 5 }, { 1, 3 } };
		int[] res = findingUsersActiveMinutes(nums, 4);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
		Set<String> count = new HashSet<String>();
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		for (int i = 0; i < logs.length; i++) {
			String temp = Integer.toString(logs[i][0]) + "*" + Integer.toString(logs[i][1]);
			if (!count.contains(temp)) {
				count.add(temp);
				if (counter.containsKey(logs[i][0])) {
					counter.replace(logs[i][0], counter.get(logs[i][0]) + 1);
				} else {
					counter.put(logs[i][0], 1);
				}
			}
		}
		int[] res = new int[k];
		Set<Integer> keys = counter.keySet();
		Iterator<Integer> i = keys.iterator();
		while (i.hasNext()) {
			res[counter.get(i.next()) - 1]++;
		}
		return res;

	}
}