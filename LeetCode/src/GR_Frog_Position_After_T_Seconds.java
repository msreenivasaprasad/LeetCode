public class GR_Frog_Position_After_T_Seconds {
	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 5 } };
		System.out.println(frogPosition(7, edges, 20, 6));

	}

	public static double frogPosition(int n, int[][] edges, int t, int target) {
		int[] count = new int[n + 1];
		boolean[][] map = new boolean[n + 1][n + 1];
		for (int i = 0; i < edges.length; i++) {
			map[edges[i][0]][edges[i][1]] = true;
			map[edges[i][1]][edges[i][0]] = true;
			count[edges[i][0]]++;
			count[edges[i][1]]++;
		}
		return help(map, 0, t, target, 1, count);

	}

	public static double help(boolean[][] graph, int previous, int time, int target, int current, int[] count) {
		double res = 0;
		int den = count[current] - 1;
		if (time == 0 && target == current) {
			return 1;
		}
		if (time == 0) {
			return 0;
		}
		if (current == 1) {
			den++;
		}
		boolean flag = false;
		for (int i = 0; i < graph[current].length; i++) {
			if (i != previous && graph[current][i]) {
				flag = true;
				res += help(graph, current, time - 1, target, i, count);
			}
		}
		if (!flag) {
			if (current == target) {
				return 1;
			}
			return 0;
		}
		res = res / den;
		return res;
	}
}
