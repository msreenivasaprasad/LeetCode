public class AR_Image_Overlap {
	public static void main(String[] args) {
		int[][] img1 = { { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };

		int[][] img2 = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0 } };
		System.out.println(largestOverlap(img1, img2));
	}

	public static int largestOverlap(int[][] img1, int[][] img2) {
		int max = 0;
		for (int i = 0; i < img1.length; i++) {
			int[][] temp = up(img1, i);
			for (int right = 0; right < img1[0].length; right++) {
				int[][] tempo = right(temp, right);
				max = Integer.max(over(tempo, img2), max);
			}
			for (int left = 0; left < img1[0].length; left++) {
				int[][] tempo = left(temp, left);
				max = Integer.max(over(tempo, img2), max);
			}

		}
		for (int i = 0; i < img1.length; i++) {
			int[][] temp = down(img1, i);
			for (int right = 0; right < img1[0].length; right++) {
				int[][] tempo = right(temp, right);
				max = Integer.max(over(tempo, img2), max);
			}
			for (int left = 0; left < img1[0].length; left++) {
				int[][] tempo = left(temp, left);
				max = Integer.max(over(tempo, img2), max);
			}

		}
		return max;
	}

	public static int over(int[][] img1, int[][] img2) {
		int res = 0;
		for (int i = 0; i < img1.length; i++) {
			for (int j = 0; j < img1[0].length; j++) {
				if (img1[i][j] == 1 && img2[i][j] == 1) {
					res++;
				}
			}
		}
		return res;
	}

	public static int[][] up(int[][] img, int up) {
		int[][] res = new int[img.length][img[0].length];
		for (int i = 0; i < img.length - up; i++) {
			for (int j = 0; j < img[0].length; j++) {
				res[i][j] = img[i + up][j];
			}
		}
		return res;
	}

	public static int[][] down(int[][] img, int down) {
		int[][] res = new int[img.length][img[0].length];
		for (int i = down; i < img.length; i++) {
			for (int j = 0; j < img[0].length; j++) {
				res[i][j] = img[i - down][j];
			}
		}
		return res;
	}

	public static int[][] left(int[][] img, int left) {
		int[][] res = new int[img.length][img[0].length];
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[0].length - left; j++) {
				res[i][j] = img[i][j + left];
			}
		}
		return res;
	}

	public static int[][] right(int[][] img, int right) {
		int[][] res = new int[img.length][img[0].length];
		for (int i = 0; i < img.length; i++) {
			for (int j = right; j < img[0].length; j++) {
				res[i][j] = img[i][j - right];
			}
		}
		return res;
	}
}
