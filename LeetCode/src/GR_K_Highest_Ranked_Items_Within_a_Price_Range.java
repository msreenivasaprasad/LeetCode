import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GR_K_Highest_Ranked_Items_Within_a_Price_Range {
	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 0, 1 }, { 1, 3, 3, 1 }, { 0, 2, 5, 1 } };
		int[] price = { 2, 3 };
		int[] start = { 2, 3 };
		System.out.println(highestRankedKItems(grid, price, start, 2).toString());
	}

	public static List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		all = new ArrayList<List<Integer>>();
		allPaths(start[0], start[1], visited, grid, pricing, 0);
		int[][] allarr = new int[all.size()][4];
		for (int i = 0; i < allarr.length; i++) {
			for (int j = 0; j < 4; j++) {
				allarr[i][j] = all.get(i).get(j);
			}
		}
		mergeSort(allarr, 0, allarr.length);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int i = allarr.length - 1;
		while (k > 0 && i >= 0) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(allarr[i][0]);
			temp.add(allarr[i][1]);
			res.add(new ArrayList<Integer>(temp));
			k--;
			i--;
		}
		return res;
	}

	public static void mergeSort(int[][] nums, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(nums, start, mid);
		mergeSort(nums, mid, end);
		merge(nums, start, mid, end);
	}

	public static void merge(int[][] nums, int start, int mid, int end) {
		int[][] temp = new int[end - start][4];
		int i = start;
		int j = mid;
		int k = 0;
		while (i < mid && j < end) {
			if (nums[i][2] > nums[j][2]) {
				temp[k++] = nums[i++];
			} else if (nums[i][2] < nums[j][2]) {
				temp[k++] = nums[j++];
			} else {
				if (nums[i][3] > nums[j][3]) {
					temp[k++] = nums[i++];
				} else if (nums[i][3] < nums[j][3]) {
					temp[k++] = nums[j++];
				} else {
					if (nums[i][0] > nums[j][0]) {
						temp[k++] = nums[i++];
					} else if (nums[i][0] < nums[j][0]) {
						temp[k++] = nums[j++];
					} else {
						if (nums[i][1] > nums[j][1]) {
							temp[k++] = nums[i++];
						} else if (nums[i][1] < nums[j][1]) {
							temp[k++] = nums[j++];
						}
					}
				}
			}
		}
		while (i < mid) {
			temp[k++] = nums[i++];
		}
		while (j < end) {

			temp[k++] = nums[j++];
		}
		i = start;
		for (k = 0; k < temp.length; k++) {
			nums[i++] = temp[k];
		}
	}

	public static List<List<Integer>> all;

	public static void allPaths(int i, int j, boolean[][] visited, int[][] grid, int[] price, int len) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
			return;
		}

		visited[i][j] = true;
		Queue<List<Integer>> q = new LinkedList<>();
		List<Integer> t = new ArrayList<Integer>();
		t.add(i);
		t.add(j);
		q.add(new ArrayList<Integer>(t));
		visited[i][j] = true;
		int tlen = 0;
		int tempo = 1;
		while (!q.isEmpty()) {
			List<Integer> temp = q.poll();
			int i1 = temp.get(0);
			int j1 = temp.get(1);
			if (i1 - 1 >= 0 && !visited[i1 - 1][j1] && grid[i1 - 1][j1] != 0) {
				List<Integer> t1 = new ArrayList<Integer>();
				t1.add(i1 - 1);
				t1.add(j1);
				q.add(new ArrayList<Integer>(t1));
				visited[i1 - 1][j1] = true;
				tlen++;
			}
			if (j1 - 1 >= 0 && !visited[i1][j1 - 1] && grid[i1][j1 - 1] != 0) {
				List<Integer> t1 = new ArrayList<Integer>();
				t1.add(i1);
				t1.add(j1 - 1);
				q.add(new ArrayList<Integer>(t1));
				visited[i1][j1 - 1] = true;
				tlen++;
			}
			if (i1 + 1 < grid.length && !visited[i1 + 1][j1] && grid[i1 + 1][j1] != 0) {
				List<Integer> t1 = new ArrayList<Integer>();
				t1.add(i1 + 1);
				t1.add(j1);
				q.add(new ArrayList<Integer>(t1));
				visited[i1 + 1][j1] = true;
				tlen++;
			}
			if (j1 + 1 < grid[0].length && !visited[i1][j1 + 1] && grid[i1][j1 + 1] != 0) {
				List<Integer> t1 = new ArrayList<Integer>();
				t1.add(i1);
				t1.add(j1 + 1);
				q.add(new ArrayList<Integer>(t1));
				visited[i1][j1 + 1] = true;
				tlen++;
			}
			if (grid[i1][j1] >= price[0] && grid[i1][j1] <= price[1]) {
				List<Integer> item = new ArrayList<Integer>();
				item.add(i1);
				item.add(j1);
				item.add(len);
				item.add(grid[i1][j1]);
				all.add(new ArrayList<Integer>(item));
			}
			tempo--;
			if (tempo == 0) {
				len++;
				tempo = tlen;
				tlen = 0;
			}

		}
	}
}
