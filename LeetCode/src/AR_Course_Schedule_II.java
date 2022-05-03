import java.util.ArrayList;
import java.util.List;

public class AR_Course_Schedule_II {
	public static void main(String[] args) {
		int[][] prerequisites = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		int[] res = findOrder(3, prerequisites);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static boolean canDo(List<Integer> pre, boolean[] done) {
		for (int i = 0; i < pre.size(); i++) {
			if (!done[pre.get(i)]) {
				return false;
			}
		}
		return true;
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		List<List<Integer>> allPre = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			allPre.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			allPre.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		boolean flag = true;
		int[] result = new int[numCourses];
		int resPointer = 0;
		boolean[] done = new boolean[numCourses];
		while (flag) {
			flag = false;
			for (int i = 0; i < numCourses; i++) {
				if (!done[i] && canDo(allPre.get(i), done)) {
					done[i] = true;
					result[resPointer++] = i;
					flag = true;
				}
			}
		}
		if (resPointer != result.length) {
			return new int[0];
		}
		return result;
	}
}
