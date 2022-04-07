import java.util.ArrayList;
import java.util.List;

public class GR_All_Paths_From_Source_to_Target {
	public static void main(String[] args) {
		int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
		System.out.println(allPathsSourceTarget(graph));
	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		boolean[][] map = new boolean[graph.length][graph.length];
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				map[i][graph[i][j]] = true;
			}
		}
		List<Integer> path = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[graph.length];
		path.add(0);
		findAll(0, map, visited, path, res);
		return res;
	}

	public static void findAll(int i, boolean[][] graph, boolean[] visited, List<Integer> path,
			List<List<Integer>> res) {
		if (i == graph.length - 1) {
			res.add(new ArrayList<Integer>(path));
		}
		for (int j = 0; j < graph[i].length; j++) {
			if (graph[i][j] && !visited[j]) {
				visited[j] = true;
				path.add(j);
				findAll(j, graph, visited, path, res);
				visited[j] = false;
				path.remove(path.size() - 1);
			}

		}
	}

}
