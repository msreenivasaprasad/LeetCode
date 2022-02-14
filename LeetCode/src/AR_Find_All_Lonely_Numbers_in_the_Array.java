import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AR_Find_All_Lonely_Numbers_in_the_Array {
	public static void main(String[] args) {
		int[] nums = { 10 };
		System.out.println(findLonely(nums).toString());

	}

	public static List<Integer> findLonely(int[] nums) {
		Arrays.sort(nums);
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 1) {
			res.add(nums[0]);
			return res;
		}
		if (nums[0] < nums[1] - 1) {
			res.add(nums[0]);
		}
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i - 1] + 1 && nums[i] < nums[i + 1] - 1) {
				res.add(nums[i]);
			}
		}
		if (nums[nums.length - 1] > nums[nums.length - 2] + 1) {
			res.add(nums[nums.length - 1]);
		}
		return res;
	}
}
