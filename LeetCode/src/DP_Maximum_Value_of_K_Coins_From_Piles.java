import java.util.ArrayList;
import java.util.List;

public class DP_Maximum_Value_of_K_Coins_From_Piles {
	public static void main(String[] args) {
		List<List<Integer>> piles = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(100);
		piles.add(new ArrayList<Integer>(temp));
		temp = new ArrayList<Integer>();
		temp.add(100);
		piles.add(new ArrayList<Integer>(temp));
		temp = new ArrayList<Integer>();
		temp.add(100);
		piles.add(new ArrayList<Integer>(temp));
		temp = new ArrayList<Integer>();
		temp.add(100);
		piles.add(new ArrayList<Integer>(temp));
		temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(1);
		temp.add(1);
		temp.add(1);
		temp.add(1);
		temp.add(1);
		temp.add(10000);

		piles.add(new ArrayList<Integer>(temp));
		System.out.println(maxValueOfCoins(piles, 7));
	}

	public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
		int max = 0;
		for (int i = 0; i < piles.size(); i++) {
			max = Integer.max(piles.get(i).size(), max);
		}
		int[][] counter = new int[piles.size()][max + 1];
		for (int i = 0; i < piles.size(); i++) {
			int sum = 0;
			int j = 0;
			for (j = 0; j < counter[0].length; j++) {
				counter[i][j] = sum;
				if (j < piles.get(i).size()) {
					sum += piles.get(i).get(j);
				}
			}
		}
		dyn = new int[k + 1][counter.length + 1];
		visited = new boolean[k + 1][counter.length + 1];
		return help(counter, k, 0);
	}

	static int[][] dyn;
	static boolean[][] visited;

	public static int help(int[][] count, int rem, int index) {
		if (rem <= 0 || index >= count.length) {
			return 0;
		}
		if (visited[rem][index]) {
			return dyn[rem][index];
		}

		int max = 0;
		for (int j = 0; j < count[0].length; j++) {
			if (j <= rem) {
				int a = help(count, rem - j, index + 1);
				max = Integer.max(max, a + count[index][j]);
			}
		}
		visited[rem][index] = true;
		dyn[rem][index] = max;
		return max;

	}
}
