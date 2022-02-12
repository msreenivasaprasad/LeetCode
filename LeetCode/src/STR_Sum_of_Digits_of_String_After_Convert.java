public class STR_Sum_of_Digits_of_String_After_Convert {
	public static void main(String[] args) {
		System.out.println(getLucky("leetcode", 2));
	}

	public static int getLucky(String s, int k) {
		char[] c = s.toCharArray();
		int num = 0;
		for (int i = 0; i < c.length; i++) {
			int temp = c[i] - 'a' + 1;
			num += findSum(temp);
		}
		for (int i = 0; i < k - 1; i++) {
			num = findSum(num);
		}
		return num;
	}

	public static int findSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}
}
