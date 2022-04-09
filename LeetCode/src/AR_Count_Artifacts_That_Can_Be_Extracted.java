public class AR_Count_Artifacts_That_Can_Be_Extracted {
	public static void main(String[] args) {

	}

	public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
		boolean[][] dug = new boolean[n][n];
		int res = 0;
		for (int i = 0; i < dig.length; i++) {
			dug[dig[i][0]][dig[i][1]] = true;
		}
		for (int i = 0; i < artifacts.length; i++) {
			if (isCovered(artifacts[i], dug)) {
				res++;
			}
		}
		return res;
	}

	public static boolean isCovered(int[] coordinates, boolean[][] dug) {
		for (int i = coordinates[0]; i <= coordinates[2]; i++) {
			for (int j = coordinates[1]; j <= coordinates[3]; j++) {
				if (!dug[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}