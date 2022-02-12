import java.util.Arrays;

public class MA_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {
	public static void main(String[] args) {
		System.out.println(minimumSum(2932));
	}

	public static int minimumSum(int num) {
		int[] digits = digits(num);
		Arrays.sort(digits);
		return digits[3] + digits[2] + ((digits[1] + digits[0]) * 10);
	}

	public static int[] digits(int num) {
		int[] digits = new int[4];
		int i = 0;
		while (num > 0) {
			digits[i++] = num % 10;
			num = num / 10;
		}
		return digits;
	}
}
