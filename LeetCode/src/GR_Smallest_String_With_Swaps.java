import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GR_Smallest_String_With_Swaps {
	public static void main(String[] args) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		temp.add(1);
		sets.add(new ArrayList<Integer>(temp));
		temp.clear();
		temp.add(1);
		temp.add(2);
		sets.add(new ArrayList<Integer>(temp));
		System.out.println("Hello World");
		System.out.println(smallestStringWithSwaps("cba", sets));
	}

	public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		int n = s.length();
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < pairs.size(); i++) {
			graph.get(pairs.get(i).get(0)).add(pairs.get(i).get(1));
			graph.get(pairs.get(i).get(1)).add(pairs.get(i).get(0));
		}
		boolean[] visited = new boolean[n];
		char[] c = new char[s.length()];
		for (int i = 0; i < visited.length; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			if (!visited[i]) {
				temp.clear();
				get(i, graph, visited, temp);
				List<Character> chars = new ArrayList<Character>();
				for (int j = 0; j < temp.size(); j++) {
					chars.add(s.charAt(temp.get(j)));
				}
				Collections.sort(chars);
				Collections.sort(temp);
				for (int j = 0; j < temp.size(); j++) {
					c[temp.get(j)] = chars.get(j);
				}
			}
		}
		return new String(c);
	}

	public static void get(int i, List<List<Integer>> map, boolean[] visited, List<Integer> ind) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		ind.add(i);
		for (int j = 0; j < map.get(i).size(); j++) {
			get(map.get(i).get(j), map, visited, ind);
		}
	}

}