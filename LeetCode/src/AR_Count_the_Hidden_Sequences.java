public class AR_Count_the_Hidden_Sequences {
	public static void main(String[] args) {
		int[] differences = { 1, -3, 4 };
		System.out.println(numberOfArrays(differences, 1, 6));
	}

	public static int numberOfArrays(int[] differences, int lower, int upper) {
		int[] count = new int[differences.length + 1];
		int max = 0;
		int min = 0;
		for (int i = 0; i < differences.length; i++) {
			count[i + 1] = count[i] + differences[i];
			max = Integer.max(max, count[i + 1]);
			min = Integer.min(min, count[i + 1]);
		}
		int res = 0;
		for (int i = lower; i <= upper; i++) {
			if (i + max <= upper && i + min >= lower) {
				res++;
			}
		}
		return res;
	}
}
