public class SW_Longest_Nice_Substring {
	public static void main(String[] args) {
		System.out.println(longestNiceSubstring("c"));
	}

	public static String longestNiceSubstring(String s) {
		int[] count1 = new int[26];
		int[] count2 = new int[26];
		char[] c = s.toCharArray();
		int right = c.length - 1;
		int left = 0;
		int len = c.length;
		for (int i = left; i <= right; i++) {
			if (c[i] >= 'a' && c[i] <= 'z') {
				count1[c[i] - 'a']++;
			} else {
				count2[c[i] - 'A']++;
			}
		}
		right++;
		if (isOk(count1, count2)) {
			return s.substring(left, right);
		}
		while (len > 0) {
			if (right == c.length) {
				len--;
				if (len == 0) {
					break;
				}
				right = len - 1;
				left = 0;
				for (int i = 0; i < count1.length; i++) {
					count1[i] = 0;
					count2[i] = 0;
				}
				for (int i = left; i <= right; i++) {
					if (c[i] >= 'a' && c[i] <= 'z') {
						count1[c[i] - 'a']++;
					} else {
						count2[c[i] - 'A']++;
					}
				}
			} else {
				if (c[left] >= 'a' && c[left] <= 'z') {
					count1[c[left] - 'a']--;
				} else {
					count2[c[left] - 'A']--;
				}
				if (c[right] >= 'a' && c[right] <= 'z') {
					count1[c[right] - 'a']++;
				} else {
					count2[c[right] - 'A']++;
				}
				left++;
			}
			right++;
			if (isOk(count1, count2)) {
				return s.substring(left, right);
			}

		}
		return new String();
	}

	public static boolean isOk(int[] count1, int[] count2) {
		for (int i = 0; i < count1.length; i++) {
			if (count1[i] != 0 && count2[i] == 0) {
				return false;
			}
			if (count2[i] != 0 && count1[i] == 0) {
				return false;
			}
		}
		return true;
	}
}