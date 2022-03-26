public class MA_Queries_on_Number_of_Points_Inside_a_Circle {
	public static void main(String[] args) {
		int[][] points = { { 1, 3 }, { 3, 3 }, { 5, 3 }, { 2, 2 } };
		int[][] queries = { { 2, 3, 1 }, { 4, 3, 1 }, { 1, 1, 2 } };
		int[] res = countPoints(points, queries);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] countPoints(int[][] points, int[][] queries) {
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int t = 0;
			for (int j = 0; j < points.length; j++) {
				if (distance(points[j][0], points[j][1], queries[i][0], queries[i][1]) <= queries[i][2]) {
					t++;
				}
			}
			res[i] = t;
		}
		return res;
	}

	public static double distance(int x1, int y1, int x2, int y2) {
		double a = Math.pow(x1 - x2, 2);
		double b = Math.pow(y1 - y2, 2);
		return Math.sqrt(a + b);
	}

}
