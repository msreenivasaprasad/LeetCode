public class MA_Maximum_Number_of_Balls_in_a_Box {
	public static void main(String[] args) {
		System.out.println(countBalls(1, 100000));
	}

	public static int countBalls(int lowLimit, int highLimit) {
		int[] count = new int[45];
		int max = 0;
		for (int i = lowLimit; i <= highLimit; i++) {
			count[digitSum(i) - 1]++;
		}
		for (int i = 0; i < count.length; i++) {
			max = Integer.max(max, count[i]);
		}
		return max;
	}

	public static int digitSum(int n) {
		int res = 0;
		while (n > 0) {
			res += n % 10;
			n /= 10;
		}
		return res;
	}

}