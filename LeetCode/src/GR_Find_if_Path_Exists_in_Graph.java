import java.util.ArrayList;
import java.util.List;

public class GR_Find_if_Path_Exists_in_Graph {
	public static void main(String[] args) {
		int[][] edges = { { 0, 7 }, { 0, 8 }, { 6, 1 }, { 2, 0 }, { 0, 4 }, { 5, 8 }, { 4, 7 }, { 1, 3 }, { 3, 5 },
				{ 6, 5 } };
		System.out.println(validPath(10, edges, 7, 5));
//		int[][] edges = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
//		System.out.println(validPath(6, edges, 0, 5));
	}

	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		boolean[] visited = new boolean[n];
		// visited[source] = true;
		map = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			map.add(temp);
		}
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);

		}
		return help(destination, source, visited);
	}

	static List<List<Integer>> map;

	public static boolean help(int dest, int i, boolean[] visited) {
		if (i == dest) {
			return true;
		}
		if (visited[i]) {
			return false;
		}
		visited[i] = true;
		List<Integer> tempo = map.get(i);
		for (int j = 0; j < tempo.size(); j++) {
			if (help(dest, tempo.get(j), visited)) {
				return true;
			}
		}
		return false;
	}
}
