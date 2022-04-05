import java.util.Arrays;

public class SW_Maximize_the_Confusion_of_an_Exam {
	public static void main(String[] args) {
		System.out.println(maxConsecutiveAnswers("T", 1));
	}

	public static int maxConsecutiveAnswers(String answerKey, int k) {
		char[] c = answerKey.toCharArray();
		int t = 0;
		int left = -1;
		int max = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'F') {
				t++;
			}
			while (t > k) {
				left++;
				if (left < c.length && c[left] == 'F') {
					t--;
				}
			}
			max = Integer.max(max, i - left);
		}
		t = 0;
		left = -1;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'T') {
				t++;
			}
			while (t > k) {
				left++;
				if (left < c.length && c[left] == 'T') {
					t--;
				}
			}
			max = Integer.max(max, i - left);
		}
		return max;

	}

	public int hIndex(int[] citations) {
		int res = 0;
		Arrays.sort(citations);
		if (citations.length == 1 && citations[0] != 0) {
			return 1;
		}
		if (citations[0] > citations.length) {
			return citations.length;
		}
		for (int i = 0; i < citations.length; i++) {
			int right = citations.length - i;
			if (citations[i] <= right) {
				res = Integer.max(res, citations[i]);
			} else if (i - 1 >= 0 && right > citations[i - 1]) {
				res = Integer.max(res, Integer.min(right, citations[i] - 1));
			}
		}
		return res;
	}

}
