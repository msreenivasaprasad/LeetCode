public class AR_Find_Missing_Observations {
	public static void main(String[] args) {
		int[] rolls = { 1, 5, 6 };
		int[] res = missingRolls(rolls, 3, 4);
		int[] nums = new int[4];
		findArr(nums, 21);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] missingRolls(int[] rolls, int mean, int n) {
		int total = n + rolls.length;
		int sum = 0;
		for (int i = 0; i < rolls.length; i++) {
			sum += rolls[i];
		}
		int sumofn = (mean * total) - sum;
		if (sumofn < n || sumofn > (6 * n)) {
			return new int[0];
		}
		int[] resultArr = new int[n];
		findArr(resultArr, sumofn);
		return resultArr;
	}

	public static void findArr(int[] arr, int sum) {
		if (sum < arr.length || sum > (6 * arr.length)) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if ((arr.length - i - 1) * 6 < sum) {
				arr[i] = sum - (arr.length - i - 1) * 6;
				sum -= arr[i];
			} else {
				arr[i] = 1;
				sum--;
			}
		}
	}
}