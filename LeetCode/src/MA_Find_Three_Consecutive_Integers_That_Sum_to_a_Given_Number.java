public class MA_Find_Three_Consecutive_Integers_That_Sum_to_a_Given_Number {
	public static void main(String[] args) {
		System.out.println(sumOfThree(33));
	}

	public static long[] sumOfThree(long num) {
		long[] res = new long[3];
		long t = num - 3;
		if (t % 3 != 0) {
			long[] temp = new long[0];
			return temp;
		}
		long q = t / 3;
		res[0] = q;
		res[1] = q + 1;
		res[2] = q + 2;
		return res;
	}
}
