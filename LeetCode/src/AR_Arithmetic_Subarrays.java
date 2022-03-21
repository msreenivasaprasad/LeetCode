
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AR_Arithmetic_Subarrays {
	public static void main(String[] args) {
		int[] nums = { 4, 6, 5, 9, 3, 7 };
		int[] l = { 0, 0, 2 };
		int[] r = { 2, 3, 5 };
		System.out.println(checkArithmeticSubarrays(nums, l, r));
	}

	public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> res = new ArrayList<Boolean>();
		for (int i = 0; i < l.length; i++) {
			res.add(help(nums, l[i], r[i]));
		}
		return res;
	}

	public static boolean help(int[] nums, int left, int right) {
		int[] temp = new int[right - left];
		int j = 0;
		for (int i = left; i <= right; i++) {
			temp[j++] = nums[i];
		}
		Arrays.sort(temp);
		if (temp.length <= 2) {
			return true;
		}
		int cd = temp[1] - temp[0];
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] != temp[i - 1] + cd) {
				return false;
			}
		}
		return true;
	}
}