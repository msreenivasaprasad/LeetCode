import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MA_Smallest_Value_of_the_Rearranged_Number {
	public static void main(String[] args) {
		System.out.println(smallestNumber(-12310));
	}

	public static long smallestNumber(long num) {
		if (num == 0) {
			return 0;
		}
		long res = 0;
		if (num < 0) {
			num = -num;
			int[] digits = digits(num);
			Arrays.sort(digits);
			int k = digits.length - 1;

			for (int i = digits.length - 1; i >= 0; i--) {
				res += digits[i] * Math.pow(10, k--);
			}
			return -res;
		}
		int[] digits = digits(num);
		Arrays.sort(digits);
		int k = digits.length - 1;
		if (digits[0] == 0) {
			int nonz = firstnonzero(digits);
			res += digits[nonz] * Math.pow(10, k--);
			for (int i = 0; i < digits.length; i++) {
				if (i != nonz) {
					res += digits[i] * Math.pow(10, k--);
				}
			}
		} else {
			for (int i = 0; i < digits.length; i++) {
				res += digits[i] * Math.pow(10, k--);
			}
		}
		return res;
	}

	public static int firstnonzero(int[] digits) {
		int i = 0;
		while (digits[i] == 0) {
			i++;
		}
		return i;
	}

	public static int[] digits(long num) {
		List<Integer> digits = new ArrayList<Integer>();

		while (num > 0) {
			digits.add((int) (num % 10));
			num = num / 10;
		}
		int[] digitsarr = new int[digits.size()];
		for (int i = 0; i < digitsarr.length; i++) {
			digitsarr[i] = digits.get(i);
		}
		return digitsarr;
	}

}
