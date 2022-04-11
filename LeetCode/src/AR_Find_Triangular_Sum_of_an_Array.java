import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AR_Find_Triangular_Sum_of_an_Array {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(maxFreq("aababcaab", 2, 3, 4));
		System.out.println(triangularSum(nums));
	}

	public static int triangularSum(int[] nums) {
		List<Integer> temp = new ArrayList<Integer>();
		visited = new boolean[10][10];
		dyn = new int[10][10];
		for (int i = 0; i < nums.length; i++) {
			temp.add(nums[i]);
		}
		while (temp.size() > 1) {
			List<Integer> tempo = new ArrayList<Integer>();
			for (int i = 0; i < temp.size() - 1; i++) {
				tempo.add(help(temp.get(i), temp.get(i + 1)));
			}
			temp = tempo;
		}
		return temp.get(0);
	}

	static boolean[][] visited;
	static int[][] dyn;

	public static int help(int i, int j) {
		if (visited[i][j]) {
			return dyn[i][j];
		}
		int t = (i + j) % 10;
		visited[i][j] = true;
		visited[j][i] = true;
		dyn[i][j] = t;
		dyn[j][i] = t;
		return t;

	}

	public static boolean checkTree(TreeNode root) {
		return root.left.val + root.right.val == root.val;
	}

	public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		char[] c = s.toCharArray();
		Set<Character> count = new HashSet<Character>();
		int[] counter = new int[c.length];
		for (int i = 0; i < c.length; i++) {
			count.add(c[i]);
			counter[i] = count.size();
		}
		return help(counter, minSize, maxSize, maxLetters);
	}

	public static int help(int[] nums, int min, int max, int maxLetters) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = 0;
			for (j = i + max - 1; j >= i + min; j--) {
				if (j >= nums.length || nums[j] - nums[i] >= maxLetters) {
					break;
				}
			}
			res += j - i - min + 2;
		}
		return res;
	}
}