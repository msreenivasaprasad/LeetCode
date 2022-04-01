import java.util.Arrays;

public class SW_Frequency_of_the_Most_Frequent_Element {
	public static void main(String[] args) {
		int[] nums = { 9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990,
				9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000,
				9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981,
				9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926,
				9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946,
				9966 };
		System.out.println(nums.length);
		System.out.println(maxFrequency(nums, 3056));
	}

	public static int maxFrequency(int[] nums, int k) {
		int right = 0;
		int left = -1;
		int max = 1;
		Arrays.sort(nums);
		int sum = 0;
		while (right < nums.length) {
			int len = right - left;
			while (left < nums.length && (nums[right] * (len - 1)) - sum > k) {
				left++;
				len = right - left;
				if (left >= nums.length) {
					break;
				}
				sum -= nums[left];
			}
			sum += nums[right];
			len = right - left;
			max = Integer.max(max, len);
			right++;
		}
		return max;
	}
}
