import java.util.HashMap;
import java.util.Map;

public class AR_Most_Frequent_Number_Following_Key_In_an_Array {
	public static void main(String[] args) {
		int[] nums = { 1, 100, 200, 1, 100 };
		System.out.println(mostFrequent(nums, 1));
	}

	public static int mostFrequent(int[] nums, int key) {
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		int res = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key && i + 1 < nums.length) {
				if (count.containsKey(nums[i + 1])) {
					count.replace(nums[i + 1], count.get(nums[i + 1]) + 1);
				} else {
					count.put(nums[i + 1], 1);
				}
				if (count.get(nums[i + 1]) > max) {
					max = count.get(nums[i + 1]);
					res = nums[i + 1];
				}
				i++;
			}
		}
		return res;
	}
}