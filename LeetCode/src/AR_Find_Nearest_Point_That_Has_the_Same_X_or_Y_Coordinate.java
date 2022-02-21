public class AR_Find_Nearest_Point_That_Has_the_Same_X_or_Y_Coordinate {
	public static void main(String[] args) {

	}

	public static int nearestValidPoint(int x, int y, int[][] points) {
		int j = -1;
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] == x || points[i][1] == y) {
				if (j == -1) {
					j = i;
				} else if ((Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y)) < (Math.abs(points[j][0] - x)
						+ Math.abs(points[j][1] - y))) {
					j = i;
				}
			}
		}
		return j;
	}
}
