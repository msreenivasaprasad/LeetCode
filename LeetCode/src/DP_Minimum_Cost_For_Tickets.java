public class DP_Minimum_Cost_For_Tickets {
	public static void main(String[] args) {
		int[] days = { 3, 5, 6, 7, 8, 10, 12, 15, 16, 18, 19, 21, 23, 24, 25, 26, 27, 28, 29, 37, 38, 39, 40, 48, 49,
				52, 54, 55, 57, 61, 63, 65, 66, 69, 73, 75, 77, 78, 81, 83, 84, 85, 88, 89, 90, 91, 93, 94, 96, 99 };
		int[] costs = { 5, 26, 98 };
		System.out.println(mincostTickets(days, costs));
	}

	public static int mincostTickets(int[] days, int[] costs) {
		boolean[] count = new boolean[366];
		visited = new boolean[366];
		dyn = new int[366];
		for (int i = 0; i < days.length; i++) {
			count[days[i]] = true;
		}
		return help(count, costs, 1);
	}

	static boolean[] visited;
	static int[] dyn;

	public static int help(boolean[] count, int[] costs, int index) {
		if (index > 365) {
			return 0;
		}
		if (visited[index]) {
			return dyn[index];
		}
		if (!count[index]) {
			visited[index] = true;
			int t = help(count, costs, index + 1);
			dyn[index] = t;
			return t;
		}
		int a = help(count, costs, index + 1) + costs[0];
		int b = help(count, costs, index + 7) + costs[1];
		int c = help(count, costs, index + 30) + costs[2];
		int min = Integer.min(Integer.min(a, b), c);
		visited[index] = true;
		dyn[index] = min;
		return min;

	}
}
