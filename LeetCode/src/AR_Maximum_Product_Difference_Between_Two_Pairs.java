import java.util.Arrays;

public class AR_Maximum_Product_Difference_Between_Two_Pairs {
	public static void main(String[] args) {

	}

	public int maxProductDifference(int[] nums) {
		Arrays.sort(nums);
		return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
	}

}