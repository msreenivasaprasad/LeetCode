import java.util.Arrays;

public class MA_Valid_Square {
	public static void main(String[] args) {
		int[] p1 = { 0, 0 };
		int[] p2 = { 1, 1 };
		int[] p3 = { 1, 0 };
		int[] p4 = { 0, 1 };
		System.out.println(validSquare(p1, p2, p3, p4));
	}

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		double a = 0;
		int[][] points = { { p1[0], p1[1] }, { p2[0], p2[1] }, { p3[0], p3[1] }, { p4[0], p4[1] } };
		double[] dists = new double[3];
		for (int i = 0; i < points.length; i++) {
			int t = 0;
			for (int k = 0; k < 4; k++) {
				if (i != k) {
					dists[t++] = dist(points[i], points[k]);
				}
			}
			Arrays.sort(dists);
			if (i == 0) {
				a = dists[0];
			}
			if (dists[0] != a || dists[1] != a || round(dists[2], 1) != round(Math.sqrt(2) * a, 1)) {
				return false;
			}
		}
		return true;
	}

	private static double round(double value, int precision) {
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}

	public static double dist(int[] p1, int[] p2) {
		return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
	}
}