public class GR_Find_Center_of_Star_Graph {
	public static void main(String[] args) {
		int[][] edges = { { 1, 3 }, { 2, 3 } };
		System.out.println(findCenter(edges));
	}

	public static int findCenter(int[][] edges) {
		int max = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] > max)
				max = edges[i][0];
			else if (edges[i][1] > max)
				max = edges[i][1];
		}
		int[] nums = new int[max];
		for (int i = 0; i < edges.length; i++) {
			nums[edges[i][0] - 1]++;
			nums[edges[i][1] - 1]++;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums.length - 1) {
				return i + 1;
			}
		}
		return 0;
	}
}
