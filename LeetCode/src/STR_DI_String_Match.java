public class STR_DI_String_Match {
	public static void main(String[] args) {
		int[] res = diStringMatch("DDI");
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] diStringMatch(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		int[] nums = new int[c.length + 1];
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'D') {
				nums[i] = n;
				n--;
			}
		}
		nums[nums.length - 1] = n;
		n--;
		for (int i = c.length - 1; i >= 0; i--) {
			if (c[i] == 'I') {
				nums[i] = n;
				n--;
			}
		}
		return nums;
	}
}
