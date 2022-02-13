import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AR_Finding_3_Digit_Even_Numbers {
	public static void main(String[] args) {
		int[] digits = { 2, 2, 8, 8, 2 };
		int[] nums = findEvenNumbers(digits);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	public static int[] findEvenNumbers(int[] digits) {
		Arrays.sort(digits);
		boolean[] doneinl1 = new boolean[10];
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < digits.length; i++) {
			int sum = 0;
			if (!doneinl1[digits[i]] && digits[i] != 0) {
				boolean[] doneinl2 = new boolean[10];
				sum += digits[i] * 100;
				for (int j = 0; j < digits.length; j++) {
					if (!doneinl2[digits[j]] && j != i) {
						boolean[] doneinl3 = new boolean[10];
						sum += digits[j] * 10;
						for (int k = 0; k < digits.length; k++) {
							if (!doneinl3[digits[k]] && k != j && k != i && digits[k] % 2 == 0) {
								sum += digits[k];
								res.add(new Integer(sum));
								sum -= digits[k];
								doneinl3[digits[k]] = true;
							}
						}
						sum -= digits[j] * 10;
						doneinl2[digits[j]] = true;
					}

				}
				sum -= digits[i] * 100;
				doneinl1[digits[i]] = true;
			}
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}
		return result;
	}
}
