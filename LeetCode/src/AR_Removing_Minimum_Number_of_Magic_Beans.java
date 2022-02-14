import java.util.Arrays;

public class AR_Removing_Minimum_Number_of_Magic_Beans {
	public static void main(String[] args) {
		int[] beans = { 1, 1, 1, 1, 2 };
		System.out.println(minimumRemoval(beans));
	}

	public static long minimumRemoval(int[] beans) {
		Arrays.sort(beans);
		long sum = 0;
		long rightcount = beans.length;
		for (int i = 0; i < beans.length; i++) {
			sum += beans[i];
		}
		long min = sum;
		for (int i = 0; i < beans.length; i++) {
			long num = sum - (rightcount * (long) beans[i]);
			if (num < min) {
				min = num;
			}
			rightcount--;
		}
		return min;
	}

}
