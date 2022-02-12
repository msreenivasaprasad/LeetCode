import java.util.Arrays;

public class AR_Sort_Even_and_Odd_Indices_Independently {
	public static void main(String[] args) {
		int[] nums = { 2, 1 };
		int[] res = sortEvenOdd(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] sortEvenOdd(int[] nums) {
		int evenlength = 0;
		if (nums.length % 2 == 0) {
			evenlength = nums.length / 2;
		} else {
			evenlength = ((nums.length) / 2) + 1;
		}
		int[] evennums = new int[evenlength];
		int[] oddnums = new int[nums.length - evenlength];
		int j = 0, k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				evennums[j++] = nums[i];
			} else {
				oddnums[k++] = nums[i];
			}
		}
		Arrays.sort(evennums);
		Arrays.sort(oddnums);
		j = 0;
		k = oddnums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				nums[i] = evennums[j++];
			} else {
				nums[i] = oddnums[k--];
			}

		}
		return nums;
	}
}
