public class GR_Maximal_Network_Rank {
	public static void main(String[] args) {
		int[][] nums = { { 2, 3 }, { 0, 3 }, { 0, 4 }, { 4, 1 } };
		System.out.println(maximalNetworkRank(5, nums));
	}

	public static int maximalNetworkRank(int n, int[][] roads) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				max = Integer.max(max, findRank(i, j, roads));
			}
		}
		return max;
	}

	public static int findRank(int i, int j, int[][] roads) {
		int res = 0;
		for (int k = 0; k < roads.length; k++) {
			if (roads[k][0] == i || roads[k][0] == j || roads[k][1] == i || roads[k][1] == j) {
				res++;
			}
		}
		return res;
	}
}