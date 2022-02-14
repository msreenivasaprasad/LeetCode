import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AR_Find_Target_Indices_After_Sorting_Array {
	public static void main(String[] args) {
		int[] nums = { -1, -2, 3, 4 };
		List<Integer> res = targetIndices(nums, -1);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	public static List<Integer> targetIndices(int[] nums, int target) {
		Arrays.sort(nums);
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				res.add(i);
			}
		}
		return res;
	}
}
