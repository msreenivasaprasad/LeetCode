import java.util.ArrayList;
import java.util.List;

public class STR_Longest_Substring_Of_All_Vowels_in_Order {
	public static void main(String[] args) {
		System.out.println(longestBeautifulSubstring("aieou"));

	}

	public static int longestBeautifulSubstring(String word) {
		char[] c = word.toCharArray();
		int start = 0;
		int max = 0;
		List<Character> vowels = new ArrayList<Character>();
		List<Integer> count = new ArrayList<Integer>();
		while (start < word.length()) {
			int t = findLength(c, start);
			vowels.add(c[start]);
			count.add(t - start);
			start = t;
		}

		for (int j = 0; j + 4 < vowels.size(); j++) {
			if (isOk(vowels, j)) {
				int sum = 0;
				for (int i = j; i <= j + 4; i++) {
					sum += count.get(i);
				}
				max = Integer.max(max, sum);
			}
		}
		return max;
	}

	public static boolean isOk(List<Character> vowels, int start) {
		return (vowels.get(start) == 'a' && vowels.get(start + 1) == 'e' && vowels.get(start + 2) == 'i'
				&& vowels.get(start + 3) == 'o' && vowels.get(start + 4) == 'u');
	}

	static int end;

	public static int findLength(char[] c, int index) {
		int i = index;
		while (i < c.length && c[i] == c[index]) {
			i++;
		}
		return i;
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
