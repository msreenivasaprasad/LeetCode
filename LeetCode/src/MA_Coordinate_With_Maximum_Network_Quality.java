public class MA_Coordinate_With_Maximum_Network_Quality {
	public static void main(String[] args) {
		int[][] nums = { { 30, 34, 31 }, { 10, 44, 24 }, { 14, 28, 23 }, { 50, 38, 1 }, { 40, 13, 6 }, { 16, 27, 9 },
				{ 2, 22, 23 }, { 1, 6, 41 }, { 34, 22, 40 }, { 40, 10, 11 } };
		int[] res = bestCoordinate(nums, 20);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static int[] bestCoordinate(int[][] towers, int radius) {
		double max = 0;
		int[] res = new int[2];
		for (int x = 0; x <= 50; x++) {
			for (int y = 0; y <= 50; y++) {
				double quality = 0;
				for (int k = 0; k < towers.length; k++) {
					quality += Math.floor(findQuality(towers[k], x, y, radius));
				}
				if (quality > max) {
					max = quality;
					res[0] = x;
					res[1] = y;
				}
			}
		}
		return res;
	}

	public static double findQuality(int[] tower, int x, int y, int radius) {
		double distance = findDistance(x, y, tower[0], tower[1]);
		if (distance > (double) radius) {
			return 0;
		}
		return ((double) tower[2]) / ((double) distance + (double) 1);
	}

	public static double findDistance(int x, int y, int p, int q) {
		return Math.sqrt(Math.pow(x - p, 2) + Math.pow(y - q, 2));
	}
}
