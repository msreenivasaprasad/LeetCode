import java.util.HashSet;
import java.util.Set;

public class GR_Is_Graph_Bipartite {
	public static void main(String[] args) {
		int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		System.out.println(isBipartite(graph));
	}

	public static boolean isBipartite(int[][] graph) {
		return help(0, graph, new HashSet<Integer>(), new HashSet<Integer>());
	}

	public static boolean help(int i, int[][] graph, Set<Integer> a, Set<Integer> b) {
		if (i == graph.length) {
			System.out.println(a);
			System.out.println(b);
			return true;
		}
		if ((a.contains(i) && contains(a, graph[i])) || (b.contains(i) && contains(b, graph[i]))) {
			return false;
		}
		if ((a.contains(i) && shouldcontains(b, graph[i])) || (b.contains(i) && shouldcontains(a, graph[i]))) {
			return help(i + 1, graph, a, b);
		}

		if (a.contains(i)) {
			for (int j = 0; j < graph[i].length; j++) {
				b.add(graph[i][j]);
			}
			return help(i + 1, graph, a, b);
		}
		if (b.contains(i)) {
			for (int j = 0; j < graph[i].length; j++) {
				a.add(graph[i][j]);
			}
			return help(i + 1, graph, a, b);
		}
		a.add(i);
		for (int j = 0; j < graph[i].length; j++) {
			b.add(graph[i][j]);
		}
		if (help(i + 1, graph, a, b)) {
			return true;
		}
		a.remove(i);
		for (int j = 0; j < graph[i].length; j++) {
			b.remove(graph[i][j]);
		}
		b.add(i);
		for (int j = 0; j < graph[i].length; j++) {
			a.add(graph[i][j]);
		}
		return help(i + 1, graph, a, b);

	}

	public static boolean shouldcontains(Set<Integer> s, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (!s.contains(arr[i])) {
				return false;
			}
		}
		return true;
	}

	public static boolean contains(Set<Integer> s, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (s.contains(arr[i])) {
				return true;
			}
		}
		return false;
	}
}