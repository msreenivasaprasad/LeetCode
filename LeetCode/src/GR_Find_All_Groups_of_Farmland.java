import java.util.ArrayList;
import java.util.List;

public class GR_Find_All_Groups_of_Farmland {
	public static void main(String[] args) {
		int[][] land = { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
		int[][] res = findFarmland(land);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] findFarmland(int[][] land) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean[][] visited = new boolean[land.length][land[0].length];
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					int[] arr = findCorner(land, visited, i, j);
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(arr[0]);
					temp.add(arr[1]);
					temp.add(arr[2]);
					temp.add(arr[3]);
					res.add(new ArrayList<Integer>(temp));
				}
			}
		}
		int[][] result = new int[res.size()][4];
		for (int i = 0; i < res.size(); i++) {
			int[] tarr = new int[4];
			tarr[0] = res.get(i).get(0);
			tarr[1] = res.get(i).get(1);
			tarr[2] = res.get(i).get(2);
			tarr[3] = res.get(i).get(3);
			result[i] = tarr;
		}
		return result;
	}

	public static int[] findCorner(int[][] land, boolean[][] visited, int i, int j) {
		int starti = i;
		int startj = j;
		int q = j;
		while (q < land[0].length && land[i][q] == 1) {
			q++;
		}
		q--;
		int p = i;
		while (i < land.length && land[i][j] == 1) {
			i++;
		}
		i--;
		while (p < land.length && land[p][q] == 1) {
			p++;
		}
		p--;
		int s = Integer.min(i, p);
		int t = 0;
		if (i < p) {
			s = i;
			t = j;
		} else {
			s = p;
			t = q;
		}
		for (i = starti; i <= s; i++) {
			for (j = startj; j <= t; j++) {
				visited[i][j] = true;
			}
		}
		int[] res = { starti, startj, s, t };
		return res;
	}
}
