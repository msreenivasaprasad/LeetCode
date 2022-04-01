import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DS_Minimize_the_Difference_Between_Target_and_Chosen_Elements {
	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(minimizeTheDifference(mat, 13));
	}

	public static int minimizeTheDifference(int[][] mat, int target) {
		Set<Integer> sums = new HashSet<Integer>();
		sums.add(0);
		for (int i = 0; i < mat.length; i++) {
			Set<Integer> temp = new HashSet<Integer>();
			for (int j = 0; j < mat[0].length; j++) {
				Iterator<Integer> s = sums.iterator();
				while (s.hasNext()) {
					temp.add((s.next() + mat[i][j]));
				}
			}
			sums.clear();
			Iterator<Integer> s = temp.iterator();
			int tmin = Integer.MAX_VALUE;
			while (s.hasNext()) {
				int t = s.next();
				if (t <= target) {
					sums.add(t);
				} else {
					tmin = Integer.min(tmin, t);
				}
			}
			if (tmin != Integer.MAX_VALUE) {
				sums.add(tmin);
			}
		}
		int min = Integer.MAX_VALUE;
		Iterator<Integer> s = sums.iterator();
		while (s.hasNext()) {
			// System.out.println(s.next());
			min = Integer.min(min, Math.abs(s.next() - target));
		}
		return min;
	}
}
