import java.util.ArrayList;
import java.util.List;

public class AR_Diagonal_Traverse {
	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 } };
		int[] res = findDiagonalOrder(mat);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] findDiagonalOrder(int[][] mat) {
		int i = -1, j = 0;
		int k = 0;
		int[] res = new int[mat.length * mat[0].length];
		int number = 0;
		while (true) {
			if (i < mat.length - 1) {
				i++;
			} else if (i == mat.length - 1) {
				j++;
			}
			if (j == mat[0].length) {
				break;
			}
			List<Integer> temp = new ArrayList<Integer>();
			for (int p = i, q = j; p >= 0 && q >= 0 && p < mat.length && q < mat[0].length; p--, q++) {
				if (number % 2 == 0) {
					res[k++] = mat[p][q];
				} else {
					temp.add(mat[p][q]);
				}
			}
			int n = temp.size() - 1;
			while (n >= 0) {
				res[k++] = temp.get(n--);
			}
			number++;
		}
		return res;
	}
}
