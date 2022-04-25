public class AR_K_Closest_Points_to_Origin {
	public static void main(String[] args) {
		int[][] points = { { 68, 97 }, { 34, -84 }, { 60, 100 }, { 2, 31 }, { -27, -38 }, { -73, -74 }, { -55, -39 },
				{ 62, 91 }, { 62, 92 }, { -57, -67 } };
		int[][] res = kClosest(points, 5);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}

	public static int[][] kClosest(int[][] points, int k) {
		double[] distances = new double[points.length];
		for (int i = 0; i < points.length; i++) {
			distances[i] = findDistance(points[i][0], points[i][1]);
		}
		mergeSort(distances, points, 0, points.length);
		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++) {
			res[i] = points[i];
		}
		return res;
	}

	public static void mergeSort(double[] distances, int[][] nums, int start, int end) {
		if (start + 1 >= end) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(distances, nums, start, mid);
		mergeSort(distances, nums, mid, end);
		merge(distances, nums, start, mid, end);
	}

	public static void merge(double[] distances, int[][] nums, int start, int mid, int end) {
		int[][] temp = new int[end - start][2];
		double[] tempo = new double[end - start];

		int i = start;
		int j = mid;
		int t = 0;
		while (i < mid && j < end) {
			if (distances[i] < distances[j]) {
				tempo[t] = distances[i];
				temp[t++] = nums[i++];
			} else {
				tempo[t] = distances[j];
				temp[t++] = nums[j++];
			}
		}
		while (i < mid) {
			tempo[t] = distances[i];
			temp[t++] = nums[i++];
		}
		while (j < end) {
			tempo[t] = distances[j];
			temp[t++] = nums[j++];
		}
		i = start;
		for (t = 0; t < temp.length; t++) {
			distances[i] = tempo[t];
			nums[i++] = temp[t];
		}

	}

	public static double findDistance(int x, int y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}
