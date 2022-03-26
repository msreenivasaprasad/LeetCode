import java.util.ArrayList;
import java.util.List;

public class AR_Find_All_K_Distant_Indices_in_an_Array {
	public static void main(String[] args) {
		int[] nums = { 2, 2, 2, 2, 2 };
		System.out.println(findKDistantIndices(nums, 2, 2));
	}

	public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i - k; j <= i + k; j++) {
				if (j < 0 || j >= nums.length) {
					continue;
				}
				if (nums[j] == key) {
					res.add(i);
					break;
				}
			}
		}
		return res;
	}
}
