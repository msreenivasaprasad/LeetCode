
import java.util.ArrayList;
import java.util.List;

public class AR_Cells_with_Odd_Values_in_a_Matrix {
	public static void main(String[] args) {
		int[][] grid = { { 1, 1 }, { 0, 0 } };
		System.out.println(oddCells(2, 2, grid));
	}

	public static int oddCells(int m, int n, int[][] indices) {
		int[] rows = new int[m];
		int[] cols = new int[n];
		for (int i = 0; i < indices.length; i++) {
			rows[indices[i][0]]++;
			cols[indices[i][1]]++;
		}
		int[][] grid = new int[m][n];
		for (int i = 0; i < rows.length; i++) {
			for (int j = -0; j < cols.length; j++) {
				grid[i][j] += rows[i];
			}
		}
		for (int j = 0; j < cols.length; j++) {
			for (int i = -0; i < rows.length; i++) {
				grid[i][j] += cols[j];
			}
		}
		int res = 0;
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				if (grid[i][j] % 2 != 0) {
					res++;
				}
			}
		}
		return res;
	}
}